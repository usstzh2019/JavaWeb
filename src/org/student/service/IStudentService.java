package org.student.service;

import org.student.dao.StudentDao;
import org.student.entity.Student;

import java.util.List;

public interface IStudentService {
    StudentDao studentDao = new StudentDao();

    public Student queryStudentBySno(int sno);

    public List<Student> queryAllStudents();


    public boolean updateStudentBySno(int sno, Student student);


    public boolean deleteStudentBySno(int sno);

    public boolean addStudent(Student student);

    public List<Student> queryStudentByPage (int currentPage, int pageSize);

    public int getTotalCount();
}