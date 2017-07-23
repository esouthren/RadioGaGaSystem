
package radioshowModel;

/**
 * Class to store information about Music Item in Radio Show
 * @author Eilidh Southren - 1513195
 */
public class Music extends Content{
    
    private String artist;
    private String songTitle;
    
    // Contructor
    public Music(int order, int seconds, String artist, String song) {
        super(order, seconds, "Music", true);
        this.artist = artist;
        this.songTitle = song;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }
    
    @Override
    public int calculateCost() {
        return 20;
    }

    @Override
    public String toString() {
        return super.toString() 
                + " . . . Artist: " + this.getArtist() 
                + " . . Song: " + this.getSongTitle();
    }
    
}
