package com.offcn.service;

import com.offcn.mapper.CustomerMapper;
import com.offcn.pojo.Customer;
import com.offcn.pojo.CustomerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-19 14:23
 */
//alt+enter
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    public int deleteByPrimaryKey(Integer[] ids) throws Exception{
        for (Integer id : ids) {
            customerMapper.deleteByPrimaryKey(id);
        }
        return 1;
    }

    @Override
    public int insert(Customer record) {
        return customerMapper.insert(record);
    }


    @Override
    public Customer selectByPrimaryKey(Integer id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Customer record) {
        return customerMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Customer> selectByExample(Integer searchType,String key,String order) {
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria c = example.createCriteria();
        if(searchType!=null){
            if(searchType==1){//客户所在公司名称
                c.andComnameLike("%"+key+"%");
            }else if(searchType==2){//联系人姓名
                c.andCompanypersonLike("%"+key+"%");
            }
        }
        example.setOrderByClause(order);
        return customerMapper.selectByExample(example);
    }

    @Override
    public List<Customer> selectByProjectExample() {
        return customerMapper.selectByExample(null);
    }
}
