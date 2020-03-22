package com.offcn.controller;

import com.offcn.pojo.Archives;
import com.offcn.service.ArchivesService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author songmu
 * @create 2019-06-26 15:47
 */
@Controller
public class ArchivesController {
    @Autowired
    private ArchivesService archivesService;

    @RequestMapping("/getArchiesList")
    @ResponseBody
    public List<Archives> getArchiesList(){
        return archivesService.selectArchEmp();
    }

    //
    @RequestMapping("/getReceivePerson")
    @ResponseBody
    public List<Archives> getReceivePerson(){
        return archivesService.selectArchEmp();
    }


    @RequestMapping("/archivesadd")
    public String archivesAdd(@RequestParam("files")MultipartFile file, HttpServletRequest request) throws IOException {

        if(file.getSize()>0){
            //获取文件上传服务器的路径
            String realPath = request.getServletContext().getRealPath("upload");
            //获取文件名
            String fielName = file.getOriginalFilename();
            //获取文件上传后的路径
            String filePath = realPath+"/"+fielName;
            File file1=new File(filePath);
            //上传文件到指定路径
            file.transferTo(file1);
            //将文件以流的形式读取
            InputStream inputStream = new FileInputStream(file1);

            //创建工作表 读取上传的文件
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            //创建sheet表
            for(int i=0;i<workbook.getNumberOfSheets();i++){
                //获取sheet
                HSSFSheet sheet = workbook.getSheetAt(i);
                if(sheet==null) {
                    continue;
                }
                //通过sheet获取行记录
                List<Archives> list=new ArrayList<>();
                for(int j=0;j<sheet.getLastRowNum();j++){

                    //读取每一行
                    HSSFRow row = sheet.getRow(j);
                    if(row==null) {
                        continue;
                    }

                    Archives archives=new Archives();
                    //获取单元格中的数据保存到对象中
                    archives.setDnum(row.getCell(0).getStringCellValue());
                    archives.setLandline(row.getCell(1).getStringCellValue());
                    archives.setSchool(row.getCell(2).getStringCellValue());
                    archives.setZhuanye(row.getCell(3).getStringCellValue());
                    archives.setSosperson(row.getCell(4).getStringCellValue());
                    archives.setBiyedate(row.getCell(5).getDateCellValue());
                    archives.setZzmm(row.getCell(6).getStringCellValue());
                    archives.setMinzu(row.getCell(7).getStringCellValue());
                    archives.setXueli(row.getCell(8).getStringCellValue());
                    archives.setEmail(row.getCell(9).getStringCellValue());
                    archives.setEmpFk((int) row.getCell(10).getNumericCellValue());
                    archives.setRemark(row.getCell(11).getStringCellValue());
                    archives.setHirdate(row.getCell(12).getDateCellValue());

                    list.add(archives);
                }
                System.out.println("*********************************");
                System.out.println("list:"+list);
                //写入数据表
                try {
                    if(list.size()>0) {
                        archivesService.insert(list);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return "archives";
    }
}
