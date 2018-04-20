import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;

public class Log {
	protected String outputFile; // The location of the logfile
	
	/*
		printLevel determines whether severity of message will printed to console
		Note: 0 is special - assume everything is written to file with other levels
		
		Level (Value) - Description:
		
		Debug (0) - No log or output, unless super-verbose mode is on (manually set printLevel to 0)
		Info  (1) - Information that should be logged, but not always said. Normal verbose should be this value.
		Warn  (2) - By default where errors start showing up; problems encountered, but program attempts to continue
		Error (3) - Problems that may give unintentional results; give user a chance to respond
		Fatal (4) - Prints to console no matter what; errors that prevent program from continuing
	*/
	protected int printLevel = 2;
	private File logfile;
	
	public Log() {
		// With no log file present, use the current date as a log file
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy-HH:mm:ss");
		Date date = new Date();
		this.outputFile = df.format(date);
		this.outputFile += ".log"; // Adds the extension
		
		
	}
	
	private void initialize() throws FileNotFoundException {
		// Prepare tmp string
		String tmp = "*** Initializing log instance, ";
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy at HH:mm:ss");
		Date date = new Date();
		
		tmp += df.format(date);
		tmp += "! ***"
		
		// Check to see if file exists or not, create if not
		logfile = new File(outputFile);
		if (!logFile.exists()) {
			logfile.createNewFile();
		}
		
	}
}