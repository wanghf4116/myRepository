package cn.gson.oasys.controller.kanban;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ExcelController {
	
	@RequestMapping("/excelread")
	public String ExcelRead(Model model) {
		
		return "excel/excelread";
		
	}

}
