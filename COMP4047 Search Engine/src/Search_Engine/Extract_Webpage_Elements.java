package Search_Engine;

import javax.swing.text.html.*;
import javax.swing.text.html.HTML.*;
import javax.swing.text.html.HTMLEditorKit.*;
import javax.swing.text.html.parser.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.text.*;
import java.util.LinkedList;

class Extract_Webpage_Elements extends HTMLEditorKit.ParserCallback {
	
	LinkedList<String> body_Text = new LinkedList<String>();
	LinkedList<String> all_Tag = new LinkedList<String>();
	LinkedList<String> extractedURL = new LinkedList<String>();
	LinkedList<String[]> extractedImage = new LinkedList<String[]>();

	@Override
	public void handleText(char[] data, int pos) {
		body_Text.add("body " + new String(data));
	}
	
	@Override
	public void handleStartTag(HTML.Tag tag, MutableAttributeSet attr, int pos) {
		this.all_Tag.add(tag + " " + attr);
	} 
	
	public void handleSimpleTag(HTML.Tag tag, MutableAttributeSet attr, int pos) {
		this.all_Tag.add(tag + " " + attr);
	}
	
	void start_Extracting (String urlString){
		
		try {
			Extract_Webpage_Elements callback = new Extract_Webpage_Elements();
			ParserDelegator parser = new ParserDelegator();
			Extract_URL urlExtractor = new Extract_URL();
			Extract_Image imageExtractor = new Extract_Image();
			
			URL url = new URL(urlString);
			InputStreamReader reader = new InputStreamReader(url.openStream());
			parser.parse(reader, callback, true); 
			
			//Extract Keyword Call
			
			//Extract Image Call
			this.extractedImage = imageExtractor.extract_Image(callback.all_Tag, urlString);
			//Extract URL Call
			this.extractedURL = urlExtractor.extract_URL(callback.all_Tag, urlString);
			
			//Extract Video Call
			
			
		}catch (IOException error) {
			
		}
		
		return;
	}
}

