package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import constant.FileExtensionPath;
import constant.FolderPath;
import constant.GenreConst;
import constant.narou4j.Narou4jNovelBigGenre;
import constant.narou4j.Narou4jNovelGenre;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import trend.Trends;


/**
 * 指定されたジャンルの小説情報(キーワード)を取得して返送する
 * @author Nana Tsukumo
 * @version 1.0.0
 * @see jakarta.servlet.http.HttpServlet
 */
public class GenreServlet extends HttpServlet
{
	/* @seeはドキュメントの関連項目 */
	
	
	/**
	 * 定期的にコマンドを送信するクラスのオブジェクト
	 */
	private ScheduledExecutorService scheduler;
	
	/**
	 * サーブレット限定ジャンル定数
	 */
	protected String COMPREHENSIVE = "COMPREHENSIVE";
	
	/**
	 * キーワード情報の取得
	 */
	protected Trends trend;
	
	//情報を読み取ったら追加する
	/**
	 * ジャンルランキングの更新を終えたら1に変更する
	 */
	protected int update;
	
	/**
	 * 更新時間
	 */
	protected LocalDateTime updateTime;
	
	/**
	 * サーブレット初回起動時間を記録する変数
	 */
	protected LocalDateTime startTime;
	
	/**
	 * 情報更新開始時間を記録する変数
	 */
	protected long start;
	
	/**
	 * 情報更新終了時間を記録する変数
	 */
	protected long end;
	
	/**
	 * 情報更新終了までの秒数を記録する変数
	 */
	protected long endPeriod;
	
	/**
	 * コンストラクタ
	 * Trendsクラスをインスタンス化します。
	 */
	public GenreServlet()
	{
		trend = new Trends();
		update = 0;
		startTime = LocalDateTime.now();
	}
	
	
	
	/**
	 * 時間による情報更新
	 * @exception ServletException サーブレットの起動が上手くいかなかった場合に発生します。
	 */
	@Override
	public void init() throws ServletException
	{
		super.init();
		/* 一度に送信できるコマンド数の上限設定 */
		scheduler = Executors.newScheduledThreadPool(1);
		
		//サーブレット初回起動時にタスク
		executeTask();
		
		// 7時にタスクをスケジュール
        scheduleTaskAtFixedTime(LocalTime.of(7, 0));
        // 12時にタスクをスケジュール
        scheduleTaskAtFixedTime(LocalTime.of(12, 0));
        // 19時にタスクをスケジュール
        scheduleTaskAtFixedTime(LocalTime.of(19, 0));
	}
	
	/**
	 * サーブレット起動時のみに実行するメソッドです．
	 */
	private void executeTask()
	{
		//開始時間計測
		start = System.currentTimeMillis();
		/* 総合 */
		updateKeywordRank(Narou4jNovelBigGenre.COMPREHENSIVE, 1);
		
		/* 異世界 */
		/* 異世界(恋愛) */
		updateKeywordRank(Narou4jNovelGenre.LOVE_DIFF_WORLD, 1);
		/* 現実（恋愛） */
		updateKeywordRank(Narou4jNovelGenre.LOVE_REAL_WORLD, 1);
		
		/* ファンタジー */
		/* ハイファンタジー（ファンタジー） */
		updateKeywordRank(Narou4jNovelGenre.FANTASY_HIGH, 1);
		/* ローファンタジー（ファンタジー） */
		updateKeywordRank(Narou4jNovelGenre.FANTASY_LOW, 1);
		
		/* 文芸 */
		/* 純文学（文芸） */
		updateKeywordRank(Narou4jNovelGenre.LITERAL_PURE, 1);
		/* ヒューマンドラマ */
		updateKeywordRank(Narou4jNovelGenre.LITERAL_DRAMA, 1);
		/* 歴史 */
		updateKeywordRank(Narou4jNovelGenre.LITERAL_HISTORY, 1);
		/* 推理 */
		updateKeywordRank(Narou4jNovelGenre.LITERAL_DETECTIVE, 1);
		/* ホラー */
		updateKeywordRank(Narou4jNovelGenre.LITERAL_HORROR, 1);
		/* アクション */
		updateKeywordRank(Narou4jNovelGenre.LITERAL_ACTION, 1);
		/* コメディー */
		updateKeywordRank(Narou4jNovelGenre.LITERAL_COMEDY, 1);
		
		/* SF */
		/* VRゲーム */
		updateKeywordRank(Narou4jNovelGenre.SF_VR, 1);
		/* 宇宙 */
		updateKeywordRank(Narou4jNovelGenre.SF_SPACE, 1);
		/* 空想科学 */
		updateKeywordRank(Narou4jNovelGenre.SF_SCIENCE, 1);
		/* パニック */
		updateKeywordRank(Narou4jNovelGenre.SF_PANIC, 1);
		
		/* その他 */
		/* 童話 */
		updateKeywordRank(Narou4jNovelGenre.OTHER_FAIRYTALE, 1);
		/* 詩 */
		updateKeywordRank(Narou4jNovelGenre.OTHER_POEM, 1);
		/* エッセイ */
		updateKeywordRank(Narou4jNovelGenre.OTHER_ESSAY, 1);
		/* リプレイ */
		updateKeywordRank(Narou4jNovelGenre.OTHER_REPLAY, 1);
		/* その他 */
		updateKeywordRank(Narou4jNovelGenre.OTHER, 1);
		
		/* ノンジャンル */
		updateKeywordRank(Narou4jNovelGenre.NONGENRE, 1);
		
		updateTime = LocalDateTime.now();
		System.out.println("情報を更新しました． -> " + updateTime);
		end = System.currentTimeMillis();
		System.out.println("開始時刻:" + start + "ms");
		System.out.println("終了時刻:" + end + "ms");
		endPeriod = (end - start)/1000;
		System.out.println("処理時間:" + endPeriod + "秒");
	}
	
