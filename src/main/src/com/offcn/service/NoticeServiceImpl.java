package com.offcn.service;

import com.offcn.mapper.NoticeMapper;
import com.offcn.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-25 19:45
 */
@Service
public class NoticeServiceImpl implements NoticeService{
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public int insert(Notice record) {
        return noticeMapper.insert(record);
    }

    @Override
    public List<Notice> selectByExample() {
        return noticeMapper.selectByExample(null);
    }

    @Override
    public List<Notice> selectnoticeOrderByTime() {


        return noticeMapper.selectnoticeOrderByTime();
    }

    @Override
    public Notice selectnoticeOrderByNid(Integer nid) {

        /*NoticeExample example = new NoticeExample();
        NoticeExample.Criteria criteria = example.createCriteria();
        criteria.andNidEqualTo(nid);
        return noticeMapper.selectByExample(example);*/
        return noticeMapper.selectByPrimaryKey(nid);
    }
}

