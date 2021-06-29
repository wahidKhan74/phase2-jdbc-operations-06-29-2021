package com.dell.webapp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dell.webapp.connection.DBConnection;

/**
 * Servlet implementation class InitConnection
 */
@WebServlet("/init")
public class InitConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InitConnection() { }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			String url = "jdbc:mysql://localhost:3306/ecom_webapp";
			String username = "root";
			String password = "root";
			DBConnection conn =  new DBConnection(url, username, password);
			
			if(conn!=null) {
				out.println("<h1 style='color:green'> DB connection is initialized !</h1>");
			}
			
		} catch (Exception e) {
			out.println("<h1 style='color:red'>DB connection is failed !</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
