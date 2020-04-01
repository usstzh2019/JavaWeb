package org.student.dao.impl;

import org.student.dao.IStudentDao;
import org.student.entity.Student;
import org.student.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements IStudentDao {
    private final String URL="jdbc:mysql://localhost:3306/ssm?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
    private final String USERNAME="root";
    private final String PASSWORD="123456";
/*判断学生是否存在*/
    public boolean isExist(int sno){
       return queryStudentBySno(sno)==null?false:true;
    }
    /*增加学生*/
    public boolean addStudent(Student student){
        String sql="insert into student  values (?,?,?,?)";
        Object[] params={student.getSno(),student.getSname(),student.getSage(),student.getSaddress()};
        return  DBUtil.executeUpdate(sql,params);
    }
    /*根据学号修改学生，根据sno知道待修改的人，把这个人修改成student*/
    public boolean updateStudentBySno(int sno,Student student){
        String sql="update student set sname=?,sage=?,saddress=? where sno=?";
        Object[] params={student.getSname(),student.getSage(),student.getSaddress(),sno};
        return DBUtil.executeUpdate(sql,params);
    }


    /*根据学号删除学生*/
    public boolean deleteStudentBySno(int sno){
        String sql="delete from student where  sno=?";
        Object[] params={sno};
        return DBUtil.executeUpdate(sql,params);

    }


//根据学号查询学生
    public Student queryStudentBySno(int sno) {
        Student student = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {

           // String sql = "select * from student where sno=?";
          //  pstmt = connection.prepareStatement(sql);
           // pstmt.setInt(1, sno);
            String sql="select * from student where sno=?";
            Object[] params={sno};
            rs=DBUtil.executeQuery(sql,params);
           // rs = pstmt.executeQuery();
            if (rs.next()) {
                int no = rs.getInt("sno");
                String name = rs.getString("sname");
                int age = rs.getInt("sage");
                String address = rs.getString("saddress");
                student = new Student(no, name, age, address);
            }
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }finally {
            DBUtil.closeAll(rs,pstmt,DBUtil.connection);
//            try {
//                if(rs!=null)rs.close();
//                if(pstmt!=null)pstmt.close();
//                if(DBUtil.connection!=null)DBUtil.connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }
    }

/*查询全部学生*/
public List<Student> queryAllStudentBySno() {
    List<Student> students=new ArrayList<>();
    Student student = null;
    PreparedStatement pstmt = null;
    ResultSet rs=null;
    try {
        String sql="select * from student ";
        rs = DBUtil. executeQuery(sql, null);
        //rs=pstmt.executeQuery();
        while (rs.next()) {
            int no = rs.getInt("sno");
            String name = rs.getString("sname");
            int age = rs.getInt("sage");
            String address = rs.getString("saddress");
            student = new Student(no, name, age, address);
            students.add(student);
        }
        return students;
    } catch (SQLException e) {
        e.printStackTrace();
        return null;

    } catch (Exception e) {
        e.printStackTrace();
        return null;

    }finally {
        DBUtil.closeAll(rs,pstmt,DBUtil.connection);
//        try {
//            if(rs!=null)rs.close();
//            if(pstmt!=null)pstmt.close();
//            if(DBUtil.connection!=null)DBUtil.connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
    //查询总数据数
    @Override
    public int getTotalCount() {
        String sql="select count(1) from student";
        return DBUtil.getTotalCount(sql);
    }

    @Override
    public List<Student> queryStudentByPage(int currentPage, int pageSize) {
        String sql="select * from student limit ?,?";
        Object[] params={(currentPage-1)*pageSize,pageSize};
        List<Student> students=new ArrayList<>();
        ResultSet rs = DBUtil.executeQuery(sql, params);
       try{
           while (rs.next()){
               Student student=new Student(rs.getInt("sno"),rs.getString("sname"), rs.getInt("sage"),rs.getString("saddress"));
               students.add(student);
           }
       } catch (Exception e){
           e.printStackTrace();
       }
        return students;
    }
}
