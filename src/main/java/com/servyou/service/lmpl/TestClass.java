package com.servyou.service.lmpl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servyou.mapper.DjSysqxxMapper;
import com.servyou.model.DjSysqxx;

@Transactional
@Component
public class TestClass {

	@Autowired
	private DjSysqxxMapper djSysqxxMapper;
	public DjSysqxx getInfo(Integer qyid){
		if(djSysqxxMapper!=null){
			String name = djSysqxxMapper.selectById(qyid).toString();
			System.out.println(name);
			return djSysqxxMapper.selectById(qyid);
		}
		return null;
	}

}
