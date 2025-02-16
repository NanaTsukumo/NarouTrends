package main;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import info.KeywordInfo;
import trend.TrendsGenre;

public class Main
{
	/**
	 * キーワード情報取得の検証用クラス
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args)
	{
		TrendsGenre trend = new TrendsGenre();
		
		//結果の表示
		//System.out.println(trend.getDesignRankTrends(OrderConst.DAILY_POINT, GenreConst.HIGH_FANTASY, 1));
		
		//処理前の時刻の計測(ミリ)
		long start = System.currentTimeMillis();
		
		System.out.println("日間連載中ランキングキーワード一覧：（降順）\n");
		//List<KeywordInfo> keywords = trend.getWeekRankTrends("FANTASY_HIGH", 1);
		List<KeywordInfo> keywords = trend.getDailyRankTrends("COMPREHENSIVE", 1);
		trend.getWeeklyRankTrends("COMPREHENSIVE", 1);
		//trend.getMonthlyRankTrends("COMPREHENSIVE", 1);
		//trend.getQuarterRankTrends("COMPREHENSIVE", 1);
		//trend.getYearlyRankTrends("COMPREHENSIVE", 1);
		//trend.getCumulativeRankTrends("COMPREHENSIVE", 1);
		int rank = 20;
		for(int i = 0; i < rank; i++)
			System.out.println("上位"+ rank + "位のキーワード:\n"
					+ keywords.get(i));
		
		System.out.println("保存されている日間連載中ランキングキーワード一覧：（降順）\n");
		System.out.println(trend.getKeywordInfo().get("COMPREHENSIVE").getKeywordTrend("DAILY_POINT"));
		//処理後の時刻の計測（ミリ）
		long end = System.currentTimeMillis();
		
		//処理時間の計測結果表示
		System.out.println("計測した小説の数:" + trend.getNovelNum() + "個");
		System.out.println("開始時刻:" + start + "ms");
		System.out.println("終了時刻:" + end + "ms");
		System.out.println("処理時間:" + ((end - start)/1000) + "秒");
		
		//終了時刻の方が遅い時間だと1 終了時刻の方が早い時間だと-1　完全に同一の時刻であれば0
		//System.out.println("始めと終わりの時間の差" + start.until(realTime, ChronoUnit.valueOf("HOURS")));
		
		//更新回数カウント
		int updateCount = 0;
		
		//ジャンルごとの初期設定完了状況
		//初期値は設定していないことを示すfalse
		//本番環境ではコンストラクタでfalseに設定
		//異世界恋愛
		boolean setLoveDiff = false;
		//現実世界恋愛
		boolean setLoveReal = false;
		//ハイファンタジー
		boolean setHighFantasy = false;
		//ローファンタジー
		boolean setLowFantasy = false;
		//純文学
		boolean setLiteralPure = false;
		//ヒューマンドラマ
		boolean setDrama = false;
		//歴史
		boolean setHistory = false;
		//推理
		boolean setDetective = false;
		//ホラー
		boolean setHorror = false;
		//アクション
		boolean setAction = false;
		//コメディー
		boolean setComedy = false;
		//VRゲーム
		boolean setVR = false;
		//宇宙
		boolean setSpace = false;
		//空想科学
		boolean setScience = false;
		//パニック
		boolean setPanic = false;
		//童話
		boolean setFairytale = false;
		//詩
		boolean setPoem = false;
		//エッセイ
		boolean setEssay = false;
		//リプレイ
		boolean setReplay = false;
		//その他
		boolean setOther = false;
		//ノンジャンル
		boolean setNongenre = false;
		//総合
		boolean setComprehensive = false;
		//注目度
		boolean setDegree = false;
		//異世界転生
		boolean setDiffRein = false;
		//異世界転移
		boolean setDiffMeta = false;
		//ここからジャンルが増え次第順次追加
		
		//初期設定確認用変数（テストのみ。本番環境ではそれぞれのジャンルごとの変数を使用）
		//初期値は設定していないことを示すfalse
		//本番環境ではコンストラクタでfalseに初期化
		boolean initialSetting = false;
		
		//毎日更新の設定
		//朝の更新時間
		LocalDateTime morningUpdate = LocalDateTime.now().with(LocalTime.of(8, 0, 0));
		//昼の更新時間
		LocalDateTime noonUpdate = LocalDateTime.now().with(LocalTime.of(13, 0, 0));
		//夜の更新時間
		LocalDateTime nightUpdate = LocalDateTime.now().with(LocalTime.of(20, 0, 0));
		//夜の更新で0時を回っている場合
		LocalDateTime clockZero = LocalDateTime.now().with(LocalTime.of(0, 0, 0));
		
		//初回起動時間を朝４時に設定
		LocalDateTime startTime = LocalDateTime.now().with(LocalTime.of(4, 0, 0));
		System.out.println("start:" + startTime);
		
		LocalDateTime realTime = LocalDateTime.now();
		System.out.println("realTime:" + realTime);
		
		//次の更新時間
		LocalDateTime nextUpdateTime;
		
		//updateCount=0 初回起動時の更新
		//updateCount=1 ８時の更新
		//updateCount=2 １３時の更新
		//updateCount=3 ２０時の更新
		
		
		//終了時刻(現在時刻)の方が遅い時間だと1 終了時刻(現在時刻)の方が早い時間だと-1　完全に同一の時刻であれば0
		//0 < 更新設定時刻.until(現在時刻, ChronoUnit.valueOf("HOURS"))
		//更新設定時間を現在時刻が超えていた場合はtrueとなる
		
		//更新を繰り返せるかどうかを確かめる
		for(int i = 0; i < 10; i++)
		{
			System.out.println("繰り返し" + i + "回目");
			
			//この初期設定部分はジャンルを引数として渡せばメソッドとして落とし込めそう
			//初期設定が済んでいなかった場合
			//更新をジャンルごとに行いたいがこれだと１つのジャンルの初期設定が終わった時点で他のジャンルの初期設定ができなくなってしまう
			// ⇒各ジャンルごとに初期設定がされているかどうか(boolean型変数の値)を確認することで解決する
			if(!initialSetting)
			{
				//日にちは同じだが時間が８時よりも前の場合(０時～８時)
				//現在時刻が当日の朝更新時間を超えていない場合
				if(0 > morningUpdate.until(realTime, ChronoUnit.valueOf("HOURS")))
				{
					//次の更新時間を当日の朝に設定?
					updateCount = 1;
				}
				//現在時刻が朝の時間の更新時間後の場合(８時～１３時)
				else if((0 < morningUpdate.until(realTime, ChronoUnit.valueOf("HOURS"))) || (0 == morningUpdate.until(realTime, ChronoUnit.valueOf("HOURS"))))
				{
					//次の更新時間を昼に設定？
					updateCount = 2;
				}
				//現在時刻が昼の時間の更新時間後の場合（１３時～２０時）
				if((0 < noonUpdate.until(realTime, ChronoUnit.valueOf("HOURS"))) || (0 == noonUpdate.until(realTime, ChronoUnit.valueOf("HOURS"))))
				{
					//次の更新を夜に設定？
					updateCount = 3;
				}
				//現在時刻が夜の時間の更新時間後の場合（２０時～０時）
				if((0 < nightUpdate.until(realTime, ChronoUnit.valueOf("HOURS"))) || (0 == nightUpdate.until(realTime, ChronoUnit.valueOf("HOURS"))))
				{
					//次の更新時間を翌日の朝に設定？
					
					//0時を回って翌日になっていた場合（０時～８時）
					if(0 < nightUpdate.until(realTime, ChronoUnit.valueOf("DAYS")))
					{
						//次の更新時間を当日の朝に設定？（深夜０時を回っていたらその日の朝を設定）
					}
					
					updateCount = 1;
				}
				//初期設定は必ず１回実行されるため最後に行う
				//ここでTrendsクラスを呼び出して指定ジャンルの初期設定（キーワードの取得）をする
				//setGenreAttribute(session, Narou4jNovelBigGenre.ジャンル定数, 1(昇順、降順でデフォルトは降順（今後の機能拡張のための値）));
				//初期設定完了の変数更新
				initialSetting = true;
			}
			//初期設定が完了していたら
			else
			{
				//この条件分岐だと朝に初期設定をした後に夜更新をすると昼に更新をする設定になってしまう
				//朝の更新
				if(updateCount == 1)
				{
					//現在時刻が朝の更新時刻を超えていなかったら
					if(0 < morningUpdate.until(realTime, ChronoUnit.valueOf("HOURS")))
					{
						//更新はせず以前に取得したデータを取り出してセットする
					}
					//更新時刻を超えていたら(同時刻でもOK)指定ジャンルの【日間】【週間】【月間】【四半期】【年間】【累計】キーワードを更新
					else
					{
						//指定ジャンルの【日間】【週間】【月間】【四半期】【年間】【累計】キーワードを更新
						//次の更新時間を昼に設定
						updateCount = 2;
					}
					/*
					else
					{
						//更新のためのメソッドを呼び出してジャンルごとのキーワード情報の更新を実行->【日間】【週間】【月間】【四半期】【年間】【累計】
						//次の更新時間を昼に設定
						updateCount = 2;
						//更新時刻が夜の更新時間を越していたら
						if(0 > nightUpdate.until(realTime, ChronoUnit.valueOf("HOURS")))
						{
							//更新時刻が夜であり２０時～０時の間の場合
							//0時を回って翌日になっていた場合（０時～８時）
							if(0 > nightUpdate.until(realTime, ChronoUnit.valueOf("DAYS")))
							{
								//次の更新時間を当日の朝に設定？（深夜０時を回っていたらその日の朝を設定）
								updateCount = 1;
							}
							//更新時刻が夜であり２０時～０時の間の場合
							else if(0 == nightUpdate.until(realTime, ChronoUnit.valueOf("DAYS")))
							{
								//次の更新時間を翌日の朝に設定？
								updateCount = 1;
							}
						}
						//現在時刻が昼の更新時間を超えていたら
						else if(0 < noonUpdate.until(realTime, ChronoUnit.valueOf("HOURS")))
						{
							//次の更新時間を当日の夜に設定？
							updateCount = 3;
						}
					}
					*/
				}
				//昼の更新
				else if(updateCount == 2)
				{
					//現在時刻が昼の更新時刻を超えていなかったら
					if(0 < noonUpdate.until(realTime, ChronoUnit.valueOf("HOURS")))
					{
						//更新はせず以前に取得したデータを取り出してセットする
					}
					//更新時刻を超えていたら指定ジャンルの【日間】【累計】キーワードを更新
					else
					{
						//更新のためのメソッドを呼び出してジャンルごとのキーワード情報の更新を実行->【日間】【累計】
						//次の更新時間を夜に設定
						updateCount = 3;
					}
				}
				//夜の更新
				else
				{
					//現在時刻が夜の更新時刻を超えていなかったら
					if(0 > nightUpdate.until(realTime, ChronoUnit.valueOf("HOURS")))
					{
						//更新はせず以前に取得したデータを取り出してセットする
					}
					//更新時刻を超えていたら指定ジャンルの【日間】【累計】キーワードを更新
					else
					{
						//0時を回って翌日になっていた場合（０時～８時）
						if(0 < nightUpdate.until(realTime, ChronoUnit.valueOf("DAYS")))
						{
							//次の更新時間を当日の朝に設定？（深夜０時を回っていたらその日の朝を設定）
						}
						//更新のためのメソッドを呼び出してジャンルごとのキーワード情報の更新を実行->【日間】【累計】
						//次の更新時間を朝に設定
						updateCount = 1;
					}
				}
			}
			
			/*
			if(updateCount == 0)
			{
				//仕様上初めにupdateを1に設定する
				updateCount = 1;
				
				//公式の更新時間は7~8時、11~12時、18~19時の３回で３回日間ランキングを更新する必要がある
				//年間ランキングは毎週火曜日朝更新(これは毎朝更新のついでに行う)
				//毎時更新の累計ランキングをどのように扱うか？(累計ランキングは１日３回更新)
				//setGenreAttribute(session, Narou4jNovelBigGenre.COMPREHENSIVE, 1);
				//keywords = trend.getDailyRankTrends("COMPREHENSIVE", 1);
				//trend.getWeeklyRankTrends("COMPREHENSIVE", 1);
				//trend.getMonthlyRankTrends("COMPREHENSIVE", 1);
				//trend.getQuarterRankTrends("COMPREHENSIVE", 1);
				//trend.getYearlyRankTrends("COMPREHENSIVE", 1);
				//trend.getCumulativeRankTrends("COMPREHENSIVE", 1);
				//その日の更新時間を記録(初期値は朝８時に設定)
				
				//送信されたジャンルの情報を更新
				//update=0
				//初回の更新は全ての期間を更新する
				
				//更新時間をその日の8時に設定
				startTime = LocalDateTime.now().with(LocalTime.of(8, 0, 0));
				//System.out.println("start:" + start);
				System.out.println("更新" + updateCount + "回目");
				//現在時刻を朝９時に設定
				realTime = LocalDateTime.now().with(LocalTime.of(9, 0, 0));
			}
			else if(updateCount == 1)//n=1をどのように処理するか問題
			{
				//保存してあるキーワード情報を取得
				//setGenreAttribute(session, Narou4jNovelBigGenre.COMPREHENSIVE);
				//現在時刻を取得して1日経っているかどうかを検証
				//startの値はその日の８時に設定されている
				//引数の終了時刻の方が遅い場合(1の場合)
				if(0 < startTime.until(realTime, ChronoUnit.valueOf("HOURS")))
				{
					//setDailyGenreAttribute(session, Narou4jNovelBigGenre.COMPREHENSIVE, 1);
					updateCount = 2;
					
					//ここで１日の更新１回目
					//更新する期間は全ての期間
					 
					//更新時刻を13時に設定
					startTime = LocalDateTime.now().with(LocalTime.of(13, 0, 0));
					//現在時刻を14時に設定
					realTime = LocalDateTime.now().with(LocalTime.of(14, 0, 0));
				}
				else//終了時刻の方が早い場合(-1の場合)
				{
					
					//保存されている指定されたジャンルの期間別トレンドを取得する
					 
					//setGenreAttribute(session, Narou4jNovelBigGenre.COMPREHENSIVE);
				}
			}
			else if(updateCount == 2)
			{
				
			}
			*/
		}
	}
}
