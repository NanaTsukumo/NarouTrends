package constant.narou4j;

/**
 * Narou4jで定義されている小説タイプの文字列表現の定数群<br><br>
 * 小説タイプ<br><br>
 * SHORT 短編<br>
 * SERIES_IN 連載中<br>
 * SERIES_END 完結済連載小説<br>
 * ALL_SERIES すべての連載小説(連載中および完結済)<br>
 * ALL_NOVEL 短編と完結済連載小説
 */
public class Narou4jNovelType
{
	/**
	 * 短編
	 */
	public static final String SHORT = "SHORT";
	/**
	 * 連載中
	 */
	public static final String SERIES_IN = "SERIES_IN";
	/**
	 * 完結済連載小説
	 */
	public static final String SERIES_END = "SERIES_END";
	/**
	 * すべての連載小説(連載中および完結済)
	 */
	public static final String ALL_SERIES = "ALL_SERIES";
	/**
	 * 短編と完結済連載小説
	 */
	public static final String ALL_NOVEL = "ALL_NOVEL";
}
