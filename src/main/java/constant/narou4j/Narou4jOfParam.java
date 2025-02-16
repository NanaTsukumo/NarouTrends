package constant.narou4j;

/**
 * Narou4jで定義されている出力項目の文字列表現の定数群<br><br>
 * 指定しない場合はすべて出力<br><br>
 * 
 * TITLE 小説名<br>
 * NCODE 小説固有コード<br>
 * USERID 作者のユーザID<br>
 * WRITER 作者名<br>
 * STORY 小説のあらすじ<br>
 * BIG_GENRE 小説の大ジャンル NovelBigGenre<br>
 * GENRE 小説のジャンル NovelGenre<br>
 * KEYWORD キーワード<br>
 * GENERAL_FIRSTUP 初回掲載日<br>
 * GENERAL_LASTUP 最終掲載日<br>
 * NOVELTYPE 連載の場合は1、短編の場合は2<br>
 * END 短編，完結小説0，連載中は1<br>
 * GENERAL_ALL_NO 全掲載話数，短編の場合は1<br>
 * LENGTH 小説文字数．スペースと改行はカウント数から除外く<br>
 * TIME 小説読了時間<br>
 * STOP 長期連載中は1，それ以外は0．<br>
 * R15 登録必須キーワード 「r15」が含まれる場合は1, 違ければ0, BL 登録必須キーワード 「bl」が含まれる場合は1, 違ければ0, GL 登録必須キーワード 「gl」が含まれる場合は1, 違ければ0, ZANKOKU 登録必須キーワード 「zankoku」が含まれる場合は1, 違ければ0, TENSEI 登録必須キーワード 「tensei」が含まれる場合は1, 違ければ0, TENNI 登録必須キーワード 「tenni」が含まれる場合は1, 違ければ0, PC_OR_K 投稿した端末．1はケータイのみ、2はPCのみ、3はPCとケータイ<br>
 * GLOBAL_POINT 総合得点<br>
 * DAILY_POINT 日間得点 (新規)<br>
 * WEEKLY_POINT 週間得点 (新規)<br>
 * MONTHLY_POINT 月間得点 (新規)<br>
 * QUARTER_POINT 四半期得点 (新規)<br>
 * YEARLY_POINT 年間得点 (新規)<br>
 * FAV_NOVEL_COUNT ブックマーク数<br>
 * IMPRESSION_CNT 感想数 (新規)<br>
 * REVIEW_COUNT レビュー数<br>
 * ALL_POINT 評価点<br>
 * ALL_HYOKA_COUNT 評価者数<br>
 * SASIE_COUNT 挿絵数<br>
 * KAIWARITU 会話率<br>
 * NOVEL_UPDATE_AT 小説の更新日時<br>
 * UPDATED_AT 最終更新日時 (API側のシステム用でこちらは関係無いらしい)
 */
public class Narou4jOfParam
{
	/**
	 * 小説名
	 */
	public static final String TITLE = "TITLE";
	/**
	 * 小説固有コード
	 */
	public static final String NCODE = "NCODE";
	/**
	 * 作者のユーザID
	 */
	public static final String USERID = "USERID";
	/**
	 * 作者名
	 */
	public static final String WRITER = "WRITER";
	/**
	 * 小説のあらすじ
	 */
	public static final String STORY = "STORY";
	/**
	 * 小説の大ジャンル NovelBigGenre
	 */
	public static final String BIG_GENRE = "BIG_GENRE";
	/**
	 * 小説のジャンル NovelGenre
	 */
	public static final String GENRE = "GENRE";
	/**
	 * キーワード
	 */
	public static final String KEYWORD = "KEYWORD";
	/**
	 * 初回掲載日
	 */
	public static final String GENERAL_FIRSTUP = "GENERAL_FIRSTUP";
	/**
	 * 最終掲載日
	 */
	public static final String GENERAL_LASTUP = "GENERAL_LASTUP";
	/**
	 * 連載の場合は1、短編の場合は2
	 */
	public static final String NOVELTYPE = "NOVELTYPE";
	/**
	 * 短編，完結小説0，連載中は1
	 */
	public static final String END = "END";
	/**
	 * 全掲載話数，短編の場合は1
	 */
	public static final String GENERAL_ALL_NO = "GENERAL_ALL_NO";
	/**
	 * 小説文字数．スペースと改行はカウント数から除外
	 */
	public static final String LENGTH = "LENGTH";
	/**
	 * 小説読了時間
	 */
	public static final String TIME = "TIME";
	/**
	 * 長期連載中は1，それ以外は0．
	 */
	public static final String STOP = "STOP";
	/**
	 * 登録必須キーワード 「r15」が含まれる場合は1, 違ければ0, BL 登録必須キーワード 「bl」が含まれる場合は1, 違ければ0, GL 登録必須キーワード 「gl」が含まれる場合は1, 違ければ0, ZANKOKU 登録必須キーワード 「zankoku」が含まれる場合は1, 違ければ0, TENSEI 登録必須キーワード 「tensei」が含まれる場合は1, 違ければ0, TENNI 登録必須キーワード 「tenni」が含まれる場合は1, 違ければ0, PC_OR_K 投稿した端末．1はケータイのみ、2はPCのみ、3はPCとケータイ<br>
	 */
	public static final String R15 = "R15";
	/**
	 * 総合得点
	 */
	public static final String GLOBAL_POINT = "GLOBAL_POINT";
	/**
	 * 日間得点
	 */
	public static final String DAILY_POINT = "DAILY_POINT";
	/**
	 * 週間得点
	 */
	public static final String WEEKLY_POINT = "WEEKLY_POINT";
	/**
	 * 月間得点
	 */
	public static final String MONTHLY_POINT = "MONTHLY_POINT";
	/**
	 * 四半期得点
	 */
	public static final String QUARTER_POINT = "QUARTER_POINT";
	/**
	 * 年間得点
	 */
	public static final String YEARLY_POINT = "YEARLY_POINT";
	/**
	 * ブックマーク数
	 */
	public static final String FAV_NOVEL_COUNT = "FAV_NOVEL_COUNT";
	/**
	 * 感想数
	 */
	public static final String IMPRESSION_CNT = "IMPRESSION_CNT";
	/**
	 * レビュー数
	 */
	public static final String REVIEW_COUNT = "REVIEW_COUNT";
	/**
	 * 評価点
	 */
	public static final String ALL_POINT = "ALL_POINT";
	/**
	 * 評価者数
	 */
	public static final String ALL_HYOKA_COUNT = "ALL_HYOKA_COUNT";
	/**
	 * 挿絵数
	 */
	public static final String SASIE_COUNT = "SASIE_COUNT";
	/**
	 * 会話率
	 */
	public static final String KAIWARITU = "KAIWARITU";
	/**
	 * 小説の更新日時
	 */
	public static final String NOVEL_UPDATE_AT = "NOVEL_UPDATE_AT";
	/**
	 * 最終更新日時
	 */
	public static final String UPDATED_AT = "UPDATED_AT";
}
