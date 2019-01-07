package com.ruoyi.project.monitor.kanban.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.monitor.kanban.domain.KanBan;
import com.ruoyi.project.monitor.kanban.service.IKanBanService;
@Controller
@RequestMapping("/monitor/kanban")
public class KanBanController extends BaseController{
	
	
    private String prefix = "monitor/kanban";
    
    
    @Autowired
    private IKanBanService iKanbanService;

    @RequiresPermissions("monitor:kanban:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/kanban";
    }

    @RequiresPermissions("monitor:kanban:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(KanBan kanban)
    {
        startPage();
		kanban.setGroup_next("N");
		List<KanBan> SteadyListN = iKanbanService.selectKanBanList(kanban);
        return getDataTable(SteadyListN);
    }

	@RequestMapping("/kanban")
	public String Kanbanshow(Model model) {
		
		
//		Long m = null;
//		KanBan kanban = new KanBan();
//		kanban.setGroup_next("N");
//		List<KanBan> SteadyListN = kanBanService.listAll(kanban);
//		model.addAttribute("PM", SteadyListN);
//		kanban.setGroup_next("D");
//		List<KanBan> SteadyListD = kanBanService.listAll(kanban);
//		model.addAttribute("AM", SteadyListD);

		return "kanban/kanbanshow";
	}
	

}
