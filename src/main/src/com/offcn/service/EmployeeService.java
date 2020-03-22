package com.offcn.service;

import com.offcn.pojo.Employee;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-21-8:37
 */
public interface EmployeeService {

    public List<Employee> selectByExample();

    Employee selectByUserNamePwdExample(String username, String password);

    List<Employee> selectEmpPos();

    int insertSelectiveReturnEmpid(Employee employee);

    public List<Employee> selectByUserName(String username);

    List selectByExample1(Employee employee);

}
