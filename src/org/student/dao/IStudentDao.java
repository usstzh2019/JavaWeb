package org.student.dao;

import org.student.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface IStudentDao {

    /*判断学生是否存在*/
    public boolean isExist(int sno);


    /*增加学生*/
    public boolean addStudent(Student student);


    /*根据学号修改学生，根据sno知道待修改的人，把这个人修改成student*/
    public boolean updateStudentBySno(int sno, Student student);


    /*根据学号删除学生*/
    public boolean deleteStudentBySno(int sno);


    //根据学号查询学生
    public Student queryStudentBySno(int sno);

    /*查询全部学生*/
    public List<Student> queryAllStudentBySno();

    /*查询总数据数*/
    public int getTotalCount( );

    /*currentPage:当前页（页码） pageSize：页面大小（每页显示数据条数）*/
    public List<Student> queryStudentByPage(int currentPage,int pageSize);
}