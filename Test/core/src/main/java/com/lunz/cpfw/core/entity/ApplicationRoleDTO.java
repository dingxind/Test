package com.lunz.cpfw.core.entity;

import lombok.Data;

/**
 * 
 * @Title:ApplicationRole
 * @Package com.lunz.uc.users.dto
 * @Description: 
 * @author Liuruixia
 * @date 2019/04/17
 */
@Data
public class ApplicationRoleDTO {
	private String id;
	private String name;

	public ApplicationRoleDTO(String id, String name) {
		this.setId(id);
		this.setName(name);
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
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}
