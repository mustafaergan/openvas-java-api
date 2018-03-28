package com.out.openvasclient.model.requests;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.out.openvasclient.util.BooleanStringAdapter;

import javax.xml.bind.annotation.XmlAttribute;


@XmlRootElement(name="get_tasks")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetTasksRequest {
	
	@XmlAttribute(name= "task_id")
	private String taskId;
	
	@XmlAttribute
	private String filter;
	
	@XmlAttribute(name="filt_id")
	private String filterID;
	
	@XmlAttribute
	@XmlJavaTypeAdapter(BooleanStringAdapter.class)
	private Boolean trash = false;
	
	@XmlAttribute(name = "details")	
	@XmlJavaTypeAdapter(BooleanStringAdapter.class)
	private Boolean details = false;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getFilterID() {
		return filterID;
	}

	public void setFilterID(String filterID) {
		this.filterID = filterID;
	}

	public Boolean isTrash() {
		return trash;
	}

	public void setTrash(Boolean trash) {
		this.trash = trash;
	}

	public Boolean isDetails() {
		return details;
	}

	public void setDetails(Boolean details) {
		this.details = details;
	}
	
	
	
}
