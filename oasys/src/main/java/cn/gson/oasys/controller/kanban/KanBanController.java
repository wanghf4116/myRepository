package cn.gson.oasys.controller.kanban;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

import cn.gson.oasys.common.formValid.BindingResultVOUtil;
import cn.gson.oasys.common.formValid.MapToList;
import cn.gson.oasys.common.formValid.ResultEnum;
import cn.gson.oasys.common.formValid.ResultVO;
import cn.gson.oasys.model.entity.kanban.KanBan;
import cn.gson.oasys.model.entity.kanban.State;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.services.kanban.KanBanService;

@Controller
@RequestMapping("/")
public class KanBanController {

	Logger log = LoggerFactory.getLogger(getClass());
//	@Autowired
//	private KanBanDao kanBanDao;

	@Autowired
	private KanBanService kanBanService;
//	@Autowired
//	private  OutlookService outlookService;

	@RequestMapping("/kanbanshow")
	public String Kanbanshow(Model model) {
		Long m = null;
		KanBan kanban = new KanBan();
		kanban.setGroup_next("N");
		List<KanBan> SteadyListN = kanBanService.listAll(kanban);
		model.addAttribute("PM", SteadyListN);
		kanban.setGroup_next("D");
		List<KanBan> SteadyListD = kanBanService.listAll(kanban);
		model.addAttribute("AM", SteadyListD);
//	 	ActiveXComponent ol = new ActiveXComponent("Outlook.Application");
//		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Timestamp ts = new Timestamp(System.currentTimeMillis()); 
//		Dispatch olo = ol.getObject();
//		Dispatch myNamespace = Dispatch.call(olo, "GetNamespace", "MAPI").toDispatch();
//		OutlookMail mail = new  OutlookMail();
//		Dispatch myFolder1 = Dispatch.call(myNamespace, "Folders", "FJCIT保守").toDispatch();
//		Dispatch myFolder2 = Dispatch.call(myFolder1, "Folders", "10_知財").toDispatch();
//		Dispatch myFolder3 = Dispatch.call(myFolder2, "Folders", "11_知財メール全件").toDispatch();
//		Dispatch items = Dispatch.get(myFolder3, "Items").toDispatch();
//		int count = Dispatch.call(items, "Count").toInt();
//		for (int i = 1; i <= count; i++) {
//			Dispatch item = Dispatch.call(items, "Item", new Integer(i)).toDispatch();
//			mail.setSubject(Dispatch.get(item, "subject").toString());
//			mail.setSendername(Dispatch.get(item, "sendername").toString());
//			@SuppressWarnings("deprecation")
//			String sent =sdf.format(Dispatch.get(item, "senton").toJavaDate());
//			ts =Timestamp.valueOf(sent);
//			mail.setSenton(ts);
//			mail.setInbox("知財");
//			@SuppressWarnings("unused")
//			int	outlookMails = outlookService.insertOutlook(mail);
//		}
		return "kanban/kanbanshow";
	}

	@RequestMapping("/kanbanmanage")
	public String Kanbanmanage(Model model) {
		KanBan kanban = new KanBan();
		List<KanBan> kanbanList = kanBanService.selectmanageAll(kanban);
		model.addAttribute("today", kanbanList);
		return "kanban/kanbanmanage";
	}

