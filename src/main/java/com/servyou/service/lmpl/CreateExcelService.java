package com.servyou.service.lmpl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.servyou.mapper.DjQyxxMapper;
import com.servyou.mapper.DjSysqxxMapper;
import com.servyou.model.DjQyxx;
import com.servyou.model.DjSysqxx;
@Component
public class CreateExcelService {
	private static final Logger LOG = LoggerFactory.getLogger(CreateExcelService.class);
	@Resource
	private DjSysqxxMapper djSysqxxMapper;
	@Resource
	private DjQyxxMapper djQyxxMapper;
	public String downloadExcel() {  
 	        Date date = new Date();  
	        DateFormat sdf = new SimpleDateFormat("yyyyMMdd");   
	        String fileName = sdf.format(date);  
	        String filePath = fileName + ".xls";
	        LOG.info(filePath);
	        List<Map<Integer,String>> sySqxxexcelList = getSySqxxExcelList();
	        List<Map<Integer,String>> registerQyxxexcelList = getRegisterQyxxExcelList();
	        try {
	        	HSSFWorkbook workbook = new HSSFWorkbook();
	        	if(sySqxxexcelList!=null){
	        		ExcelUtil.writeExcel(filePath, sySqxxexcelList, workbook, "申请试用表");
	        	}else{
	        		LOG.info("最近没有公司申请适用");
	        	}
	        	if(registerQyxxexcelList!=null){
	        		ExcelUtil.writeExcel(filePath, registerQyxxexcelList,workbook,"企业信息表");
	        	}else{
	        		LOG.info("最近没有公司注册使用");
	        	}
			} catch (IOException e) {
				LOG.info("EXECL输出出错");
			} 
	        return filePath;  
	    }  
	
	public List<Map<Integer,String>> getSySqxxExcelList(){
		Date fssj = new Date();
    	List<DjSysqxx> djSysqxxs = djSysqxxMapper.selectByDays(fssj);
    	Map<Integer,String> cellParamTitle = new HashMap<Integer,String>();
    	List<Map<Integer,String>> excelList = new ArrayList<Map<Integer,String>>();
    	cellParamTitle.put(0,"企业名称");
    	cellParamTitle.put(1,"纳税人识别号");
    	cellParamTitle.put(2,"申请人姓名");
    	cellParamTitle.put(3,"联系方式");
    	excelList.add(cellParamTitle);
    	LOG.info("excelList长度："+excelList.size());
    	for(DjSysqxx sysqxx:djSysqxxs){
    		Map<Integer,String> cellParam = new HashMap<Integer,String>();
    		cellParam.put(0, sysqxx.getQymc());
    		cellParam.put(1, sysqxx.getNsrsbh());
    		cellParam.put(2, sysqxx.getXm());
    		cellParam.put(3, sysqxx.getLxdh());
    		excelList.add(cellParam);
    		LOG.info("excelList长度："+excelList.size());
    	}
    	return excelList;
	}
	public List<Map<Integer,String>> getRegisterQyxxExcelList(){
		Date lrsj = new Date();
    	List<DjQyxx> djQyxxs = djQyxxMapper.getQyxxByDay(lrsj);
    	Map<Integer,String> cellParamTitle = new HashMap<Integer,String>();
    	List<Map<Integer,String>> excelList = new ArrayList<Map<Integer,String>>();
    	cellParamTitle.put(0,"企业名称");
    	cellParamTitle.put(1,"纳税人识别号");
    	cellParamTitle.put(2,"用户名");
    	cellParamTitle.put(3,"登录名");
    	cellParamTitle.put(4,"联系方式");
    	cellParamTitle.put(5,"行业代码");
    	cellParamTitle.put(6,"地区代码");
    	excelList.add(cellParamTitle);
    	for(DjQyxx qyxx:djQyxxs){
    		Map<Integer,String> cellParam = new HashMap<Integer,String>();
    		cellParam.put(0, qyxx.getQymc());
    		cellParam.put(1, qyxx.getNsrsbh());
    		cellParam.put(2, qyxx.getYhm());
    		cellParam.put(3, qyxx.getDlm());
    		cellParam.put(4, qyxx.getSjhm());
    		cellParam.put(5, qyxx.getHydm());
    		cellParam.put(6, qyxx.getDqdm());
    		excelList.add(cellParam);
    	}
    	return excelList;
	}
}
