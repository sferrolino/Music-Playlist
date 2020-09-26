public class SongItem {
	
	// instance variables
	private String label ;
	private double time ;
	private String genre ;
	private String artist ;
	
	/**
	 	Constructs a song "item".
	 	@param genre the genre of the song.
	 	@param label the label of the song.
	 	@param time the time of the song.
	 */
	public SongItem(String genre, String label, double time, String artist) {
		this.genre = genre ;
		this.label = label ;
		this.time = time ;
		this.artist = artist ;
	}
	
	/**
	 	Sets the label for a song item.
	 	@param label the new label of the song item.
	 */
	public void setLabel(String label) {
		this.label = label ;
	}
	
	/**
	 	Gets the label of a song item.
	 	@return the label of a song item.
	 */
	public String getLabel() {
		return label ;
	}
	
	/**
 		Sets the time for a song item.
 		@param time the new time of the song item.
	 */
	public void settime(double time) {
		this.time = time ;
	}
	
	/**
 		Gets the time of a song item.
 		@return the time of a song item.
	 */
	public double gettime() {
		return time ;
	}
	
	/**
		Sets the genre for a song item.
		@param time the new genre of the song item.
	 */
	public void setgenre(String genre) {
		this.genre = genre ;
	}
	
	/**
 		Gets the genre of a song item.
 		@return the genre of a song item.
	 */
	public String getgenre() {
		return genre ;
	}
	
	public String getartist() {
		return artist ;
	}
}
