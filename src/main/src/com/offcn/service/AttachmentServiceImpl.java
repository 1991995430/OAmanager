package com.offcn.service;

import com.offcn.mapper.AttachmentMapper;
import com.offcn.pojo.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-24 16:17
 */
@Service
public class AttachmentServiceImpl implements AttachmentService{
    @Autowired
    private AttachmentMapper attachmentMapper;


    @Override
    public int insert(Attachment attachment) {
        return attachmentMapper.insert(attachment);
    }

    @Override
    public List<Attachment> selectAttachmentPname() {
        return attachmentMapper.selectAttachmentPname();
    }
}
