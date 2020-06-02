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
import com.datangedu.cn.model.sysUser.RegisterUser;
import com.datangedu.cn.service.RegisterUserService;

//登录
@Controller
@RequestMapping("/provider")
public class ControllerRegister2 {
	@Resource
	RegisterUserService registerUserService;
	@ResponseBody
	@RequestMapping(value="/providerlogin",method=RequestMethod.POST)
	public Map<String,Object> memberLogin(HttpServletRequest request) {
		System.out.println(8888888);
		Map<String,Object> map=new HashMap<String,Object>();
		String cellphone=request.getParameter("cellphone");
		String password=request.getParameter("password");
		String code = request.getParameter("code");
		System.out.println(cellphone);

		if(request.getParameter("cellphone").isEmpty()) {
		map.put("msg","手机号为空");
		return map;
		}
		if(!(request.getParameter("cellphone").length()==11)) {
			map.put("msg","手机号必须为11位");
			return map;
		}
		System.out.println(12354);
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
		
		List<RegisterUser> memberInfo=registerUserService.getcellphone(request.getParameter("cellphone"));
		System.out.println(memberInfo);
		
		if(memberInfo.isEmpty()) {
			map.put("msg","帐号不存在");
			return map;
		}else if(!memberInfo.get(0).getPassword().equals(MD5Util.getMD5(request.getParameter("password").getBytes()))) {
			map.put("msg","密码错误" );
			return map;
		}
		else {
			map.put("code", 1);
			map.put("msg","恭喜登录成功");		
		}
		map.put("username", memberInfo.get(0).getUserName());
		map.put("userid", memberInfo.get(0).getId());
		return map;
	}
}
