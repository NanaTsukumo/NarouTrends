package info;

/**
 * 小説に設定されたのキーワードの情報を保存します。
 * @author Nana Tsukumo
 * @version 1.0.0
 */
public class KeywordInfo
{
	/**
	 * キーワード名
	 */
	private String keyword;
	/**
	 * キーワード数
	 */
	private int quantity;
	
	/**
	 * コンストラクタ
	 * キーワードとキーワード数を初期化します。
	 */
	public KeywordInfo()
	{
		keyword = "";
		quantity = 1;
	}
	
	/**
	 * コンストラクタ2
	 * キーワードを設定してキーワード数を初期化します。
	 * @param keyword キーワード
	 */
	public KeywordInfo(String keyword)
	{
		this.keyword = keyword;
		quantity = 1;
	}
	
	/**
	 * キーワードを取得します。
	 * @return キーワード
	 */
	public String getKeyword()
	{
		return keyword;
	}
	
	/**
	 * キーワード数を取得します。
	 * @return キーワード数
	 */
	public int getQuantity()
	{
		return quantity;
	}
	/**
	 * キーワードを設定します。
	 * @param keyword キーワード
	 */
	public void setKeyword(String keyword)
	{
		this.keyword = keyword;
	}
	/**
	 * キーワード数を設定します。
	 * @param quantity キーワード数
	 */
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	/**
	 * 指定されたキーワードにキーワード数を追加します。
	 */
	public void addQuantity()
	{
		quantity++;
	}
	/**
	 * キーワードに付随する情報を出力します。
	 */
	@Override
	public String toString()
	{
		return "[キーワード]:" + keyword
				+ "\n[数量]:" + quantity
				+ "\n";
	}
}