	/**
	 * サーブレットを停止した際にschedulerメソッドが動作していた場合にschedulerｗｐを停止させます。
	 */
	@Override
	public void destroy()
	{
		super.destroy();
		if(scheduler != null && !scheduler.isShutdown())
			scheduler.shutdown();
	}
	
	/**
	 * キーワード情報の初回更新を行います。
	 * @param genre ジャンル
	 * @param allign 並び変え順
	 */
	private void updateKeywordRank(String genre, int allign)
	{
		trend.getCumulativeRankTrends(genre, allign);
		trend.getDailyRankTrends(genre, allign);
		trend.getWeeklyRankTrends(genre, allign);
		trend.getMonthlyRankTrends(genre, allign);
		trend.getQuarterRankTrends(genre, allign);
		trend.getYearlyRankTrends(genre, allign);
	}
	
	/**
	 * キーワード情報の更新を行います。
	 * @param targetTime 更新時間
	 * @param genre ジャンル
	 * @param allign 並び変え順
	 */
	private void updateKeywordRank(LocalTime targetTime, String genre, int allign)
	{
		
		//累計と日間は7時、1２時、１９時に更新
		trend.getCumulativeRankTrends(genre, allign);
		trend.getDailyRankTrends(genre, allign);
		
		//７時であれば週間・月間・四半期・年間・累計を更新
		if(targetTime.equals(LocalTime.of(7, 0)))
		{
			trend.getWeeklyRankTrends(genre, allign);
			trend.getMonthlyRankTrends(genre, allign);
			trend.getQuarterRankTrends(genre, allign);
			trend.getYearlyRankTrends(genre, allign);
		}
	}
	
