package com.lunz.cpfw.core.entity;

import lombok.Data;

/**
 * 
 * @Title:DepartmentDTO
 * @Package com.lunz.uc.users.dto
 * @Description: 部门信息
 * @author Liuruixia
 * @date 2019/04/17
 */
@Data
public class DepartmentDTO {
	private String id;
	private String name;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}
