package twitter;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TweetsParser {
	private Double coordX;
	private Double coordY;
	private Date date;
	private String text;

	public void TweetsReader(String s) {
		StringBuffer str = new StringBuffer();
		Pattern regExpression;
		String regex;
		Matcher regMatcher;
		regex = "\\d{2}\\.\\d+,";
		regExpression = Pattern.compile(regex);
		regMatcher = regExpression.matcher(s);
		while (regMatcher.find()) {
			str.append(s.substring(regMatcher.start(), regMatcher.end() - 1));
			coordX = Double.parseDouble(str.toString());
		}
		str.delete(0, str.length());
		regex = "\\-\\d{2,3}\\.\\d+";
		regExpression = Pattern.compile(regex);
		regMatcher = regExpression.matcher(s);
		while (regMatcher.find()) {
			str.append(s.substring(regMatcher.start(), regMatcher.end()));
			coordY = Double.parseDouble(str.toString());
		}
		str.delete(0, str.length());
		regex = "(\\d{4}(\\-\\d{2}){2}) (\\d{2}(:\\d{2}){2})";
		regExpression = Pattern.compile(regex);
		regMatcher = regExpression.matcher(s);
		while (regMatcher.find()) {
			str.append(s.substring(regMatcher.start(), regMatcher.end()));
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			date = dateFormat.parse(str.toString());
		} catch (ParseException e) {
			e.getMessage();
		}
		str.delete(0, str.length());
		regex = "[a-zA-Z#@].*";
		regExpression = Pattern.compile(regex);
		regMatcher = regExpression.matcher(s);
		while (regMatcher.find()) {
			str.append(s.substring(regMatcher.start(), regMatcher.end()));
		}
		text = str.toString();
		str.delete(0, str.length());
	}

	public void ShowTweet() {
		System.out.println("(" + coordX.toString() + ", " + coordY.toString() + ")");
		System.out.println("Date: " + date.toString());
		System.out.println("Text: " + text);
	}
}
