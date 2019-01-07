package cn.gson.oasys.model.entity.kanban;



import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aoa_kanban")
public class KanBan {
	
	@Id
	@Column(name="kanbanid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long kanbanid;			//看板id
	
	@Column(name="state")
	private String state;		//看板状态
	
	@Column(name="work_date")
	
	private String work_date;		//作業日付
	
	@Column(name="group_next")
	private String group_next;		//班次
	
	@Column(name="group_personnel")
	private String group_personnel;		//要員
	
	@Column(name="scheduled_time")
	private Time scheduled_time;		//予定時刻
	
	@Column(name="work_id")
	private String work_id;		//作業ID
	
	@Column(name="completion_time")
	private Time completion_time;		//完了時刻
	
	@Column(name="results")
	private String results;		//結果
	
	@Column(name="personnel")
	private String personnel;		//担当者
	
	@Column(name="confirmed_by")
	private String confirmed_by;		//確認者
	
	@Column(name="work_start_time")
	
	private Timestamp work_start_time;		//作業開始時刻
	
	@Column(name="work_end_time")

	private Timestamp work_end_time;		//作業終了時刻
	
	@Column(name="delivery")
	
	private Time delivery;		//納期
	
	@Column(name="delivery_rate")
	private String delivery_rate;		//納期遵守率
	
	@Column(name="remark")
	private String remark;		//備考
	
//	public KanBan(Long kanbanid, String state, Time work_date, String group_next, String group_personnel, String taskDescribe,
//			String comment, Boolean top, Boolean cancel, Integer statusId) {
//		super();
//		this.kanbanid = kanbanid;
//		this.state = state;
//		this.work_date = work_date;
//		this.group_next = group_next;
//		this.group_personnel = group_personnel;
//		this.taskDescribe = taskDescribe;
//		this.comment = comment;
//		this.top = top;
//		this.cancel = cancel;
//		this.statusId = statusId;
//	}
	public Long getKanbanid() {
		return kanbanid;
	}

	public void setKanbanid(Long kanbanid) {
		this.kanbanid = kanbanid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
	

	public KanBan(Long kanbanid, String state, String work_date, String group_next, String group_personnel,
			Time scheduled_time, String work_id, Time completion_time, String results, String personnel,
			String confirmed_by, Timestamp work_start_time, Timestamp work_end_time, Time delivery,
			String delivery_rate, String remark) {
		super();
		this.kanbanid = kanbanid;
		this.state = state;
		this.work_date = work_date;
		this.group_next = group_next;
		this.group_personnel = group_personnel;
		this.scheduled_time = scheduled_time;
		this.work_id = work_id;
		this.completion_time = completion_time;
		this.results = results;
		this.personnel = personnel;
		this.confirmed_by = confirmed_by;
		this.work_start_time = work_start_time;
		this.work_end_time = work_end_time;
		this.delivery = delivery;
		this.delivery_rate = delivery_rate;
		this.remark = remark;
	}

	
	public KanBan() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "KanBan [kanbanid=" + kanbanid + ", state=" + state + ", work_date=" + work_date + ", group_next="
				+ group_next + ", group_personnel=" + group_personnel + ", scheduled_time=" + scheduled_time
				+ ", work_id=" + work_id + ", completion_time=" + completion_time + ", results=" + results
				+ ", personnel=" + personnel + ", confirmed_by=" + confirmed_by + ", work_start_time=" + work_start_time
				+ ", work_end_time=" + work_end_time + ", delivery=" + delivery + ", delivery_rate=" + delivery_rate
				+ ", remark=" + remark + "]";
	}
	
}
