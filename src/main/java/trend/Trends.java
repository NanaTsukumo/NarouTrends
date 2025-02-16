package trend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import info.GenreInfo;
import info.KeywordInfo;
import narou4j.Narou;
import narou4j.enums.NovelGenre;
import narou4j.enums.NovelType;
import narou4j.enums.OfParam;
import narou4j.enums.OutputOrder;

/**
 * 指定されたジャンルの日間、週間、月間、四半期、年間、累計別のトレンドキーワード名とキーワード数を取得します。
 * @author Nana Tsukumo
 * @version 1.1.0
 * @see TrendsGenre
 * 
 */
public class Trends
{
	/**
	 * キーワード情報をジャンルごとかつ期間別に保存する連想配列
	 * 第一キーはジャンル名、第二キーは期間、値はキーワードリスト
	 */
	//protected HashMap<String, HashMap<String, GenreInfo>> genreInfo;
	/**
	 * キーワード情報をジャンルごとかつ期間別に保存する連想配列
	 */
	protected HashMap<String, GenreInfo> genreInfo;
	/**
	 * キーワード情報を保存する可変長配列
	 */
	protected List<KeywordInfo> keywords;
	/**
	 * 情報整列クラス
	 */
	protected InfoAllign allign;
	/**
	 * 取得する小説情報の個数
	 */
	public static final int NOVEL_NUM = 100; //後で500に変更
	
	/**
	 * デバッグ判定の可否
	 */
	protected final boolean debug = true;
	
	/**
	 * コンストラクタ
	 */
	public Trends()
	{
		allign = new InfoAllign();
		//genreInfo = new HashMap<String, HashMap<String, GenreInfo>>();
		genreInfo = new HashMap<String, GenreInfo>();
	}
	
