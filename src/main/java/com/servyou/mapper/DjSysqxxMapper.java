package com.servyou.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.servyou.model.DjSysqxx;
import com.servyou.model.DjSysqxxKey;
/**
 * <p>修改历史记录：
 * 修改时间：2017-3-8
 * 修改人：huangg
 * 修改内容：增加selectByDays()方法
 * </p>
 */
@Mapper
public interface DjSysqxxMapper {
    int deleteByPrimaryKey(DjSysqxxKey key);

    int insert(DjSysqxx record);

    int insertSelective(DjSysqxx record);

    DjSysqxx selectByPrimaryKey(DjSysqxxKey key);

    int updateByPrimaryKeySelective(DjSysqxx record);

    int updateByPrimaryKey(DjSysqxx record);
    //查询7天内试用申请的企业信息
    List<DjSysqxx> selectByDays(@Param(value = "fssj") Date fssj);
    DjSysqxx selectById(Integer qyid);
}