	/**
	 * 看板编辑界面；
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("kanbanedit")
	public String kanbanEdit(HttpServletRequest req, Model model) {
//		CITUsers citusers = new CITUsers();
//		List<CITUsers> citobj = kanBanService.queryuser(citusers);
		State state = new State();
		List<State> states = kanBanService.listState (state);
		
		if (!StringUtils.isEmpty(req.getParameter("kanbanid"))) {
			Long kanbanid = Long.parseLong(req.getParameter("kanbanid"));
		
			KanBan kanban = kanBanService.listeditAll(kanbanid);
			Long state_id=	Long.parseLong(kanban.getState());
//			 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Date utilDate = new Date();// util utilDate
			Timestamp sqlDate = new Timestamp(utilDate.getTime());// uilt date转sql date
//			if (kanban.getWork_start_time() == null) {
//				kanban.setWork_start_time(sqlDate.getNanos());
//				kanban.setWork_end_time(sqlDate.getTime());
//			}
//			if(kanbanObj.get(0)==null) {
//				kanbanObj.(sqlDate);
//				kanbanObj.setWork_end_time(sqlDate);
//				}
//			model.addAttribute("kanban", kanban);

			HttpSession session = req.getSession();
			session.setAttribute("states", states);
			session.setAttribute("statename", kanBanService.StateName(state_id));
			session.setAttribute("kanban", kanban);
			session.setAttribute("kanbanid", kanbanid);
//			session.setAttribute("citobj", citobj);
		}
		return "kanban/kanbanedit";
	}

	/**
	 * 系统管理表单验证
	 * 
	 * @param req
	 * @param menu
	 * @param br   后台校验表单数据，不通过则回填数据，显示错误信息；通过则直接执行业务，例如新增、编辑等；
	 * @return
	 */
	@RequestMapping("kanbancheck")
	public String testMess(HttpServletRequest req, @Valid KanBan menu, BindingResult br) {
		HttpSession session = req.getSession();
		Long menuId = null;
		req.setAttribute("kanban", menu);

		// 这里返回ResultVO对象，如果校验通过，ResultEnum.SUCCESS.getCode()返回的值为200；否则就是没有通过；
		ResultVO res = BindingResultVOUtil.hasErrors(br);
		// 校验失败
		if (!ResultEnum.SUCCESS.getCode().equals(res.getCode())) {
			List<Object> list = new MapToList<>().mapToList(res.getData());
			req.setAttribute("errormess", list.get(0).toString());
			// 代码调试阶段，下面是错误的相关信息；
			System.out.println("list错误的实体类信息：" + menu);
			System.out.println("list错误详情:" + list);
			System.out.println("list错误第一条:" + list.get(0));
			System.out.println("啊啊啊错误的信息——：" + list.get(0).toString());
			// 下面的info信息是打印出详细的信息
			log.info("getData:{}", res.getData());
			log.info("getCode:{}", res.getCode());
			log.info("getMsg:{}", res.getMsg());
		}
		// 校验通过，下面写自己的逻辑业务
		else {
			// 判断是否从编辑界面进来的，前面有"session.setAttribute("getId",getId);",在这里获取，并remove掉；
			if (!StringUtils.isEmpty(session.getAttribute("kanbanid"))) {
				System.out.println(session.getAttribute("kanbanid"));
				menuId = (Long) session.getAttribute("kanbanid"); // 获取进入编辑界面的menuID值

				menu.setKanbanid(menuId);
				log.info("getId:{}", session.getAttribute("kanbanid"));
				session.removeAttribute("kanbanid");
			}

			// 执行业务代码
			kanBanService.updatekanban(menu);
			System.out.println("此操作是正确的");
			req.setAttribute("success", "后台验证成功");
		}
		System.out.println("是否进入最后的实体类信息：" + menu);
		return "kanban/kanbanedit";
	}

	//显示本周的每天的记录
		@RequestMapping("dayinfo")
		public String dayinfo(HttpServletResponse response) throws IOException{
			Integer []r=new Integer[4];
//			Calendar calendar=Calendar.getInstance();
//			 setToFirstDay(calendar);
			List<Integer> kanbanm = kanBanService.ticketNumber();
//			 for (int i = 0; i < 4; i++) {
////				 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//				 r[i]=userLogRecordDao.countlog(sdf.format(calendar.getTime()));
////				 calendar.add(Calendar.DATE, 1);
//		        }
			 String json=JSONObject.toJSONString(kanbanm);
			 System.out.println(json);
				response.setHeader("Cache-Control", "no-cache");
				response.setContentType("text/json;charset=UTF-8");
				response.getWriter().write(json);
			return null;
		}
		
		private static void setToFirstDay(Calendar calendar) {
	        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
	            calendar.add(Calendar.DATE, -1);
	        }
	    }
	// 给hashMap按照value排序
	public static ArrayList<Map.Entry<String, Integer>> sortMap(Map map) {
		List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
				return obj2.getValue() - obj1.getValue();
			}
		});
		return (ArrayList<Entry<String, Integer>>) entries;
	}

	// 显示起票数量
	@RequestMapping("ticketnumber")
	public String ticketNumber(HttpServletResponse response) throws IOException {
//			List<User> uList= uDao.findAll();
		List<String> list = kanBanService.listType();
		List<Integer> kanbanm = kanBanService.ticketNumber();
		HashMap<String, Integer> hashMap = new HashMap<>();
		System.out.println(list);
		System.out.println(kanbanm);
			for (int i = 0; i < list.size(); i++) {
				hashMap.put(list.get(i), kanbanm.get(i));
			}
	
			 ArrayList<Map.Entry<String,Integer>> entries= sortMap(hashMap);
//			 ArrayList<Map.Entry<String,Integer>> entries2=new ArrayList<Map.Entry<String,Integer>>();
//			
//			 if(entries.size()>=5)
//			 //获得前5个s
//			 for (int j = 0; j < 5; j++) {
//				entries2.add(entries.get(j));
//			}
//			 else {
//				 entries2= entries;
//			}
			String json=JSONObject.toJSONString(entries);
			System.out.println(json);
			response.setHeader("Cache-Control", "no-cache");
			response.setContentType("text/json;charset=UTF-8");
			response.getWriter().write(json);
		return null;
	}

	/**
	 * 执行删除方法
	 */
	@RequestMapping("deletekanban")
	public String deleteThis(HttpServletRequest req) {
		Long kanbanid = null;
		if (!StringUtils.isEmpty(req.getParameter("kanbanid"))) {
			kanbanid = Long.parseLong(req.getParameter("kanbanid"));
		}
		kanBanService.deleteKanBan(kanbanid);
		return "forward:/kanbanmanage";
	}
}