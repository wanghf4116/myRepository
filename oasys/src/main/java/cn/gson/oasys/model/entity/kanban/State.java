package cn.gson.oasys.model.entity.kanban;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aoa_state")
public class State {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;			//看板id
	
	@Column(name="state_id")
	private Integer state_id;		//状态id
	
	@Column(name="state_name")
	
	private String state_name;		//状态名称

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getState_id() {
		return state_id;
	}

	public void setState_id(Integer state_id) {
		this.state_id = state_id;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	
	
	public State() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", state_id=" + state_id + ", state_name=" + state_name + ", getId()=" + getId()
				+ ", getState_id()=" + getState_id() + ", getState_name()=" + getState_name() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
