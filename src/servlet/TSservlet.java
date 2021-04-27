package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.TSDao;
import Bean.*;

@WebServlet("/TSservlet")
public class TSservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
        
        
        protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	request.setCharacterEncoding("utf-8");
            String method = request.getParameter("method");
            if ("addteacher".equals(method)) {
                addteacher(request, response);
            } 
            else if ("addclass".equals(method)) {
                addclass(request, response);
            }
            else if ("addstudent".equals(method)) {
                addstudent(request, response);
            }
            else if ("getbyidc".equals(method)) {
                getbyidc(request, response);
            }
            else if ("getbyidc1".equals(method)) {
                getbyidc1(request, response);
            }
            else if ("update".equals(method)) {
                update(request, response);
            }
            else if ("update1".equals(method)) {
                update1(request, response);
            }
            else if ("courselist".equals(method)) {
                courselist(request, response);
            }
            else if ("courselist1".equals(method)) {
                courselist1(request, response);
            }
            else if ("coursedetails".equals(method)) {
                coursedetails(request, response);
            }
            else if ("teacherdetails".equals(method)) {
                teacherdetails(request, response);
            }
            else if ("chosecourse".equals(method)) {
                chosecourse(request, response);
            }
            else if ("teachercourselist".equals(method)) {
                teachercourselist(request, response);
            }
            else if ("chosecoursestudentlist".equals(method)) {
                chosecoursestudentlist(request, response);
            }
            
        }
        private void addteacher(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        	request.setCharacterEncoding("utf-8");
        	String name = request.getParameter("name");
        	String password = request.getParameter("password");
            String idc = request.getParameter("idc");
            String college = request.getParameter("college");
            String sex = request.getParameter("sex");
            String zhicheng = request.getParameter("zhicheng");
            Teacher teacher = new Teacher(name,idc,password,sex,zhicheng,college);
            if(TSDao.addteacher(teacher)) {
            	 request.setAttribute("message", "添加教师信息成功");
                 request.getRequestDispatcher("menu1.jsp").forward(request,response);
            } else {
                request.setAttribute("message", "添加教师信息失败");
                request.getRequestDispatcher("menu1.jsp").forward(request,response);
            }
        	
        	}
        
        
        private void addstudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        	request.setCharacterEncoding("utf-8");
        	String name = request.getParameter("name");
            String idc = request.getParameter("idc");
            String class1 = request.getParameter("class1");
            String sex = request.getParameter("sex");
            String password = request.getParameter("password");
            String major = request.getParameter("major");
            Student student = new Student(name,idc,password,class1,major,sex);
            if(TSDao.addstudent(student)) {
                request.setAttribute("message", "添加学生信息成功");
                request.getRequestDispatcher("menu1.jsp").forward(request,response);
            } else {
                request.setAttribute("message", "添加学生信息失败");
                request.getRequestDispatcher("menu1.jsp").forward(request,response);
            }
        	
        	}
        
        
        private void addclass(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        	request.setCharacterEncoding("utf-8");
        	String name = request.getParameter("name");
            String idc = request.getParameter("idc");
            String peoplenumber = request.getParameter("peoplenumber");
            String teacher = request.getParameter("teacher");
            course course = new course(name,idc,peoplenumber,teacher);
            if(TSDao.addclass(course)) {
                request.setAttribute("message", "添加课程信息成功");
                request.getRequestDispatcher("menu2.jsp").forward(request,response);
            } else {
                request.setAttribute("message", "添加课程信息失败");
                request.getRequestDispatcher("menu2.jsp").forward(request,response);
            }
        	
        	}
        
        
        private void getbyidc(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        	request.setCharacterEncoding("utf-8");
        	String idc = request.getParameter("id");
        	Teacher teacher = TSDao.getbyid(idc);
        	if(teacher.getIdc().equals(idc)) {
            request.setAttribute("teacher", teacher);
            request.getRequestDispatcher("update.jsp").forward(request,response);
        	}
        	else
        	{
        	request.setAttribute("message", "查找失败！");
            request.getRequestDispatcher("menu2.jsp").forward(request,response);
        	}
        }
        
        private void getbyidc1(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        	request.setCharacterEncoding("utf-8");
        	String idc = request.getParameter("id");
        	Student student = TSDao.getbyid1(idc);
        	if(student.getIdc().equals(idc)) {
            request.setAttribute("student", student);
            request.getRequestDispatcher("update1.jsp").forward(request,response);
        	}
        	else
        	{
        	request.setAttribute("message", "查找失败！");
            request.getRequestDispatcher("menu3.jsp").forward(request,response);
        	}
        }
        
        
        
        
        private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
            req.setCharacterEncoding("utf-8");
            boolean a = false;
            String name = req.getParameter("name");
            String idc = req.getParameter("id");
            String sex = req.getParameter("sex");
            String college = req.getParameter("college");
            String zhicheng = req.getParameter("zhicheng");
            String password = req.getParameter("password");
            Teacher teacher = new Teacher(name,idc,password,sex,zhicheng,college);
            a = TSDao.update(teacher);
            if(a)
            {
            	req.setAttribute("message", "修改成功");
            	req.getRequestDispatcher("TSservlet?method=getbyidc").forward(req,resp);
            }
            else
            {
            	req.setAttribute("message", "修改失败");
                req.getRequestDispatcher("menu2.jsp").forward(req,resp);
            }
            }
        
        
        
        
        private void update1(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
            req.setCharacterEncoding("utf-8");
            boolean a = false;
            String name = req.getParameter("name");
            String idc = req.getParameter("id");
            String sex = req.getParameter("sex");
            String major = req.getParameter("major");
            String class1 = req.getParameter("class");
            String password = req.getParameter("password");
            Student student = new Student(name,idc,password,class1,major,sex);
            a = TSDao.update1(student);
            if(a)
            {
            	req.setAttribute("message", "修改成功");
            	req.setAttribute("id", idc);
            	req.getRequestDispatcher("TSservlet?method=getbyidc1").forward(req,resp);
            }
            else
            {
            	req.setAttribute("message", "修改失败");
                req.getRequestDispatcher("menu3.jsp").forward(req,resp);
            }
            }
        
        
        
        private void courselist(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
            req.setCharacterEncoding("utf-8");
            List<course> courses = TSDao.courselist();
            req.setAttribute("courses", courses);
            req.getRequestDispatcher("courselist.jsp").forward(req,resp);
        }
        
        
        private void courselist1(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
            req.setCharacterEncoding("utf-8");
            List<course> courses = TSDao.courselist();
            req.setAttribute("courses", courses);
            req.getRequestDispatcher("courselist1.jsp").forward(req,resp);
        }
        
        
        
        private void coursedetails(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
            req.setCharacterEncoding("utf-8");
            String course = req.getParameter("course");
            int count = 0;
            count = TSDao.countchosestudent(course);
            course course1 = TSDao.coursedetails(course);
            req.setAttribute("course", course1);
            req.setAttribute("count", count);
            req.getRequestDispatcher("coursedetails.jsp").forward(req,resp);
        }
        
        
        private void teacherdetails(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
            req.setCharacterEncoding("utf-8");
            String teacher = req.getParameter("teacher");
            Teacher teacher1 = TSDao.teacherdetails(teacher);
            req.setAttribute("teacher", teacher1);
            req.getRequestDispatcher("teacherdetails.jsp").forward(req,resp);
        }
        
        
        private void chosecourse(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
            req.setCharacterEncoding("utf-8");
            String studentidc = req.getParameter("studentidc");
            String course = req.getParameter("course");
            if(30>TSDao.countchosestudent(course))
            {
            	TSDao.chosecourse(course,studentidc);
            	req.setAttribute("message", "选课成功！");
                req.getRequestDispatcher("menu3.jsp").forward(req,resp);
            }
            else{
            	req.setAttribute("message", "人数已满，选课失败！");
                req.getRequestDispatcher("menu3.jsp").forward(req,resp);
            }
        }
        
        
        
        private void teachercourselist(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
            req.setCharacterEncoding("utf-8");
            String idc = req.getParameter("id");
            Teacher teacher = new Teacher();
            teacher = TSDao.getbyid(idc);
            List<course> courses = TSDao.teachercourselist(teacher.getName());
            req.setAttribute("courses", courses);
            req.getRequestDispatcher("teachercourselist.jsp").forward(req,resp);
        }
        
        
        
        private void chosecoursestudentlist(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
            req.setCharacterEncoding("utf-8");
            String course = req.getParameter("course");
            List<Student> students = TSDao.chosecoursestudentlist(course);
            req.setAttribute("students", students);
            req.setAttribute("course", course);
            req.getRequestDispatcher("chosecoursestudentlist.jsp").forward(req,resp);
        }
        
        
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            doGet(request, response);
        }

    


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */


}