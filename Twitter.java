package twitter;

public class Twitter {

	public static void main(String[] args) {
		Parser prsr = new Parser();
		String filename = args[0]; 					//This file is read out
		int sline = Integer.parseInt(args[1]); 		//The string, which we start reading
		int scount = Integer.parseInt(args[2]); 	//The number of lines to be read
		prsr.StringsReader(filename, sline, scount);
		/*System.out.println("Strings:");
		for (String s : prsr.getStrs()) {
			prsr.ShowStrings(s);
		}
		*/
		/*ParserCSV csv = new ParserCSV();
		System.out.println("Sentiments:");
		for (String s : prsr.getStrs()) {
			csv.CSVReader(s);
			csv.ShowSentiment();
		}*/	
		TweetsParser twparser = new TweetsParser();
		System.out.println("Tweets:");
		for (String s : prsr.getStrs()) {
			twparser.TweetsReader(s);
			twparser.ShowTweet();
		}
	}

}
