package org.student.service;

import org.student.dao.StudentDao;
import org.student.entity.Student;

import java.util.List;

public class StudentService {

    StudentDao studentDao=new StudentDao();

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


    public List<Student> queryStudentByPage(int currentPage, int pageSize) {
        return null;
    }


    public int getTotalCount() {
        return 0;
    }
}
