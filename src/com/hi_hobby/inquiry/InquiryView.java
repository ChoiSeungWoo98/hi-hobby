package com.hi_hobby.inquiry;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.hi_hobby.action.Action;
import com.hi_hobby.action.ActionInfo;
import com.hi_hobby.domain.dao.InquiryDAO;
import com.hi_hobby.domain.dao.UserDAO;
import com.hi_hobby.domain.vo.InquiryVO;
import com.hi_hobby.domain.vo.UserVO;
import com.sun.security.jgss.InquireType;

public class InquiryView implements Action{
	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		ActionInfo actionInfo = new ActionInfo();
		HttpSession session = req.getSession();
		InquiryVO inquiryVO = new InquiryVO();
		InquiryDAO inquiryDAO = new InquiryDAO();
		UserDAO userDAO = new UserDAO();
		Integer userNum = (Integer)inquiryVO.getUserNum();
		
		String num = req.getParameter("inquiryNum");
		
		inquiryVO.setInquiryNum(Integer.parseInt(num));
		
		req.setAttribute("inquiryMyView", inquiryDAO.inquiryView(inquiryVO));
		req.setAttribute("inquiryMyView", userDAO.view(userNum));
		
		actionInfo.setRedirect(false);
		actionInfo.setPath("/cs.jsp");
		
		return actionInfo;
	}
	

}