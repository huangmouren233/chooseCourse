package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bean.*;
import DBUitl.DBUtil;

public class TSDao {
    //
    
        
        
        public static boolean addteacher(Teacher teacher) {
            boolean f = false;
            String sql = "insert into denglu(name,idc,password,sex,college,class) values('" + teacher.getName() + "','" + teacher.getIdc() + "','" + teacher.getPassword() + "','" + teacher.getSex() + "','" + teacher.getCollege() + "','" + teacher.getZhicheng() + "')";
            //
            Connection conn = DBUtil.getConn();
            Statement state = null;    
            int a = 0;
            try {
                state = conn.createStatement();
                a = state.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(state, conn);
            }
            
            if (a > 0) {
                f = true;
            }
            return f;
        }
        public static boolean addstudent(Student student) {
        	boolean f = false;
            String sql = "insert into denglu(name,idc,password,sex,college,class) values('" + student.getName() + "','" + student.getIdc() + "','" + student.getPassword() + "','" + student.getSex() + "','" + student.getMajor() + "','" + student.getClass1() + "')";
            //
            Connection conn = DBUtil.getConn();
            Statement state = null;    
            int a = 0;
            try {
                state = conn.createStatement();
                a = state.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(state, conn);
            }
            
            if (a > 0) {
                f = true;
            }
            return f;
        }
        public static boolean addclass(course course) {
        	boolean f = false;
            String sql = "insert into class(name,idc,teacher,peoplenumber) values('" + course.getName() + "','" + course.getIdc() + "','" + course.getTeacher() + "','" + course.getPeoplenumber() + "')";
            //
            Connection conn = DBUtil.getConn();
            Statement state = null;    
            int a = 0;
            try {
                state = conn.createStatement();
                a = state.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(state, conn);
            }
            
            if (a > 0) {
                f = true;
            }
            return f;
        }
        
        
        
        
        public static Teacher getbyid(String idc) {
            String sql = "select * from denglu where idc ='" + idc + "'";
            Connection conn = DBUtil.getConn();
            Statement state = null;
            ResultSet rs = null;
            Teacher teacher = null;
            
            try {
                state = conn.createStatement();
                rs = state.executeQuery(sql);
                while (rs.next()) {
                	String name = rs.getString("name");
                    String college = rs.getString("college");
                    String sex = rs.getString("sex");
                    String idc1 = rs.getString("idc");
                    String zhicheng = rs.getString("class");
                    String password = rs.getString("password");
                    teacher = new Teacher(name,idc1,password,sex,zhicheng,college);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(rs, state, conn);
            }
            
            return teacher;
        }
        
        
        public static Student getbyid1(String idc) {
            String sql = "select * from denglu where idc ='" + idc + "'";
            Connection conn = DBUtil.getConn();
            Statement state = null;
            ResultSet rs = null;
            Student student = null;
            
            try {
                state = conn.createStatement();
                rs = state.executeQuery(sql);
                while (rs.next()) {
                	String name = rs.getString("name");
                    String college = rs.getString("college");
                    String sex = rs.getString("sex");
                    String idc1 = rs.getString("idc");
                    String zhicheng = rs.getString("class");
                    String password = rs.getString("password");
                    student = new Student(name,idc1,password,zhicheng,college,sex);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(rs, state, conn);
            }
            
            return student;
        }
        
        
        
        public static boolean update(Teacher teacher) {
            String sql = "update denglu set name='" + teacher.getName() + "', password='" + teacher.getPassword() + "', college='" + teacher.getCollege() +"', class='" + teacher.getZhicheng() +"', sex='" + teacher.getSex()
                + "' where idc='" + teacher.getIdc() + "'";
            Connection conn = DBUtil.getConn();
            Statement state = null;
            boolean f = false;
            int a = 0;

            try {
                state = conn.createStatement();
                a = state.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(state, conn);
            }
            
            if (a > 0) {
                f = true;
            }
            return f;
        }
        
        
        
        public static boolean update1(Student student) {
            String sql = "update denglu set name='" + student.getName() + "', password='" + student.getPassword() + "', college='" + student.getMajor() +"', class='" + student.getClass1() +"', sex='" + student.getSex()
                + "' where idc='" + student.getIdc() + "'";
            Connection conn = DBUtil.getConn();
            Statement state = null;
            boolean f = false;
            int a = 0;

            try {
                state = conn.createStatement();
                a = state.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(state, conn);
            }
            
            if (a > 0) {
                f = true;
            }
            return f;
        }
        
        
        public static int countchosestudent(String course) {
            String sql = "select * from chosestudent where course like '%" + course + "%'";
            int i=0;
            Connection conn = DBUtil.getConn();
            Statement state = null;
            ResultSet rs = null;
            
            try {
                state = conn.createStatement();
                rs = state.executeQuery(sql);
                while (rs.next()) {
                    i++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(rs, state, conn);
            }
            
            return i;
        }

        public static course coursedetails(String course) {
            String sql = "select * from class where name like '%" + course + "%'";
            Connection conn = DBUtil.getConn();
            Statement state = null;
            ResultSet rs = null;
            course bean = null;
            try {
                state = conn.createStatement();
                rs = state.executeQuery(sql);
                while (rs.next()) {
                	String name = rs.getString("name");
                    String idc = rs.getString("idc");
                    String peoplenumber = rs.getString("peoplenumber");
                    String teacher = rs.getString("teacher");
                    bean = new course(name,idc,peoplenumber,teacher);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(rs, state, conn);
            }
            
            return bean;
        }
        
        
        
        public static Teacher teacherdetails(String teacher) {
            String sql = "select * from denglu where name like '%" + teacher + "%'";
            Connection conn = DBUtil.getConn();
            Statement state = null;
            ResultSet rs = null;
            Teacher bean = null;
            try {
                state = conn.createStatement();
                rs = state.executeQuery(sql);
                while (rs.next()) {
                	String name = rs.getString("name");
                	String sex = rs.getString("sex");
                	String college = rs.getString("college");
                	String zhicheng = rs.getString("class");
                    bean = new Teacher(name,sex,zhicheng,college);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(rs, state, conn);
            }
            
            return bean;
        }
        
        
        public static List<course> courselist() {
            String sql = "select * from class";
            List<course> list = new ArrayList<>();
            Connection conn = DBUtil.getConn();
            Statement state = null;
            ResultSet rs = null;
            

            try {
                state = conn.createStatement();
                rs = state.executeQuery(sql);
                course bean = null;
                while (rs.next()) {
                    String name = rs.getString("name");
                    String idc = rs.getString("idc");
                    String peoplenumber = rs.getString("peoplenumber");
                    String teacher = rs.getString("teacher");
                    bean = new course(name,idc,peoplenumber,teacher);
                    list.add(bean);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(rs, state, conn);
            }
            
            return list;
        }
        
        
        
        public static boolean chosecourse(String course,String studentidc) {
        	boolean f = false;
        	String sql = "select * from denglu where idc like '%" + studentidc + "%'";
        	Connection conn = DBUtil.getConn();
        	Statement state = null;
            ResultSet rs = null;
            Student student = null;
            try {
                state = conn.createStatement();
                rs = state.executeQuery(sql);
                while (rs.next()) {
                	String name = rs.getString("name");
                	String college = rs.getString("college");
                	String class1 = rs.getString("class");
                    student = new Student(name,class1,college);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(rs, state, conn);
            }
        	String sql1 = "insert into chosestudent(name,idc,class,major,course) values('" + student.getName() + "','" + studentidc + "','" + student.getClass1() + "','" + student.getMajor() + "','" + course + "')";
            //
            Connection conn1 = DBUtil.getConn();
            Statement state1 = null;    
            int a = 0;
            try {
                state1 = conn1.createStatement();
                a = state1.executeUpdate(sql1);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(state1, conn1);
            }
            
            if (a > 0) {
                f = true;
            }
            return f;
        }
        
        
        public static List<course> teachercourselist(String name) {
            String sql = "select * from class where teacher like '%" + name + "%'";
            List<course> list = new ArrayList<>();
            Connection conn = DBUtil.getConn();
            Statement state = null;
            ResultSet rs = null;
            

            try {
                state = conn.createStatement();
                rs = state.executeQuery(sql);
                course bean = null;
                while (rs.next()) {
                    String name1 = rs.getString("name");
                    String idc = rs.getString("idc");
                    String peoplenumber = rs.getString("peoplenumber");
                    String teacher = rs.getString("teacher");
                    bean = new course(name1,idc,peoplenumber,teacher);
                    list.add(bean);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(rs, state, conn);
            }
            
            return list;
        }
        
        
        
        
        public static List<Student> chosecoursestudentlist(String course) {
            String sql = "select * from chosestudent where course like '%" + course + "%'";
            List<Student> list = new ArrayList<>();
            Connection conn = DBUtil.getConn();
            Statement state = null;
            ResultSet rs = null;
            

            try {
                state = conn.createStatement();
                rs = state.executeQuery(sql);
                Student bean = null;
                while (rs.next()) {
                    String name1 = rs.getString("name");
                    String idc = rs.getString("idc");
                    String class1 = rs.getString("class");
                    String major = rs.getString("major");
                    bean = new Student(name1,idc,class1,major);
                    list.add(bean);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(rs, state, conn);
            }
            
            return list;
        }

    }