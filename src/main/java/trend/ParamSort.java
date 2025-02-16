package trend;

import narou4j.enums.NovelBigGenre;
import narou4j.enums.NovelGenre;
import narou4j.enums.OutputOrder;

public class ParamSort
{
	/**
	 * 指定された大ジャンルのNovelBigGenreクラス定数を返す(不必要)
	 * @param bigGenre 大ジャンル名
	 * @return NovelBigGenreクラス　ジャンル定数
	 */
	public NovelBigGenre sortBigGenre(String bigGenre)
	{
		//恋愛
		if(bigGenre.equals(constant.BigGenreConst.LOVE))
			return NovelBigGenre.LOVE;
		//フンアタジー
		else if(bigGenre.equals(constant.BigGenreConst.FANTASY))
			return NovelBigGenre.FANTASY;
		//文芸
		else if(bigGenre.equals(constant.BigGenreConst.LITERATURE))
			return NovelBigGenre.LITERATURE;
		//SF
		else if(bigGenre.equals(constant.BigGenreConst.SF))
			return NovelBigGenre.SF;
		//その他
		else if(bigGenre.equals(constant.BigGenreConst.OTHERS))
			return NovelBigGenre.OTHER;
		//ノンジャンル
		else
			return NovelBigGenre.NONGENRE;
	}
	/**
	 * 指定されたジャンルのNovelGenreクラス定数を返す
	 * @param genre ジャンル名
	 * @return Novelgenreクラス　ジャンル定数
	 */
	public NovelGenre sortGenre(String genre)
	{
		//異世界[恋愛]
		if(genre.equals(constant.GenreConst.DIFF_LOVE))
			return NovelGenre.LOVE_DIFF_WORLD;
		//現実世界[恋愛]
		else if(genre.equals(constant.GenreConst.REAL_LOVE))
			return NovelGenre.LOVE_REAL_WORLD;
		//ハイファンタジー[ファンタジー]
		else if(genre.equals(constant.GenreConst.HIGH_FANTASY))
			return NovelGenre.FANTASY_HIGH;
		//ローファンタジー[ファンタジー]
		else if(genre.equals(constant.GenreConst.LOW_FANTASY))
			return NovelGenre.FANTASY_LOW;
		//純文学[文芸]
		else if(genre.equals(constant.GenreConst.PURE_LITERATURE))
			return NovelGenre.LITERAL_PURE;
		//ヒューマンドラマ[文芸]
		else if(genre.equals(constant.GenreConst.HYUMAN_DRAMA))
			return NovelGenre.LITERAL_DRAMA;
		//歴史[文芸]
		else if(genre.equals(constant.GenreConst.HISTORY))
			return NovelGenre.LITERAL_HISTORY;
		//推理[文芸]
		else if(genre.equals(constant.GenreConst.REASONING))
			return NovelGenre.LITERAL_DETECTIVE;
		//ホラー[文芸]
		else if(genre.equals(constant.GenreConst.HORROR))
			return NovelGenre.LITERAL_HORROR;
		//アクション[文芸]
		else if(genre.equals(constant.GenreConst.ACTION))
			return NovelGenre.LITERAL_ACTION;
		//コメディー[文芸]
		else if(genre.equals(constant.GenreConst.COMEDY))
			return NovelGenre.LITERAL_COMEDY;
		//VRゲーム[SF]
		else if(genre.equals(constant.GenreConst.VR_GAME))
			return NovelGenre.SF_VR;
		//宇宙[SF]
		else if(genre.equals(constant.GenreConst.UNIVERSE))
			return NovelGenre.SF_SPACE;
		//空想科学[SF]
		else if(genre.equals(constant.GenreConst.SCIENCE_FICTION))
			return NovelGenre.SF_SCIENCE;
		//パニック[SF]
		else if(genre.equals(constant.GenreConst.PANIC))
			return NovelGenre.SF_PANIC;
		//童話[その他]
		else if(genre.equals(constant.GenreConst.FAIRY_TALE))
			return NovelGenre.OTHER_FAIRYTALE;
		//詩[その他]
		else if(genre.equals(constant.GenreConst.POEM))
			return NovelGenre.OTHER_POEM;
		//エッセイ[その他]
		else if(genre.equals(constant.GenreConst.ESSAY))
			return NovelGenre.OTHER_ESSAY;
		//リプレイ[その他]
		else if(genre.equals(constant.GenreConst.REPLAY))
			return NovelGenre.OTHER_REPLAY;
		//その他[その他]
		else if(genre.equals(constant.GenreConst.OTHER))
			return NovelGenre.OTHER;
		//ノンジャンル[ノンジャンル]
		else
			return NovelGenre.NONGENRE;
		
	}
	/**
	 * 小説出力順序の指定
	 * @param order 指定する出力順序
	 * @return OutputOrderクラス　出力順序定数
	 */
	public OutputOrder sortOutputOrder(String order)
	{
		//新着更新順
		if(order.equals(constant.OrderConst.NEW))
			return OutputOrder.NEW;
		//ブックマーク数の多い順
		else if(order.equals(constant.OrderConst.BOOKMARK_COUNT))
			return OutputOrder.BOOKMARK_COUNT;
		//レビュー数の多い順
		else if(order.equals(constant.OrderConst.REVIEW_COUNT))
			return OutputOrder.REVIEW_COUNT;
		//総合ポイントの高い順
		else if(order.equals(constant.OrderConst.TOTAL_POINT))
			return OutputOrder.TOTAL_POINT;
		//総合ポイントの低い順
		else if(order.equals(constant.OrderConst.TOTAL_POINT_ASC))
			return OutputOrder.TOTAL_POINT_ASC;
		//日間ポイントの高い順
		else if(order.equals(constant.OrderConst.DAILY_POINT))
			return OutputOrder.DAILY_POINT;
		//週間ポイントの高い順
		else if(order.equals(constant.OrderConst.WEEKLY_POINT))
			return OutputOrder.WEEKLY_POINT;
		//月間ポイントの高い順
		else if(order.equals(constant.OrderConst.MONTHLY_POINT))
			return OutputOrder.MONTHLY_POINT;
		//四半期ポイントの高い順
		else if(order.equals(constant.OrderConst.QUARTER_POINT))
			return OutputOrder.QUARTER_POINT;
		//年間ポイントの高い順
		else if(order.equals(constant.OrderConst.YEARLY_POINT))
			return OutputOrder.YEARLY_POINT;
		//感想の多い順
		else if(order.equals(constant.OrderConst.IMPRESSION_COUNT))
			return OutputOrder.IMPRESSION_COUNT;
		//評価者数の多い順
		else if(order.equals(constant.OrderConst.HYOKA_COUNT))
			return OutputOrder.HYOKA_COUNT;
		//評価者数の少ない順
		else if(order.equals(constant.OrderConst.HYOKA_COUNT_ASC))
			return OutputOrder.HYOKA_COUNT_ASC;
		//週間ユニークユーザの多い順
		else if(order.equals(constant.OrderConst.WEEKLY_UU))
			return OutputOrder.WEEKLY_UU;
		//作品本文の文字数が多い順
		else if(order.equals(constant.OrderConst.CHARACTER_LENGTH_DESC))
			return OutputOrder.CHARACTER_LENGTH_DESC;
		//作品本文の文字数が少ない順
		else if(order.equals(constant.OrderConst.CHARACTER_LENGTH_ASC))
			return OutputOrder.CHARACTER_LENGTH_ASC;
		//新着投稿順
		else if(order.equals(constant.OrderConst.NCODE_DESC))
			return OutputOrder.NCODE_DESC;
		//更新が古い順
		else
			return OutputOrder.OLD;
	}

	/**
	 * デバッグ用メソッド
	 * @param message 表示するメッセージ
	 */
	private void printDebug(Object message)
	{
		System.out.println("\n[trend.Sort Class]\n"
				+ message
				+ "\n");
	}
}
