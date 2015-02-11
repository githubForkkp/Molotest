package com.molo.Utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.logging.Level;
//import com.qq.jutil.j4log.Logger;
import org.apache.log4j.Logger;

/**
 * 字符串处理工具集
 * 全部为静态方法
 * @author stonexie
 *
 */
public final class StringUtil 
{
	//private static final Logger debugLog = Logger.getLogger("jutil");
	/**UTF-8编码常量*/
	public static final String ENC_UTF8 = "UTF-8";
	/**GBK编码常量*/
	public static final String ENC_GBK = "GBK";
	/**精确到秒的日期时间格式化的格式字符串*/
	public static final String FMT_DATETIME = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 将字符串转为WML编码,用于wml页面显示
	 * 根据unicode编码规则Blocks.txt：E000..F8FF; Private Use Area
	 * @param str 
	 * @return String
	 */
	public static String encodeWML(String str)
	{
		if(str == null)
		{
			return "";
		}
		// 不用正则表达式替换，直接通过循环，节省cpu时间
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); ++i)
		{
			char c = str.charAt(i);
			switch(c)
			{
				case '\u00FF':
				case '\u0024':
					break;
				case '&':
					sb.append("&amp;");
					break;
				case '\t':
					sb.append("  ");
					break;
				case '<':
					sb.append("&lt;");
					break;
				case '>':
					sb.append("&gt;");
					break;
				case '\"':
					sb.append("&quot;");
					break;
				case '\'':
					sb.append("&apos;");
					break;
				case '\n':
					sb.append("<br/>");
					break;
				default:
					if(c >= '\u0000' && c <= '\u001F')
						break;
					if(c >= '\uE000' && c <= '\uF8FF')
						break;
					if(c >= '\uFFF0' && c <= '\uFFFF')
						break;
					sb.append(c);
					break;
			}
		}
		return sb.toString();
	}
	
	/**
	 * 转换&#123;这种编码为正常字符<br/>
	 * 有些手机会将中文转换成&#123;这种编码,这个函数主要用来转换成正常字符.
	 * @param str
	 * @return String
	 */
	public static String decodeNetUnicode(String str)
	{
		if(str == null) 
			return null;
		
        String pStr = "&#(\\d+);";
        Pattern p = Pattern.compile(pStr);
        Matcher m = p.matcher(str);
        StringBuffer sb = new StringBuffer();
		while (m.find()) {
			String mcStr = m.group(1);
			int charValue = StringUtil.convertInt(mcStr, -1);
			String s = charValue > 0 ? (char) charValue + "" : "";
			m.appendReplacement(sb, Matcher.quoteReplacement(s));
		}
        m.appendTail(sb);
        return sb.toString();		
	}
	
	/**
	 * 过滤SQL字符串,防止SQL inject
	 * @param sql
	 * @return String
	 */
	public static String encodeSQL(String sql)
	{
		if (sql == null)
		{
			return "";
		}
		// 不用正则表达式替换，直接通过循环，节省cpu时间
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < sql.length(); ++i)
		{
			char c = sql.charAt(i);
			switch(c)
			{
			case '\\':
				sb.append("\\\\");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\t':
				sb.append("\\t");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\'':
				sb.append("\'\'");
				break;
			case '\"':
				sb.append("\\\"");
				break;
			default:
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 删除在wml下不能正确处理的字符
	 * 根据unicode编码规则Blocks.txt：E000..F8FF; Private Use Area
	 * @param str	要处理的字符串
	 * @return		结果
	 */
	public static String removeInvalidWML(String str){
    	if(str == null)
    		return null;
    	//* 不用正则表达式替换，直接通过循环，节省cpu时间
    	StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); ++i)
		{
			char c = str.charAt(i);
			if(c >= '\u0000' && c <= '\u001F')
				continue;
			if(c >= '\uE000' && c <= '\uF8FF')
				continue;
			if(c >= '\uFFF0' && c <= '\uFFFF')
				continue;
			switch(c)
			{
			case '\u00FF':
			case '\u0024':
				break;
			case '&':
				sb.append("&amp;");
				break;
			case '\t':
				sb.append("  ");
				break;
			case '<':
				sb.append("&lt;");
				break;
			case '>':
				sb.append("&gt;");
				break;
			case '\"':
				sb.append("&quot;");
				break;
			case '\'':
				sb.append("&apos;");
				break;
			case '^':
			case '`':
				break;
			default:
				sb.append(c);
				break;
			}
		}
		return sb.toString();
	}
	/**
	 * 新增一个可以多次执行去除非法字符以及进行xml转义的方法，将unicode私有区域的合法xml字符也移除了
	 * @param str 
	 * @return 如果字符串中有已经转义的实体字符串，则跳过，否则转义避免amp;amp;这样的情形出现
	 * @author quickli
	 */

	public static String safeRemoveInvalidWML(String str) {
		return safeRemoveInvalidWML(str, true);
	}
	/**
	 * 新增一个可以多次执行去除非法字符以及进行xml转义的方法<br/>
	 * 与removeInvalidWML区别如下：<br/>
	 * 1.本方法严格按照xml规范进行过滤，removeInvalidWML则还过滤了$,^,`,\u00FF,\UE000-\UF8FF(Unicode私有保留区Private Use Area)区间的字符<br/>
	 * 2.本方法按照xml规范对5个公共转义字符做了转义，removeInvalidWML未对单引号转义<br/>
	 * 3.本方法对$,\r,\n,\t字符使用了&#加unicode值的方式进行表示，removeInvalidWML则将$,\r\,\n直接去除，将\
	 * t转换为两个空格<br/>
	 * 4.本方法针对超过\uFFFF的Unicode字符做了高代理判断，支持将非法高代理或低代理字符去除，removeInvalidWML没有做过滤<br/>
	 * 测试用例为：<br/>
	 * String s = "0\u00031&2&amp;3&amp;amp;4&gt;5&lt;6&apos;7&quot;"<br/>
	 * + "8<9>10\'11\"12\n13\r14\t15&#37;16&#;17&#y;18&#7654321;19"<br/>
	 * +
	 * "&amp;lt;20&amp;gt;21&amp;quot;22&amp;apos;23$\uD860\uDEE224\uDEE2\uD860aaa"
	 * ;<br/>
	 * System.out.println("safeRemoveInvalidWML=" + safeRemoveInvalidWML(s));<br/>
	 * System.out.println("removeInvalidWML=" + removeInvalidWML(s));<br/>
	 * 
	 * @param str
	 *            需要进行过滤xml非法字符并进行xml转义的字符串
	 * @param removePrivateUseArea 是否移除虽然是xml合法字符但却是在unicode里私有保留区里的字符
	 * @return 如果字符串中有已经转义的实体字符串，则跳过，否则转义避免amp;amp;这样的情形出现
	 * @see 
	 * @author quickli
	 */
	public static String safeRemoveInvalidWML(String str,boolean removePrivateUseArea) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		StringBuilder sb = new StringBuilder(str.length() + 48);
		for (int i = 0, len = str.length(); i < len; i++) {
			char c = str.charAt(i);
			if (Character.isHighSurrogate(c)) {// 如果已经是高代理字符，则可能是超过\uFFFF的unicode了
				int codePoint = str.codePointAt(i);// 进行代码点解析
				if (codePoint == c) {// 解析后的值与单个字符想通，说明只有单个高代理字符，则编码有问题，需要过滤该字符
					continue;
				} else if (!isXMLCharacter(codePoint)) {// 非法xml字符滤掉
					// System.err.println(codePoint + "|"
					// + Integer.toHexString(codePoint)
					// + " is not xml char a,i=" + i + ",len=" + len);
					i++;
					continue;
				} else if (removePrivateUseArea
						&& ((codePoint >= 0xF0000 && codePoint <= 0xFFFFD) || (codePoint >= 0x100000 && codePoint <= 0x10FFFD))) {
					// 过滤高代理的PrivateUseArea区的字符,
					// Supplementary Private Use Area-A Range: F0000–FFFFD
					// Supplementary Private Use Area-B Range: 100000–10FFFD
					i++;
					continue;
				} else {
					i++;
					sb.appendCodePoint(codePoint);
					continue;
				}
			}
			if (!isXMLCharacter(c)) {//跳过非法xml字符
//				System.err.println((int) c + "|" + Integer.toHexString(c)
//						+ " is not xml char");
				continue;
			}
			if(removePrivateUseArea && c >= '\uE000' && c <= '\uF8FF'){//过滤PrivateUseArea区的字符
				continue;
			}
			if (removePrivateUseArea && c == '\u202E') {// 过滤RIGHT-TO-LEFT
														// OVERRIDE转义字符
														// http://www.fileformat.info/info/unicode/char/202e/index.htm
				continue;
			}			
			switch (c) {
			case '&':
				if (str.startsWith("&amp;amp;", i)) {// 把两个amp;的兼容掉
					sb.append("&amp;");
					i = i + 8;
				} else if (str.startsWith("&amp;gt;", i)) {// 把多encode了一次的导致amp;的兼容掉
					sb.append("&gt;");
					i = i + 7;
				} else if (str.startsWith("&amp;lt;", i)) {// 把多encode了一次的导致amp;的兼容掉
					sb.append("&lt;");
					i = i + 7;
				} else if (str.startsWith("&amp;apos;", i)) {// 把多encode了一次的导致amp;的兼容掉
					sb.append("&apos;");
					i = i + 9;
				} else if (str.startsWith("&amp;quot;", i)) {// 把多encode了一次的导致amp;的兼容掉
					sb.append("&quot;");
					i = i + 9;
				} else if (str.startsWith("&amp;", i)) {// 把已经encode的amp;的兼容掉
					sb.append("&amp;");
					i = i + 4;
				} else if (str.startsWith("&gt;", i)) {
					sb.append("&gt;");
					i = i + 3;
				} else if (str.startsWith("&lt;", i)) {
					sb.append("&lt;");
					i = i + 3;
				} else if (str.startsWith("&apos;", i)) {
					sb.append("&apos;");
					i = i + 5;
				} else if (str.startsWith("&quot;", i)) {
					sb.append("&quot;");
					i = i + 5;
				} else if (str.startsWith("&#", i)) {// 检测已经是&#37;这样编码字符串
					int index = -1;
					for (int j = i + 2; j < i + 10 && j < len; j++) {// xml字符用数字转义方式表示的最大值是&#111411;,因此往前最多检测到10位即可
						char cc = str.charAt(j);
						if (cc == ';') {
							index = j;
							break;
						}
					}
//					System.out.println("index=" + index + ",i==" + i);
					if (index > i + 2) {// 说明&#和;之间有字符存在，则尝试反解析
						String unicodeVal = str.substring(i + 2, index);
//						System.out.println("index=" + index + ",i==" + i
//								+ ",unicodeVal=" + unicodeVal);
						try {
							int val = Integer.parseInt(unicodeVal.substring(1),
									'x' == unicodeVal.charAt(0) ? 16 : 10);
//							System.out.println("val==" + val);
							if (!isXMLCharacter(val)) {
								sb.append("&amp;");// &#后面的字符无法反解析为合法xml字符，因此继续转义
							} else {// 否则原样拼接
								sb.append("&#").append(unicodeVal).append(';');
								i = i + 2 + unicodeVal.length();
							}
						} catch (Exception e) {
							sb.append("&amp;");
						}
					} else {
						sb.append("&amp;");
					}
				} else {
					sb.append("&amp;");
				}
				break;
			case '<':
				sb.append("&lt;");
				break;
			case '>':
				sb.append("&gt;");
				break;
			case '\'':
				sb.append("&apos;");
				break;
			case '\"':
				sb.append("&quot;");
				break;
			case '$':// wml中$在postfield的value中表示变量定义，因此需要展示真实的$时，需要转义
			case '\n':
			case '\r':
			case '\t':
				sb.append("&#").append((int) c).append(';');
				break;
			default:
				sb.append(c);
				break;
			}
		}
		return sb.toString();
	}

    /**
     * 返回移除非法xml字符后的字符串，确保json和xml中的字符串能被正常解析
     * 
     * @param str
     * @return
     * @see org.jdom.Verifier
     */
	public static String removeInvalidXmlChar(String str) {
		if (str == null || str.length() < 1) {
			return str;
		}
		for (int k = 0, len = str.length(); k < len; k++) {
			char c = str.charAt(k);
			if (!isXMLCharacter(c)) {
				StringBuilder sb = new StringBuilder(str.length() + 48);
				sb.append(str, 0, k);
				for (int i = k; i < len; i++) {
					c = str.charAt(i);
					if (Character.isHighSurrogate(c)) {// 如果已经是高代理字符，则可能是超过\uFFFF的unicode了
						int codePoint = str.codePointAt(i);// 进行代码点解析
						if (codePoint == c) {// 解析后的值与单个字符相同，说明只有单个高代理字符，则编码有问题，需要过滤该字符
							continue;
						} else if (!isXMLCharacter(codePoint)) {// 非法xml字符滤掉
							// System.err.println(codePoint + "|"
							// + Integer.toHexString(codePoint)
							// + " is not xml char a,i=" + i + ",len=" + len);
							i++;
							continue;
						} else {
							i++;
							sb.appendCodePoint(codePoint);
							continue;
						}
					} else if (isXMLCharacter(c)) {
						sb.append(c);
					}
				}
				return sb.toString();
			}
		}
		return str;
	}

	/**
	 * 新增一个可以多次执行去除非法字符以及进行xml转义反解析的方法<br/>
	 * 
	 * @param str
	 *            需要反解析xml的字符串
	 * @return 返回将xml转义字符反解析后的字符串，默认过滤掉xml字符允许但是是unicode私有区域的字符
	 * @author quickli
	 */
	public static String decodeWML(String str) {
		return decodeWML(str, true);
	}

	/**
	 * 新增一个可以多次执行去除非法字符以及进行xml转义反解析的方法<br/>
	 * 
	 * @param str
	 *            需要反解析xml的字符串
	 * @param removePrivateUseArea
	 *            是否去除unicode私有区的字符
	 * 
	 * @return 返回反解析后的字符串
	 * @author quickli
	 */
	public static String decodeWML(String str, boolean removePrivateUseArea) {
		if (str == null || str.isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder(str.length());
		for (int i = 0, len = str.length(); i < len; i++) {
			char c = str.charAt(i);
			if (Character.isHighSurrogate(c)) {// 如果已经是高代理字符，则可能是超过\uFFFF的unicode了
				int codePoint = str.codePointAt(i);// 进行代码点解析
				if (codePoint == c) {// 解析后的值与单个字符想通，说明只有单个高代理字符，则编码有问题，需要过滤该字符
					continue;
				} else if (!isXMLCharacter(codePoint)) {// 非法xml字符滤掉
					i++;
					continue;
				} else if (removePrivateUseArea
						&& ((codePoint >= 0xF0000 && codePoint <= 0xFFFFD) || (codePoint >= 0x100000 && codePoint <= 0x10FFFD))) {
					// 过滤高代理的PrivateUseArea区的字符,
					// Supplementary Private Use Area-A Range: F0000–FFFFD
					// Supplementary Private Use Area-B Range: 100000–10FFFD
					i++;
					continue;
				} else {
					i++;
					sb.appendCodePoint(codePoint);
					continue;
				}
			}
			if (!isXMLCharacter(c)) {// 跳过非法xml字符
				continue;
			}
			if (removePrivateUseArea && c >= '\uE000' && c <= '\uF8FF') {// 过滤PrivateUseArea区的字符
				continue;
			}
			if (removePrivateUseArea && c == '\u202E') {// 过滤RIGHT-TO-LEFT
														// OVERRIDE转义字符
														// http://www.fileformat.info/info/unicode/char/202e/index.htm
				continue;
			}
			switch (c) {
			case '&':
				if (str.startsWith("&amp;amp;", i)) {// 把两个amp;的兼容还原
					sb.append("&");
					i = i + 8;
				} else if (str.startsWith("&amp;gt;", i)) {// 把多encode了一次的导致amp;的兼容还原
					sb.append(">");
					i = i + 7;
				} else if (str.startsWith("&amp;lt;", i)) {// 把多encode了一次的导致amp;的兼容兼容还原
					sb.append("<");
					i = i + 7;
				} else if (str.startsWith("&amp;apos;", i)) {// 把多encode了一次的导致amp;的兼容兼容还原
					sb.append("'");
					i = i + 9;
				} else if (str.startsWith("&amp;quot;", i)) {// 把多encode了一次的导致amp;的兼容兼容还原
					sb.append("\"");
					i = i + 9;
				} else if (str.startsWith("&amp;nbsp;", i)) {// 把多encode了一次的导致amp;的兼容兼容还原
					sb.append(" ");
					i = i + 9;
				} else if (str.startsWith("&amp;", i)) {// 把已经encode的amp;的兼容兼容还原
					sb.append("&");
					i = i + 4;
				} else if (str.startsWith("&gt;", i)) {
					sb.append(">");
					i = i + 3;
				} else if (str.startsWith("&lt;", i)) {
					sb.append("<");
					i = i + 3;
				} else if (str.startsWith("&apos;", i)) {
					sb.append("'");
					i = i + 5;
				} else if (str.startsWith("&quot;", i)) {
					sb.append("\"");
					i = i + 5;
				} else if (str.startsWith("&nbsp;", i)) {
					sb.append(" ");
					i = i + 5;
				} else if (str.startsWith("&#", i)) {// 检测已经是&#37;这样编码字符串
					int index = -1;
					for (int j = i + 2; j < i + 10 && j < len; j++) {// xml字符用数字转义方式表示的最大值是&#111411;,因此往前最多检测到10位即可
						char cc = str.charAt(j);
						if (cc == ';') {
							index = j;
							break;
						}
					}
					if (index > i + 2) {// 说明&#和;之间有字符存在，则尝试反解析
						String unicodeVal = str.substring(i + 2, index);
						try {
							boolean hex = 'x' == unicodeVal.charAt(0);
							int val = hex ? Integer.parseInt(
									unicodeVal.substring(1), 16) : Integer
									.parseInt(unicodeVal, 10);
							if (!isXMLCharacter(val)) {
								sb.append("&");// &#后面的字符无法反解析为合法xml字符，因此继续保持转义
							} else {// 否则还原成unicode字符
								if (removePrivateUseArea) {// 反解析后再次过滤文字反向和私有区域字符
									if (!((val == '\u202E')
											|| (val >= '\uE000' && val <= '\uF8FF')
											|| (val >= 0xF0000 && val <= 0xFFFFD) || (val >= 0x100000 && val <= 0x10FFFD))) {
										sb.appendCodePoint(val);
									} else {
										//System.err.println(" error for:"
										//		+ unicodeVal);
									}
								} else {
									sb.appendCodePoint(val);

								}
								i = i + 2 + unicodeVal.length();
							}
						} catch (Exception e) {
							// System.err.println("error for :" + unicodeVal);//
							// 继续原始编码方式
							sb.append("&");
						}
					} else {
						sb.append("&");
					}
				} else {
					sb.append("&");
				}
				break;
			default:
				sb.append(c);
				break;
			}
		}
		return sb.toString();
	}

	/**
	 * 判断一个unicode值是否为合法的xml字符，从org.jdom.Verifier复制过来的
	 * 
	 * @param c
	 * @return
	 * @author quickli
	 * @see org.jdom.Verifier#isXMLCharacter(int)
	 */
	public static boolean isXMLCharacter(int c) {
		if (c == '\n')
			return true;
		if (c == '\r')
			return true;
		if (c == '\t')
			return true;

		if (c < 0x20)
			return false;
		if (c <= 0xD7FF)
			return true;
		if (c < 0xE000)
			return false;
		if (c <= 0xFFFD)
			return true;
		if (c < 0x10000)
			return false;
		if (c <= 0x10FFFF)
			return true;

		return false;
	}
	/**
	 * 格式化日期
	 * 
	 * @param dateStr
	 *            输入的日期字符串
	 * @param inputFormat
	 *            输入日期格式
	 * @param format
	 *            输出日期格式
	 * @return String 格式化后的日期,如果不能格式化则输出原日期字符串
	 */
	public static String formatDate(String dateStr, String inputFormat, String format)
	{
		String resultStr = dateStr;
		try 
		{
			Date date = new SimpleDateFormat(inputFormat).parse(dateStr);
			resultStr = formatDate(date,format);
		}
		catch (ParseException e) 
		{
		}	
		return resultStr;		
	}
	/**
	 * 格式化日期
	 * 输入日期格式只支持yyyy-MM-dd HH:mm:ss 或 yyyy/MM/dd HH:mm:ss
	 * @param dateStr 输入的日期字符串
	 * @param format 输出日期格式
	 * @return String 格式化后的日期,如果不能格式化则输出原日期字符串
	 */	
	public static String formatDate(String dateStr, String format)
	{
		String resultStr = dateStr;
		String inputFormat = "yyyy-MM-dd HH:mm:ss";
		if(dateStr == null)
		{
			return "";
		}
		if(dateStr.matches("\\d{1,4}\\-\\d{1,2}\\-\\d{1,2}\\s+\\d{1,2}:\\d{1,2}:\\d{1,2}\\.\\d{1,3}"))
		{
			inputFormat = "yyyy-MM-dd HH:mm:ss.SSS";
		}
		else if(dateStr.matches("\\d{4}\\-\\d{1,2}\\-\\d{1,2} +\\d{1,2}:\\d{1,2}"))
		{
			inputFormat = "yyyy-MM-dd HH:mm:ss";
		}
		else if(dateStr.matches("\\d{4}\\-\\d{1,2}\\-\\d{1,2} +\\d{1,2}:\\d{1,2}"))
		{
			inputFormat = "yyyy-MM-dd HH:mm";
		}
		else if(dateStr.matches("\\d{4}\\-\\d{1,2}\\-\\d{1,2} +\\d{1,2}"))
		{
			inputFormat = "yyyy-MM-dd HH";
		}
		else if(dateStr.matches("\\d{4}\\-\\d{1,2}\\-\\d{1,2} +\\d{1,2}"))
		{
			inputFormat = "yyyy-MM-dd";
		}
		else if(dateStr.matches("\\d{1,4}/\\d{1,2}/\\d{1,2}\\s+\\d{1,2}:\\d{1,2}:\\d{1,2}\\.\\d{1,3}"))
		{
			inputFormat = "yyyy/MM/dd HH:mm:ss.SSS";
		}
		else if(dateStr.matches("\\d{4}/\\d{1,2}/\\d{1,2} +\\d{1,2}:\\d{1,2}"))
		{
			inputFormat = "yyyy/MM/dd HH:mm:ss";
		}
		else if(dateStr.matches("\\d{4}/\\d{1,2}/\\d{1,2} +\\d{1,2}:\\d{1,2}"))
		{
			inputFormat = "yyyy/MM/dd HH:mm";
		}
		else if(dateStr.matches("\\d{4}/\\d{1,2}/\\d{1,2} +\\d{1,2}"))
		{
			inputFormat = "yyyy/MM/dd HH";
		}
		else if(dateStr.matches("\\d{4}/\\d{1,2}/\\d{1,2} +\\d{1,2}"))
		{
			inputFormat = "yyyy/MM/dd";
		}
		resultStr = formatDate(dateStr,inputFormat,format);
		return resultStr;
	}
	
	/**
	 * 格式化日期
	 * @param date 输入日期
	 * @param format 输出日期格式
	 * @return String
	 */
	public static String formatDate(Date date, String format)
	{
    	SimpleDateFormat sdf = new SimpleDateFormat(format);
    	return sdf.format(date);		
	}
	
    /**
     * 获取字符型参数，若输入字符串为null，则返回设定的默认值
     * @param str 输入字符串
     * @param defaults 默认值 
     * @return 字符串参数
     */
    public static String convertString(String str, String defaults)
    {
        if(str == null)
        {
            return defaults;
        }
        else
        {
            return str;
        }
    }
        
    /**
     * 获取int参数，若输入字符串为null或不能转为int，则返回设定的默认值
     * @param str 输入字符串
     * @param defaults 默认值
     * @return int参数
     */
    public static int convertInt(String str, int defaults)
    {
        if(str == null)
        {
            return defaults;
        }        
        try
        {
            return Integer.parseInt(str);
        }
        catch(Exception e)
        {
            return defaults;
        }
    }
    
    /**
     * 获取long型参数，若输入字符串为null或不能转为long，则返回设定的默认值
     * @param str 输入字符串
     * @param defaults 默认值
     * @return long参数
     */
    public static long convertLong(String str, long defaults)
    {
        if(str == null)
        {
            return defaults;
        }        
        try
        {
            return Long.parseLong(str);
        }
        catch(Exception e)
        {
            return defaults;
        }
    }
    
    /**
     * 获取double型参数，若输入字符串为null或不能转为double，则返回设定的默认值
     * @param str 输入字符串
     * @param defaults 默认值
     * @return double型参数
     */
    public static double convertDouble(String str, double defaults)
    {
        if(str == null)
        {
            return defaults;
        }
        try
        {
            return Double.parseDouble(str);
        }
        catch(Exception e)
        {
            return defaults;
        }
    }
    
    /**
     * 获取short型参数，若输入字符串为null或不能转为short，则返回设定的默认值
     * @param str 输入字符串
     * @param defaults 默认值
     * @return short型参数
     */
    public static short convertShort(String str, short defaults)
    {
        if(str == null)
        {
            return defaults;
        }
        try
        {
            return Short.parseShort(str);
        }
        catch(Exception e)
        {
            return defaults;
        }
    }
    
    /**
     * 获取float型参数，若输入字符串为null或不能转为float，则返回设定的默认值
     * @param str 输入字符串
     * @param defaults 默认值
     * @return float型参数
     */
    public static float convertFloat(String str, float defaults)
    {
        if(str == null)
        {
            return defaults;
        }
        try
        {
            return Float.parseFloat(str);
        }
        catch(Exception e)
        {
            return defaults;
        }
    }
    
    /**
     * 获取boolean型参数，若输入字符串为null或不能转为boolean，则返回设定的默认值
     * @param str 输入字符串
     * @param defaults 默认值
     * @return boolean型参数
     */
    public static boolean convertBoolean(String str, boolean defaults)
    {
        if(str == null)
        {
            return defaults;
        }
        try
        {
            return Boolean.parseBoolean(str);
        }
        catch(Exception e)
        {
            return defaults;
        }
    }
    
    /**
     * 分割字符串
     * @param line			原始字符串
     * @param seperator		分隔符
     * @return				分割结果
     */
    public static String[] split(String line, String seperator)
	{
		if(line == null || seperator == null || seperator.length() == 0)
			return null;
		ArrayList<String> list = new ArrayList<String>();
		int pos1 = 0;
		int pos2;
		for(; ; )
		{
			pos2 = line.indexOf(seperator, pos1);
			if(pos2 < 0)
			{
				list.add(line.substring(pos1));
				break;
			}
			list.add(line.substring(pos1, pos2));
			pos1 = pos2 + seperator.length();
		}
		// 去掉末尾的空串，和String.split行为保持一致
		for(int i = list.size() - 1; i >= 0 && list.get(i).length() == 0; --i)
		{
			list.remove(i);
		}
		return list.toArray(new String[0]);
	}
    
	/**
	 * 分割字符串，并转换为int
	 * 
	 * @param line
	 *            原始字符串
	 * @param seperator
	 *            分隔符
	 * @param def
	 *            默认值
	 * @return 分割结果
	 */
	public static int[] splitInt(String line, String seperator, int def) {
		String[] ss = split(line, seperator);
		int[] r = new int[ss.length];
		for (int i = 0; i < r.length; ++i) {
			r[i] = convertInt(ss[i], def);
		}
		return r;
	}
	
	/**
	 * 分割字符串，并转换为long
	 * 
	 * @param line
	 *            原始字符串
	 * @param seperator
	 *            分隔符
	 * @param def
	 *            默认值
	 * @return 分割结果
	 */
	public static long[] splitLong(String line, String seperator, long def) {
		String[] ss = split(line, seperator);
		long[] r = new long[ss.length];
		for (int i = 0; i < r.length; ++i) {
			r[i] = convertLong(ss[i], def);
		}
		return r;
	}
    
    @SuppressWarnings("unchecked")
	public static String join(String separator, Collection c)
    {
    	if(c.isEmpty())
    		return "";
    	StringBuilder sb = new StringBuilder();
    	Iterator i = c.iterator();
    	sb.append(i.next());
    	while(i.hasNext()){
    		sb.append(separator);
    		sb.append(i.next());
    	}
    	return sb.toString();
    }
    
    public static String join(String separator, String[] s)
    {
    	return joinArray(separator,s);
    }

    public static String joinArray(String separator, Object[] s)
    {
    	if(s == null || s.length == 0)
    		return "";
    	StringBuilder sb = new StringBuilder();
    	sb.append(s[0]);
    	for(int i = 1; i < s.length; ++i){
    		if(s[i] != null)
    		{
	    		sb.append(separator);
	    		sb.append(s[i].toString());
    		}
    	}
    	return sb.toString();
    }

    public static String joinArray(String separator, int[] s)
    {
    	if(s == null || s.length == 0)
    		return "";
    	StringBuilder sb = new StringBuilder();
    	sb.append(s[0]);
    	for(int i = 1; i < s.length; ++i){
    		sb.append(separator);
    		sb.append(s[i]);
    	}
    	return sb.toString();
    }
    
    public static String joinArray(String separator, long[] s)
    {
    	if(s == null || s.length == 0)
    		return "";
    	StringBuilder sb = new StringBuilder();
    	sb.append(s[0]);
    	for(int i = 1; i < s.length; ++i){
    		sb.append(separator);
    		sb.append(s[i]);
    	}
    	return sb.toString();
    }
    
    public static String join(String separator, Object...c)
    {
    	return joinArray(separator, c);
    }
    
    /**
     * 字符串全量替换
     * @param s			原始字符串
     * @param src		要替换的字符串
     * @param dest		替换目标
     * @return			结果
     */
    public static String replaceAll(String s, String src, String dest)
    {
    	if(s == null || src == null || dest == null || src.length() == 0)
    		return s;
    	int pos = s.indexOf(src);			// 查找第一个替换的位置
    	if(pos < 0)
    		return s;
    	int capacity = dest.length() > src.length() ? s.length() * 2: s.length();
    	StringBuilder sb = new StringBuilder(capacity);
    	int writen = 0;
    	for(; pos >= 0; )
    	{
    		sb.append(s, writen, pos);		// append 原字符串不需替换部分
    		sb.append(dest);				// append 新字符串
    		writen = pos + src.length();	// 忽略原字符串需要替换部分
    		pos = s.indexOf(src, writen);	// 查找下一个替换位置
    	}
    	sb.append(s, writen, s.length());	// 替换剩下的原字符串
    	return sb.toString();
    }

    /**
     * 只替换第一个
     * @param s
     * @param src
     * @param dest
     * @return
     */
	public static String replaceFirst(String s, String src, String dest)
	{
		if(s == null || src == null || dest == null || src.length() == 0)
			return s;
		int pos = s.indexOf(src);
		if(pos < 0)
		{
			return s;
		}
		StringBuilder sb = new StringBuilder(s.length() - src.length() + dest.length());
		
		sb.append(s, 0, pos);
		sb.append(dest);
		sb.append(s, pos + src.length(), s.length());
		return sb.toString();
	}

	/**
	 * Returns <tt>true</tt> if s is null or <code>s.trim().length()==0<code>.
	 * 
	 * @see java.lang.String#isEmpty()
	 * @author isaacdong
	 */
	public static boolean isEmpty(String s) {
		if (s == null)
			return true;
		return s.trim().isEmpty();
	}
	
	public static boolean isNotEmpty(String s) {
		return !isEmpty(s);
	}
	
	/**
	 *@see java.lang.String#trim()
	 */
	public static String trim(String s) {
		if (s == null)
			return null;
		return s.trim();
	}
    
    public static String removeAll(String s, String src)
    {
    	return replaceAll(s, src, "");
    }
   

    /**
     * 以某一长度缩写字符串（1个中文或全角字符算2个长度单位，英文或半角算一个长度单位）.
     * 如果要显示n个汉字的长度，则maxlen= 2* n
     * @param src utf-8字符串
     * @param maxlen 缩写后字符串的最长长度（1个中文或全角字符算2个单位长度）
     * @param replacement 替换的字符串，该串长度会计算到maxlen中
     * @return String
     */
    public static String abbreviate(String src, int maxlen, String replacement){
        
        if(src==null)  return "";
        
        if ( replacement == null ) {
            replacement = "";
        }
        
        StringBuffer dest = new StringBuffer();                         //初始值设定为源串
        
        try{
            maxlen = maxlen - computeDisplayLen(replacement);

            if ( maxlen < 0) {
                return src;
            }

            int i = 0;
            for(; i < src.length() && maxlen > 0; ++i)
            {
                char c = src.charAt(i);
                if(c >= '\u0000' && c <= '\u00FF') {
                    maxlen = maxlen - 1;
                } else {
                    maxlen = maxlen - 2;
                }
                if ( maxlen >= 0 ) {
                    dest.append(c);
                }
            }
            
            //没有取完 src 所有字符时，才需要加后缀 ...
            if(i<src.length()-1){
            	dest.append( replacement );
            }
            return dest.toString();
        }catch(Throwable e){
       	    Logger.getLogger("jutil").error("abbreviate error: ", e);
//        	log.error("abbreviate error:",e);
        }
        return src;
    }
    
    /**
     * @see  abbreviate(String src, int maxlen, String replacement)
     * @param src
     * @param maxlen
     * @return
     */
    public static String abbreviate(String src, int maxlen) 
    {
        return abbreviate(src, maxlen, "");
    }
    
	/**
	 * 将字符串截短,功能与abbreviate()类似
	 * 全角字符算一个字,半角字符算半个字,这样做的目的是为了显示的时候排版整齐,因为全角字占的位置要比半角字小
	 * @param str
	 * @param maxLen
	 * @return String
	 */
	public static String toShort(String str, int maxLen, String replacement)
	{
		if(str == null)
		{
			return "";
		}
		if(str.length() <= maxLen)
		{
			return str;
		}
		StringBuilder dest = new StringBuilder();
		double len = 0;
		for (int i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);
			if(c >= '\u0000' && c <= '\u00FF')
			{//半角字算半个字
				len += 0.5;
			}
			else
			{
				len += 1;
			}
			if(len > maxLen)
				return dest.toString() + replacement;
			else
				dest.append(c);
		}
		return dest.toString();
	}
	
	public static String toShort(String str, int maxLen)
	{
		return toShort(str, maxLen, "...");
	}
    
    /**
     * 计算字符串的显示长度，半角算１个长度，全角算两个长度
     * @param s
     * @return
     */
    public static int computeDisplayLen( String s ) {
        int len = 0;
        if ( s == null ) {
            return len;
        }
       
        for(int i = 0; i < s.length(); ++i)
        {
            char c = s.charAt(i);
            if(c >= '\u0000' && c <= '\u00FF') {
                len = len + 1;
            } else {
                len = len + 2;
            }
        }
        return len;
    }
	/**
	 * 获取字符串的UTF-8编码字节数组
	 * 
	 * @param s
	 * @author quickli 
	 * @return
	 */
	public static byte[] getUTF8Bytes(String s) {
		if (s != null && s.length() >= 0) {
			try {
				return s.getBytes(ENC_UTF8);
			} catch (UnsupportedEncodingException e) {
			}
		}
		return null;
	}

	/**
	 * 获取字符串的GBK编码字节数组
	 * 
	 * @param s
	 * @author quickli 
	 * @return
	 */
	public static byte[] getGBKBytes(String s) {
		if (s != null && s.length() >= 0) {
			try {
				return s.getBytes(ENC_GBK);
			} catch (UnsupportedEncodingException e) {
			}
		}
		return null;
	}

	/**
	 * 获取字节数组的UTF-8编码字符串
	 * 
	 * @param s
	 * @author quickli 
	 * @return
	 */
	public static String getUTF8String(byte[] b) {
		if (b != null) {
			try {
				return new String(b,ENC_UTF8);
			} catch (UnsupportedEncodingException e) {
			}
		}
		return null;
	}

	/**
	 * 获取字节数组的GBK编码字符串
	 * 
	 * @param s
	 * @author quickli 
	 * @return
	 */
	public static String getGBKString(byte[] b) {
		if (b != null) {
			try {
				return new String(b,ENC_GBK);
			} catch (UnsupportedEncodingException e) {
			}
		}
		return null;
	}
	
	/**
	 * 对字符串以 GBK编码方式进行URLEncode
	 * 
	 * @param s
	 * @author quickli 
	 * @return
	 */
	public static String URLEncodeGBK(String s) {
		if (s != null && s.length() > 0) {
			try {
				return URLEncoder.encode(s, ENC_GBK);
			} catch (UnsupportedEncodingException e) {
			}
		}
		return s;
	}

	/**
	 * 对字符串以 UTF-8编码方式进行URLEncode
	 * 
	 * @param s
	 * @author quickli 
	 * @return
	 */
	public static String URLEncodeUTF8(String s) {
		if (s != null && s.length() > 0) {
			try {
				return URLEncoder.encode(s, ENC_UTF8);
			} catch (UnsupportedEncodingException e) {
			}
		}
		return s;
	}
	
	/**
	 * 对字符串以 GBK编码方式进行URLDecode
	 * 
	 * @param s
	 * @author quickli 
	 * @return
	 */
	public static String URLDecodeGBK(String s) {
		if (s != null && s.length() > 0) {
			try {
				return URLDecoder.decode(s, ENC_GBK);
			} catch (UnsupportedEncodingException e) {
			}
		}
		return s;
	}

	/**
	 * 对字符串以 UTF-8编码方式进行URLDecode
	 * 
	 * @param s
	 * @author quickli 
	 * @return
	 */
	public static String URLDecodeUTF8(String s) {
		if (s != null && s.length() > 0) {
			try {
				return URLDecoder.decode(s, ENC_UTF8);
			} catch (UnsupportedEncodingException e) {
			}
		}
		return s;
	}
    
    
    public static void main(String[] argv)
    {
    	System.out.println(joinArray(",",new int[]{1,2}));
		String s = "0\u00031&2&amp;3&amp;amp;4&gt;5&lt;6&apos;7&quot;"
			+ "8<9>10\'11\"12\n13\r14\t15&#37;16&#;17&#y;18&#7654321;19"
			+ "&amp;lt;20&amp;gt;21&amp;quot;22&amp;apos;23$\uD860\uDEE224\uDEE2quick\uD860lia\uF8FFb\uDB80\uDC01c\uDBC0\uDC01d";
		System.out.println("safeRemoveInvalidWML=" + safeRemoveInvalidWML(s));
		System.out.println("safeRemoveInvalidWML=" + safeRemoveInvalidWML(s,false));
		System.out.println("removeInvalidWML=" + removeInvalidWML(s));
		s = "&1&amp;2&amp;amp;3&gt;4&lt;5&apos;6&quot;7&#37;AA8&#22032;9&#abc;10&#987654321;11&#3712&#x7B;13&#1;14\u202E&#x202E;15&#xFFFFD;16&amp;nbsp;17&nbsp;18&#x0d;19";
		System.out.println("decodeWML=" + decodeWML(s, false));
		System.out.println("decodeWML=" + decodeWML(s, true));
		
		s = "abc%26%238238%3Bdef";//&#8238;
		s = URLDecoder.decode(s);
		System.out.println(s+" decodeNetUnicode = " + decodeNetUnicode(s));
		System.out.println();
		s = "abc%26%23123%3Bdef-abc%26%238238%3Bdef";//&#8238;
		s = URLDecoder.decode(s);
		System.out.println(s+" decodeNetUnicode = " + decodeNetUnicode(s));
    }
}
