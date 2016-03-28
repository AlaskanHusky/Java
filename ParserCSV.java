package twitter;

public class ParserCSV {
	String wd;
	Double factor;
	public void CSVReader(String str) {
		final String delimiter = ",";
		String[] tokens = str.split(delimiter);
		wd = tokens[0];
		factor = Double.parseDouble(tokens[1]);
	}
	public void ShowSentiment() {
		System.out.println(wd + " : " + factor.toString());
	}
}
