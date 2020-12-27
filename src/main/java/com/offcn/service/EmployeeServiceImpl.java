package com.offcn.service;

import com.offcn.mapper.EmployeeMapper;
import com.offcn.pojo.Employee;
import com.offcn.pojo.EmployeeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-21-8:37
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> selectByExample() {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andPFkEqualTo(4);

        return employeeMapper.selectByExample(example);
    }

    @Override
    public Employee selectByUserNamePwdExample(String username, String password) {

        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria c =  example.createCriteria();
        //查询用户名及密码是否存在
        c.andUsernameEqualTo(username);
        c.andPasswordEqualTo(password);

        List<Employee> list=employeeMapper.selectByExample(example);
        Employee employee=null;
        if(list.size()==1){
            employee = list.get(0);
        }
        return employee;
    }

    @Override
    public List<Employee> selectEmpPos() {
        return employeeMapper.selectEmpPos();
    }


    @Override
    public int insertSelectiveReturnEmpid(Employee employee) {
        return employeeMapper.insertSelectiveReturnEmpid(employee);
    }

    @Override
    public List<Employee> selectByUserName(String username) {

        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        return employeeMapper.selectByExample(example);
    }

    @Override
    public List selectByExample1(Employee employee) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(employee.getUsername());
        return employeeMapper.selectByExample1(example);
    }


}
