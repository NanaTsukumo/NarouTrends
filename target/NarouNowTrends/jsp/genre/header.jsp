<%@ page language="java" contentType="text/html; charset=UTF-8" %>

	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/header.css">
	<link rel="stylesheet" type="text/css" href="css/dropdown.css">
	<link rel="stylesheet" type="text/css" href="css/table_style.css">
	<link rel="stylesheet" type="text/css" href="css/home.css">
	<link rel="stylesheet" type="text/css" href="css/small_genre.css">
	
</head>

<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PVLBMR24"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->
	<div class="wrapper">
		<div class="center">
			<div class="container">
				<header>
					<h1 class="title-block"><a class="title-block" href="index.html">なろうトレンド</a></h1>
					<nav class="global-nav">
						<ul class="nav-list">
							<li class="nav-item">
								<a class="dropdown-p">【総合】</a>
								<ul class="dropdown-lists">
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="comprehensive">
											<input class="submit-design" type="submit" value="【総合】">
										</form>
									</li>
								</ul>
							</li>
							<li class="nav-item">
								<a class="dropdown-p">【恋愛】</a>
								<ul class="dropdown-lists">
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="love">
											<input type="hidden" name="genre" value="different_love">
											<input class="submit-design" type="submit" value="【異世界（恋愛）】">
										</form>
									</li>
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="love">
											<input type="hidden" name="genre" value="real_love">
											<input class="submit-design" type="submit" value="【現実（恋愛）】">
										</form>
									</li>
								</ul>
							</li>
							<li class="nav-item">
								<a class="dropdown-p">【ファンタジー】</a>
								<ul class="dropdown-lists">
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="fantasy">
											<input type="hidden" name="genre" value="high_fantasy">
											<input class="submit-design" type="submit" value="【ハイファンタジー】">
										</form>
									</li>
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="fantasy">
											<input type="hidden" name="genre" value="low_fantasy">
											<input class="submit-design" type="submit" value="【ローファンタジー】">
										</form>
									</li>
								</ul>
							</li>
							<li class="nav-item">
								<a class="dropdown-p">【文芸】</a>
								<ul class="dropdown-lists">
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="literature">
											<input type="hidden" name="genre" value="pure_literature">
											<input class="submit-design" type="submit" value="【純文学】">
										</form>
									</li>
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="literature">
											<input type="hidden" name="genre" value="human_drama">
											<input class="submit-design" type="submit" value="【ヒューマンドラマ】">
										</form>
									</li>
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="literature">
											<input type="hidden" name="genre" value="history">
											<input class="submit-design" type="submit" value="【歴史】">
										</form>
									</li>
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="literature">
											<input type="hidden" name="genre" value="horror">
											<input class="submit-design" type="submit" value="【ホラー】">
										</form>
									</li>
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="literature">
											<input type="hidden" name="genre" value="action">
											<input class="submit-design" type="submit" value="【アクション】">
										</form>
									</li>
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="literature">
											<input type="hidden" name="genre" value="comedy">
											<input class="submit-design" type="submit" value="【コメディー】">
										</form>
									</li>
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="literature">
											<input type="hidden" name="genre" value="reasoning">
											<input class="submit-design" type="submit" value="【推理】">
										</form>
									</li>
								</ul>
							</li>
							<li class="nav-item">
								<a class="dropdown-p">【SF】</a>
								<ul class="dropdown-lists">
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="sf">
											<input type="hidden" name="genre" value="vr_game">
											<input class="submit-design" type="submit" value="【VRゲーム】">
										</form>
									</li>
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="sf">
											<input type="hidden" name="genre" value="universe">
											<input class="submit-design" type="submit" value="【宇宙】">
										</form>
									</li>
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="sf">
											<input type="hidden" name="genre" value="science_fiction">
											<input class="submit-design" type="submit" value="【空想科学】">
										</form>
									</li>
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="sf">
											<input type="hidden" name="genre" value="panic">
											<input class="submit-design" type="submit" value="【パニック】">
										</form>
									</li>
								</ul>
							</li>
							<li class="nav-item">
								<a class="dropdown-p">【その他】</a>
								<ul class="dropdown-lists">
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="others">
											<input type="hidden" name="genre" value="fairy_tale">
											<input class="submit-design" type="submit" value="【童話】">
										</form>
									</li>
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="others">
											<input type="hidden" name="genre" value="poem">
											<input class="submit-design" type="submit" value="【詩】">
										</form>
									</li>
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="others">
											<input type="hidden" name="genre" value="essay">
											<input class="submit-design" type="submit" value="【エッセイ】">
										</form>
									</li>
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="others">
											<input type="hidden" name="genre" value="replay">
											<input class="submit-design" type="submit" value="【リプレイ】">
										</form>
									</li>
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="others">
											<input type="hidden" name="genre" value="other">
											<input class="submit-design" type="submit" value="【その他】">
										</form>
									</li>
								</ul>
							</li>
					   		<li class="nav-item">
								<a class="dropdown-p">【ノンジャンル】</a>
								<ul class="dropdown-lists">
									<li class="dropdown-list">
										<form action="trends" method="post">
											<input type="hidden" name="bigGenre" value="non">
											<input class="submit-design" type="submit" value="【ノンジャンル】">
										</form>
									</li>
								</ul>
					   		</li>
					  	</ul>
					</nav>
				</header>