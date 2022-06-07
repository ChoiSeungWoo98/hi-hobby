package com.hi_hobby._class;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hi_hobby.action.Action;
import com.hi_hobby.action.ActionInfo;
import com.hi_hobby.domain.dao.ClassDAO;

public class ClassCreatirInfo implements Action{

	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		int classNum = Integer.parseInt(req.getParameter("classNum"));
		int userNum = (Integer)req.getSession().getAttribute("userNum");
		ClassDAO classDAO = new  ClassDAO();
		ActionInfo actionInfo = new ActionInfo();
		
		classDAO.del(classNum);
		System.out.println(classDAO.modify(classNum).getClassStatus());
		
		actionInfo.setRedirect(false);
		actionInfo.setPath(req.getContextPath()+"/_class/ClassMine.cl?userNum="+userNum);
		
		return actionInfo;
	}

}
