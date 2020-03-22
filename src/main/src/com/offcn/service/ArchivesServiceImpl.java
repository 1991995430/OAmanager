package com.offcn.service;

import com.offcn.mapper.ArchivesMapper;
import com.offcn.pojo.Archives;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-26 15:58
 */
@Service
public class ArchivesServiceImpl implements ArchivesService{

    @Autowired
    private ArchivesMapper archivesMapper;

    @Override
    public List<Archives> selectArchEmp() {

        return archivesMapper.selectArchEmp();
    }

    @Override
    public int insert(List list) {
        int istate = 0;
        for (int i = 0; i < list.size(); i++) {
            Archives a = (Archives) list.get(i);
            istate+=archivesMapper.insert(a);
        }
        return istate;

    }
}
