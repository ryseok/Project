package com.funshop.admin.actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.funshop.admin.dao.Admin_memberDAO;
import com.funshop.admin.vo.Admin_memberVO;

public class Admin_memberAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String action = request.getParameter("action");
		String search = request.getParameter("search");
		System.out.println("관리자 액션>>>"+action);
		
		Admin_memberDAO dao = new Admin_memberDAO();
		
		String forwardName = "";
		Map<String, Object> map = new HashMap<>();
		if(action==null) {
			action = "list";
			map.put("search", "%"+search+"%");
		}
		
		//request.setAttribute("list", dao.selectAll(map));
		return mapping.findForward("input");
	}
}
