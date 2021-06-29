package com.dell.webapp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dell.webapp.connection.DBConnection;

/**
 * Servlet implementation class ListProduct
 */
@WebServlet("/list-product")
public class ListProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListProduct() { }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// add navigation
		request.getRequestDispatcher("index.html").include(request, response);
		
		try {
			// 1. get connection
			Connection conn = DBConnection.getConnection();
			
			// 2. create statement
			Statement stm = conn.createStatement();			
			
			// 3. execute query 
			String selectQuery = "select * from eproduct";
			ResultSet rst = stm.executeQuery(selectQuery);
			
			// 4. display all products			
			display(out,rst);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	private void display(PrintWriter out, ResultSet rst) {
		try {
			out.print("<div>");
			out.print("<h1> List of Products </h1> <br><br>");
			while (rst.next()) {
				out.print("<p> "+rst.getInt("id") +" , " +rst.getString("name") +" , " +rst.getString("price") +" , " 
						+rst.getString("description") +" , "+rst.getString("date_added") +" , ");
			}
			out.print("</div>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
