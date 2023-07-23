import java.util.LinkedList;

class Song {
    // The Song class is expected to contains information about a particular song,
    // such as its title, artist, and duration.
}

public class musicplaylist {
    // In this specific case, <Song> indicates that the LinkedList named songs will
    // store objects of the Song class.
    private LinkedList<Song> songs;

    // Constructor
    public musicplaylist() {
        // Task: Initialize the LinkedList to store songs
        // Hint: Use the LinkedList constructor without parameters
    }

    // Method to add a song at the beginning of the playlist
    public void addSongAtBeginning(Song song) {
        // Task: Add the given song at the beginning of the playlist
        // Hint: Use the appropriate LinkedList method
    }

    // Method to add a song at the end of the playlist
    public void addSongAtEnd(Song song) {
        // Task: Add the given song at the end of the playlist
        // Hint: Use the appropriate LinkedList method
    }

    // Method to remove a song from the playlist by its title
    public void removeSongByTitle(String title) {
        // Task: Remove the song with the given title from the playlist
        // Hint: Use an iterator to iterate through the songs and remove the song with
        // the matching title
    }

    // Method to remove songs from the playlist by artist name
    public void removeSongsByArtist(String artist) {
        // Task: Remove all songs with the given artist name from the playlist
        // Hint: Use an iterator to iterate through the songs and remove the songs with
        // the matching artist name
    }

    // Method to play the current song
    public void playCurrentSong() {
        // Task: Play the song at the current index in the playlist
        // Hint: Use the currentSongIndex variable to keep track of the current index
    }

    // Method to play the next song
    public void playNextSong() {
        // Task: Play the next song in the playlist
        // Hint: Increment the currentSongIndex to move to the next song, and then call
        // playCurrentSong() method
    }

    // Method to play the previous song
    public void playPreviousSong() {
        // Task: Play the previous song in the playlist
        // Hint: Decrement the currentSongIndex to move to the previous song, and then
        // call playCurrentSong() method
    }

    // Method to display the playlist
    public void displayPlaylist() {
        // Task: Display the details of all songs in the playlist
        // Hint: Use a loop to iterate through the songs and print their details
    }

    // Method to shuffle the playlist
    public void shufflePlaylist() {
        // Task: Shuffle the order of songs in the playlist
        // Hint: Use the Collections.shuffle() method to shuffle the LinkedList
    }

    // Method to search for a song by its title or artist and play it
    public void searchAndPlay(String searchQuery) {
        // Task: Search for a song by its title or artist in the playlist and play it
        // Hint: Use a loop to iterate through the songs and check for matches with the
        // searchQuery
    }

    // Method to create and play a custom playlist based on specific criteria
    public void createAndPlayCustomPlaylist(double durationLimit) {
        // Task: Create and play a custom playlist based on a duration limit
        // Hint: Use a loop to iterate through the songs and add them to the custom
        // playlist until the duration limit is reached
    }

}
