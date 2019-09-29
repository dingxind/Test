package com.lunz.cpfw.core.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.lunz.cpfw.core.entity.ApplicationRoleDTO;
import com.lunz.cpfw.core.entity.CurrentUserDTO;

import org.springframework.security.jwt.JwtHelper;

public class JwtService implements Serializable {

    private static final long serialVersionUID = -5411576208518588161L;
    private static final String CLAIM_ROLE_KEY = "http://schemas.microsoft.com/ws/2008/06/identity/claims/role";

    /**
     * 获取用户信息
     * 
     * @param token jwt token
     * @return
     */
    public static CurrentUserDTO getClaimsFromToken(String token) {
        try {
            List<ApplicationRoleDTO> appRoles = new ArrayList<ApplicationRoleDTO>();
            String claimsBody = JwtHelper.decode(token).getClaims();
            JSONObject jsonObj = JSONObject.parseObject(claimsBody);
            Object roleObject = jsonObj.get(CLAIM_ROLE_KEY);
            if (roleObject != null) {
                if (roleObject instanceof String) {
                    roleObject = "[\"" + roleObject + "\"]";
                }
                List<String> roleList = JSONObject.parseArray(roleObject.toString(), String.class);
                for (String role : roleList) {
                    String[] arr = role.split(":");
                    appRoles.add(new ApplicationRoleDTO(arr[0], arr[1]));
                }
            }
            CurrentUserDTO currentUserDTO = JSONObject.parseObject(claimsBody, CurrentUserDTO.class);
            currentUserDTO.setRoles(appRoles);
            return currentUserDTO;

        } catch (Exception e) {
            throw e;
        }
    }
}