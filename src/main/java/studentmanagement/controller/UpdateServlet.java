package studentmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import studentmanagement.model.StudentBean;
import studentmanagement.persistant.dao.StudentDAO;
import studentmanagement.persistant.dto.RequestDTO;
import studentmanagement.persistant.dto.ResponseDTO;
import java.io.IOException;



/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDTO dto = new RequestDTO();
		dto.setId(Integer.valueOf(request.getParameter("id")));
		StudentDAO dao = new StudentDAO();
		ResponseDTO res = dao.selectOne(dto);
		request.setAttribute("res", res);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentBean bean = new StudentBean();
		String id = request.getParameter("id");
		bean.setId(Integer.valueOf(id));
		bean.setStuName(request.getParameter("name"));
		bean.setStuEmail(request.getParameter("email"));
		bean.setStuAge(request.getParameter("age"));
		bean.setStuAddress(request.getParameter("address"));
		bean.setStuPh(request.getParameter("phno"));
		if(bean.getStuName().equals("") || bean.getStuEmail().equals("") || bean.getStuAge().equals("") || bean.getStuPh().equals("")) {
			request.setAttribute("error", "Field cannot be empty");
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
		else {
			RequestDTO dto= new RequestDTO();
			dto.setId(bean.getId());
			dto.setStuName(bean.getStuName());
			dto.setStuEmail(bean.getStuEmail());
			dto.setStuAge(Integer.valueOf(bean.getStuAge()));
			dto.setStuAddress(bean.getStuAddress());
			dto.setStuPh(bean.getStuPh());
			StudentDAO dao = new StudentDAO();
			int i =dao.updateData(dto);
			if(i>0) {
				response.sendRedirect("DisplayServlet");
			}else {
				request.setAttribute("error", "Update Fail");
				request.setAttribute("bean", bean);
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		}
	}
}
