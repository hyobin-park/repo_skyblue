package com.color.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {
	
	@Autowired
	CodeService codeService;
	
	@RequestMapping(value="/v1/infra/code/codeXdmList")
	public String codeXdmList(Model model) {
		model.addAttribute("list", codeService.selectList());
		
//		System.out.println("codes.size(): " + codes.size());
//	
//		for(CodeDto codedto : codes) {
//			System.out.print(codedto.getIfcdSeq() + "|");
//			System.out.print(codedto.getIfcdName() + "|");
//			System.out.print(codedto.getIfcdUseNy() + "|");
//			System.out.print(codedto.getIfcdOrder() + "|");
//			System.out.print(codedto.getIfcdDesc() + "|");
//			System.out.print(codedto.getIfcdDelNy() + "|");
//			System.out.print(codedto.getIfcdRgDate() + "|");
//			System.out.print(codedto.getIfcdEditDate() + "|");
//			System.out.println(codedto.getCodegroupIfcgSeq() + "|");
//		}
		return "/xdm/v1/infra/code/codeXdmList";
	}
	
	@RequestMapping(value="/v1/infra/code/codeXdmForm")
	public String codeXdmForm(Model model) {
		List<CodeDto> codeGroups = codeService.selectListCodeGroup();
		model.addAttribute("listCodeGroup", codeService.selectListCodeGroup());
		return "/xdm/v1/infra/code/codeXdmForm";
	}
	
	@RequestMapping(value="/v1/infra/code/codeXdmInst")
	public String codeXdmInst(CodeDto codeDto) {
		codeService.codeinsert(codeDto);
		return "redirect:/v1/infra/code/codeXdmList";
	}
	
	@RequestMapping(value="/v1/infra/code/codeXdmUpdt")
	public String codeXdmUpdt(CodeDto codeDto) {
		codeService.codeUpdate(codeDto);
		return "redirect:/v1/infra/code/codeXdmList";
	}
	
	@RequestMapping(value="/v1/infra/code/codeXdmMFom")
	public String codeXdmMFom(CodeDto codeDto, Model model) {
		model.addAttribute("codeItem", codeService.selectOne(codeDto));
		
		List<CodeDto> codeGroups = codeService.selectListCodeGroup();
		model.addAttribute("listCodeGroup", codeService.selectListCodeGroup());
		
		return "/xdm/v1/infra/code/codeXdmMFom";
	}
}
