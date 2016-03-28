package twitter;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TweetsParser {
	Double coordX;
	Double coordY;
	Date date;
	String text;
	public void TweetsReader(String s) {
		int i = 0;
		StringBuffer str = new StringBuffer();
		char[] tweet = s.toCharArray();
		while (tweet[i] != ']') {
			i++;
			if (tweet[i + 1] == ']') {
				coordY = Double.parseDouble(str.toString());
				str.delete(0, str.length());
			}
			if (tweet[i] == ',') {
				coordX = Double.parseDouble(str.toString());
				i++;
				str.delete(0, str.length());
			}
			str.append(tweet[i]);
		}
		str.delete(0, str.length());
		Pattern dateExpression = Pattern.compile("(\\d{4}(\\-\\d{2}){2}) (\\d{2}(:\\d{2}){2})");
        Matcher dateMatcher = dateExpression.matcher(s);
        while (dateMatcher.find()) {
        	str.append(dateMatcher.group());
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
        try {
			date = dateFormat.parse(str.toString());
		} catch (ParseException e) {
			e.getMessage();
		}
		str.delete(0, str.length());
		i += 27;
		for (; i < tweet.length; i++) {
			str.append(tweet[i]);
			i++;
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
