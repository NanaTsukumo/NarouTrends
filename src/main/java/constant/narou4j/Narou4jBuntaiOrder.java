package constant.narou4j;

/**
 * Narou4jで定義されている文体の文字列表現の定数群<br><br>
 * OFF_INDENT_CONTINU_NEWLINE 字下げされておらず、連続改行が多い作品<br>
 * OFF_INDENT_AVERAGE_NEWLINE 字下げされていないが、改行数は平均な作品<br>
 * ON_INDENT_CONTINU_NEWLINE 字下げが適切だが、連続改行が多い作品<br>
 * ON_INDENT_AVERAGE_NEWLINE 字下げが適切でかつ改行数も平均な作品
 */
public class Narou4jBuntaiOrder
{
	/**
	 * 字下げされておらず、連続改行が多い作品
	 */
	public static final String OFF_INDENT_CONTINU_NEWLINE = "OFF_INDENT_CONTINU_NEWLINE";
	/**
	 * 字下げされていないが、改行数は平均な作品
	 */
	public static final String OFF_INDENT_AVERAGE_NEWLINE = "OFF_INDENT_AVERAGE_NEWLINE";
	/**
	 * 字下げが適切だが、連続改行が多い作品
	 */
	public static final String ON_INDENT_CONTINU_NEWLINE = "ON_INDENT_CONTINU_NEWLINE";
	/**
	 * 字下げが適切でかつ改行数も平均な作品
	 */
	public static final String ON_INDENT_AVERAGE_NEWLINE = "ON_INDENT_AVERAGE_NEWLINE";
}
