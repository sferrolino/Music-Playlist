import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;

import javax.swing.JTextArea;

public class SongPlaylist {
	
	private LinkedList<SongItem> myItems ;
	NumberFormat decimal = new DecimalFormat("#0.00") ; //to format the decimal
	
	/**
	 	Constructs a playlist.
	 */
	public SongPlaylist() {
		myItems = new LinkedList<SongItem>() ;
	}
	
	/**
	 	Adds an item to this playlist.
	 	@param item the item being added.
	 */
	public void scanItem(SongItem item) {
		myItems.add(item) ;
	}
	
	/**
	 	Clears the items.
	 */
	public void clear() {
		myItems = new LinkedList<SongItem>() ;
	}
	
	//displays song in playlist one at a time
	public String displaySong(SongItem item)
	{
		String t = "";
		String a = "";
		String g = "";
		String format = "";
		/*
		for(SongItem i: myItems)
		{
			t = i.getLabel();
			a = i.getartist();
			g = i.getgenre();
			
		}*/
		t = item.getLabel();
		a = item.getartist();
		g = item.getgenre();
		
		format = "\n\nTITLE:	" + t + "\n\nARTIST:	" + a + "\n\nGENRE:	" + g;
		return format;
	}
	
	/**
	 	Displays the times of the songs.
	 	@param area the JTextArea in the frame.
	 */
	public void displayAll(JTextArea area) {
		String description = "" ;
		double totaltime=0;
		String timeInMinutes="";
		for (SongItem i : myItems) {
			 
			 //Formats the song's time so that it is presented in minutes not decimals (ex. 6.06 -> 06:06)
			 timeInMinutes= Double.toString(i.gettime());
			 timeInMinutes=timeInMinutes.replace(".", ":");
			 if(timeInMinutes.length()<=4) { timeInMinutes= "0" + timeInMinutes; }
			 if(timeInMinutes.length()==4) { timeInMinutes= timeInMinutes + "0"; }
			 
			 if(i.getLabel() == "Old Town Road" || i.getLabel().length() > 14)
				 description += i.getLabel() + "	" + timeInMinutes + "\n\n" ;
			 else
				 description += i.getLabel() + "		" + timeInMinutes + "\n\n" ;	
			 totaltime+= i.gettime();
		}
		
		String dateTime = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy").format(Calendar.getInstance().getTime()) ;
		String totalSongTime = decimal.format(totaltime);
		totalSongTime = totalSongTime.replace(".", ":");
		String totalSongTimeLeft = decimal.format(180-totaltime);
		totalSongTimeLeft = totalSongTimeLeft.replace(".", ":");
		description+="\n----------------------------------------------------------\nTotal Song Time:     " + totalSongTime + " min" + "\n\n"  ;
		description+="Total Song Time Left:     " + totalSongTimeLeft + " min" + "\n\n" ;
		description+=dateTime;
		description+="\n----------------------------------------------------------\n";
		area.setText(description) ;
		
	}
	
	/**
  	Removing the last song item added to the playlist.
    */
	public void removeTopItemRegister() { 
		LinkedList<SongItem> mySongsCopy = new LinkedList<SongItem>() ;
		mySongsCopy.addAll(myItems) ;
		if(!myItems.isEmpty()) { myItems.removeLast();}
		
	}
}
