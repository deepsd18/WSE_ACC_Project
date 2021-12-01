import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import webFeatures.*;

public class mainPage {

	public static void main(String[] args) throws FileNotFoundException, NullPointerException, IOException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("<<--------------- Welcome User --------------->>");

		System.out.println("\n-> Do you want to run web crawler ? Y/N : ");
		String crawlerStart = scanner.next();
		if (crawlerStart.equals("Y")) {
			System.out.println("\n----->> Starting HTML Crawler on 'www.crawler-test.com' <<-----");
			pageCrawler.downloadHTML("https://crawler-test.com/", 10);
			System.out.println("\n-->> Crawler run on 'www.crawler-test.com' was performed successfully <<--");
		}

		htmlConverter.htmlTextConverter();
		System.out.println("\n-> Conversion from HTML files to Text files is completed <--\n");

		System.out.println("--------------------------------------------------------------\n");

		Boolean flag = true;

		while (flag) {
			System.out.println("-> Enter your word to search from files : ");
			String searchword = scanner.next();
			Boolean wordCheck = spellingCheck.SpellCheck(searchword);

			if (wordCheck) {
				fileRanker.rankingResults(searchword);
			}
			
			System.out.println("\n-> Do you want search again ? Y/N : ");
			String quitCheck = scanner.next();
			
			if (quitCheck.equals("N")) {
				break;
			}
		}

		System.out.println("--------------------------------------------------------------\n");

		System.out.println("-> Enter your word to count frequency of the word n all files : ");
		String wordtocount = scanner.next();
		frequencyCount.frqCount(wordtocount);

		scanner.close();
	}
}
