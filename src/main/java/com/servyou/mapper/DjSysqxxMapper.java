package com.servyou.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.servyou.model.DjSysqxx;

@Mapper
public interface DjSysqxxMapper {
    //查询7天内试用申请的企业信息
    List<DjSysqxx> selectByDays(@Param(value = "fssj") Date fssj);
}