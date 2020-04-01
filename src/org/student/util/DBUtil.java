package org.student.util;

import org.student.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//通用的数据操作方法
public class DBUtil {
    private static final String URL="jdbc:mysql://localhost:3306/ssm?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
    private static final String USERNAME="root";
    private static final String PASSWORD="123456";
    public static Connection connection = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs=null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }



    public static PreparedStatement createpreparedStatement(String sql,Object[] params) throws SQLException, ClassNotFoundException {
        pstmt = getConnection().prepareStatement(sql);
        if(params!=null){
            for(int i=0;i<params.length;i++){
                pstmt.setObject(i+1,params[i]);
            }
        }
        return  pstmt;
    }

    public static void closeAll(ResultSet rs,Statement stmt,Connection connection){
        try {
            if(rs!=null)rs.close();
            if(pstmt!=null)pstmt.close();
            if(connection!=null)connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //查询总数
    public static int getTotalCount(String sql){
        int count=-1;
        try {
             pstmt = createpreparedStatement(sql, null);
             rs=pstmt.executeQuery();
            if(rs.next()){
                count=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            closeAll(rs,pstmt,connection);
        }
        return  count;
    }


    //通用的增删改
    public static boolean executeUpdate(String sql,Object[] params){
        try {

           // String sql = "delete from student where  sno=?";
           pstmt=createpreparedStatement(sql,params);
            int count = pstmt.executeUpdate();
            if(count>0)
                return true;
            else
                return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            closeAll(null,pstmt,connection);
        }
    }


    //通用的查：返回值是一个集合  适合于任何查询
    public static ResultSet executeQuery(String sql,Object[] params) {
        List<Student> students=new ArrayList<>();
        Student student = null;

        ResultSet rs = null;
        try {

           // String sql = "select * from student ";
            pstmt=createpreparedStatement(sql,params);
            rs=pstmt.executeQuery();
            return rs;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

       }
//        finally {
//            try {
//                if(rs!=null)rs.close();
//                if(pstmt!=null)pstmt.close();
//                if(connection!=null)connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
  }

}
