package org.student.service.impl;

import org.student.dao.IStudentDao;
import org.student.dao.StudentDao;
import org.student.dao.impl.StudentDaoImpl;
import org.student.entity.Student;
import org.student.service.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {

    IStudentDao studentDao=new StudentDaoImpl();

    public Student queryStudentBySno(int sno){
       return studentDao.queryStudentBySno(sno);
    }
    public List<Student> queryAllStudents(){
        return studentDao.queryAllStudentBySno();
    }


    public boolean updateStudentBySno(int sno,Student student){
        if(studentDao.isExist(sno)){
            return studentDao.updateStudentBySno(sno,student);
        }
        return false;
    }


    public boolean deleteStudentBySno(int sno) {
        if (studentDao.isExist(sno)) {
           return studentDao.deleteStudentBySno(sno);
        }else {
            return false;
        }

    }

    public boolean addStudent(Student student){
        if (!studentDao.isExist(student.getSno())){
            studentDao.addStudent(student);
            return true;
        }else {
            System.out.println("此人已存在！");
            return false;
        }
    }
    //查询当前页的数据集合
    @Override
    public List<Student> queryStudentByPage(int currentPage, int pageSize) {
        return studentDao.queryStudentByPage(currentPage,pageSize);
    }
    //查询数据总条数
    @Override
    public int getTotalCount() {
        return studentDao.getTotalCount();
    }


}
