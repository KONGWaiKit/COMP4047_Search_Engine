package Search_Engine;

import java.util.LinkedList;

public class Extract_URL {
	
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
					result_List.add(correctedURL);
				}
				
			}
		}
		
		return result_List;
				
	}
	
}
