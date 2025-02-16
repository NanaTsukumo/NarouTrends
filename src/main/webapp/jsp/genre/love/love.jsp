<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>大ジャンル【恋愛】ジャンル選択ページ</title>

<%@ include file="../headTag.jsp" %>

<%@ include file="../header.jsp" %>
				
				<h1>大ジャンル</h1>
				<h1><b>【恋愛】</b></h1>
				<h1>におけるジャンル選択ページです！</h1>

				<form action="trends" method="post">
					<input type="hidden" name="bigGenre" value="love">
					<input type="hidden" name="genre" value="different_love">
					<input class="submit-design" type="submit" value="【異世界（恋愛）】">
				</form>
				<form action="trends" method="post">
					<input type="hidden" name="bigGenre" value="love">
					<input type="hidden" name="genre" value="real_love">
					<input class="submit-design" type="submit" value="【現実（恋愛）】">
				</form>
				
<%@ include file="../footer.jsp" %>