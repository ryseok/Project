package com.encore.funshop.actions;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.encore.funshop.dao.MyPageDAO;

public class PointAction extends Action{
	private final int PERIOD = 365; //����Ʈ ��ȿ�Ⱓ(�� ����)
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String action = request.getParameter("action");
		String member_id = (String) request.getSession().getAttribute("member_id");
		MyPageDAO dao = new MyPageDAO();
		
		if(action == null) { //�ܼ� ����Ʈ ��ȸ	
			Calendar startCal = Calendar.getInstance();
			Calendar endCal = Calendar.getInstance();
			startCal.add(Calendar.YEAR, -1);
			request.setAttribute("validPoint", dao.selectTotalPoint(member_id, startCal.getTime(), endCal.getTime()));
			endCal.add(Calendar.YEAR, -1);
			endCal.add(Calendar.MONTH, 1);
			request.setAttribute("warningPoint", dao.selectTotalPoint(member_id, startCal.getTime(), endCal.getTime()));
			
			request.setAttribute("myInfo", dao.selectMyInfo(member_id));
			
			return mapping.findForward("result");
		} else if(action.equals("insert")) {
			try {
				int point_point = Integer.parseInt(request.getParameter("point_point"));
				dao.insertPoint(member_id, point_point);
				return null; //����Ʈ �߰����� Ư���� �ٸ� ���� ���� ����
			} catch(Exception e) {
				return null;
			}
		} else {
			return null;
		}
	}
}
