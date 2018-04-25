//package com.mrmusic25.log;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;

public class Log {
	/* 
		Class Attributes
	*/
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
	protected int printLevel = 2, defaultLevel = 1;
	private File logfile;
	
	/*
		Constructors
	*/
	public Log() throws IOException {
		// With no log file present, use the current date as a log file
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy-HH:mm:ss");
		Date date = new Date();
		this.outputFile = df.format(date);
		this.outputFile += ".log"; // Adds the extension
		
		this.initialize();
	}
	
	public Log(String s) throws IOException {
		this.outputFile = s;
		// If extension is missing, add .log. Relies on having a 3 or 4-char extension
		if (!(s.charAt(s.length()-4) == '.' || s.charAt(s.length()-3) == '.'))
			this.outputFile += ".log";
		
		this.initialize();
	}
	
	public Log(File f) throws IOException {
		this.logfile = f;
		this.outputFile = f.getName();
		this.initialize();
	}
	
	public Log(Log l, boolean initializeLog) throws IOException {
		this.outputFile = l.getName();
		this.printLevel = l.getPrintLevel();
		this.defaultLevel = l.getDefaultLevel();
		if (outputFile.charAt(outputFile.length()-4) != '.' || outputFile.charAt(outputFile.length()-3) != '.')
			this.outputFile += ".log";
		logfile = new File(outputFile);
		
		// This is useful when multiple methods use the same log file
		// Prevents re-initialization of a common logfile
		if (initializeLog)
			this.initialize();
	}
	
	/* 
		Private methods
	*/
	private void initialize() throws IOException {
		// Prepare tmp string
		String tmp = "*** Initializing log instance, ";
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy 'at' HH:mm:ss");
		Date date = new Date();
		
		tmp += df.format(date);
		tmp += "! ***";
		
		// Check to see if file exists or not, create if not
		this.logfile = new File(outputFile);
		if (!this.logfile.exists()) {
			this.logfile.createNewFile();
		}
		// Make sure file is writeable. Try to change if not.
		else if (!this.logfile.canWrite()) {
			if (!this.logfile.setWritable(true))
				throw new IOException("File " + outputFile + " cannot be written to!");
		}
		
		//this.log(tmp);
		FileWriter out = new FileWriter(this.logfile);
		out.append(tmp);
		out.close();
	}
	
	// Returns the text for the given level, as listed above
	private String getLevelText(int i) {
		switch(i) {
			case 0:
				return "DEBUG";
			case 1:
				return "INFO";
			case 2:
				return "WARN";
			case 3:
				return "ERROR";
			case 4:
				return "FATAL";
			default:
				return "BAD NUM";
		}
	}
	
	/* 
		Public methods
	*/
	public void log(String s) throws IOException { 
		String w = getLevelText(defaultLevel) + ": " + s;
		FileWriter out = new FileWriter(this.logfile);
		out.append(w);
		out.close();
		
		if (printLevel <= defaultLevel)
			System.err.println(w);
	}
	
	public void log(String s, int i) throws IOException {
		String w = getLevelText(i) + ": " + s;
		PrintWriter out = new PrintWriter(this.logfile);
		out.println(w);
		out.close();
		
		if (printLevel <= i || i == 4)
			System.err.println(w);
	}
	
	/*
		Data access/manipulation
	*/
	public String getName() { return outputFile; }
	public int getDefaultLevel() { return defaultLevel; }
	public int getPrintLevel() { return printLevel; }
	public void setDefaultLevel(int i) { this.defaultLevel = i; }
	public void setPrintLevel(int i) { this.printLevel = i; }
	public void setNewFilename(String s) throws IOException {
		this.outputFile = s;
		// If extension is missing, add .log. Relies on having a 3 or 4-char extension
		if (s.charAt(s.length()-4) != '.' || s.charAt(s.length()-3) != '.')
			this.outputFile += ".log";
		
		this.initialize();
	}
	public void verbose() { this.printLevel = 1; }
	public void superVerbose() { this.printLevel = 0; }
	public void setNewFile(File f) throws IOException {
		this.logfile = f;
		this.outputFile = f.getName();
		this.initialize();
	}
}
