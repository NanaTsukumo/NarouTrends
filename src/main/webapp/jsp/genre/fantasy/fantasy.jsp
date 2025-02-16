<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>大ジャンル【ファンタジー】ジャンル選択ページ</title>
	
	<%@ include file="../headTag.jsp" %>

<%@ include file="../header.jsp" %>
				
				<h1>大ジャンル</h1>
				<h1><b>【ファンタジー】</b></h1>
				<h1>におけるジャンル選択ページです！</h1>
				
				<form action="trends" method="post">
					<input type="hidden" name="bigGenre" value="fantasy">
					<input type="hidden" name="genre" value="high_fantasy">
					<input class="submit-design" type="submit" value="【ハイファンタジー】">
				</form>
				<form action="trends" method="post">
					<input type="hidden" name="bigGenre" value="fantasy">
					<input type="hidden" name="genre" value="low_fantasy">
					<input class="submit-design" type="submit" value="【ローファンタジー】">
				</form>

<%@ include file="../footer.jsp" %>