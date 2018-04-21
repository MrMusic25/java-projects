package com.mrmusic25.m3u2usb;

import com.mrmusic25.log.*;
import java.util.Scanner;
import java.lang.*;
import java.io.*;

public class M3U2USB {
	/*
        Global Variables
	*/
	public boolean copyDRM = true; // How to handle songs with DRM. true, just copy them over; false, skip the song and notify user
	public char preserveMode = 'n'; // Indicates the level of folder preservation; None by default (see displayHelp() for more info)
	public boolean noNumbers = false; // Tells program to delete numbers in fron of song name, off by default
	public static Log logger; // Can't be initialized in the class, but it can be declared!
	
	/*
        Main
    */
	public static void main(String args[]) {
		// Using this program assume you have a music folder with the following structure:
		// ../Music/<Artist>/<Album>/<Song>
		
		try {
        logger = new Log("m3u2usb.log");
        } 
        catch(IOException e) {
            System.err.println("FATAL: Log could not be initialized! Exiting in failure! " + e.getMessage());
            System.exit(1);
        }
		
		displayHelp();
	}
	
	/*
        Methods
    */
    public static void displayHelp() {
        String help = "M3U2USB - A program to convert and centralize music files in an M3U (or text based) playlist\n\n"
                    + "Usage: ./M3U2USB [options] <inputFile> <outputFolder>\n"
                    + "\n"
                    + "Options:\n"
                    + " -h | --help              : Display this help message and exit\n"
                    + " -v | --verbose           : Enables verbose logging messages\n"
                    + " -n | --noNumbers         : Deletes starting numbers in title for output (e.g \"01 Monster.mp3\" -> \"Monster.mp3\")\n"
                    + " -m | --playlistMode      : Uses a centralized music folder instead of individual folders, re-creating original structure of music folder (see below)\n"
                    + " -p | --preserve <level>  : Indicates folder preservation level (see below)\n"
                    + "      --noCopyDRM         : Tells programs not to copy DRM files (default), ignores them instead\n"
                    + "\n"
                    + "NOTE: All playlist files will be localized to the output folder and deposited in the parent of the output\n"
                    + "The preserve level will re-create the specified folder structure in the output folder. Levels are as follows:\n\n"
                    + "  Given the song \"../<root>/Music/Starset/Vessels/01 Monster.m4a\", the output will become:\n\n"
                    + "  [N]one    - ../<outputFolder>/<playlistName>/01 Monster.mp3 (default behavior)\n"
                    + "  [A]rtist  - ../<outputFolder>/<playlistName>/Starset/01 Monster.mp3\n"
                    + "  Al[b]um   - ../<outputFolder>/<playlistName>/Starset/Vessels/01 Monster.mp3\n"
                    + "  [P]arent  - ../<outputFolder>/Music/Starset/Vessels/01 Monster.mp3\n\n"
                    + "Running \"-m|--playlistMode\" is the same as running \"-p|--preserve parent\"\n"
                    + "  Playlist mode relies on using the converted playlist files for music instead of using the directories for organization\n"
                    + "  This means it saves space on smaller drives by not duplicating songs that appear in multiple playlists\n"
                    + "  However, do note that this require a player that supports M3U playlist files for this to work\n";
        System.out.println(help);
    }
    
    public String toLower(String s) {
        StringBuilder b = new StringBuilder(s), c = new StringBuilder();
        for (int i = 0; i < b.length(); i++)
            c.append(Character.toLowerCase(b.charAt(i)));
        return c.toString();
    }
    
    public void processArgs(String args[]) {
    
    }
}
