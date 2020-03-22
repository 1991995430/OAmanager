package com.offcn.service;

import com.offcn.pojo.Notice;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-25 19:45
 */
public interface NoticeService {

    int insert(Notice record);

    List<Notice> selectByExample();

    public List<Notice> selectnoticeOrderByTime();

    public Notice selectnoticeOrderByNid(Integer nid);
}
