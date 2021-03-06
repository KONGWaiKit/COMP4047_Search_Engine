package Search_Engine;

import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		
		Pool pool = new Pool(20,20,"https://www.comp.hkbu.edu.hk/v1");
		Extract_Webpage_Elements webpageExtractor = new Extract_Webpage_Elements();
		Database db = new Database(".."); // Provide path to create database

		while (pool.count_URL_Pool() > 0 && pool.count_Processed_URL_Pool() < pool.processed_URL_Pool_Limit) {
			String currentURL = pool.poll_URL_Pool();
			System.out.println("Current URL:" + currentURL);
			
			webpageExtractor.start_Extracting(currentURL);
			pool.offer_URL_Pool(webpageExtractor.extractedURL);
			
			// push Keyword to database (Linkedlist<String[Type,URL,Keyword]>)
			
			// push Image to database (Linkedlist<String[Type,URL,Keyword]>)
			db.push(webpageExtractor.extractedImage);
			
			// push Video to database (Linkedlist<String[Type,URL,Keyword]>)
			
			pool.offer_Processed_URL_Pool(currentURL);
		}
		
		return;
	}
}
