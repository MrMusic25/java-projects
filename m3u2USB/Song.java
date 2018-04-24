package com.mrmusic25.m3u2usb;

import com.mrmusic25.log.*;
import java.io.*;
import java.lang.*;

public class Song {
	/*
		Class Attributes
	*/
	protected String fullInputPath, fullOutputPath, outputFolder;
	protected String artist, album, title, extension, parent, origExt;
	
	/*
		Valid output modes are as follows
		Mode (valid chars) - description
		
		None   (n,c) - Files will be output straight to the given folder
		Artist (b,r) - Artist folder will be preserved
		Album  (a,l) - Both artist and album folder will be preserved
		Parent (p,t) - Re-creates entire "Music" directory
		
		Invalid chars will be treated as none
	*/
	private char outputMode, divider = '\\';
	
	private boolean convertSong = true; // Leave true to convert song (by default), false to copy
	private Log sLog;
	
	// This will work for now, make this list modifiable after release
	public static String allowedExt[] = new String[]{ "mp3" }; // Extensions that can be copied instead of converted, saving time
	public static String unconvertable[] = new String[]{ "m4p" }; // Songs that will throw an error because of DRM protection, making them unplayable

	public File inputFile = null, outputFile = null; // File for input/output
	/*
		Constructors
	*/
	public Song() {
		this.fullInputPath = null;
		this.fullOutputPath = null;
		this.extension = null;
		this.outputMode = 'x';
		this.artist = null;
		this.album = null;
		this.parent = null;
		this.title = null;
		this.outputFolder = null;
		this.origExt = null;
		this.sLog = null;
	}
	
	// Extension should be the output extension
	public Song(String inFile, String outFolder, String ext, char mode, Log l, boolean noNumbers) throws IOException {
		this.sLog = new Log(l,false); // Assuming shared logfile, do not reinitialize
		
		this.fullInputPath = inFile;
		this.outputFolder = outFolder;
		this.inputFile = new File(fullInputPath);
		
		// Determine folder divider char
		if (this.fullInputPath.charAt(0) == '/')
			this.swapDivider();
		this.seperatePath();
		
		// Check if extensions match allowed, or unconvetable extension types
		if (this.extension == ext || contains(ext,allowedExt)) 
			this.convertSong = false;
		else if (contains(ext,unconvertable)) {
            sLog.log("Song " + fullInputPath + " is unconvertable!",3);
            this.convertSong = false;
        }
        else
			this.extension = ext;
		
		// Delete numbers if user specified
		if (noNumbers) {
			StringBuilder s = new StringBuilder(this.title);
			while (s.charAt(0) != ' ')
				if (Character.isDigit(s.charAt(0)) || s.charAt(0) == '-')
					s.deleteCharAt(0);
				else
					continue;
		}
		
		this.outputMode = mode;
		this.fullOutputPath = determineOutput(this.outputFolder);
		this.outputFile = new File(fullOutputPath);
	}
	
	/*
		Private Methods
	*/
	private String reverse(String s) {
		StringBuilder b = new StringBuilder(s), tmp = new StringBuilder();
		for (int i = b.length() - 1; i >= 0; i--)
			tmp.append(b.charAt(i));
		return tmp.toString();
	}
	
	private boolean contains(String s, String a[]) {
        for (int i = 0; i < a.length; i++)
            if (s.equals(a[i]))
                return true;
        return false;
	}
	
	private void seperatePath() {
		StringBuilder s = new StringBuilder(reverse(fullInputPath)), tmp = new StringBuilder();
		
		// Now, use the reversed string to set the values
		// Remember, this is assuming the default file structure!
		
		// Extension
		while (s.charAt(0) != '.') {
			tmp.append(Character.toLowerCase(s.charAt(0)));
			s.deleteCharAt(0);
		}
		s.deleteCharAt(0);
		this.extension = reverse(tmp.toString());
		this.origExt = this.extension;
		
		// Album
		tmp = new StringBuilder();
		while (s.charAt(0) != this.divider) {
			tmp.append(s.charAt(0));
			s.deleteCharAt(0);
		}
		s.deleteCharAt(0);
		this.title = reverse(tmp.toString());
		
		// Artist
		tmp = new StringBuilder();
		while (s.charAt(0) != this.divider) {
			tmp.append(s.charAt(0));
			s.deleteCharAt(0);
		}
		s.deleteCharAt(0);
		this.title = reverse(tmp.toString());
		
		// Parent
		tmp = new StringBuilder();
		while (s.charAt(0) != this.divider && s.length() > 0) {
			tmp.append(s.charAt(0));
			s.deleteCharAt(0);
		}
		s.deleteCharAt(0);
		this.parent = reverse(tmp.toString());
	}
	
	private String determineOutput(String outFolder) {
		StringBuilder s = new StringBuilder(outFolder);
		switch (this.outputMode) {
			case 'b':
			case 'r':
				s.append(divider + artist + divider + title + '.' + this.extension);
				break;
			case 'a':
			case 'l':
				s.append(divider + artist + divider + album + divider + title + '.' + this.extension);
				break;
            case 'p':
            case 't':
                s.append(divider + parent + divider + artist + divider + album + divider + title + '.' + this.extension);
			default:
				s.append(divider + title + '.' + this.extension);
		}
		return s.toString();
	}

	/*
        Public Methods
    */
    
    public void deleteOutputFile() throws IOException {
        if (!this.outputFile.delete())
            throw new IOException("Unable to delete file!");
    }
    
    /*
        Data Access/Manipulation
    */
    public String getFullInputPath() { return this.fullInputPath; }
    public String getFullOutputPath() { return this.fullOutputPath; }
    public String getOutputFolder() { return this.outputFolder; }
    public char getOutputMode() { return this.outputMode; }
    public char getDivider() { return this.divider; }
    public boolean willBeConverted() { return this.convertSong; }
    public void setFullInputPath(String a, String outFolder, String ext, boolean noNumbers, char mode) throws IOException { 
        this.fullInputPath = a;
        this.outputFolder = outFolder;
        this.seperatePath();
        
        // Determine folder divider char
        if (this.fullInputPath.charAt(0) == '/')
            this.divider = '/'; // Windows implicit, Linux/MacOS/BSD explicit. Conversion is later, so nbd
        
        // Check if extensions match allowed, or unconvetable extension types
        if (this.extension == ext || contains(ext,allowedExt)) 
            this.convertSong = false;
        else if (contains(ext,unconvertable)) {
            sLog.log("Song " + fullInputPath + " is unconvertable!",3);
            this.convertSong = false;
        }
        else
            this.extension = ext;
        
        // Delete numbers if user specified
        if (noNumbers) {
            StringBuilder s = new StringBuilder(this.title);
            while (s.charAt(0) != ' ')
                if (Character.isDigit(s.charAt(0)) || s.charAt(0) == '-')
                    s.deleteCharAt(0);
                else
                    continue;
        }
        
        this.outputMode = mode;
        this.fullOutputPath = determineOutput(this.outputFolder);
    }
    public void swapDivider() { if (this.divider == '/') this.divider = '\\'; else this.divider = '/'; }
    public void setConversion(boolean b) { this.convertSong = b; };
    public boolean inputFileExists() { return this.inputFile.exists(); }
    public boolean outputFileExists() { return this.outputFile.exists(); }
}
