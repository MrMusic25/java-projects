import java.util.Scanner;

public class M3U2USB {
	/*
        Global Variables
	*/
	public boolean copyDRM = true; // How to handle songs with DRM. true, just copy them over; false, skip the song and notify user
	
	/*
        Main
    */
	public static void main(String args[]) {
		// Using this program assume you have a music folder with the following structure:
		// ../Music/<Artist>/<Album>/<Song>
		displayHelp();
	}
	
	/*
        Methods
    */
    public static void displayHelp() {
        String help = "M3U2USB - A program to convert and centralize music files in an M3U playlist\n\n"
                    + "Usage: ./M3U2USB [options] <inputFile> <outputFolder>\n"
                    + "\n"
                    + "Options:\n"
                    + " -h | --help              : Display this help message and exit\n"
                    + " -v | --verbose           : Enables verbose logging messages\n"
                    + " -n | --noNumbers         : Deletes starting numbers in title for output (e.g \"01 Monster.mp3\" -> \"Monster.mp3\")\n"
                    + " -m | --playlistMode      : Overrides and sets preserve level to album; recreates parent Music folder and uses playlist files instead of directories for orginazation (see below)\n"
                    + " -p | --preserve <level>  : Indicates folder preservation level (see below)\n"
                    + "\n";
        System.out.println(help);
    }
}
