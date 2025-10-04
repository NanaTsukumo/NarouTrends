<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="import.jsp" %>

<!DOCTYPE html>
<html>
<head>
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PVLBMR24');</script>
<!-- End Google Tag Manager -->
	<meta charset="UTF-8">
	<title>ジャンル【総合】期間別トレンド</title>
	
	<%@ include file="headTag.jsp" %>

<%@ include file="genreKeywordListInput.jsp" %>

<%@ include file="header.jsp" %>
				
				<h1>ジャンル</h1>
				<h1><b>【総合】</b></h1>
				<h1>における期間別トレンドです！</h1>
				
				<%@ include file="cautionary_note.jsp" %>
				
				<%@ include file="keywordDisplay/keywordDisplay.jsp" %>
				
				<%@ include file="footer.jsp" %>