package com.servyou.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.servyou.model.DjQyxx;
@Mapper
public interface DjQyxxMapper {
    /**
     * 查询从当前开始往前一周的所有注册的企业
     * @param fssj
     * @return
     */
    List<DjQyxx> getQyxxByDay(@Param(value = "lrsj") Date lrsj);

}