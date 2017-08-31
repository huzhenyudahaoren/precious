package cn.e3.utils;

import java.io.Serializable;

public class TreeNode implements Serializable{
	//id
	private Integer id;
	//树形菜单名称
	private String text;
	//状态,是否是父节点
	private String state;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
