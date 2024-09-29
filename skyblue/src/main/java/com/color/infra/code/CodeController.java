package com.color.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.color.common.util.UtilDateTime;

@Controller
public class CodeController {
	
	@Autowired
	CodeService codeService;
	
	@RequestMapping(value="/v1/infra/code/codeXdmList")
	public String codeXdmList(@ModelAttribute("vo") CodeVo codeVo, Model model) {
		
		codeVo.setShDateStart(codeVo.getShDateStart() == null || codeVo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(codeVo.getShDateStart()));
		codeVo.setShDateEnd(codeVo.getShDateEnd() == null || codeVo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(codeVo.getShDateEnd()));
//		codeVo.setShDateStart(codeVo.getShDateStart() + " 00:00:00");
//		codeVo.setShDateEnd(codeVo.getShDateEnd() + " 23:59:59");
		
		//paging
		codeVo.setParamsPaging(codeService.selectOneCount(codeVo));

		if (codeVo.getTotalRows() > 0) {
			model.addAttribute("list", codeService.selectList(codeVo));
		}
		
		model.addAttribute("list", codeService.selectList(codeVo));
		
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
	
	@RequestMapping(value="/v1/infra/code/codeXdmUel")
	public String codeXdmUel(CodeDto codeDto) {
		codeService.codeUelete(codeDto);
		return "redirect:/v1/infra/code/codeXdmList";
	}
	
	@RequestMapping(value="/v1/infra/code/codeXdmDel")
	public String codeXdmDel(CodeDto codeDto) {
		codeService.codeDelete(codeDto);
		return "redirect:/v1/infra/code/codeXdmList";
	}
}
