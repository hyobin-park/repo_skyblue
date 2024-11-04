package com.color.infra.hotel;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.color.common.util.UtilDateTime;

@Service
public class HotelService {
	
	@Autowired
	private HotelDao hotelDao;
	
	@Autowired
	AmazonS3Client amazonS3Client;
	
	public List<HotelDto> hotelList(HotelVo hotelVo) {
		return hotelDao.hotelList(hotelVo);
	}
	
	public int hotelInsert(HotelDto hotelDto, int type) {
		
		for(int i=0; i<hotelDto.getUploadFiles().length; i++) {
			
			if(!hotelDto.getUploadFiles()[i].isEmpty()) {
				
				String className = hotelDto.getClass().getSimpleName().toString().toLowerCase();		
				String fileName = hotelDto.getUploadFiles()[i].getOriginalFilename();
				String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
				String uuid = UUID.randomUUID().toString();
				String uuidFileName = uuid + "." + ext;
				String pathModule = className;
				String nowString = UtilDateTime.nowString();
				String pathDate = nowString.substring(0,4) + "/" + nowString.substring(5,7) + "/" + nowString.substring(8,10); 
				String path = pathModule + "/" + type + "/" + pathDate + "/";
//				String pathForView = Constants.UPLOADED_PATH_PREFIX_FOR_VIEW_LOCAL + "/" + pathModule + "/" + type + "/" + pathDate + "/";
				
				
		        ObjectMetadata metadata = new ObjectMetadata();
		        metadata.setContentLength(hotelDto.getUploadFiles()[i].getSize());
		        metadata.setContentType(hotelDto.getUploadFiles()[i].getContentType());
		        
		        amazonS3Client.putObject("skyskyblue", path + uuidFileName, hotelDto.getUploadFiles()[i].getInputStream(), metadata);
				
		        String objectUrl = amazonS3Client.getUrl("skyskyblue", path + uuidFileName).toString();
		        
		        hotelDto.setPath(objectUrl);
		        hotelDto.setOriginalName(fileName); 
		        hotelDto.setUuidName(uuidFileName);
		        hotelDto.setExt(ext);
		        hotelDto.setSize(hotelDto.getUploadFiles()[i].getSize());
				
//		        hotelDto.setTableName(tableName);
		        hotelDto.setType(type);
//				hotelDto.setDefaultNy(); 
//		        hotelDto.setSort(maxNumber + i);
		        hotelDto.setPseq(pSeq);
				
		        hotelDao.insertUploaded(hotelDto);
			}
		}
		
		return hotelDao.hotelInsert(hotelDto);
	}
	
	public HotelDto selectOne(HotelDto hotelDto) {
		return hotelDao.selectOne(hotelDto);
	}
	
	public int hotelUpdate(HotelDto hotelDto) {
		return hotelDao.hotelUpdate(hotelDto);
	}
	
	public int hotelUelete(HotelDto hotelDto) {
		return hotelDao.hotelUelete(hotelDto);
	}
	
	public int hotelDelete(HotelDto hotelDto) {
		return hotelDao.hotelDelete(hotelDto);
	}
	
	public int selectOneCount(HotelVo hotelVo) {
		return hotelDao.selectOneCount(hotelVo);
	}
}
