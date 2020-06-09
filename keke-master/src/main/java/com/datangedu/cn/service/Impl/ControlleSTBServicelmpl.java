package com.datangedu.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.AdminstratorMapper;
import com.datangedu.cn.dao.mapper.StbMapper;
import com.datangedu.cn.model.sysUser.RegisterUser;
import com.datangedu.cn.model.sysUser.RegisterUserExample;
import com.datangedu.cn.model.sysUser.Stb;
import com.datangedu.cn.model.sysUser.StbExample;
import com.datangedu.cn.model.sysUser.StbWithBLOBs;
import com.datangedu.cn.service.AdminstratorUserService;
import com.datangedu.cn.service.ControlleSTBService;
@Service
public class ControlleSTBServicelmpl implements ControlleSTBService {
	@Resource
	StbMapper stbMapper;
	//*******************************所有机顶盒用户渲染************************
	@Override
	public List<StbWithBLOBs> getSTBInfo(HttpServletRequest request) {
			System.out.println("查询数据");
			StbExample stbExample = new StbExample();
			StbExample.Criteria criteria = stbExample.createCriteria();
			//criteria.andIdEqualTo(request.getParameter("userid"));
			stbExample.setPageNum(Integer.parseInt(request.getParameter("pageNum")));
			stbExample.setPageSize(Integer.parseInt(request.getParameter("pageSize")));

			return stbMapper.selectByExampleWithBLOBs(stbExample);
		
	}
	//******************************模糊搜索***************************************
	@Override
	public List selectByLikeCellphone(HttpServletRequest request) {
		List cellphone=stbMapper.selectByLike(request.getParameter("cellphone"));
		return cellphone;
	}
	//*******************************热门节目信息***************************************
	@Override
	public List<StbWithBLOBs> getProgramInfo(HttpServletRequest request) {
		StbExample stbExample = new StbExample();
		StbExample.Criteria criteria = stbExample.createCriteria();
		return stbMapper.selectProgramByExample(stbExample);
	}
	
	//*******************************營銷支撐信息***************************************
		@Override
		public List<StbWithBLOBs> getmarketInfo(HttpServletRequest request) {
			StbExample stbExample = new StbExample();
			StbExample.Criteria criteria = stbExample.createCriteria();
			return stbMapper.selectmarketExample(stbExample);
		}
	

}
