package studentmanagement.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import studentmanagement.model.StudentBean;
import studentmanagement.persistant.dto.RequestDTO;
import studentmanagement.persistant.dao.StudentDAO;
/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentBean bean = new StudentBean();
		bean.setStuName(request.getParameter("name"));
		bean.setStuEmail(request.getParameter("email"));
		bean.setStuAge(request.getParameter("age"));
		bean.setStuAddress(request.getParameter("address"));
		bean.setStuPh(request.getParameter("phno"));
		if(bean.getStuName().equals("") || bean.getStuEmail().equals("") || bean.getStuAge().equals("") || bean.getStuPh().equals("")) {
			request.setAttribute("error", "Field cannot be empty");
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		else {
			RequestDTO dto= new RequestDTO();
			dto.setStuName(bean.getStuName());
			dto.setStuEmail(bean.getStuEmail());
			dto.setStuAge(Integer.valueOf(bean.getStuAge()));
			dto.setStuAddress(bean.getStuAddress());
			dto.setStuPh(bean.getStuPh());
			StudentDAO dao = new StudentDAO();
			int i =dao.insertData(dto);
			if(i>0) {
				response.sendRedirect("DisplayServlet");
				System.out.println("Insert Successful");
			}else {
				request.setAttribute("error", "Insert Fail");
				request.setAttribute("bean", bean);
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		}
	}
}