	/**
	 * 定期的にスケジュールに応じた処理を実行するメソッドです。
	 * @param targetTime
	 */
	private void scheduleTaskAtFixedTime(LocalTime targetTime)
	{
		//現在の時間を取得
		LocalDateTime now = LocalDateTime.now();
		//更新時間の設定
		LocalDateTime nextRun = now.with(targetTime);
		
		//もし現在時刻が更新時刻を過ぎていたら次の日に更新するように設定
		if(now.isAfter(nextRun))
			nextRun = nextRun.plusDays(1);
		
		//初期化日程の設定
		long initialDalay = ChronoUnit.MINUTES.between(now, nextRun);
		long period = TimeUnit.DAYS.toMinutes(1);
		
		//処理前の時刻の計測(ミリ)
		start = System.currentTimeMillis();
		
		scheduler.scheduleAtFixedRate(() -> {
			//実行する処理を記述
			//ランキング情報の取得(Trendクラスの解析メソッドを直接使用する)
			//各ジャンルの日間ランキングの取得（朝昼夜）
			
			/* 総合 */
			updateKeywordRank(targetTime, Narou4jNovelBigGenre.COMPREHENSIVE, 1);
			
			/* 異世界 */
			/* 異世界(恋愛) */
			updateKeywordRank(targetTime, Narou4jNovelGenre.LOVE_DIFF_WORLD, 1);
			/* 現実（恋愛） */
			updateKeywordRank(targetTime, Narou4jNovelGenre.LOVE_REAL_WORLD, 1);
			
			/* ファンタジー */
			/* ハイファンタジー（ファンタジー） */
			updateKeywordRank(targetTime, Narou4jNovelGenre.FANTASY_HIGH, 1);
			/* ローファンタジー（ファンタジー） */
			updateKeywordRank(targetTime, Narou4jNovelGenre.FANTASY_LOW, 1);
			
			/* 文芸 */
			/* 純文学（文芸） */
			updateKeywordRank(targetTime, Narou4jNovelGenre.LITERAL_PURE, 1);
			/* ヒューマンドラマ */
			updateKeywordRank(targetTime, Narou4jNovelGenre.LITERAL_DRAMA, 1);
			/* 歴史 */
			updateKeywordRank(targetTime, Narou4jNovelGenre.LITERAL_HISTORY, 1);
			/* 推理 */
			updateKeywordRank(targetTime, Narou4jNovelGenre.LITERAL_DETECTIVE, 1);
			/* ホラー */
			updateKeywordRank(targetTime, Narou4jNovelGenre.LITERAL_HORROR, 1);
			/* アクション */
			updateKeywordRank(targetTime, Narou4jNovelGenre.LITERAL_ACTION, 1);
			/* コメディー */
			updateKeywordRank(targetTime, Narou4jNovelGenre.LITERAL_COMEDY, 1);
			
			/* SF */
			/* VRゲーム */
			updateKeywordRank(targetTime, Narou4jNovelGenre.SF_VR, 1);
			/* 宇宙 */
			updateKeywordRank(targetTime, Narou4jNovelGenre.SF_SPACE, 1);
			/* 空想科学 */
			updateKeywordRank(targetTime, Narou4jNovelGenre.SF_SCIENCE, 1);
			/* パニック */
			updateKeywordRank(targetTime, Narou4jNovelGenre.SF_PANIC, 1);
			
			/* その他 */
			/* 童話 */
			updateKeywordRank(targetTime, Narou4jNovelGenre.OTHER_FAIRYTALE, 1);
			/* 詩 */
			updateKeywordRank(targetTime, Narou4jNovelGenre.OTHER_POEM, 1);
			/* エッセイ */
			updateKeywordRank(targetTime, Narou4jNovelGenre.OTHER_ESSAY, 1);
			/* リプレイ */
			updateKeywordRank(targetTime, Narou4jNovelGenre.OTHER_REPLAY, 1);
			/* その他 */
			updateKeywordRank(targetTime, Narou4jNovelGenre.OTHER, 1);
			
			/* ノンジャンル */
			updateKeywordRank(targetTime, Narou4jNovelGenre.NONGENRE, 1);
			
			updateTime = LocalDateTime.now();
			System.out.println("情報を更新しました． -> " + updateTime);
			end = System.currentTimeMillis();
			System.out.println("開始時刻:" + start + "ms");
			System.out.println("終了時刻:" + end + "ms");
			endPeriod = (end - start)/1000;
			System.out.println("処理時間:" + endPeriod + "秒");
			}, initialDalay, period, TimeUnit.MINUTES);
	}
	
	/**
	 * サイトから送られてきたジャンル情報を分別しジャンル別に小説情報(キーワード)を取得して返送します。
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/* セッションオブジェクトの生成 */
		HttpSession session = request.getSession();
		/* サイトから送信された大ジャンル名の取得 */
		String bigGenre = request.getParameter("bigGenre");

