package com.datangedu.cn.service.Impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datang.hrb.util.MD5Util;
import com.datangedu.cn.dao.mapper.RegisterUserMapper;
import com.datangedu.cn.model.sysUser.RegisterUser;
import com.datangedu.cn.model.sysUser.RegisterUserExample;
import com.datangedu.cn.service.RegisterUserService;

@Service
public class RegisterUserServicelmpl implements RegisterUserService {
	
	@Resource
	RegisterUserMapper registerUserMapper;
	//通过手机号查
	@Override
	public List<RegisterUser> getcellphone(String id) {
		RegisterUserExample registerUserExample = new RegisterUserExample();
		RegisterUserExample.Criteria criteria = registerUserExample.createCriteria();
		criteria.andCellphoneEqualTo(id);
		return registerUserMapper.selectByExample(registerUserExample);
	}
	
	//注册插入用户
	@Override
	public int register(HttpServletRequest request) {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		System.out.println("id=="+uuid);
		RegisterUser m=new RegisterUser();
		System.out.println("手机号"+request.getParameter("cellphone"));
		System.out.println("密码"+request.getParameter("password"));

		java.sql.Date ctime = new java.sql.Date(new java.util.Date().getTime());

		m.setRegisterTime(ctime);
		m.setId(uuid);
		m.setUserName(request.getParameter("cellphone"));
		m.setCellphone(request.getParameter("cellphone"));
		m.setPassword(MD5Util.getMD5(request.getParameter("password").getBytes()));
		m.setStatus(1);
		return registerUserMapper.insert(m);
	}
	
	
	

		
	

		
}
