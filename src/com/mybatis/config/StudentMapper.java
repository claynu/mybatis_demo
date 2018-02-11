package com.mybatis.config;

import java.util.List;

public interface StudentMapper {//该接口只定义查询方法 不执行具体查询
    //接口方法默认自带public
    int insertStudent(Student student) throws Exception;// 插入 int判断是否执行成功
    int deleteOneById(int username) throws Exception;
    Student selectOneById(int username,String password) throws Exception;//查询一条数据
    List<Student> selectAllStudent();//查询列表 封装到list中
}
