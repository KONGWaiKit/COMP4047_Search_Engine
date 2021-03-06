package Search_Engine;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.LinkedList;


public class Database {
	
	File db_Txt;
	LinkedList<String> blacklist_Words = new LinkedList<String>();
	
	Database(String db_Path){
		db_Txt = new File(db_Path + "\\Search_Engine_Database.txt");
		
		try {
			if(!db_Txt.createNewFile()) {
				db_Txt.delete();
				db_Txt.createNewFile();
			}
			
			File blacklist_File = new File("BlackListWords.txt");
			Scanner reader = new Scanner(blacklist_File);
			while(reader.hasNextLine()) {
				blacklist_Words.add(reader.nextLine());
			}
			reader.close();
			System.out.println("Database Created:" + db_Path + "\\" + db_Txt.getName());
			
		}catch (IOException error) {
			System.out.println(error);
		}

	}
	
	void push(LinkedList<String[]> data){
		
		try {
			BufferedWriter db_BufferedWriter = new BufferedWriter(new FileWriter(db_Txt,true));
			for(int i = 0; i < data.size(); i++) {
				
				if(blacklist_Words.contains(data.get(i)[2])) {continue;}
				
				db_BufferedWriter.write(",./.,|dE");
				db_BufferedWriter.write(data.get(i)[0]);
				db_BufferedWriter.write(",./.,|eD");
				db_BufferedWriter.write(data.get(i)[1]);
				db_BufferedWriter.write(",./.,|eD");
				db_BufferedWriter.write(data.get(i)[2]);
				db_BufferedWriter.newLine();
			}
			
			db_BufferedWriter.close();
			
		}catch (IOException error) {
			System.out.println(error);
		}
		
	}
}
