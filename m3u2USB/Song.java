import java.io.*;
import java.lang.*;

public class Song {
	/*
		Class Attributes
	*/
	protected String fullInputPath, fullOutputPath;
	protected String artist, album, title, extension;
	
	/*
		Valid output modes are as follows
		Mode (valid chars) - description
		
		None   (n,c) - Files will be output straight to the given folder
		Artist (b,r) - Artist folder will be preserved
		Album  (a,l) - Both artist and album folder will be preserved
		
		Invalid chars will be treated as none
	*/
	private char outputMode, divider = '\\';
	
	private boolean convertSong = true; // Leave true to convert song (by default), false to copy
	private Log sLog;
	
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
		this.title = null;
		this.sLog = null;
	}
	
	// Extension should be the output extension
	public Song(String inFile, String outFolder, String ext, char mode, Log l, boolean noNumbers) throws IOException {
		this.sLog = new Log(l,false); // Assuming shared logfile, do not reinitialize
		
		this.fullInputPath = inFile;
		this.seperatePath();
		
		// Determine folder divider char
		if (this.fullInputPath.charAt(0) == '/')
			this.divider = '/'; // Windows implicit, Linux/MacOS/BSD explicit. Conversion is later, so nbd
		
		// Check if extensions match
		if (this.extension == ext) 
			this.convertSong = false;
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
		this.fullOutputPath = determineOutput(outFolder);
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
		
		// Album
		tmp = new StringBuilder();
		while (s.charAt(0) != this.divider) {
			tmp.append(s.charAt(0));
			s.deleteCharAt(0);
		}
		s.deleteCharAt(0);
		this.title = this.extension = reverse(tmp.toString());
		
		// Artist
		tmp = new StringBuilder();
		while (s.charAt(0) != this.divider) {
			tmp.append(s.charAt(0));
			s.deleteCharAt(0);
		}
		s.deleteCharAt(0);
		this.title = this.extension = reverse(tmp.toString());
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
			default:
				s.append(divider + title + '.' + this.extension);
		}
		return s.toString();
	}
}