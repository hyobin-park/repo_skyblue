package com.color.infra.lecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LectureController {

	@Autowired
	LectureService lectureService;

	@RequestMapping(value="/v1/infra/lecture/lectureXdmList")
	public String lectureXdmList(Model model) {
		model.addAttribute("list", lectureService.selectLec());
		
//		for(LectureDto lectureDto : lectures) {
//			System.out.print(lectureDto.getSeq() + "|");
//			System.out.print(lectureDto.getType() + "|");
//			System.out.print(lectureDto.getTitle() + "|");
//			System.out.print(lectureDto.getInstructor() + "|");
//			System.out.print(lectureDto.getClassRegDate() + "|");
//			System.out.print(lectureDto.getClassRegEndDate() + "|");
//			System.out.print(lectureDto.getClassStartDate() + "|");
//			System.out.print(lectureDto.getClassEndDate() + "|");
//			System.out.print(lectureDto.getPlace() + "|");
//			System.out.print(lectureDto.getClassDesc() + "|");
//			System.out.print(lectureDto.getRegDate() + "|");
//			System.out.println(lectureDto.getEditDate() + "|");
//		}
	return "/xdm/v1/infra/lecture/lectureXdmList";
	}
	@RequestMapping(value="/v1/infra/lecture/lectureXdmForm")
	public String lectureXdmForm() {
		return "/xdm/v1/infra/lecture/LectureXdmForm";
	}
	
	@RequestMapping(value="/v1/infra/lecture/lectureXdmInst")
	public String lectureXdmInst(LectureDto lectureDto) {
		lectureService.insert(lectureDto);
		return "redirect:/v1/infra/lecture/lectureXdmList";
	}
}