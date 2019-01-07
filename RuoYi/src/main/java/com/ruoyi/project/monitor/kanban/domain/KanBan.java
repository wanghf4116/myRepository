package com.ruoyi.project.monitor.kanban.domain;

import java.sql.Time;
import java.sql.Timestamp;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 岗位表 aoa_kanban
 * 
 * @author wanghf
 */
public class KanBan extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private int kanban_id; // 看板id

	private int state_id; // 看板状态

	private String work_date; // 作業日付

	private String group_next; // 班次

	private String group_personnel; // 要員

	private Time scheduled_time; // 予定時刻

	private String work_id; // 作業ID

	private Time completion_time; // 完了時刻

	private String results; // 結果

	private String personnel; // 担当者

	private String confirmed_by; // 確認者

	private Timestamp work_start_time; // 作業開始時刻

	private Timestamp work_end_time; // 作業終了時刻

	private Time delivery; // 納期

	private String delivery_rate; // 納期遵守率

	private String remark; // 備考
	
	private Timestamp update_time; // 更新时间
	
	private String update_user; // 更新者
	

	public int getKanban_id() {
		return kanban_id;
	}

	public void setKanbanid(int kanban_id) {
		this.kanban_id = kanban_id;
	}

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}

	public String getWork_date() {
		return work_date;
	}

	public void setWork_date(String work_date) {
		this.work_date = work_date;
	}

	public String getGroup_next() {
		return group_next;
	}

	public void setGroup_next(String group_next) {
		this.group_next = group_next;
	}

	public String getGroup_personnel() {
		return group_personnel;
	}

	public void setGroup_personnel(String group_personnel) {
		this.group_personnel = group_personnel;
	}

	public Time getScheduled_time() {
		return scheduled_time;
	}

	public void setScheduled_time(Time scheduled_time) {
		this.scheduled_time = scheduled_time;
	}

	public String getWork_id() {
		return work_id;
	}

	public void setWork_id(String work_id) {
		this.work_id = work_id;
	}

	public Time getCompletion_time() {
		return completion_time;
	}

	public void setCompletion_time(Time completion_time) {
		this.completion_time = completion_time;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getPersonnel() {
		return personnel;
	}

	public void setPersonnel(String personnel) {
		this.personnel = personnel;
	}

	public String getConfirmed_by() {
		return confirmed_by;
	}

	public void setConfirmed_by(String confirmed_by) {
		this.confirmed_by = confirmed_by;
	}

	public Timestamp getWork_start_time() {
		return work_start_time;
	}

	public void setWork_start_time(Timestamp work_start_time) {
		this.work_start_time = work_start_time;
	}

	public Timestamp getWork_end_time() {
		return work_end_time;
	}

	public void setWork_end_time(Timestamp work_end_time) {
		this.work_end_time = work_end_time;
	}

	public Time getDelivery() {
		return delivery;
	}

	public void setDelivery(Time delivery) {
		this.delivery = delivery;
	}

	public String getDelivery_rate() {
		return delivery_rate;
	}

	public void setDelivery_rate(String delivery_rate) {
		this.delivery_rate = delivery_rate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

	public String getUpdate_user() {
		return update_user;
	}

	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}


	 @Override
	    public String toString() {
	        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
	            .append("kanban_id", getKanban_id())
	            .append("state_id", getState_id())
	            .append("work_date", getWork_date())
	            .append("group_next", getGroup_next())
	            .append("group_personnel", getGroup_personnel())
	            .append("scheduled_time", getScheduled_time())
	            .append("work_id", getWork_id())
	            .append("completion_time", getCompletion_time())
	            .append("results", getResults())
	            .append("personnel", getPersonnel())
	            .append("confirmed_by", getConfirmed_by())
	            .append("work_start_time", getWork_start_time())
	            .append("work_end_time", getWork_end_time())
	            .append("delivery", getDelivery())
	            .append("delivery_rate", getDelivery_rate())
	            .append("remark", getRemark())
	            .append("update_time", getUpdate_time())
	            .append("update_user", getRemark())
	            .toString();
	    }
	


	

}
