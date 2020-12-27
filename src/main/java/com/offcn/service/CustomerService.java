package com.offcn.service;

import com.offcn.pojo.Customer;
import com.offcn.pojo.CustomerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerService {

    int deleteByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer[] ids) throws Exception;

    int insert(Customer record);


    Customer selectByPrimaryKey(Integer id);


    int updateByPrimaryKey(Customer record);

    List<Customer> selectByExample(Integer searchType, String key, String order);

    //项目添加中查询客户信息
    List<Customer> selectByProjectExample();
}