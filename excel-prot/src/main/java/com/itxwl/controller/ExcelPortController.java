package com.itxwl.controller;

import com.alibaba.excel.EasyExcel;
import com.itxwl.demo.ChildrenServiceA;
import com.itxwl.demo.CurrencyDataDto;
import com.itxwl.demo.EnvironMental;
import com.itxwl.mayi.PayContext;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Auther: 薛
 * @Date: 2020/11/20 13:45
 * @Description:
 */
@RestController
@RequestMapping("/export")
@AllArgsConstructor
public class ExcelPortController {
    private PayContext payContext;
    @GetMapping("exportTableDatas")
    public void   exportTableDatas(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String datetime=String.valueOf(Calendar.getInstance().getTimeInMillis())+".xls";
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition","attachment;filename="+new String(datetime.getBytes(),"iso-8859-1")+"");
        EasyExcel.write(response.getOutputStream(),PlanDetail.class).sheet().doWrite(PlanDetail.getPlanDetail());
//        Map<String, Object> map = new HashMap<>();
////从其它方法获的得集合
//        List<PlanDetail> planManageList = PlanDetail.getPlanDetail();
//        // 创建excel
//        HSSFWorkbook wk = new HSSFWorkbook();
//        // 创建一张工作表
//        HSSFSheet sheet = wk.createSheet();
//        // 2
//        sheet.setColumnWidth(0, 5000);
//        HSSFRow row = sheet.createRow(0);
//        // 创建第一行的第一个单元格
//        // 想单元格写值
//        HSSFCell cell = row.createCell((short) 0);
//        cell.setCellValue("姓名");
//        cell = row.createCell((short) 1);
//        cell.setCellValue("地址");
//        cell = row.createCell((short) 2);
//        cell.setCellValue("年龄");
//        cell = row.createCell((short) 3);
//        cell.setCellValue("邮箱");
//        cell = row.createCell((short) 4);
//        for (int i = 0; i < planManageList.size(); i++) {
//            HSSFRow row1 = sheet.createRow(i + 1);
//            row1.createCell(0).setCellValue(planManageList.get(i).getName());
//            row1.createCell(1).setCellValue(planManageList.get(i).getAddress());
//            row1.createCell(2).setCellValue(planManageList.get(i).getAges());
//            row1.createCell(3).setCellValue(planManageList.get(i).getEmail() );
//        }
//        String datetime=String.valueOf(Calendar.getInstance().getTimeInMillis())+".xls";
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("application/vnd.ms-excel");
//        response.setHeader("Content-disposition","attachment;filename="+new String(datetime.getBytes(),"iso-8859-1")+"");
//        String   url=null;
//        try {
//            url  =datetime;
//           // FileOutputStream outputStream = new FileOutputStream(url);
//            OutputStream outputStream=response.getOutputStream();
//            wk.write(outputStream);
//            outputStream.flush();
//            outputStream.close();
//
//        } catch (FileNotFoundException e) {
//            map.put("error","导出失败,找不到路径");
//            //return map;
//        } catch (IOException e) {
//
//        }
//        if (url==null){
//            map.put("error","导出失败");
//          //  return map;
//        }
//        map.put("success", true);
//        map.put("url",datetime);
//        boolean ss = StringUtils.isEmpty("ss");
//        boolean ss1 = ObjectUtils.isEmpty("ss");
    }

//    public static void main(String[] args) throws Exception{
//        Class aClass = Class.forName("com.itxwl.controller.PlanDetail");
//        Method[] methods = aClass.getMethods();
//        System.out.println(methods);
//    }
    @GetMapping("demo")
    public String getDemo(String pareCode){
        String s = payContext.toGetData(pareCode);
        return s;
//        CurrencyDataDto currencyDataDto = new ChildrenServiceA();
//        EnvironMental environMental = new EnvironMental(currencyDataDto);
//        String s = environMental.convertEnvironMental();
//        return s;
    }
}