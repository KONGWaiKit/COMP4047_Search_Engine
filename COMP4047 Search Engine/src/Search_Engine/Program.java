package Search_Engine;

import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		
		Pool pool = new Pool(20,20,"https://www.comp.hkbu.edu.hk/v1/");
		Extract_Webpage_Elements webpageExtractor = new Extract_Webpage_Elements();

		while (pool.count_URL_Pool() > 0 && pool.count_Processed_URL_Pool() < pool.processed_URL_Pool_Limit) {
			String currentURL = pool.poll_URL_Pool();
			System.out.println("Current URL:" + currentURL);
			
			webpageExtractor.start_Extracting(currentURL);
			pool.offer_URL_Pool(webpageExtractor.extractedURL);
			// push webpageExtractor.extractedImage to database
			pool.offer_Processed_URL_Pool(currentURL);
		}
		
		return;
	}
}