		/* 大ジャンル【総合】の指定
		 * キーワード情報取得と返送 */
		if(bigGenre.equals(GenreConst.COMPREHENSIVE))
		{
			//ジャンル[総合]:
			//日間・週間・月間・四半期・年間・総合キーワードランキング取得・設定
			
			//保存されているキーワード情報を取得
			setGenreAttribute(session, Narou4jNovelBigGenre.COMPREHENSIVE);
			//更新時間を設定
			session.setAttribute("updateTime", updateTime);
			//総合ページに情報を設定
			RequestDispatcher disp = request.getRequestDispatcher(
					FolderPath.JSP_FOLDER_PATH
					+ FolderPath.GENRE_FOLDER_PATH
					+ GenreConst.COMPREHENSIVE
					+ FileExtensionPath.JSP_EXTENSION);
			disp.forward(request, response);
		}
		// 大ジャンル【恋愛】の指定
		else if(bigGenre.equals(GenreConst.LOVE))
		{
			//サイトから送信されたジャンル名の取得
			String genre = request.getParameter("genre");
			//異世界（恋愛）のキーワード情報取得と返送
			if(genre.equals(GenreConst.DIFF_LOVE))
			{
				//保存されているキーワード情報を取得
				setGenreAttribute(session, Narou4jNovelGenre.LOVE_DIFF_WORLD);
				//更新時間を設定
				session.setAttribute("updateTime", updateTime);
				//恋愛(異世界)ページに情報を設定
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.LOVE
						+ "/"
						+ GenreConst.DIFF_LOVE
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
			//現実世界（恋愛）のキーワード情報取得と返送
			else if(genre.equals(GenreConst.REAL_LOVE))
			{
				//保存されているキーワード情報を取得
				setGenreAttribute(session, Narou4jNovelGenre.LOVE_REAL_WORLD);
				//更新時間を設定
				session.setAttribute("updateTime", updateTime);
				//恋愛(現実)ページに情報を設定
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.LOVE
						+ "/"
						+ GenreConst.REAL_LOVE
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
			//ジャンル名が上手く送信できなかった場合の送信先
			else
			{
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.LOVE
						+ "/"
						+ GenreConst.LOVE
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
		}
		//大ジャンル【ファンタジー】の指定
		else if(bigGenre.equals(GenreConst.FANTASY))
		{
			//サイトから送信されたジャンル名の取得
			String genre = request.getParameter("genre");
			//ハイファンタジーのキーワード情報取得と返送
			if(genre.equals(GenreConst.HIGH_FANTASY))
			{
				//保存されているキーワード情報を取得
				setGenreAttribute(session, Narou4jNovelGenre.FANTASY_HIGH);
				//更新時間を設定
				session.setAttribute("updateTime", updateTime);
				//ページに情報を設定
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.FANTASY
						+ "/"
						+ GenreConst.HIGH_FANTASY
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
			//ローファンタジーのキーワード情報取得と返送
			else if(genre.equals(GenreConst.LOW_FANTASY))
			{
				//保存されているキーワード情報を取得
				setGenreAttribute(session, Narou4jNovelGenre.FANTASY_LOW);
				//更新時間を設定
				session.setAttribute("updateTime", updateTime);
				//ページに情報を設定
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.FANTASY
						+ "/"
						+ GenreConst.LOW_FANTASY
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
			//ジャンル名が上手く送信できなかった場合の送信先
			else
			{
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.FANTASY
						+ "/"
						+ GenreConst.FANTASY
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
		}
		//大ジャンル【文芸】の指定
		else if(bigGenre.equals(GenreConst.LITERATURE))
		{
			//サイトから送信されたジャンル名の取得
			String genre = request.getParameter("genre");
			//純文学のキーワード情報取得と返送
			if(genre.equals(GenreConst.PURE_LITERATURE))
			{
				//保存されているキーワード情報を取得
				setGenreAttribute(session, Narou4jNovelGenre.LITERAL_PURE);
				//更新時間を設定
				session.setAttribute("updateTime", updateTime);
				//ページに情報を設定
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.LITERATURE
						+ "/"
						+ GenreConst.PURE_LITERATURE
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
			//ヒューマンドラマのキーワード情報取得と返送
			else if(genre.equals(GenreConst.HYUMAN_DRAMA))
			{
				//保存されているキーワード情報を取得
				setGenreAttribute(session, Narou4jNovelGenre.LITERAL_DRAMA);
				//更新時間を設定
				session.setAttribute("updateTime", updateTime);
				//ページに情報を設定
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.LITERATURE
						+ "/"
						+ GenreConst.HYUMAN_DRAMA
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
			//歴史のキーワード情報取得と返送
			else if(genre.equals(GenreConst.HISTORY))
			{
				//保存されているキーワード情報を取得
				setGenreAttribute(session, Narou4jNovelGenre.LITERAL_HISTORY);
				//更新時間を設定
				session.setAttribute("updateTime", updateTime);
				//ページに情報を設定
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.LITERATURE
						+ "/"
						+ GenreConst.HISTORY
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
			//ホラーのキーワード情報取得と返送
			else if(genre.equals(GenreConst.HORROR))
			{
				//保存されているキーワード情報を取得
				setGenreAttribute(session, Narou4jNovelGenre.LITERAL_HORROR);
				//更新時間を設定
				session.setAttribute("updateTime", updateTime);
				//ページに情報を設定
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.LITERATURE
						+ "/"
						+ GenreConst.HORROR
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
			//アクションのキーワード情報取得と返送
			else if(genre.equals(GenreConst.ACTION))
			{
				//保存されているキーワード情報を取得
				setGenreAttribute(session, Narou4jNovelGenre.LITERAL_ACTION);
				//更新時間を設定
				session.setAttribute("updateTime", updateTime);
				//ページに情報を設定
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.LITERATURE
						+ "/"
						+ GenreConst.ACTION
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
			//コメディーのキーワード情報取得と返送
			else if(genre.equals(GenreConst.COMEDY))
			{
				//保存されているキーワード情報を取得
				setGenreAttribute(session, Narou4jNovelGenre.LITERAL_COMEDY);
				//更新時間を設定
				session.setAttribute("updateTime", updateTime);
				//ページに情報を設定
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.LITERATURE
						+ "/"
						+ GenreConst.COMEDY
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
			//推理のキーワード情報取得と返送
			else if(genre.equals(GenreConst.REASONING))
			{
				//保存されているキーワード情報を取得
				setGenreAttribute(session, Narou4jNovelGenre.LITERAL_DETECTIVE);
				//更新時間を設定
				session.setAttribute("updateTime", updateTime);
				//ページに情報を設定
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.LITERATURE
						+ "/"
						+ GenreConst.REASONING
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
			//ジャンル名が上手く送信できなかった場合の送信先
			else
			{
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.LITERATURE
						+ "/"
						+ GenreConst.LITERATURE
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
		}
		//大ジャンル【SF】の指定
		else if(bigGenre.equals(GenreConst.SF))
		{
			//サイトから送信されたジャンル名の取得
			String genre = request.getParameter("genre");
			//VRゲームのキーワード情報取得と返送
			if(genre.equals(GenreConst.VR_GAME))
			{
				//保存されているキーワード情報を取得
				setGenreAttribute(session, Narou4jNovelGenre.SF_VR);
				//更新時間を設定
				session.setAttribute("updateTime", updateTime);
				//ページに情報を設定
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.SF
						+ "/"
						+ GenreConst.VR_GAME
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
			//宇宙のキーワード情報取得と返送
			else if(genre.equals(GenreConst.UNIVERSE))
			{
				//保存されているキーワード情報を取得
				setGenreAttribute(session, Narou4jNovelGenre.SF_SPACE);
				//更新時間を設定
				session.setAttribute("updateTime", updateTime);
				//ページに情報を設定
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.SF
						+ "/"
						+ GenreConst.UNIVERSE
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
			//空想科学のキーワード情報取得と返送
			else if(genre.equals(GenreConst.SCIENCE_FICTION))
			{
				//保存されているキーワード情報を取得
				setGenreAttribute(session, Narou4jNovelGenre.SF_SCIENCE);
				//更新時間を設定
				session.setAttribute("updateTime", updateTime);
				//ページに情報を設定
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.SF
						+ "/"
						+ GenreConst.SCIENCE_FICTION
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
			//パニックのキーワード情報取得と返送
			else if(genre.equals(GenreConst.PANIC))
			{
				//保存されているキーワード情報を取得
				setGenreAttribute(session, Narou4jNovelGenre.SF_PANIC);
				//更新時間を設定
				session.setAttribute("updateTime", updateTime);
				//ページに情報を設定
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.SF
						+ "/"
						+ GenreConst.PANIC
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
			//ジャンル名が上手く送信できなかった場合の送信先
			else
			{
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.SF
						+ "/"
						+ GenreConst.SF
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
		}
		//大ジャンル【その他】の指定
		else if(bigGenre.equals(GenreConst.OTHERS))
		{
			//サイトから送信されたジャンル名の取得
			String genre = request.getParameter("genre");
			//童話のキーワード情報取得と返送
			if(genre.equals(GenreConst.FAIRY_TALE))
			{
				//保存されているキーワード情報を取得
				setGenreAttribute(session, Narou4jNovelGenre.OTHER_FAIRYTALE);
				//更新時間を設定
				session.setAttribute("updateTime", updateTime);
				//ページに情報を設定
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.OTHERS
						+ "/"
						+ GenreConst.FAIRY_TALE
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
			//詩のキーワード情報取得と返送
			else if(genre.equals(GenreConst.POEM))
			{
				//保存されているキーワード情報を取得
				setGenreAttribute(session, Narou4jNovelGenre.OTHER_POEM);
				//更新時間を設定
				session.setAttribute("updateTime", updateTime);
				//ページに情報を設定
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.OTHERS
						+ "/"
						+ GenreConst.POEM
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
			//エッセイのキーワード情報取得と返送
			else if(genre.equals(GenreConst.ESSAY))
			{
				//保存されているキーワード情報を取得
				setGenreAttribute(session, Narou4jNovelGenre.OTHER_ESSAY);
				//更新時間を設定
				session.setAttribute("updateTime", updateTime);
				//ページに情報を設定
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.OTHERS
						+ "/"
						+ GenreConst.ESSAY
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
			//リプレイのキーワード情報取得と返送
			else if(genre.equals(GenreConst.REPLAY))
			{
				//保存されているキーワード情報を取得
				setGenreAttribute(session, Narou4jNovelGenre.OTHER_REPLAY);
				//更新時間を設定
				session.setAttribute("updateTime", updateTime);
				//ページに情報を設定
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.OTHERS
						+ "/"
						+ GenreConst.REPLAY
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
			//その他のキーワード情報取得と返送
			else if(genre.equals(GenreConst.OTHER))
			{
				//保存されているキーワード情報を取得
				setGenreAttribute(session, Narou4jNovelGenre.OTHER);
				//更新時間を設定
				session.setAttribute("updateTime", updateTime);
				//ページに情報を設定
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.OTHERS
						+ "/"
						+ GenreConst.OTHER
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
			//ジャンル名が上手く送信できなかった場合の送信先
			else
			{
				RequestDispatcher disp = request.getRequestDispatcher(
						FolderPath.JSP_FOLDER_PATH
						+ FolderPath.GENRE_FOLDER_PATH
						+ GenreConst.OTHERS
						+ "/"
						+ GenreConst.OTHERS
						+ FileExtensionPath.JSP_EXTENSION);
				disp.forward(request, response);
			}
		}
		//大ジャンル【ノンジャンル】の指定
		else if(bigGenre.equals(GenreConst.NON))
		{
			//保存されているキーワード情報を取得
			setGenreAttribute(session, Narou4jNovelGenre.NONGENRE);
			//更新時間を設定
			session.setAttribute("updateTime", updateTime);
			//ページに情報を設定
			RequestDispatcher disp = request.getRequestDispatcher(
					FolderPath.JSP_FOLDER_PATH
					+ FolderPath.GENRE_FOLDER_PATH
					+ GenreConst.NON
					+ "/"
					+ GenreConst.NON
					+ FileExtensionPath.JSP_EXTENSION);
			disp.forward(request, response);
		}
	}
	
	/**
	 * 設定したジャンルで日間キーワードランキングを更新する
	 * @param session セッション
	 * @param genreName ジャンル名
	 * @param GenreConst ジャンル定数
	 */
	private void setDailyGenreAttribute(HttpSession session/* セッション */, String genreConst/* ジャンル設定 */, int allignNum/* 並び替え順 */)
	{
		session.setAttribute("dailyPoint", trend.getDailyRankTrends(genreConst, allignNum));
	}
	
	/**
	 * 設定したジャンルで年間キーワードランキングを更新する
	 * @param session セッション
	 * @param genreName ジャンル名
	 * @param GenreConst ジャンル定数
	 */
	private void setYearlyGenreAttribute(HttpSession session/* セッション */, String genreConst/* ジャンル設定 */, int allignNum/* 並び替え順 */)
	{
		session.setAttribute("yearlyPoint", trend.getYearlyRankTrends(genreConst, allignNum));
	}
	
	/**
	 * 設定したジャンルで累計キーワードランキングを更新する
	 * @param session セッション
	 * @param genreName ジャンル名
	 * @param GenreConst ジャンル定数
	 */
	private void setCumulativeGenreAttribute(HttpSession session/* セッション */, String genreConst/* ジャンル設定 */, int allignNum/* 並び替え順 */)
	{
		session.setAttribute("cumulativePoint", trend.getCumulativeRankTrends(genreConst, allignNum));
	}
	
	/**
	 * 設定したジャンルで日間、週間、月間、四半期、年間キーワードランキングを更新（毎朝実行）
	 * @param session セッション
	 * @param genreName ジャンル名
	 * @param GenreConst ジャンル定数
	 */
	private void setMorningGenreAttribute(HttpSession session/* セッション */, String genreConst/* ジャンル設定 */, int allignNum/* 並び替え順 */)
	{
		session.setAttribute("dailyPoint", trend.getDailyRankTrends(genreConst, allignNum));
		session.setAttribute("weeklyPoint", trend.getWeeklyRankTrends(genreConst, allignNum));
		session.setAttribute("monthlyPoint", trend.getMonthlyRankTrends(genreConst, allignNum));
		session.setAttribute("quarterPoint", trend.getQuarterRankTrends(genreConst, allignNum));
		session.setAttribute("yearlyPoint", trend.getYearlyRankTrends(genreConst, allignNum));
	}
	
	/**
	 * 設定したジャンルでsetAttributeを設定する
	 * @param session セッション
	 * @param genreName ジャンル名
	 * @param GenreConst ジャンル定数
	 */
	private void setGenreAttribute(HttpSession session/* セッション */, String genreConst/* ジャンル設定 */, int allignNum/* 並び替え順 */)
	{
		session.setAttribute("dailyPoint", trend.getDailyRankTrends(genreConst, allignNum));
		session.setAttribute("weeklyPoint", trend.getWeeklyRankTrends(genreConst, allignNum));
		session.setAttribute("monthlyPoint", trend.getMonthlyRankTrends(genreConst, allignNum));
		session.setAttribute("quarterPoint", trend.getQuarterRankTrends(genreConst, allignNum));
		session.setAttribute("yearlyPoint", trend.getYearlyRankTrends(genreConst, allignNum));
		session.setAttribute("cumulativePoint", trend.getCumulativeRankTrends(genreConst, allignNum));
	}
	
	/**
	 * 設定したジャンルのキーワード情報を取得しセットする
	 * @param session セッション
	 * @param genre ジャンル名
	 */
	private void setGenreAttribute(HttpSession session, String genre)
	{
		System.out.println(genre);
		System.out.println("日間:\n" + trend.getKeywordInfo().get(genre).getKeywordTrend("DAILY_POINT"));
		System.out.println("週間:\n" + trend.getKeywordInfo().get(genre).getKeywordTrend("WEEKLY_POINT"));
		System.out.println("月間:\n" + trend.getKeywordInfo().get(genre).getKeywordTrend("MONTHLY_POINT"));
		System.out.println("四半期:\n" + trend.getKeywordInfo().get(genre).getKeywordTrend("QUARTER_POINT"));
		System.out.println("年間:\n" + trend.getKeywordInfo().get(genre).getKeywordTrend("YEARLY_POINT"));
		System.out.println("累計:\n" + trend.getKeywordInfo().get(genre).getKeywordTrend("TOTAL_POINT"));
		session.setAttribute("dailyPoint", trend.getKeywordInfo().get(genre).getKeywordTrend("DAILY_POINT"));
		session.setAttribute("weeklyPoint", trend.getKeywordInfo().get(genre).getKeywordTrend("WEEKLY_POINT"));
		session.setAttribute("monthlyPoint", trend.getKeywordInfo().get(genre).getKeywordTrend("MONTHLY_POINT"));
		session.setAttribute("quarterPoint", trend.getKeywordInfo().get(genre).getKeywordTrend("QUARTER_POINT"));
		session.setAttribute("yearlyPoint", trend.getKeywordInfo().get(genre).getKeywordTrend("YEARLY_POINT"));
		session.setAttribute("cumulativePoint", trend.getKeywordInfo().get(genre).getKeywordTrend("TOTAL_POINT"));
		
	}

}
