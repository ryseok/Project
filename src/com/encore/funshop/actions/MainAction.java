package com.encore.funshop.actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.encore.funshop.dao.ProductDAO;
import com.encore.funshop.vo.BuyHis;
import com.encore.funshop.vo.Pdetail;
import com.encore.funshop.vo.Product;

public class MainAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String forwardName=null;
		ProductDAO dao = new ProductDAO();
		String action = request.getParameter("action");
		System.out.println("action="+action);
		Map<String, String> map = new HashMap<>();
		int mainClickNum=0;
		List<Product> productList=null;
		List<Pdetail> pdtailList=null;
			if(action.contains("mainDetail")) {
			mainClickNum = action.charAt(10)-48;
			request.getSession().setAttribute("mainClickNum", mainClickNum);
			Product pro =dao.selectDetail(mainClickNum);
			request.getSession().setAttribute("pro", pro);
			
			pdtailList=dao.selectPdetail(mainClickNum);
			request.getSession().setAttribute("pdtailList", pdtailList);
			//가장 낮은 가격 가져오기
				int lowPrice = dao.selectLow(mainClickNum);
				request.getSession().setAttribute("lowPrice", lowPrice);
		}	
		if(action ==null || action.equals("main")) {
			forwardName="main";
		}else if(action.equals("search")) {
			String mainSearch = request.getParameter("mainSearch");
			request.setAttribute("mainSearch", mainSearch);
			if(mainSearch!=null) {
				forwardName="search";
			}
		}else if(action.equals("image")) {
			productList = dao.selectProductAll(map);
			request.setAttribute("productList", productList);
			forwardName="image";
		}else if(action.equals("mainDetail"+mainClickNum)) {
			forwardName="detail";
		}else if(action.equals("cloth")) {
			map.put("cloth", "의류");
			productList = dao.selectProductAll(map);
			request.setAttribute("productList", productList);
			forwardName="type";
		}else if(action.equals("place")) {
			map.put("place", "장소");
			productList = dao.selectProductAll(map);
			request.setAttribute("productList", productList);
			forwardName="type";
		}else if(action.equals("food")) {
			map.put("food", "음식");
			productList = dao.selectProductAll(map);
			request.setAttribute("productList", productList);
			forwardName="type";
		}else if(action.equals("detailType")) {
			request.setAttribute("detailType", request.getParameter("detailType"));
			List<String> typeList = dao.selectType();
			request.setAttribute("typeList", typeList.toArray());
			forwardName="typeList";
		}else if(action.equals("directBuy")) {
			String productNumber = request.getParameter("productNumber");
			pdtailList=dao.selectPdetail(Integer.parseInt(productNumber));
			String strArr = "";
			String []strArr2 = new String[pdtailList.size()];
			int productNum=0;
			for (int i = 0; i < pdtailList.size(); i++) {
				String opName = pdtailList.get(i).getName();
				String name = request.getParameter(opName);
				if(!name.equals("0")) {
					strArr += opName+" - "+name+"<br>";
					if(i==(pdtailList.size()-1)) 
						strArr2[i] = opName+" - "+name;
					else
						strArr2[i] = opName+" - "+name+",";
					System.out.println("strArr2="+strArr2[i]);
				}
				productNum += Integer.parseInt(name);
			}
			request.setAttribute("strArr", strArr);
			request.setAttribute("strArr2", strArr2);
			request.setAttribute("productNum", productNum);
			String hidTotal = request.getParameter("hidTotal");
			request.setAttribute("hidTotal", hidTotal);
			forwardName="directBuy";
		}else if(action.equals("payment")) {
			System.out.println("buyHis_addr"+request.getParameter("buyHis_addr"));
			System.out.println("pdetail_no="+request.getParameter("pdetail_no"));
			System.out.println("member_id="+request.getParameter("member_id"));
			System.out.println(request.getParameter("product_no"));
			BuyHis buyhis = new BuyHis();
			buyhis.setMember_id(request.getParameter("member_id"));
			buyhis.setPdetail_no(Integer.parseInt(request.getParameter("pdetail_no")));
			buyhis.setProduct_no(Integer.parseInt(request.getParameter("product_no")));
			buyhis.setBuyHis_num(Integer.parseInt(request.getParameter("buyHis_num")));
			buyhis.setBuyHis_payment(Integer.parseInt(request.getParameter("buyHis_payment")));
			buyhis.setBuyHis_addr(request.getParameter("buyHis_addr"));
			buyhis.setBuyHis_payType(request.getParameter("buyHis_payType"));
			buyhis.setBuyHis_payInfo(request.getParameter("buyHis_payInfo"));
			if(dao.insertBuy(buyhis)) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
		}
		return mapping.findForward(forwardName);
	}
}