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

import com.servyou.mapper.DjSysqxxMapper;
import com.servyou.model.DjSysqxx;
@Component
public class CreateExcel {
	private static final Logger LOG = LoggerFactory.getLogger(CreateExcel.class);
	@Resource
	private DjSysqxxMapper djSysqxxMapper;
	public String downloadChild() {  
 	        Date date = new Date();  
	        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
	        String fileName = sdf.format(date);  
	        //得到桌面路径  
//	        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
//	        String desktopPath = desktopDir.getAbsolutePath();  
//	        LOG.info(desktopPath);
//	        String desktopDirPath = desktopPath.replace("\\","\\\\");  
//	        LOG.info(desktopDirPath);
//	        String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
	        
//	        String filePath = "\\SpringBoot\\src\\main\\resources\\sendExcelMessage" + fileName + ".xls";
	        String currentPath = getClass().getResource("").getFile().toString();
//	        String rootPath=getClass().getResource("/").getFile().toString();
	        LOG.info(currentPath);
	        String filePath = fileName + ".xls";
	        LOG.info(filePath);
	        List<Map<Integer,String>> sySqxxexcelList = getSySqxxExcelList();
	        try {
	        	HSSFWorkbook workbook = new HSSFWorkbook();
//	        	ExcelUtil.writeExcel(titles, excelList,workbook,"申请试用表");
				ExcelUtil.writeExcel(filePath, sySqxxexcelList, workbook, "测试申请试用表");
				ExcelUtil.writeExcel(filePath, sySqxxexcelList,workbook,"申请试用表");
			} catch (IOException e) {
				LOG.info("EXECL输出出错");
			}
	        Map<String,Object> json = new HashMap<String, Object>();  
	        json.put("message", "导出Excel文件到桌面，文件名为：" + fileName + ".xls");  
	        return filePath;  
	    }  
	
	public List<Map<Integer,String>> getSySqxxExcelList(){
		Date fssj = new Date();
    	List<DjSysqxx> djSysqxxs = djSysqxxMapper.selectByDays(fssj);
    	Map<Integer,String> cellParams = new HashMap<Integer,String>();
    	List<Map<Integer,String>> excelList = new ArrayList<Map<Integer,String>>();
    	cellParams.put(0,"企业名称");
    	cellParams.put(1,"纳税人识别号");
    	cellParams.put(2,"申请人姓名");
    	cellParams.put(3,"联系方式");
    	excelList.add(cellParams);
    	for(DjSysqxx sysqxx:djSysqxxs){
    		cellParams.put(0, sysqxx.getQymc());
    		cellParams.put(1, sysqxx.getNsrsbh());
    		cellParams.put(2, sysqxx.getXm());
    		cellParams.put(3, sysqxx.getLxdh());
    		excelList.add(cellParams);
    	}
    	return excelList;
	}
}
