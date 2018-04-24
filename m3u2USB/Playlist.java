package com.mrmusic25.m3u2usb;

import com.mrmusic25.log.*;
import java.io.*;
import java.lang.*;

public class Playlist {
    /*
        Class Attributes
    */
    protected String fullFileName;
    protected File playlistFile;
    protected String fileContents[];
    
    /*
        Constructors
    */
    public Playlist() {
        this.fullFileName = null;
        this.playlistFile = null;
        this.fileContents = new String[0];
    }
    
    public Playlist(String inFile) throws IOException {
        this.fullFileName = inFile;
        this.playlistFile = new File(this.fullFileName);
        this.importContents();
    }
    
    /*
        Private Methods
    */
    
    
    
    /*
        Public Methods
    */
    public void importContents() throws IOException {
        FileReader f = new FileReader(this.playlistFile);
        BufferedReader b = new BufferedReader(f);
        String line = null;
        
        while ((line = b.readLine()) != null )
            this.append(line);
        b.close();
    }
    
    public void append(String s) {
        String tmp[] = new String[this.fileContents.length+1];
        for (int i = 0; i < this.fileContents.length; i++)
            tmp[i] = fileContents[i];
        tmp[tmp.length-1] = s;
        this.fileContents = tmp;
    }
    
    public void delete(int q) {
        String tmp[] = new String[this.fileContents.length-1];
        for (int i = 0, j=0; i < this.fileContents.length; i++)
            if (i != q) {
                tmp[j] = this.fileContents[i];
                j++;
            }
            
        this.fileContents = tmp;
    }
    
    public void outputPlaylist(String outputFile) throws IOException {
        File out = new File(outputFile);
        FileWriter f = new FileWriter(out);
        
        for (int i = 0; i < fileContents.length; i++)
            f.append(fileContents[i]);
        f.close();
    }
    /*
        Data Access/Manipulation
    */
    public String getFullFileName() { return this.fullFileName; }
    public String getLine(int i) { return this.fileContents[i]; }
    public String getFileNAme() { return this.playlistFile.getName(); }
    public int length() { return this.fileContents.length; }
    public void setFileName(String s) throws IOException {
        this.fullFileName = s;
        this.playlistFile = new File(this.fullFileName);
        this.importContents();
    }
}
