package debug;

/**
 * 標準出力に関するクラス
 * 主にデバッグ用
 */
public class StandartOutput
{
	/**
	 * デバッグメッセージ出力用メソッド
	 * @param className デバッグするクラス名　デバッグはgetClass()メソッドを使用して取得
	 * @param message 出力するメッセージ
	 */
	public void printDebug(Object className, String message)
	{
		System.out.println("[クラス名]:"+ className +
						"[メッセージ]:" + message
						+ "\n");
	}
}
