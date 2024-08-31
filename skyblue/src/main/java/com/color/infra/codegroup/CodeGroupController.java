package com.color.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;
	
	@RequestMapping(value="/v1/infra/codegroup/codeGroupXdmList")	// 변경 가능한 주소로 '/xdm' 제외 혹은 포함 가능
	public String codeGroupXdmList(Model model) {
		
//		여기에서 함수를 호출해야 된다는
//		service에 있는 함수를 호출
		
		model.addAttribute("list", codeGroupService.selectList());
		
//		System.out.println("codeGroups.size():" + codeGroups.size());
//		
//		for(CodeGroupDto codegroupdto : codeGroups) {
//			System.out.print(codegroupdto.getIfcgSeq() + "|");
//			System.out.print(codegroupdto.getIfcgName() + "|");
//			System.out.print(codegroupdto.getIfcgUseNy() + "|");
//			System.out.print(codegroupdto.getIfcgOrder() + "|");
//			System.out.print(codegroupdto.getIfcgDesc() + "|");
//			System.out.print(codegroupdto.getIfcgDelNy() + "|");
//			System.out.print(codegroupdto.getIfcgRgDate() + "|");
//			System.out.println(codegroupdto.getIfcgEditDate());
//		}
		return "/xdm/v1/infra/codegroup/codeGroupXdmList";	// 고정된 주소로 full 주소로 기재
	}
	
	@RequestMapping(value="/v1/infra/codegroup/codeGroupXdmForm")
	public String codeGroupXdmForm() {
		return "/xdm/v1/infra/codegroup/codeGroupXdmForm";
	}
	
	@RequestMapping(value="/v1/infra/codegroup/codeGroupXdmInst")
	public String codeGroupXdmInst(CodeGroupDto codeGroupDto) {
		System.out.println(codeGroupDto.getIfcgName());
		codeGroupService.insert(codeGroupDto);
		return "redirect:/v1/infra/codegroup/codeGroupXdmList";
	}
	}

