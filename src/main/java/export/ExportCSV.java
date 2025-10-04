package export;

/**
 * CSV出力クラス
 * 
 * @author Nana Tsukumo
 * @version 1.0.0
 * @see Export
 */
public class ExportCSV
{
	
	//CSV出力用データの格納場所
	private String[][] outputData = null;
	
	/**
	 * コンストラクタ
	 */



	public ExportCSV()
	{
		outputData = null;
	}
	
	public String[][] getOutputData()
	{
		return outputData;
	}

	public void setOutputData(String[][] outputData)
	{
		this.outputData = outputData;
	}
}
