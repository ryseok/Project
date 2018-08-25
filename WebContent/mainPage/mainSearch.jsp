<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>  
 <%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%> 
<%-- mainSearch.jsp --%>
<%!
String []keywords={"자바","자바라","자바캔","자라","자바프로그래밍",
    		 "자석","자소서","자기소개서","자동차","자연휴양림",
    		 "apple","ajax","aoa","abc마트","aj렌트카","apartment",
    		 "axa다이렉트","a3논란"};

     public List<String> search(String keyword){
    	List<String> resultList = new ArrayList<>();
    	
    	if(keyword==null || keyword.equals("")){
    		return resultList;//size가 0인 List리턴!! 
    	}
    		
    	for(int i=0; i<keywords.length; i++){
    	    if(keywords[i].startsWith(keyword)){
    	    	resultList.add(keywords[i]);
    	    }
    	}
    	
    	return resultList;
     }//search
     %>
  <%  
      String keyword = request.getParameter("mainSearch");
	  
      List<String> list = search(keyword);
      out.print(list.size()+"|");
      for(int i=0; i<list.size(); i++){//데이터 8개 : i=0~7
    	  out.print(list.get(i));
    	  if(i< list.size()-1)out.print(",");
      }
  %>