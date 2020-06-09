package com.datangedu.cn.dao.mapper;

import com.datangedu.cn.model.sysUser.Stb;
import com.datangedu.cn.model.sysUser.StbExample;
import com.datangedu.cn.model.sysUser.StbWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface StbMapper {
    long countByExample(StbExample example);

    int deleteByExample(StbExample example);

    int deleteByPrimaryKey(String id);

    int insert(StbWithBLOBs record);

    int insertSelective(StbWithBLOBs record);

    List<StbWithBLOBs> selectByExampleWithBLOBs(StbExample example);

    List<Stb> selectByExample(StbExample example);

    StbWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StbWithBLOBs record, @Param("example") StbExample example);

    int updateByExampleWithBLOBs(@Param("record") StbWithBLOBs record, @Param("example") StbExample example);

    int updateByExample(@Param("record") Stb record, @Param("example") StbExample example);

    int updateByPrimaryKeySelective(StbWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(StbWithBLOBs record);

    int updateByPrimaryKey(Stb record);

	List<StbWithBLOBs> selectProgramByExample(StbExample stbExample);//热门节目
	
	List<StbWithBLOBs> selectmarketExample(StbExample stbExample);//營銷支撐
	
	List selectByLike(String cellphone);

}