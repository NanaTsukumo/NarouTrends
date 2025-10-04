<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>大ジャンル【その他】ジャンル選択ページ</title>

<%@ include file="../headTag.jsp" %>

<%@ include file="../header.jsp" %>
				
				<h1>大ジャンル</h1>
				<h1><b>【その他】</b></h1>
				<h1>におけるジャンル選択ページです！</h1>

				<form action="trends" method="post">
					<input type="hidden" name="bigGenre" value="others">
					<input type="hidden" name="genre" value="fairy_tale">
					<input class="submit-design" type="submit" value="【童話】">
				</form>
				<form action="trends" method="post">
					<input type="hidden" name="bigGenre" value="others">
					<input type="hidden" name="genre" value="poem">
					<input class="submit-design" type="submit" value="【詩】">
				</form>
				<form action="trends" method="post">
					<input type="hidden" name="bigGenre" value="others">
					<input type="hidden" name="genre" value="essay">
					<input class="submit-design" type="submit" value="【エッセイ】">
				</form>
				<form action="trends" method="post">
					<input type="hidden" name="bigGenre" value="others">
					<input type="hidden" name="genre" value="replay">
					<input class="submit-design" type="submit" value="【リプレイ】">
				</form>
				<form action="trends" method="post">
					<input type="hidden" name="bigGenre" value="others">
					<input type="hidden" name="genre" value="other">
					<input class="submit-design" type="submit" value="【その他】">
				</form>

<%@ include file="../footer.jsp" %>