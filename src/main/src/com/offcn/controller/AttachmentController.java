package com.offcn.controller;

import com.offcn.pojo.Attachment;
import com.offcn.service.AttachmentService;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author songmu
 * @create 2019-06-24 10:51
 */
@Controller
public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;
    //上传附件
    @RequestMapping("/fileUpload")
    public void fileUpload(@RequestParam("file")MultipartFile file, Attachment attachment, HttpServletRequest request, HttpServletResponse response){
        int istate = 0;
            if(file.getSize()>0){
                //获取文件名
                String filename = file.getOriginalFilename();
                //获取上传路径
                String realpath = request.getServletContext().getRealPath("upload");
                String newPath = realpath+"/"+filename;
                File file1 = new File(newPath);
            try {
                file.transferTo(file1);
                attachment.setPath(filename);
                istate = attachmentService.insert(attachment);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(istate==1){
            try {
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().write("<script>alert('添加成功!');location.href='project-file.jsp'</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @RequestMapping("/getAttachmentList")
    @ResponseBody
    public List<Attachment> getAttachmentList(){

        List<Attachment> list = attachmentService.selectAttachmentPname();
        //System.out.println("查询到的附件信息：："+list);
        return list;
    }

    //下载附件
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(String fileName, HttpServletRequest request, HttpServletResponse response){

        System.out.println(fileName);
        ResponseEntity<byte[]> entity = null;
        if(fileName.length()==0 ){
            response.setContentType("text/html; charset=utf-8");
            try {
                response.getWriter().write("<script>alert('文件不存在!');location.href='project-file.jsp'</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
                //1上传路径--fileName文件名称
                String strRealPath = request.getServletContext().getRealPath("upload");
                String newFile = strRealPath + "/" + fileName;
                File file = new File(newFile);

                if (!file.exists()) {
                    response.setContentType("text/html; charset=utf-8");
                    try {
                        response.getWriter().write("<script>alert('文件不存在!');location.href='project-file.jsp'</script>");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            try {
                HttpHeaders header = new HttpHeaders();
                header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                header.setContentDispositionFormData("attachment", fileName);
                entity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), header, HttpStatus.OK);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return entity;
    }

    //导出Excel文件
    @RequestMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response){

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet =  hssfWorkbook.createSheet("附件");

        HSSFRow row = sheet.createRow(0);
        HSSFCell[] cells = new HSSFCell[6];
        for (int i = 0; i <cells.length ; i++) {
            cells[i] = row.createCell(i);
        }
        cells[0].setCellValue("序号");
        cells[1].setCellValue("附件名称");
        cells[2].setCellValue("所属项目");
        cells[3].setCellValue("附件个数");
        cells[4].setCellValue("上传时间");
        cells[5].setCellValue("修改时间");

            List<Attachment> list = attachmentService.selectAttachmentPname();
            for (int i = 0; i <list.size() ; i++) {
                HSSFRow row1 = sheet.createRow(i+1);
                HSSFCell[] cell1 = new HSSFCell[6];
                for (int j = 0; j <cell1.length ; j++) {
                    cell1[j] = row1.createCell(j);
                }
            Attachment attachment = list.get(i);
            cell1[0].setCellValue(attachment.getId());
            cell1[1].setCellValue(attachment.getAttname());
            cell1[2].setCellValue(attachment.getProject().getPname());
            //cell1[2].setCellValue(attachment.getProFk());
            cell1[3].setCellValue(3);
            cell1[4].setCellValue("2019-01-03");
            cell1[5].setCellValue("2019-05-03");
        }
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            response.setContentType("application/msexcel");
            response.setHeader("Content-Disposition","attachment;filename=attach.xls");
            hssfWorkbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
