package cn.gson.oasys.mappers;

import java.util.List;
import java.util.Map;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.gson.oasys.model.entity.kanban.KanBan;
import cn.gson.oasys.model.entity.kanban.State;

@Mapper
public interface KanBanMapper {

	@Select("select * from aoa_kanban WHERE  to_days(work_date) =to_days(Now()) and group_next = #{group_next};")
	List<KanBan> selectAll(KanBan kanban);

	@Select("select * from aoa_kanban WHERE  to_days(work_date) =to_days(Now()) ;")
	List<KanBan> selectmanageAll(KanBan kanban);
	
	@Select("select * from aoa_kanban WHERE  to_days(work_date) =to_days(Now()) and kanbanid = #{kanbanid} ;")
	KanBan selecteditAll(long kanbanid);
	
	@Select("SELECT sys_type FROM aoa_fjcit  GROUP BY sys_type;")
	List<String> selectType();
	
	@Select("SELECT * FROM aoa_state ;")
	List<State> selectState(State state);
	
	@Select("SELECT state_name FROM aoa_state where state_id = #{state_id} ;")
	String selectStateName(long  state_id);
	
	@Select("SELECT count(work_date) FROM aoa_fjcit WHERE  to_days(work_date) =to_days(Now())  GROUP BY sys_type ;")
	List<Integer> selectTicketNumber();
	
//	@Update("update aoa_kanban set completion_time = #{work_end_time, jdbcType=TIMESTAMP},results = #{results},personnel = #{personnel},confirmed_by = #{confirmed_by},work_start_time = #{work_start_time, jdbcType=TIMESTAMP},  work_end_time = #{ work_end_time, jdbcType=TIMESTAMP} where kanbanid = #{kanbanid}")
	int updatekanban(KanBan kanBan);
	
}
