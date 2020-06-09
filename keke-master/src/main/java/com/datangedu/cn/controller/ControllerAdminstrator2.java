package com.datangedu.cn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datang.hrb.util.MD5Util;
import com.datangedu.cn.model.sysUser.Adminstrator;
import com.datangedu.cn.model.sysUser.RegisterUser;
import com.datangedu.cn.service.AdminstratorUserService;
import com.datangedu.cn.service.RegisterUserService;
@Controller
@RequestMapping("api/Adminstratorregister2")
public class ControllerAdminstrator2 {
	//**************************登录********************************
	@Resource
	AdminstratorUserService adminstratorUserService;
	@ResponseBody
	@RequestMapping(value="/Adminstratorlogin",method=RequestMethod.POST)
	public Map<String,Object> adminstratorUserLogin(HttpServletRequest request) {
		Adminstrator adminstrator=new Adminstrator();
		System.out.println("获取登录信息");
		Map<String,Object> map=new HashMap<String,Object>();
		String cellphone=request.getParameter("cellphone");
		String password=request.getParameter("password");
		String code = request.getParameter("code");
		System.out.println(cellphone);
		System.out.println(password);


		if(request.getParameter("cellphone").isEmpty()) {
		map.put("msg","手机号为空");
		return map;
		}
		if(!(request.getParameter("cellphone").length()==11)) {
			map.put("msg","手机号必须为11位");
			return map;
		}
		if(password.isEmpty()){
			map.put("msg","密码为空");
			return map;
		}
	 if(request.getParameter("code").isEmpty()){
		 map.put("msg","验证码为空"); 
		 return map; }

		HttpSession session = request.getSession();
		  System.out.println("验证码"+session.getAttribute("code"));
		  if(!session.getAttribute("code").equals(request.getParameter("code").toUpperCase())) {
		   map.put("msg","验证码错误" );
		   return map;
		  }
		
		List<Adminstrator> AdminstratorInfo=adminstratorUserService.getcellphone(request.getParameter("cellphone"));
		System.out.println(AdminstratorInfo);
		
		if(AdminstratorInfo.isEmpty()) {
			map.put("msg","帐号不存在");
			return map;
		}else if(!AdminstratorInfo.get(0).getPassword().equals(MD5Util.getMD5(request.getParameter("password").getBytes()))) {
			map.put("msg","密码错误" );
			return map;
		}
		else {
			adminstrator.setStatus(1);
			int a=adminstratorUserService.updatestatus(adminstrator,request);
			map.put("code", 1);
			map.put("msg","恭喜登录成功");	
		}
		map.put("Adminstratorid",AdminstratorInfo.get(0).getId());
		map.put("Adminstratorname",AdminstratorInfo.get(0).getUserName());
		map.put("status", 1);
		return map;
	}
	//****************************用户找回密码***************************
		@ResponseBody
		@RequestMapping(value = "/Adminstratorfindpassword",method = RequestMethod.POST)
		public Map <String,Object> findPassword(HttpServletRequest request) {
			Map<String,Object> map = new HashMap<String,Object>();
			Adminstrator adminstrator=new Adminstrator();
			
			if(request.getParameter("cellphone").isEmpty()) {
				map.put("msg","输入手机号" );
				return map;
			}
			if(request.getParameter("code").isEmpty()) {
				map.put("msg","输入验证码" );
				return map;
			}
			if(!(request.getParameter("cellphone").length()==11)) {
				map.put("msg","手机号必须为11位");
				return map;
			}
			HttpSession session = request.getSession();
			if(!session.getAttribute("code").equals(request.getParameter("code").toUpperCase())) {
				map.put("msg","验证码错误" );
				return map;
			}
			if(request.getParameter("password1").isEmpty()) {
				map.put("msg","输入密码" );
				return map;
			}
			if(request.getParameter("password2").isEmpty()) {
				map.put("msg","再输入密码" );
				return map;
			}
			if(!request.getParameter("password1").equals(request.getParameter("password2"))) {
				map.put("msg","两次密码不一致");
				return map;
			}
			adminstrator.setPassword(MD5Util.getMD5(request.getParameter("password1").getBytes()));
			int a=adminstratorUserService.updatepassword(adminstrator, request);
			System.out.println("修改密码5"+a);
			map.put("stu", a);
			if(a==1) {
			map.put("msg", "修改成功");
			}else {
				map.put("msg", "账号不存在");
			}
			return map;
		}
}
