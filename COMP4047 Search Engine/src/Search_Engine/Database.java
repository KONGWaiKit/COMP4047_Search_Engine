package Search_Engine;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;


public class Database {
	
	File db_Txt;
	
	Database(String db_Path){
		db_Txt = new File(db_Path + "\\Search_Engine_Database.txt");
		
		try {
			if(!db_Txt.createNewFile()) {
				db_Txt.delete();
				db_Txt.createNewFile();
			}
			
			System.out.println("Database Created:" + db_Path + "\\" + db_Txt.getName());
			
		}catch (IOException error) {
			
		}

	}
	
	void push(LinkedList<String[]> data){
		try {
			BufferedWriter db_BufferedWriter = new BufferedWriter(new FileWriter(db_Txt));
			
			for(int i = 0; i < data.size(); i++) {
				db_BufferedWriter.write(",./.,|dE");
				db_BufferedWriter.write(data.get(i)[0]);
				db_BufferedWriter.write(",./.,|eD");
				db_BufferedWriter.write(data.get(i)[1]);
				db_BufferedWriter.write(",./.,|eD");
				db_BufferedWriter.write(data.get(i)[2]);
			}
			
			db_BufferedWriter.close();
			
		}catch (IOException error) {
			System.out.println(error);
		}
		
	}
}