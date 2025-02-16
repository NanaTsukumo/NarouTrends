package trend;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import info.KeywordInfo;

/**
 * 小説情報を整列させるためのクラス
 */
public class InfoAllign
{
	/**
	 * デバッグ判定可否用
	 */
	private boolean debug = true;
	
	/**
	 * キーワードの数に応じてキーワードリストの順番を昇順に並べます
	 * 昇順-上から小さい順
	 * @param keywords キーワードリスト
	 */
	public void ascKeywords(List<KeywordInfo> keywords)
	{	
		//昇順ソート
		/*
		Collections.sort(keywords, new Comparator<KeywordInfo>()
		{
			@Override
			public int compare(KeywordInfo key1, KeywordInfo key2)
			{
				if(key1.getQuantity() > key2.getQuantity())
					return -1;
				else if(key1.getQuantity() < key2.getQuantity())
					return 1;
				else
					return 0;
			}
		}
		);
		*/
		
		//標準としてComparaterインタフェースのcompareメソッドを実装している
		//昇順並び替え
		Comparator<KeywordInfo> comp = (KeywordInfo key1, KeywordInfo key2)
				->
		{
			if(key1.getQuantity() > key2.getQuantity())
				return -1;
			else if(key1.getQuantity() < key2.getQuantity())
				return 1;
			else
				return 0;
		};
		
		//並び替え前の出力
		if(debug)
			for(int i = 0; i < keywords.size(); i++)
				keywords.get(i).toString();
		
		//昇順に並び替え
		Collections.sort(keywords, comp);
		
		//並び替え後の出力
		if(debug)
			for(int i = 0; i < keywords.size(); i++)
				keywords.get(i).toString();
	}
	
	/**
	 * キーワードの数に応じてキーワードリストの順番を降順に並べます
	 * 降順-上から大きい順
	 * @param keywords キーワードリスト
	 */
	public void descKeywords(List<KeywordInfo> keywords)
	{
		//降順ソート
		/*
		Collections.sort(keywords, new Comparator<KeywordInfo>()
		{
			@Override
			public int compare(KeywordInfo key1, KeywordInfo key2)
			{
				if(key1.getQuantity() > key2.getQuantity())
					return -1;
				else if(key1.getQuantity() < key2.getQuantity())
					return 1;
				else
					return 0;
			}
		}
		);
		*/
		Comparator<KeywordInfo> comp = (KeywordInfo key1, KeywordInfo key2)
				->
		{
			if(key1.getQuantity() < key2.getQuantity())
				return -1;
			else if(key1.getQuantity() > key2.getQuantity())
				return 1;
			else
				return 0;
		};
		
		//降順並び替え前の出力
		if(debug)
			for(int i = 0; i < keywords.size(); i++)
				keywords.get(i).toString();
		
		//降順に並び替え
		Collections.sort(keywords, comp);
		
		//降順並び替え後の出力
		if(debug)
			for(int i = 0; i < keywords.size(); i++)
				keywords.get(i).toString();
	}
	
	/**
	 * デバッグ用メソッド
	 * @param message 表示するメッセージ
	 */
	private void printDebug(Object message)
	{
		System.out.println("\n[trend.Allign Class]\n"
				+ message
				+ "\n");
	}
}
