package cn.gson.oasys.services.kanban;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gson.oasys.mappers.KanBanMapper;
import cn.gson.oasys.model.dao.kanban.KanBanDao;
import cn.gson.oasys.model.entity.kanban.KanBan;
import cn.gson.oasys.model.entity.kanban.State;

@Service

public class KanBanService {

	@Autowired
	private KanBanDao kanBanDao;
	@Autowired
	private KanBanMapper kanBanMapper;

	/**
	 * 新增和更新
	 * 
	 * @param list
	 * @return
	 */
	public KanBan save(KanBan list) {
		return kanBanDao.save(list);
	}

	/**
	 * 删除方法
	 */
	public void deleteKanBan(Long kanbanid) {
		kanBanDao.delete(kanbanid);
	}

	int i = 0;

	public List<KanBan> selectmanageAll(KanBan kanban) {

		System.out.println(
				"now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "zhixingcishu" + i);
		i++;
		return kanBanMapper.selectmanageAll(kanban);
	}

	public List<KanBan> listAll(KanBan kanban) {

		System.out.println(
				"now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "zhixingcishu" + i);
		i++;
		return kanBanMapper.selectAll(kanban);
	}

//public List<CITUsers> queryuser(CITUsers citusers) {
//
//	System.out.println(
//			"now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "zhixingcishu" + i);
//	i++;
//	return kanBanMapper.selectuserAll(citusers);
//}

	public List<String> listType() {

		return kanBanMapper.selectType();
	}
	
	public List<State> listState(State state) {

		return kanBanMapper.selectState(state);
	}

	public String StateName(long state_id) {

		return kanBanMapper.selectStateName(state_id);
	}

	public List<Integer> ticketNumber() {

		return kanBanMapper.selectTicketNumber();
	}

	public KanBan listeditAll(Long kanbanid) {

		return kanBanMapper.selecteditAll(kanbanid);
	}

	public int updatekanban(KanBan kanBan) {

		return kanBanMapper.updatekanban(kanBan);
	}

}
