<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%  
	List<KeywordInfo> dailyList;
	dailyList = (ArrayList)session.getAttribute("dailyPoint");
	List<KeywordInfo> weeklyList;
	weeklyList = (ArrayList)session.getAttribute("weeklyPoint");
	List<KeywordInfo> monthlyList;
	monthlyList = (ArrayList)session.getAttribute("monthlyPoint");
	List<KeywordInfo> quarterList;
	quarterList = (ArrayList)session.getAttribute("quarterPoint");
	List<KeywordInfo> yearlyList;
	yearlyList = (ArrayList)session.getAttribute("yearlyPoint");
	List<KeywordInfo> cumulativeList;
	cumulativeList = (ArrayList)session.getAttribute("cumulativePoint");
	int number = 25; //キーワード表示数 
	
	LocalDateTime updateTime;
	updateTime = (LocalDateTime)session.getAttribute("updateTime");
%>