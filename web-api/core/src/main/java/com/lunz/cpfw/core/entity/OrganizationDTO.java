package com.lunz.cpfw.core.entity;

import lombok.Data;

/**
 * 
 * @Title:OrganizationDTO
 * @Package com.lunz.uc.users.dto
 * @Description: 
 * @author Liuruixia
 * @date 2019/04/17
 */
@Data
public class OrganizationDTO {
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
}
