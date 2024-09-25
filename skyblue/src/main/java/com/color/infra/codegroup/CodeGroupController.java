package com.color.infra.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.color.common.util.UtilDateTime;

@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;
	
	@RequestMapping(value="/v1/infra/codegroup/codeGroupXdmList")	// 변경 가능한 주소로 '/xdm' 제외 혹은 포함 가능
	public String codeGroupXdmList(@ModelAttribute("vo") CodeGroupVo codeGroupVo, Model model) {
		
		/* 초기값 세팅이 없는 경우 사용 */
		codeGroupVo.setShDateStart(codeGroupVo.getShDateStart() == null || codeGroupVo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(codeGroupVo.getShDateStart()));
		codeGroupVo.setShDateEnd(codeGroupVo.getShDateEnd() == null || codeGroupVo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(codeGroupVo.getShDateEnd()));
		
		//날짜 필드에 시간 추가
		//codeGroupVo.setShDateStart(codeGroupVo.getShDateStart() + " 00:00:00");
		//codeGroupVo.setShDateEnd(codeGroupVo.getShDateEnd() + " 23:59:59");
		
		//paging
		codeGroupVo.setParamsPaging(codeGroupService.selectOneCount(codeGroupVo));

		if (codeGroupVo.getTotalRows() > 0) {
			model.addAttribute("list", codeGroupService.selectList(codeGroupVo));
		}
		return "/xdm/v1/infra/codegroup/codeGroupXdmList";	// 고정된 주소로 full 주소로 기재
	}
	
	@RequestMapping(value="/v1/infra/codegroup/codeGroupXdmForm")
	public String codeGroupXdmForm() {
		return "/xdm/v1/infra/codegroup/codeGroupXdmForm";
	}
	
	@RequestMapping(value="/v1/infra/codegroup/codeGroupXdmInst")
	public String codeGroupXdmInst(CodeGroupDto codeGroupDto) {
//		System.out.println(codeGroupDto.getIfcgName());
		codeGroupService.insert(codeGroupDto);
		return "redirect:/v1/infra/codegroup/codeGroupXdmList";
	}
	
	@RequestMapping(value="/v1/infra/codegroup/codegroupxdmMfom")
	public String codegroupxdmMfom(CodeGroupDto codeGroupDto, Model model) {
		model.addAttribute("item", codeGroupService.selectOne(codeGroupDto));
		return "/xdm/v1/infra/codegroup/codegroupxdmMfom";
	}
	
//	@RequestMapping(value="/v1/infra/codegroup/codegroupxdmMfom")
//	public String codegroupxdmMfom(CodeGroupDto codeGroupDto, Model model) {
//		CodeGroupDto dto = codeGroupService.selectOne(codeGroupDto);
//		model.addAttribute("item", dto);
//		return "/xdm/v1/infra/codegroup/codegroupxdmMfom";
//	}
	
	@RequestMapping(value="/v1/infra/codegroup/codeGroupXdmUpdt")
	public String codeGroupXdmUpdt(CodeGroupDto codeGroupDto) {
		codeGroupService.update(codeGroupDto);
		return "redirect:/v1/infra/codegroup/codeGroupXdmList";
	}
	
	@RequestMapping(value="/v1/infra/codegroup/codeGroupXdmUel")
	public String codeGroupXdmUel(CodeGroupDto codeGroupDto) {
		codeGroupService.uelete(codeGroupDto);
		return "redirect:/v1/infra/codegroup/codeGroupXdmList";
	}
	
	@RequestMapping(value="/v1/infra/codegroup/codeGroupXdmDel")
	public String codeGroupXdmDel(CodeGroupDto codeGroupDto) {
		codeGroupService.delete(codeGroupDto);
		return "redirect:/v1/infra/codegroup/codeGroupXdmList";
	}

}