	/**
	 * 指定されたジャンル・期間ランキングの小説に設定されているキーワード情報の取得と整形したものを返します。
	 * @param period 指定する期間
	 * @param genre ジャンル
	 * @param allignDesign 整列方法の指定(0:ソートなし.1:降順.2:昇順)
	 * @return 整列されたキーワード情報のリスト返却
	 */
	public List<KeywordInfo> getDesignRankTrends(String period, String genre, int allignDesign)
	{
		//Narouクラスのインスタンス化
		Narou narou = new Narou();
		
		//取得する小説情報は上位５００位まで
		narou.setLim(NOVEL_NUM);
		//指定された期間ポイント上位ランキングをセット
		narou.setOrder(OutputOrder.valueOf(period));
		//取得する情報はキーワードのみにセット
		narou.setOfParams(OfParam.KEYWORD);
		//取得する情報は現在連載中のもののみにセット
		narou.setNovelType(NovelType.SERIES_IN);
		//取得するジャンルは引数genreで指定されたもの
		//総合ランキングの場合はジャンルの指定はなし
		if(!genre.equals("COMPREHENSIVE"))
			narou.setGenre(NovelGenre.valueOf(genre));
		
		//初期化＆キーワード情報を保存するListのインスタンス化
		keywords = new ArrayList<KeywordInfo>();
		
		String[] keyword = new String[NOVEL_NUM];
		
			for(int i = 0; i < NOVEL_NUM; i++)
			{
				//初めにキーワードを全てとっておく
				try
				{
					//キーワードの取得
					keyword[i] = narou.getNovels().get(i+1).getKeyword();
					if(debug)
						printDebug((i+1) + "回目:" + keyword[i]);
				}catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		
		//キーワードの取得
		for(int i = 0; i < NOVEL_NUM; i++)
		{
			if(debug)
				printDebug(i+1 + "回目");
			//分割後のキーワードリストを格納するリスト
			List<String> keywordList = new ArrayList<String>();
			try
			{
				//キーワード分割
				keywordList = spaceSplit(keyword[i]);
				if(debug)
					printDebug("分割後キーワード:\n" + keywordList);
				//初期キーワードの設定
				//if(i == 0)
				//	keywords.add(new KeywordInfo(keywordList.get(i)));
				if(debug)
					printDebug("登録されているキーワード数:" + keywords.size());
				if(debug)
					printDebug("取得したキーワード数:" + keywordList.size());
				//キーワードの有無を確認して整理
				//キーワードがなければ登録、既にあれば個数に+1
				keywords = keywordYesNo(keywordList, keywords);
				if(debug)
					printDebug("登録後のキーワード数:" + keywords.size());
			}catch(NullPointerException e)
			{
				//Nullであれば飛ばす
			}
		}
		
		if(debug)
			printDebug("並び替え前:\n" + keywords);
		//並び替え
		if(allignDesign == 1)//降順
			allign.ascKeywords(keywords);
		else if(allignDesign == 2)//昇順
			allign.descKeywords(keywords);
		else //並び替えなし
		{/* 何もしない */}
		if(debug)
			printDebug("並び替え後:" + keywords);
		
		//情報の記録
		//同名のジャンルが既に登録されていれば更新Or保存
		if(genreInfo.containsKey(genre))
			genreInfo.get(genre).setKeywordTrend(keywords, period);
		else//同名のジャンルがあれば
			genreInfo.put(genre, new GenreInfo(keywords, period));
		
		if(debug)
			printDebug("保存後:\n" + genreInfo.get(genre).getKeywordTrend(period));
		
		return keywords;
	}
	
	/**
	 * 指定されたジャンルの日間ランキングの小説に設定されているキーワードの取得と整形
	 * @param genre ジャンル
	 * @param allignDesign 整列方法の指定(0:ソートなし.1:降順.2:昇順)
	 * @return 整列されたキーワード情報のリスト返却
	 */
	public List<KeywordInfo> getDailyRankTrends(String genre, int allignDesign)
	{
		return getDesignRankTrends("DAILY_POINT", genre, allignDesign);
	}
	/**
	 * 指定されたジャンルの週間ランキングの小説に設定されているキーワードの取得と整形
	 * @param genre ジャンル名
	 * @param allignDesign 整列方法の指定(0:ソートなし.1:降順.2:昇順)
	 * @return 整列されたキーワード情報のリスト返却
	 */
	public List<KeywordInfo> getWeeklyRankTrends(String genre, int allignDesign)
	{
		return getDesignRankTrends("WEEKLY_POINT", genre, allignDesign);
	}
	/**
	 * 指定されたジャンルの月間ランキングの小説に設定されているキーワードの取得と整形
	 * @param genre ジャンル名
	 * @param allignDesign 整列方法の指定(0:ソートなし.1:降順.2:昇順)
	 * @return 整列されたキーワード情報のリスト返却
	 */
	public List<KeywordInfo> getMonthlyRankTrends(String genre, int allignDesign)
	{
		return getDesignRankTrends("MONTHLY_POINT", genre, allignDesign);
	}
	/**
	 * 指定されたジャンルの四半期ランキングの小説に設定されているキーワードの取得と整形
	 * @param genre ジャンル名
	 * @param allignDesign 整列方法の指定(0:ソートなし.1:降順.2:昇順)
	 * @return 整列されたキーワード情報のリスト返却
	 */
	public List<KeywordInfo> getQuarterRankTrends(String genre, int allignDesign)
	{
		return getDesignRankTrends("QUARTER_POINT", genre, allignDesign);
	}
	/**
	 * 指定されたジャンルの年間ランキングの小説に設定されているキーワードの取得と整形
	 * @param genre ジャンル名
	 * @param allignDesign 整列方法の指定(0:ソートなし.1:降順.2:昇順)
	 * @return 整列されたキーワード情報のリスト返却
	 */
	public List<KeywordInfo> getYearlyRankTrends(String genre, int allignDesign)
	{
		return getDesignRankTrends("YEARLY_POINT", genre, allignDesign);
	}
	/**
	 * 指定されたジャンルの総合ランキングの小説に設定されているキーワードの取得と整形
	 * @param genre ジャンル名
	 * @param allignDesign 整列方法の指定(0:ソートなし.1:降順.2:昇順)
	 * @return 整列されたキーワード情報のリスト返却
	 */
	public List<KeywordInfo> getCumulativeRankTrends(String genre, int allignDesign)
	{
		return getDesignRankTrends("TOTAL_POINT", genre, allignDesign);
	}
	
	/**
	 * 文字列を空白" "で分割する
	 * @param str 分割する文字列
	 * @return 分割後の文字列List
	 */
	public List<String> spaceSplit(String str)
	{
		List<String> splitList = new ArrayList<String>();
		//終わりを示す文字を最後に挿入
		str = str.concat(" endOfKeyword");
		
		if(debug)
			printDebug("引数str:" + str);
		
		int i = 0;
		//無限ループで空白が続かなかったら
		for(;;)
		{
			//分割後の文字列を保存
			String[] splitStr = str.split(" ");
			
			if(debug)
			{
				printDebug("分割後の配列の長さ:" + splitStr.length);
				for(int count = 0; count < splitStr.length; count++)
					printDebug("分割後の文字列:" + count
							+ "つ目:" + splitStr[count]);
			}

			//終わりの文字がきたら終了
			if(splitStr[i].equals("endOfKeyword"))
				break;
				
			//切り取った左側をリストに保存
			if(splitStr.length > i)
				splitList.add(splitStr[i]);
			i++;
		}
		
		return splitList;
	}
	/**
	 * キーワードの有無による登録キーワードの整理
	 * @param settingKeyword 取得した小説に設定されているキーワード
	 * @param registKeyword 現在登録しているキーワード
	 * @return キーワードの整理が成功したかしていないか
	 */
	protected List<KeywordInfo> keywordYesNo(List<String> settingKeyword, List<KeywordInfo> registKeyword)
	{
		for(int i = 0; i < settingKeyword.size(); i++)
		{
			//キーワードが一致したかどうか(初期値は不一致)
			boolean match = false;
			//キーワードの一致したリストの場所
			int matchIndex = 0;
			/*
			for(int j = 0; j < registKeyword.size(); j++)
			{
				//キーワードが一致
				if(registKeyword.get(j).getKeyword().equals(settingKeyword.get(i)))
				{
					//キーワードが一致した場所を記録
					matchIndex = j;
					//キーワードの一致を保存
					match = true;
				}
				
				//一致するキーワードがあった場合（繰り返しを終了する）
				if(match)
					break;
			}
			*/
			int j = 0; 
			while(j < registKeyword.size())
			{
				//キーワードが一致
				if(registKeyword.get(j).getKeyword().equals(settingKeyword.get(i)))
				{
					//キーワードが一致した場所を記録
					matchIndex = j;
					//キーワードの一致を保存
					match = true;
				}
				j++;
				//一致するキーワードがあった場合（繰り返しを終了する）
				if(match)
					break;
			}
			//一致するキーワードが存在した場合はキーワードが保存されている場所にキーワード数+1する
			if(match)
				registKeyword.get(matchIndex).addQuantity();
			else//一致するキーワードがなかった場合は新しくキーワードを追加
				registKeyword.add(new KeywordInfo(settingKeyword.get(i)));
		}
		return registKeyword;
	}
	
	/**
	 * デバッグ用メソッド
	 * @param message デバッグ文
	 */
	private void printDebug(Object message)
	{
		System.out.println("\n[trend.Trends Class]\n"
				+ message
				+ "\n");
	}
	
	/**
	 * キーワード情報を全て読み取って表示する
	 */
	public String toString()
	{
		String keywordsInfo = "";
		for(int i = 0; i < keywords.size(); i++)
		{
			keywordsInfo += keywords.get(i).toString();
		}
		return keywordsInfo;
	}
	
	/**
	 * 出力する小説の数を出力
	 * @return 小説の数
	 */
	public int getNovelNum()
	{
		return NOVEL_NUM;
	}
	
	/**
	 * 不必要
	 * キーワード情報の連想配列を取得
	 */
	public HashMap<String, GenreInfo> getKeywordInfo()
	{
		return genreInfo;
	}
}
