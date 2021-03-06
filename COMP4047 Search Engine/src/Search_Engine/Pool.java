package Search_Engine;
import java.util.LinkedList;
import java.util.Queue;

public class Pool {
	Queue<String> url_Pool = new LinkedList<String>();
	Queue<String> processed_URL_Pool = new LinkedList<String>();
	int url_Pool_Limit = 0;
	int processed_URL_Pool_Limit = 0;
	
	Pool(int url_Pool_Limit, int processed_URL_Pool_Limit, String url){
		this.url_Pool_Limit = url_Pool_Limit;
		this.processed_URL_Pool_Limit = processed_URL_Pool_Limit;
		url_Pool.offer(url);
	}
	
	void offer_URL_Pool (LinkedList<String> list) {
		for(int i = 0; i < list.size(); i++) {
			
			if(url_Pool_Limit != 0 && url_Pool.size() >= url_Pool_Limit) {return;}
			
			if (!processed_URL_Pool.contains(list.get(i)) && !url_Pool.contains(list.get(i))) {
				url_Pool.offer(list.get(i));
				System.out.println("URL Pool Offered:" + list.get(i));
			}
			
		}
		
		return;
	}
	
	String poll_URL_Pool() {
		return url_Pool.poll();
	}
	
	int count_URL_Pool() {
		return url_Pool.size();
	}
	
	void offer_Processed_URL_Pool (String url) {
		if(processed_URL_Pool_Limit != 0 && processed_URL_Pool.size() >= processed_URL_Pool_Limit) {return;}
		
		processed_URL_Pool.offer(url);
		System.out.println("Processed URL Offered:" + url);
		System.out.println("");
		return;
	}
	
	String poll_Processed_URL_Pool() {
		return processed_URL_Pool.poll();
	} 
	
	int count_Processed_URL_Pool(){
		return processed_URL_Pool.size();
	}
}
