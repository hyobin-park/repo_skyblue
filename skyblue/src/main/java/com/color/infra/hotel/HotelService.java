package com.color.infra.hotel;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.color.common.constants.Constants;
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
	
	public int hotelInsert(HotelDto hotelDto, int type) throws Exception {
		
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
		        
		        hotelDto.setUpPath(objectUrl);
		        hotelDto.setUpOriginalName(fileName);
		        hotelDto.setUpUuidName(uuidFileName);
		        hotelDto.setUpExt(ext);
		        hotelDto.setUpSize(hotelDto.getUploadFiles()[i].getSize());
				
//		        hotelDto.setTableName(tableName);
		        hotelDto.setUpType(type);
//				hotelDto.setUpDefaultNy();
//		        hotelDto.setUpSort(maxNumber + i);
		        hotelDto.setUpCusSeq(hotelDto.getUpCusSeq());
				
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
	
	// ReviewSelectList
	public List<HotelDto> ReviewSelectList(HotelDto hotelDto) {
		return hotelDao.ReviewSelectList(hotelDto);
	}
	
	// DetailReviewInsert
	public int DetailReviewInsert(HotelDto hotelDto) {
		return hotelDao.DetailReviewInsert(hotelDto);
	}
	
	// HotelDeList
	public List<HotelDto> HotelDeList(HotelDto hotelDto) {
		return hotelDao.HotelDeList(hotelDto);
	}
	
	// ===== booking ===== //
	// 예약 등록 - bookingInsert
	public int bookingInsert(HotelDto hotelDto) {
		return hotelDao.bookingInsert(hotelDto);
	};
	
	public int roomBookingInsert(HotelDto hotelDto) {
		return hotelDao.roomBookingInsert(hotelDto);
	};
	
	// ===== ShopPayment ===== //
	// booking+customer 정보 출력
	public HotelDto bookingSelectOne(HotelDto hotelDto) {
		return hotelDao.bookingSelectOne(hotelDto);
	}
		
	// bookingRoom+room 정보 출력
	public List<HotelDto> bookingRoomSelectList(HotelDto hotelDto) {
		return hotelDao.bookingRoomSelectList(hotelDto);
	}
		
	// hotel 정보 출력
	public HotelDto bookingHotelSelectOne(HotelDto hotelDto) {
		return hotelDao.bookingHotelSelectOne(hotelDto);
	}
	
	// booking 정보 update
	public int bookingUpdate(HotelDto hotelDto) {
		return hotelDao.bookingUpdate(hotelDto);
	}
	
	// My Page 예약내역
	public List<HotelDto> myPageBkSelectList(HotelVo hotelVo) {
		return hotelDao.myPageBkSelectList(hotelVo);
	}
	
	public int bkSelectOneCount(HotelVo hotelVo) {
		return hotelDao.bkSelectOneCount(hotelVo);
	}
	
}
