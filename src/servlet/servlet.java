package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Dao;
import Bean.Beanid;

@WebServlet("/servlet")
public class servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
        
        
        protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	request.setCharacterEncoding("utf-8");
            denglu(request, response);
        }
        private void denglu(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        	request.setCharacterEncoding("utf-8");
        	String jiese = request.getParameter("jiese");
            String idc = request.getParameter("id");
            String password = request.getParameter("password");
            Beanid Beanid = new Beanid(jiese,idc,password);
            if(Dao.id(idc,password)) {
            	if((Beanid.getJiese()).equals("1")){
            		request.setAttribute("message", "登录成功");
            		Cookie cookie = new Cookie("id",idc);
            		response.addCookie(cookie);
            		response.sendRedirect("menu1.jsp");
            	}
            	else if((Beanid.getJiese()).equals("2"))
            	{
            		request.setAttribute("message", "登录成功");
            		Cookie cookie = new Cookie("id",idc);
            		response.addCookie(cookie);
            		response.sendRedirect("menu2.jsp");
            	}
            	else if((Beanid.getJiese()).equals("3"))
            	{
            		request.setAttribute("message", "登录成功");
            		Cookie cookie = new Cookie("id",idc);
            		response.addCookie(cookie);
            		response.sendRedirect("menu3.jsp");
            	}
            	else
            	{
            		request.setAttribute("message", "登录失败");
                    request.getRequestDispatcher("begin.jsp").forward(request,response);
            	}
            } else {
                request.setAttribute("message", "登录失败");
                request.getRequestDispatcher("begin.jsp").forward(request,response);
            }
        	
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