package com.lunz.cpfw.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 
 * @Title:CurrentUser
 * @Package com.lunz.uc.users.dto
 * @Description: 
 * @author Liuruixia
 * @date 2019/04/17
 */
@Data
public class CurrentUserDTO implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3902673607259720897L;
	/**
	 * userId 用户Id
	 */
	@JSONField(name = "sub")
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * loginName 登录名
	 */
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPlainRoles() {
		return plainRoles;
	}

	public void setPlainRoles(List<String> plainRoles) {
		this.plainRoles = plainRoles;
	}

	public List<OrganizationDTO> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<OrganizationDTO> organizations) {
		this.organizations = organizations;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * name 用户名称
	 */
	private String userName;
	/**
	 * email 邮箱地址
	 */
	private String email;
	/**
	 * plainRoles 角色
	 */
	private List<String> plainRoles;
	/**
	 * roles 应用角色
	 */
	private List<ApplicationRoleDTO> roles;
	/**
	 * organizations 所属机构列表
	 */
	private List<OrganizationDTO> organizations;
	/**
	 * authToken 兼容老用户中心Token
	 */
	private String authToken;
	/**
	 * DepartmentId 部门ID
	 */
	protected String departmentId;
	/**
	 * OrganizationId 组织机构ID
	 */
	protected String organizationId;
	/**
	 * OrganizationName 组织机构名称
	 */
	protected String organizationName;
	/**
	 * DepartmentName 部门名称
	 */
	protected String departmentName;

	public CurrentUserDTO() {
		plainRoles = new ArrayList<String>();
		setRoles(new ArrayList<ApplicationRoleDTO>());
		organizations = new ArrayList<OrganizationDTO>();
	}

	/**
	 * @return the roles
	 */
	public List<ApplicationRoleDTO> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<ApplicationRoleDTO> roles) {
		this.roles = roles;
	}
}
