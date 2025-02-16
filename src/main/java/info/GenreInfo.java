package info;

import java.util.List;

/**
 * ジャンルのキーワード情報を記録するクラス
 */
public class GenreInfo
{
	/**
	 * 日間キーワードランキング情報
	 */
	private List<KeywordInfo> dailyTrend;
	/**
	 * 週間キーワードランキング情報
	 */
	private List<KeywordInfo> weeklyTrend;
	/**
	 * 月間キーワードランキング情報
	 */
	private List<KeywordInfo> monthlyTrend;
	/**
	 * 四半期キーワードランキング情報
	 */
	private List<KeywordInfo> quarterTrend;
	/**
	 * 年間キーワードランキング情報
	 */
	private List<KeywordInfo> yearlyTrend;
	/**
	 * 累計キーワードランキング情報
	 */
	private List<KeywordInfo> cumulativeTrend;
	
	/**
	 * コンストラクタ
	 * ランキングの初期化
	 */
	public GenreInfo()
	{
		/*
		dailyTrend = new ArrayList<KeywordInfo>();
		weeklyTrend = new ArrayList<KeywordInfo>();
		monthlyTrend = new ArrayList<KeywordInfo>();
		quarterTrend = new ArrayList<KeywordInfo>();
		yearlyTrend = new ArrayList<KeywordInfo>();
		cumulativeTrend = new ArrayList<KeywordInfo>();
		*/
	}
	
	/**
	 * コンストラクタ
	 * キーワード情報を期間を指定された期間で保存する
	 * @param list キーワード情報
	 * @param period 期間指定 (1=日間, 2=週間, 3=月間, 4=四半期, 5=年間, 6=累計)
	 */
	public GenreInfo(List<KeywordInfo> list, String period)
	{
		//日間
		if(period.equals("DAILY_POINT"))
			dailyTrend = list;
		//週間
		else if(period.equals("WEEKLY_POINT"))
			weeklyTrend = list;
		//月間
		else if(period.equals("MONTHLY_POINT"))
			monthlyTrend = list;
		//四半期
		else if(period.equals("QUARTER_POINT"))
			quarterTrend = list;
		//年間
		else if(period.equals("YEARLY_POINT"))
			yearlyTrend = list;
		//累計
		else
			cumulativeTrend = list;
	}
	
	/**
	 * 期間別キーワード情報を更新
	 */
	public void setKeywordTrend(List<KeywordInfo> list, String period)
	{
		//日間
		if(period.equals("DAILY_POINT"))
			dailyTrend = list;
		//週間
		else if(period.equals("WEEKLY_POINT"))
			weeklyTrend = list;
		//月間
		else if(period.equals("MONTHLY_POINT"))
			monthlyTrend = list;
		//四半期
		else if(period.equals("QUARTER_POINT"))
			quarterTrend = list;
		//年間
		else if(period.equals("YEARLY_POINT"))
			yearlyTrend = list;
		//累計
		else
			cumulativeTrend = list;
	}
	
	/**
	 * 期間別キーワード情報を更新
	 */
	public List<KeywordInfo> getKeywordTrend(String period)
	{
		//日間
		if(period.equals("DAILY_POINT"))
			return dailyTrend;
		//週間
		else if(period.equals("WEEKLY_POINT"))
			return weeklyTrend;
		//月間
		else if(period.equals("MONTHLY_POINT"))
			return monthlyTrend;
		//四半期
		else if(period.equals("QUARTER_POINT"))
			return quarterTrend;
		//年間
		else if(period.equals("YEARLY_POINT"))
			return yearlyTrend;
		//累計
		else
			return cumulativeTrend;
	}
	
	/**
	 * 日間キーワード情報を更新
	 */
	public void setDailyTrend(List<KeywordInfo> list)
	{
		dailyTrend = list;
	}
	/**
	 * 週間キーワード情報を更新
	 */
	public void setWeeklyTrend(List<KeywordInfo> list)
	{
		weeklyTrend = list;
	}
	/**
	 * 月間キーワード情報を更新
	 */
	public void setMonthlyTrend(List<KeywordInfo> list)
	{
		monthlyTrend = list;
	}
	/**
	 * 四半期キーワード情報を更新
	 */
	public void setQuarterTrend(List<KeywordInfo> list)
	{
		quarterTrend = list;
	}
	/**
	 * 年間キーワード情報を更新
	 */
	public void setYearlyTrend(List<KeywordInfo> list)
	{
		yearlyTrend = list;
	}
	/**
	 * 累計キーワード情報を更新
	 */
	public void setCumulativeTrend(List<KeywordInfo> list)
	{
		cumulativeTrend = list;
	}
	
	/**
	 * 日間キーワード情報を取り出す
	 * @return 日間キーワード情報
	 */
	public List<KeywordInfo> getDailyTrend()
	{
		return dailyTrend;
	}
	/**
	 * 週間キーワード情報を取り出す
	 * @return 週間キーワード情報
	 */
	public List<KeywordInfo> getWeeklyTrend()
	{
		return weeklyTrend;
	}
	/**
	 * 月間キーワード情報を取り出す
	 * @return 月間キーワード情報
	 */
	public List<KeywordInfo> getMonthlyTrend()
	{
		return monthlyTrend;
	}
	/**
	 * 四半期キーワード情報を取り出す
	 * @return 四半期キーワード情報
	 */
	public List<KeywordInfo> getQuarterTrend()
	{
		return quarterTrend;
	}
	/**
	 * 年間キーワード情報を取り出す
	 * @return 年間キーワード情報
	 */
	public List<KeywordInfo> getYearlyTrend()
	{
		return yearlyTrend;
	}
	/**
	 * 累計キーワード情報を取り出す
	 * @return 累計キーワード情報
	 */
	public List<KeywordInfo> getCumulativeTrend()
	{
		return cumulativeTrend;
	}
}
