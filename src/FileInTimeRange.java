//FileInTimeRange.java by Austin Wilburn, austinwilburn93@gmail.com
//The program takes a pathway and two dates as input, than 
//finds all the files modified in that time range and prints them out
import java.nio.file.Paths; //Paths
import java.nio.file.Path; //Path
import java.io.*; //File
import java.text.SimpleDateFormat; //SimpleDateFormat
import java.text.ParseException; //ParseException
import java.util.Date; //Date
public class FileInTimeRange {
	//main throwing exception
	public static void main(String[] args) throws ParseException {
		//directory name is first argument
	    String directoryName = args[0];
	    //set up simple date format
	    final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
	    //start and end dates based on 2nd and 3rd argument
	    final Date start = sdf.parse(args[1]); //throw ParseException
	    final Date end = sdf.parse(args[2]);
	    //path is he directory name
	    Path startPath = Paths.get(directoryName);
	    //new filter
	    FilenameFilter filter = new FilenameFilter(){ 
	    	//takes in a directory and a strign name
			public boolean accept(File dir, String name) {
				//new date is last modified of the file
				Date d = new Date(new File(dir, name).lastModified());
				//compare that to the entered dates
				return ((start.compareTo(d) < 0 
	                    && (end.compareTo(d) >= 0)));
			}
		};
	    //put to path to a file
	    File file = startPath.toFile();
	    //filter the files
	    File files[] = file.listFiles(filter);
	    //print our results
	    for(File f: files){
	    	System.out.println(f.getName() + " " + sdf.format(new Date(f.lastModified())));
	    }
	}
}
