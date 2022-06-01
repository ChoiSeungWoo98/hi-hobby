package com.hi_hobby.inquiry;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.hi_hobby.action.Action;
import com.hi_hobby.action.ActionInfo;
import com.hi_hobby.domain.dao.InquiryDAO;
import com.hi_hobby.domain.vo.InquiryVO;
import com.sun.security.jgss.InquireType;

public class InquiryGoEdit implements Action{
	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		ActionInfo actionInfo = new ActionInfo();
		HttpSession session = req.getSession();
		InquiryVO inquiryVO = new InquiryVO();
		InquiryDAO inquiryDAO = new InquiryDAO();

		int inquiryNum = (Integer.parseInt(req.getParameter("inquiryNum")));
		
		req.setAttribute("inquiryMyView", inquiryDAO.inquiryMyView(inquiryNum));
		
		actionInfo.setRedirect(false);
		actionInfo.setPath("/csEdit.jsp");
		
		return actionInfo;
	}
	

}