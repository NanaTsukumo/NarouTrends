<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>大ジャンル【文芸】ジャンル選択ページ</title>

<%@ include file="../headTag.jsp" %>

<%@ include file="../header.jsp" %>
				
				<h1>大ジャンル</h1>
				<h1><b>【文芸】</b></h1>
				<h1>におけるジャンル選択ページです！</h1>
				<form action="trends" method="post">
					<input type="hidden" name="bigGenre" value="literature">
					<input type="hidden" name="genre" value="pure_literature">
					<input class="submit-design" type="submit" value="【純文学】">
				</form>
				<form action="trends" method="post">
					<input type="hidden" name="bigGenre" value="literature">
					<input type="hidden" name="genre" value="hyuman_drama">
					<input class="submit-design" type="submit" value="【ヒューマンドラマ】">
				</form>
				<form action="trends" method="post">
					<input type="hidden" name="bigGenre" value="literature">
					<input type="hidden" name="genre" value="history">
					<input class="submit-design" type="submit" value="【歴史】">
				</form>
				<form action="trends" method="post">
					<input type="hidden" name="bigGenre" value="literature">
					<input type="hidden" name="genre" value="horror">
					<input class="submit-design" type="submit" value="【ホラー】">
				</form>
				<form action="trends" method="post">
					<input type="hidden" name="bigGenre" value="literature">
					<input type="hidden" name="genre" value="action">
					<input class="submit-design" type="submit" value="【アクション】">
				</form>
				<form action="trends" method="post">
					<input type="hidden" name="bigGenre" value="literature">
					<input type="hidden" name="genre" value="comedy">
					<input class="submit-design" type="submit" value="【コメディー】">
				</form>
				<form action="trends" method="post">
					<input type="hidden" name="bigGenre" value="literature">
					<input type="hidden" name="genre" value="reasoning">
					<input class="submit-design" type="submit" value="【推理】">
				</form>

<%@ include file="../footer.jsp" %>