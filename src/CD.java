
public class CD {
	
	private String language, album, name, composer, artist, year, tracksPerCD;
	private int noOfCds;

	public CD(String language, String album, String name, String composer,
			String artist, String year, String tracksPerCD,int noOfCds) {
		this.language = language;
		this.album = album;
		this.name = name;
		this.composer = composer;
		this.artist = artist;
		this.year = year;
		this.tracksPerCD = tracksPerCD;
		this.noOfCds = noOfCds;
		
	}
	
	public void setLanguage(String language){
		this.language = language;
	}
	public String getLanguage() {
		return language;
	}

	public String getAlbum() {
		return album;
	}

	public String getName() {
		return name;
	}

	public String getComposer() {
		return composer;
	}

	public String getArtist() {
		return artist;
	}

	public String getYear() {
		return year;
	}

	public String getTracksPerCD() {
		return tracksPerCD;
	}
	public void setNoOfCDs(int noOfCds){
		this.noOfCds = noOfCds;
	}
	public int getNoOfCds(){
		return noOfCds;
	}

	public void printCD() {
		
		System.out.print("   Language: " + getLanguage());
		System.out.print(",\t     Album: " + getAlbum());
		System.out.print(",\t\t\t  Name: " + getName());
		System.out.print(",\t     Composer: " + getComposer());
		System.out.print(",\t     Artist: " + getArtist());
		System.out.print(",\t     Year: " + getYear());
		System.out.print(",\t     Tracks per CD: " + getTracksPerCD());
		System.out.print(",\t     No of CDs: " + getNoOfCds());		
		System.out.println();
	}
	
	public String getStandardData(){
		return getLanguage()+","+getAlbum()+","+getName()+","+getComposer()+","+getArtist()+","+getYear()+","+getTracksPerCD()+","+getNoOfCds()+String.format("%n");
	}
}
