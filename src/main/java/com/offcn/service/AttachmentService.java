package com.offcn.service;

import com.offcn.pojo.Attachment;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-24 16:16
 */
public interface AttachmentService {

    int insert(Attachment attachment);
    List<Attachment> selectAttachmentPname();

}
