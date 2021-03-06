//package com.mrmusic25.m3u2usb;

//import com.mrmusic25.log.*;
//import com.mrmusic25.song.*;
//import com.mrmusic25.playlist.*;
import java.util.Scanner;
import java.lang.*;
import java.io.*;

public class M3U2USB {
	/*
        Global Variables
	*/
	public static boolean copyDRM = true; // How to handle songs with DRM. true, just copy them over; false, skip the song and notify user
	public static char preserveMode = 'n'; // Indicates the level of folder preservation; None by default (see displayHelp() for more info)
	public static boolean noNumbers = false; // Tells program to delete numbers in fron of song name, off by default
	public static Log logger; // Can't be initialized in the class, but it can be declared!
	public static String inputFile = null, outputFolder = null; // Intialized with null so the program knows if they're not given a value
	public static char divider = '\\'; // Same as Song.java, used to denote OS
	public static String validPreserveModes[] = new String[]{ "a", "album", "b", "artist", "n", "none", "p", "parent" };
	public static Playlist inList = null, outList = null;
	public static Song songs[] = null;
	
	/*
        Main
    */
	public static void main(String args[]) throws IOException { // This is mostly to make compilation easier; important exceptions will be caught with a try-catch statement
		// Using this program assume you have a music folder with the following structure:
		// ../Music/<Artist>/<Album>/<Song>
		
		// Begin by initializing the log in the local folder
		try {
			logger = new Log("m3u2usb.log");
        } 
        catch(IOException e) {
            System.err.println("FATAL: Log could not be initialized! Exiting in failure! " + e.getMessage());
            System.exit(1);
        }
		
		// Process arguments
		if (args.length < 1) {
			displayHelp("No arguments given, program cannot continue!");
			System.exit(1);
        }
		else {
			try {
				processArgs(args);
			}
			catch(IOException e) {
				System.err.println("Error thrown from processArgs()!: " + e.getMessage());
			}
		}
		
		// Make sure inputFile and outputFolder are not options
		if (inputFile.charAt(0) == '-') {
            logger.log("Input filename " + inputFile + " is invalid! Exiting, please fix and re-run!",4);
            displayHelp();
            System.exit(1);
        }
        else if (outputFolder.charAt(0) == '-') {
            logger.log("Output folder " + outputFolder + " is invalid! Exiting, please fix and re-run!",4);
            displayHelp();
            System.exit(1);
        }
        
        // Time to import playlist
        try {
            inList = new Playlist(inputFile);
        } catch (IOException e) {
            logger.log("Input file " + inputFile + " could not be accessed! Exiting...",4);
            displayHelp();
            System.exit(1);
        }
        
        // Make sure divider is correct
        if (inList.getAbsolutePath().charAt(0) == '/')
            divider = '/'; // Find a more dynamic way to do this later; for now, it works
        
        // Now, start making the songs and prepare for conversion
        songs = new Song[inList.getNumSongs()];
        outList = new Playlist(outputFolder + divider + inList.getFilename());
        for (int i = 0; i < inList.length(); i++) {
            if (inList.getLine(i).charAt(0) != '#' && inList.getLine(i).charAt(0) != ' ') {
                songs[i] = new Song(inList.getLine(i),outputFolder,"mp3",preserveMode,logger,noNumbers);
                outList.append(songs[i].getLocalizedName());
            }
            else
                outList.append(inList.getLine(i));
        }
	}
	
	/*
        Methods
    */
	public static void displayHelp(String s) { // Overloaded method for logging a fatal message before displaying help
		try {
			logger.log(s,4);
		} catch(IOException e) {
			System.err.println("Log threw an error!: " + e.getMessage());
		}
		displayHelp();
	}
	
    public static void displayHelp() {
        String help = "M3U2USB - A program to convert and centralize music files in an M3U (or text based) playlist\n\n"
                    + "Usage: ./M3U2USB [options] <inputFile> <outputFolder>\n"
                    + "\n"
                    + "Options:\n"
                    + " -h | --help              : Display this help message and exit\n"
                    + " -v | --verbose [super]   : Enables verbose logging messages\n"
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
    
    public static String toLower(String s) {
        StringBuilder b = new StringBuilder(s), c = new StringBuilder();
        for (int i = 0; i < b.length(); i++)
            c.append(Character.toLowerCase(b.charAt(i)));
        return c.toString();
    }
    
    public static boolean contains(String s, String a[]) {
        for (int i = 0; i < a.length; i++)
            if (s.equals(a[i]))
                return true;
        return false;
	}
    
    public static void processArgs(String args[]) throws IOException {
        int i = args.length, j = 0;
        boolean override = false;
        while (i > 0) {
            switch(toLower(args[j])) {
                case "-h":
                case "--help":
                    logger.log("Displaying help and exiting...");
                    displayHelp();
                    System.exit(0);
                    break;
                case "-v":
                case "--verbose":
                    if (toLower(args[j+1]) == "super") {
                        logger.superVerbose();
                        logger.log("Super verbose mode enabled!");
                        j++;
                    } 
                    else {
                        logger.verbose();
                        logger.log("Verbose mode enabled!");
                    }
                    break;
                case "-n":
                case "--nonumbers":
                    logger.log("No-numbers mode enabled!");
                    noNumbers = true;
                    break;
                case "-m":
                case "--playlistMode":
                    logger.log("Enabling playlist mode, and setting override for preserve level!");
                    preserveMode = 'p';
                    override = true;
                    break;
                case "-p":
                case "--preserve":
                    if (override)
                        logger.log("Option " + args[j] + " has been overridden, ignoring!",3);
                    else if ( j+1 == args.length ) {
                        logger.log("Invalid number of arguments given! Please fix and re-run!",4);
                        displayHelp();
                        System.exit(1);
                    }
                    else if (!contains(toLower(args[j+1]),validPreserveModes)) {
                        logger.log("Invalid preserve mode given (" + args[j+1] + ")! Please fix and re-run!",4);
                        displayHelp();
                        System.exit(1);
                    }
                    else {
                        switch(toLower(args[j+1])) {
                            case "b":
                            case "album":
                                logger.log("Setting preserve mode to album!");
                                preserveMode = 'b';
                                break;
                            case "a":
                            case "artist":
                                logger.log("Setting preserve mode to artist!");
                                preserveMode = 'a';
                                break;
                            case "n":
                            case "none":
                                logger.log("Setting preserve mode to none!");
                                preserveMode = 'n';
                                break;
                            case "p":
                            case "parent":
                                logger.log("Enabling playlist mode (parent preserve mode) and enabling override!",2);
                                override = true;
                                preserveMode = 'p';
                                break;
                            default:
                                logger.log("An unknown option got (" + toLower(args[j+1]) + ") got through the filter! Please fix and re-run!",4);
                                displayHelp();
                                System.exit(1);
                        }
                        j++;
                    }
                    break;
                default:
                    logger.log("Unknown option " + args[j] + " given! Exiting, please fix and re-run!",4);
                    displayHelp();
                    System.exit(1);
                }//switch
                j++;
                i--;
                
                
                if (args.length < 2) {
                    logger.log("Two arguments are required, " + args.length + " were given! Please fix and re-run!",4);
                    displayHelp();
                    System.exit(1);
                }
                else if (args.length == 2) {
                    inputFile = args[j];
                    outputFolder = args[j+1]; // Making assumptions, but will be error checked later
                    return;
                }
            }//while
    }//processArgs()
}
