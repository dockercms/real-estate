package com.ztuo.common.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Set;

public class FileUtil<E> {

    public  RestResponse exportExcel(HttpServletRequest request, HttpServletResponse response, List<E> list, String name)
            throws
            Exception{
        if(list.isEmpty()){
            return  RestResponse.error(-1,"没有数据");
        }
        String physicalPath = request.getSession().getServletContext().getRealPath("/")+"excel/";
        String fileName = physicalPath+name+".csv";
        File savefile = new File(physicalPath);
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        ExportParams exportParams = new ExportParams();
        exportParams.setSheetName("sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, list.get(0).getClass(), list);
        FileOutputStream fos = new FileOutputStream(fileName);
        workbook.write(fos);
        fos.close();
        name = new String(name.getBytes(),"ISO-8859-1");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;filename="+name+".csv");
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream out = response.getOutputStream();
        File file = new File(fileName);
        InputStream in = new FileInputStream(file);
        int data=in.read();
        while(data!=-1){
            out.write(data);
            data=in.read();
        }
        in.close();
        out.close();
        file.delete();
        return  RestResponse.success();
    }


    public  RestResponse exportExcel(HttpServletRequest request, HttpServletResponse response, Set<E> list, String
            name) throws Exception{
        if(list.isEmpty()){
            return  RestResponse.error(-1,"没有数据");
        }
        String physicalPath = request.getSession().getServletContext().getRealPath("/")+"excel/";
        String fileName = physicalPath+name+".csv";
        File savefile = new File(physicalPath);
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        ExportParams exportParams = new ExportParams();
        exportParams.setSheetName("sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, list.iterator().next().getClass(), list);
        FileOutputStream fos = new FileOutputStream(fileName);
        workbook.write(fos);
        fos.close();
        name = new String(name.getBytes(),"ISO-8859-1");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;filename="+name+".csv");
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream out = response.getOutputStream();
        File file = new File(fileName);
        InputStream in = new FileInputStream(file);
        int data=in.read();
        while(data!=-1){
            out.write(data);
            data=in.read();
        }
        in.close();
        out.close();
        file.delete();
        return  RestResponse.success();
    }

    public RestResponse exportExcel(Workbook workbook , HttpServletResponse response, HttpServletRequest request, String name)throws Exception{
        String physicalPath = request.getSession().getServletContext().getRealPath("/")+"excel/";
        String fileName = physicalPath+name+".csv";
        File savefile = new File(physicalPath);
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        ExportParams exportParams = new ExportParams();
        exportParams.setSheetName("sheet1");
        FileOutputStream fos = new FileOutputStream(fileName);
        workbook.write(fos);
        fos.close();
        name = new String(name.getBytes(),"ISO-8859-1");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;filename="+name+".csv");
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream out = response.getOutputStream();
        File file = new File(fileName);
        InputStream in = new FileInputStream(file);
        int data=in.read();
        while(data!=-1){
            out.write(data);
            data=in.read();
        }
        in.close();
        out.close();
        file.delete();
        return  RestResponse.success();
    }

}
