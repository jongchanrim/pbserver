package kr.pb.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kr.pb.dao.MemberDAO;
import kr.pb.dto.Member;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		
		MemberDAO dao = MemberDAO.getMemberDAO();
		
		if (dao.isMember(email, passwd)==0) {
			
		} 
		else {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			session.setAttribute("passwd",passwd);
			response.getWriter().write("success");
		
			
		}

	
	}

}
