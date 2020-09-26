import java.util.ArrayList ;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JTextArea;

public class SongList {
	
	LinkedList<SongItem> mySongs = new LinkedList<SongItem>() ;
	int currentIndex = -1 ;
	SongItem nextSong = null ;
	
	
	/**
	 	Adds items to the song list
	 	@param item the item to add to the song list
	 */
	public void addItem(SongItem item) {
		mySongs.add(item) ;
	}
	
	/**
	 	Creating different types of songs and adding them to the list.
	 */
	public void fill() {
		SongItem hello = new SongItem("Pop", "Hello", 6.06, "Hedley") ;
		addItem(hello) ;
		SongItem goingBad = new SongItem("Hip Hop", "Going Bad", 4.25, "Meek Mill") ;
		addItem(goingBad) ;
		SongItem oldTownRoad = new SongItem("Country", "Old Town Road", 2.38, "Lil Nas X") ;
		addItem(oldTownRoad) ;
		SongItem sucker = new SongItem("Pop", "Sucker", 3.20, "Jonas Brothers") ;
		addItem(sucker) ;
		SongItem myBad = new SongItem("R&B", "My Bad", 2.48, "Khalid") ;
		addItem(myBad) ;
		SongItem loveMe = new SongItem("Pop", "Love Me", 3.14, "Justin Bieber") ;
		addItem(loveMe) ;
		SongItem cool = new SongItem("Pop", "Cool", 3.04, "Jonas Brothers") ;
		addItem(cool) ;
		SongItem wow = new SongItem("Hip Hop", "Wow.", 2.38, "Post Malone") ;
		addItem(wow) ;
		SongItem ex = new SongItem("R&B", "EX", 3.43, "Kiana Lede") ;
		addItem(ex) ;
		SongItem killThisLove = new SongItem("KPop", "Kill This Love", 3.14, "BLACKPINK") ;
		addItem(killThisLove) ;
		SongItem suburbia = new SongItem("Rock", "Jesus of Suburbia", 9.08, "Green Day") ;
		addItem(suburbia) ;
		SongItem marvin = new SongItem("Hip Hop", "Marvin's Room", 5.47, "Drake") ;
		addItem(marvin) ;
		SongItem shhh = new SongItem("Jazz", "Shhh/Peaceful", 18.19, "Miles Davis") ;
		addItem(shhh) ;
	}
	
	public void clear() {
		mySongs = new LinkedList<SongItem>() ;
	}
	
	//All Songs
	public SongList getAllSongs(SongList songs) {
		SongList mySongs2 = new SongList();
		while (songs.hasNextSong()) {
			SongItem s = songs.getNextItemCart();
			mySongs2.addItem(s);
			songs.removeTopItem();
		}
		return mySongs2;

	}
	//Pop Songs
	public SongList getPopSongs(SongList songs) {

		SongList mySongs2 = new SongList();
		while (songs.hasNextSong()) {
			SongItem s = songs.getNextItemCart();
			if (s.getgenre().equals("Pop")) {
				mySongs2.addItem(s);
			}
			songs.removeTopItem();
		}
		return mySongs2;
	}
	
	public SongList getHipHopSongs(SongList songs) {

		SongList mySongs2 = new SongList();
		while (songs.hasNextSong()) {
			SongItem s = songs.getNextItemCart();
			if (s.getgenre().equals("Hip Hop")) {
				mySongs2.addItem(s);
			}
			songs.removeTopItem();
		}
		return mySongs2;
	}
	
	public SongList getRnBSongs(SongList songs) {

		SongList mySongs2 = new SongList();
		while (songs.hasNextSong()) {
			SongItem s = songs.getNextItemCart();
			if (s.getgenre().equals("R&B")) {
				mySongs2.addItem(s);
			}
			songs.removeTopItem();
		}
		return mySongs2;
	}
	
	public SongList getRockSongs(SongList songs) {

		SongList mySongs2 = new SongList();
		while (songs.hasNextSong()) {
			SongItem s = songs.getNextItemCart();
			if (s.getgenre().equals("Rock")) {
				mySongs2.addItem(s);
			}
			songs.removeTopItem();
		}
		return mySongs2;
	}
	
	public SongList getJazzSongs(SongList songs) {

		SongList mySongs2 = new SongList();
		while (songs.hasNextSong()) {
			SongItem s = songs.getNextItemCart();
			if (s.getgenre().equals("Jazz")) {
				mySongs2.addItem(s);
			}
			songs.removeTopItem();
		}
		return mySongs2;
	}
	
	//K-Pop Songs
	public SongList getKPopSongs(SongList songs) {

		SongList mySongs2 = new SongList();
		while (songs.hasNextSong()) {
			SongItem s = songs.getNextItemCart();
			if (s.getgenre().equals("KPop")) {
				mySongs2.addItem(s);
			}
			songs.removeTopItem();
		}
		return mySongs2;
	}
	
	/**
	  	Removing the song item from the list.
	  	@return a reference to the top song item that was removed.
	 */
	public SongItem removeTopItem() { 
		LinkedList<SongItem> mySongsCopy = new LinkedList<SongItem>() ;
		mySongsCopy.addAll(mySongs) ;
		mySongs.remove(0) ;
		return mySongsCopy.get(0) ; 
	}
	
	/**
	 	Goes through the list and displays them in the text area. 
	 	@param area to display the JTextArea
	 */
	public void display(JTextArea area) {
		String displayText = "" ;
		if (!mySongs.isEmpty()) {
			for (SongItem i : mySongs) {
				displayText += i.getLabel() + "\n\n" ;
			}
		}
		area.setText(displayText) ;
	}
	
	/**
 		Returns the next song item in the list (without removing it) for the playlist.
 		@return the next song item in the list.
	 */
	public SongItem getNextItemCart() {
		SongItem item = new SongItem("", "", 0, "") ;
		if (!mySongs.isEmpty()) {
			item = mySongs.get(0) ;
		}
		return item ;
	}
	
	public boolean hasNextSong() {
		if (!mySongs.isEmpty()) {return true;}
		else return false;
	}
	
	/**
	 	Resets the nextItem variable.
	 */
	
	public void resetNextItem() {
		mySongs.clear();
	}
	
}