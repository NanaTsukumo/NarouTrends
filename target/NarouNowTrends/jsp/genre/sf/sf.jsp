<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>大ジャンル【SF】ジャンル選択ページ</title>

<%@ include file="../headTag.jsp" %>

<%@ include file="../header.jsp" %>
				
				<h1>大ジャンル</h1>
				<h1><b>【SF】</b></h1>
				<h1>におけるジャンル選択ページです！</h1>

				<form action="trends" method="post">
					<input type="hidden" name="bigGenre" value="sf">
					<input type="hidden" name="genre" value="vr_game">
					<input class="submit-design" type="submit" value="【VRゲーム】">
				</form>
				<form action="trends" method="post">
					<input type="hidden" name="bigGenre" value="sf">
					<input type="hidden" name="genre" value="universe">
					<input class="submit-design" type="submit" value="【宇宙】">
				</form>
				<form action="trends" method="post">
					<input type="hidden" name="bigGenre" value="sf">
					<input type="hidden" name="genre" value="science_fiction">
					<input class="submit-design" type="submit" value="【空想科学】">
				</form>
				<form action="trends" method="post">
					<input type="hidden" name="bigGenre" value="sf">
					<input type="hidden" name="genre" value="panic">
					<input class="submit-design" type="submit" value="【パニック】">
				</form>

<%@ include file="../footer.jsp" %>