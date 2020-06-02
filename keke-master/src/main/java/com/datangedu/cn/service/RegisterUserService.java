package com.datangedu.cn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.sysUser.RegisterUser;


public interface RegisterUserService {
	public int register(HttpServletRequest request);
	List<RegisterUser> getcellphone(String id);
}
