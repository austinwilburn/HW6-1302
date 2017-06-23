//DeleteClassFiles.java by Austin Wilburn, austinwilburn93@gmail.com
//The program deletes all .class files under the directory of
//my csci1302 folder
import java.nio.file.Paths; //Paths
import java.nio.file.Path; //Path
import java.io.*; //File
import java.text.ParseException; //ParseException
public class DeleteClassFiles {
	//main method handles exception
	public static void main(String[] args) throws ParseException {
		//directory is the csci1302 folder
		String directoryName = "/home/ugrads/wilburn/courses/csci1302";
		//path is the directory name
		Path startPath = Paths.get(directoryName);
		//create new DeleteClassFiles object
		DeleteClassFiles delete = new DeleteClassFiles();
		try {
	    	//call deletefile on startpath to file
	    	delete.deleteFile(startPath.toFile());
	        // ... more
		//otherwise do nothing
	    } 
		catch (IOException ioe) {   
	    } 
	    	
	}
	 //method delete file, takes in file and handles exception
 	void deleteFile(File f) throws IOException {
 		//File array with all the files
 		File[] files = f.listFiles();
 			//if the file is a directory
		if (f.isDirectory()) {
			  //loop through its contents
		    for (File c : files){
		    	//if one of its contents is a directory
		    	if(c.isDirectory()){
		    		//call method on that directory
		    		deleteFile(c);
		    	}
		    	//if content is not a directory and the name contains .class
		    	else if((!c.isDirectory()) && c.getName().contains(".class")){
		    		//delete that file
		    		c.delete();
				}
			}
		}
		//or if f is not a directory and containst .class
		else if((!f.isDirectory()) && f.getName().contains(".class"));
		  	//delete that file
			f.delete();
		  
	}
}


