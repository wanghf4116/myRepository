package cn.gson.oasys.model.entity.kanban;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aoa_outlookmail")
public class OutlookMail {
	
	@Id
	@Column(name="outlookid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long outlookid;			//outlookid
	
	@Column(name="inbox")
	private String inbox;		//收件箱
	
	@Column(name="subject")
	private String subject;		//件名
	
	@Column(name="sendername")
	private String sendername;		//送信人
	
	@Column(name="senton")
	private Timestamp senton;		//送信时间
	
	@Column(name="remark")
	private Timestamp remark;		//備考

	public Long getOutlookid() {
		return outlookid;
	}

	public void setOutlookid(Long outlookid) {
		this.outlookid = outlookid;
	}

	public String getInbox() {
		return inbox;
	}

	public void setInbox(String inbox) {
		this.inbox = inbox;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSendername() {
		return sendername;
	}

	public void setSendername(String sendername) {
		this.sendername = sendername;
	}

	public Timestamp getSenton() {
		return senton;
	}

	public void setSenton(Timestamp senton) {
		this.senton = senton;
	}

	public Timestamp getRemark() {
		return remark;
	}

	public void setRemark(Timestamp remark) {
		this.remark = remark;
	}
	
	
}
