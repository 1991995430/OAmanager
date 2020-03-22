package com.offcn.controller;

import com.offcn.pojo.Datacollect;
import com.offcn.service.DatacollectService;
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
 * @create 2019-06-27 17:04
 */
@Controller
public class DataCollectController {
    @Autowired
    private DatacollectService datacollectService;
    @RequestMapping("/addDatacollect")
    public String addDatacollect(@RequestParam("files") MultipartFile files, HttpServletRequest request) throws IOException{

        if(files.getSize()>0){

            String realpath = request.getServletContext().getRealPath("upload");
            String fileName = files.getOriginalFilename();
            String newPath = realpath+"/"+fileName;

            File file = new File(newPath);
            try {
                files.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

            InputStream inputStream = new FileInputStream(file);

            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

            for (int i = 0; i <workbook.getNumberOfSheets() ; i++) {
                HSSFSheet sheet = workbook.getSheetAt(i);
                if(sheet==null){
                    continue;
                }

                List<Datacollect> list = new ArrayList<Datacollect>();

                for(int j=0;j<sheet.getLastRowNum();j++){

                    HSSFRow row = sheet.getRow(j);
                    if(row==null){
                        continue;
                    }

                    Datacollect datacollect = new Datacollect();

                   // datacollect.setDaid((int)row.getCell(0).getNumericCellValue());
                    datacollect.setDacname(row.getCell(0).getStringCellValue());
                    datacollect.setDaturnover(row.getCell(1).getNumericCellValue());
                    datacollect.setDatime(row.getCell(2).getDateCellValue());
                    datacollect.setDabusiness(row.getCell(3).getStringCellValue());
                    datacollect.setDasuperiority(row.getCell(4).getStringCellValue());
                    datacollect.setDainforiority(row.getCell(5).getStringCellValue());
                    datacollect.setDasort((int)row.getCell(6).getNumericCellValue());
                    datacollect.setEmpcount((int)row.getCell(7).getNumericCellValue());
                    datacollect.setBuildtime(row.getCell(8).getDateCellValue());
                    datacollect.setRemark(row.getCell(9).getStringCellValue());
                    datacollect.setDaother(row.getCell(10).getStringCellValue());

                    list.add(datacollect);
                }

                System.out.println("************************");
                System.out.println("list:::"+list);

                int istate=0;
                if(list.size()>0){
                   istate =  datacollectService.insert(list);
                }
                if(istate>0){
                    return "duibiao-base";
                }
            }
        }
        return "duibiao-add";
    }

    @RequestMapping("/getDatacollectList")
    @ResponseBody
    public List<Datacollect> getDatacollectList(){

        return datacollectService.selectByExcemple();

    }

    @RequestMapping("/getDacname")
    @ResponseBody
    public List<Datacollect> getDacname(){
        return datacollectService.selectAllDaname();
    }
    //getDatacollectMsg
    @RequestMapping("/getDatacollectMsg")
    @ResponseBody
    public Datacollect getDatacollectMsg(Integer daid){

        return datacollectService.selectByPrimaryKey(daid);

    }

    @RequestMapping("/selectByDaname")
    @ResponseBody
    public List<Datacollect> selectByDaname(){

        return datacollectService.selectByExample("浪潮集团");
    }
}
