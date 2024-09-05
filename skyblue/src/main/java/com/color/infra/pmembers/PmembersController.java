package com.color.infra.pmembers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PmembersController {

	@Autowired
	private PmembersService pmembersService;
	
	@RequestMapping(value="/v1/infra/pmembers/pmembersXdmList")
	public String pmembersXdmList(Model model) {
		model.addAttribute("list", pmembersService.selectMem());
		
//		for(PmembersDto pmembersDto : pmemberss) {
//			System.out.print(pmembersDto.getSeq() + "|");
//			System.out.print(pmembersDto.getAdmin() + "|");
//			System.out.print(pmembersDto.getName() + "|");
//			System.out.print(pmembersDto.getId() + "|");
//			System.out.print(pmembersDto.getPassword() + "|");
//			System.out.print(pmembersDto.getGender() + "|");
//			System.out.print(pmembersDto.getBirthDate() + "|");
//			System.out.print(pmembersDto.getEmail() + "|");
//			System.out.print(pmembersDto.getTel() + "|");
//			System.out.print(pmembersDto.getDesc() + "|");
//			System.out.print(pmembersDto.getRegDate() + "|");
//			System.out.println(pmembersDto.getEditDate() + "|");
//		}		
		return "/xdm/v1/infra/pmembers/pmembersXdmList";
	}
	
	@RequestMapping(value="/v1/infra/pmembers/pmembersXdmForm")
	public String pmembersXdmForm() {
		return "/xdm/v1/infra/pmembers/pmembersXdmForm";
	}
	
	@RequestMapping(value="/v1/infra/pmembers/pmembersXdmInst")
	public String pmembersXdmInst(PmembersDto pmembersDto) {
		pmembersService.insert(pmembersDto);
		return "redirect:/v1/infra/pmembers/pmembersXdmList";
	}
	
	@RequestMapping(value="/v1/infra/pmembers/pmembersXdmMFom")
	public String pmembersXdmMFom(PmembersDto pmembersDto, Model model) {
		model.addAttribute("item", pmembersService.selectOne(pmembersDto));
		return "/xdm/v1/infra/pmembers/pmembersXdmMFom";
	}
	
	@RequestMapping(value="/v1/infra/pmembers/pmembersXdmUpdt")
	public String pmembersXdmUpdt(PmembersDto pmembersDto) {
		pmembersService.update(pmembersDto);
		return "redirect:/v1/infra/pmembers/pmembersXdmList";
	}
	
}
