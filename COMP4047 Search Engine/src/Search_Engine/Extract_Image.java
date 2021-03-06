package Search_Engine;

import java.util.LinkedList;

public class Extract_Image {
	
	LinkedList<String[]> extract_Image(LinkedList<String> all_Tag, String url_String) {
		
		
		LinkedList<String[]> result_List = new LinkedList<String[]>();
		
		String base_URL = url_String;
		if (base_URL.charAt(base_URL.length() - 1) != '/') {
			base_URL += "/";
		}
				
		for(int i=0; i<all_Tag.size(); i++) {
			
			String image_URL = "";
			String image_ALT = "";
			String image_Name = "";
			
			String[] tag_Elements = all_Tag.get(i).split(" ");
			
			if(!tag_Elements[0].equals("img")) {continue;}
			
			for(int j=0; j<tag_Elements.length; j++) {
				
				if(tag_Elements[j].contains("src=")) {
					
					image_URL = tag_Elements[j].replace("src=", "");
					if(!image_URL.contains("https://") && !image_URL.contains("http://")) {
						image_URL = base_URL + image_URL;
					}
					
					String url_Path_Split[] = tag_Elements[j].split("/");
					String url_Last_Path[] = url_Path_Split[url_Path_Split.length-1].split("=");
					image_Name = url_Last_Path[url_Last_Path.length - 1];
					
					if(image_Name.contains(".")) {
						image_Name = image_Name.substring(0, image_Name.indexOf("."));
					}
				}
				
				if(tag_Elements[j].contains("alt=")) {
					image_ALT = tag_Elements[j].replace("alt=", "");
					
					int count = Math.min(j + 1, tag_Elements.length - 1);
					
					while(count < tag_Elements.length && !tag_Elements[count].contains("=")) {
						image_ALT += " " + tag_Elements[count];
						count++;
					}
				}
				
			}	
			
			if(image_Name!= "") {
				String [] current_Result = new String[] {"img",image_URL,image_Name};
				result_List.add(current_Result);
			}
			
			
			if(image_ALT != "") {
				String [] split_ALT = image_ALT.split(" ");
				for(int j = 0; j < split_ALT.length; j++) {
					String [] current_Result = new String[] {"img",image_URL,split_ALT[j]};
					result_List.add(current_Result);
				}
				
			}

		}
		
		return result_List;
				
	}
	
}
