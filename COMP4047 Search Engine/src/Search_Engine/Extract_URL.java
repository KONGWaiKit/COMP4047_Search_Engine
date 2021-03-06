package Search_Engine;

import java.util.LinkedList;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Extract_URL {
	
	LinkedList<String> blacklist_URL = new LinkedList<String>();
	
	Extract_URL(){
		
		try {
			File blacklist_URL_File = new File("BlackListUrls.txt");
			Scanner reader = new Scanner (blacklist_URL_File);
			
			while(reader.hasNextLine()) {
				String blockedURL = reader.nextLine();
				if(blockedURL.charAt(blockedURL.length() - 1) == '*') {
					blockedURL = blockedURL.substring(0, blockedURL.length() - 1);
				}
				blacklist_URL.add(blockedURL);
			}
			reader.close();
		}catch (IOException error) {
			System.out.println(error);
		}

	}
	
	LinkedList<String> extract_URL(LinkedList<String> all_Tag, String url_String) {
				
		LinkedList<String> result_List = new LinkedList<String>();
		String base_URL = url_String;
		if (base_URL.charAt(base_URL.length() - 1) != '/') {
			base_URL += "/";
		}
				
		for(int i=0; i<all_Tag.size(); i++) {
						
			String[] tag_Elements = all_Tag.get(i).split(" ");
			
			if(tag_Elements[0].equals("img") || 
					tag_Elements[0].equals("link") || 
					tag_Elements[0].equals("style") ||
					tag_Elements[0].equals("script")) {continue;} 
			
			for(int j=0; j<tag_Elements.length; j++) {
				
				if(tag_Elements[j].contains("href=")) {
					
					String correctedURL = tag_Elements[j].replace("href=", "");
					if(!correctedURL.contains("https://") && !correctedURL.contains("http://")) {
						correctedURL = base_URL + correctedURL;
					}
					
					boolean add_URL = true;
					for (int k = 0; k < blacklist_URL.size(); k++) {
						if (correctedURL.contains(blacklist_URL.get(k))) {
							add_URL = false;
							break;
						}
					}
					
					if (add_URL) {
						result_List.add(correctedURL);
					}
				}
				
			}
		}
		
		return result_List;
				
	}
	
}
