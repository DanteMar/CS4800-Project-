package control;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import objects.*;
import business.*;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.util.ArrayList;


public class OrderController extends HttpServlet {
	ArrayList<MenuItem> foods= new ArrayList<MenuItem>();
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{	
		String address="";
		BusinessLayer bl = BusinessLayer.getInstance();

		if(req.getParameter("id")!=null) {
			int BroncoID=Integer.valueOf((String)req.getParameter("id"));
			System.out.println(BroncoID+" no wya");
			try {
				Customer customer = bl.getCustomer(BroncoID);
				if(customer==null) {
					req.setAttribute("error", "null customer");
					address="/OrderWelcomeView.jsp";
				}else {
					HttpSession s= req.getSession();
					s.setAttribute("customer", customer);
					s.setAttribute("customerID",BroncoID);
					System.out.println("plz "+BroncoID);
					address = "/OrderView.jsp";
				}
			}
			catch(SQLException e) {
				req.setAttribute("error","SQLException occured");
			}catch (ClassNotFoundException e) {
				req.setAttribute("error","Customer class not found Exception occured");
			}
		}
		
		
		
		try {
			foods = bl.getMenu();
		}
		catch(SQLException e) {
			req.setAttribute("error","SQLException occured");
		}catch (ClassNotFoundException e) {
			req.setAttribute("error","ClassNotFoundException occured");
		}
		req.setAttribute("foods",foods);
		

		
		//double total = Integer.parseInt(req.getParameter("quantity1")) * 5.5 + Integer.parseInt(req.getParameter("quantity2")) * 5;
		//req.setAttribute("total", total);
		req.setAttribute("quantity1",req.getParameter("quantity1"));
		req.setAttribute("quantity2",req.getParameter("quantity2"));
		
		RequestDispatcher rd = req.getRequestDispatcher(address);
		rd.forward(req, resp);
	}
	public ArrayList<MenuItem> getMenu(){
		return foods;
	}
}
