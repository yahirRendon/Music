package com.example.android.music;

/**
 * Created by yahir on 6/20/2018.
 */

public class Song {
    //Song title
    private String mSongTitle;
    //Artist name
    private String mSongArtist;
    //Album title
    private String mSongAlbum;

    /**
     * Create a new Song object
     *
     * @param songTitle is the title of the song
     * @param songArtist is the song's artist
     * @param songAlbum is the album title
     */

    public Song(String songTitle, String songArtist, String songAlbum) {
        mSongTitle = songTitle;
        mSongArtist = songArtist;
        mSongAlbum = songAlbum;
    }

    public String getSongTitle() {
        return mSongTitle;
    }

    public String getSongArtist() {
        return mSongArtist;
    }

    public String getSongAlbum() {
        return mSongAlbum;
    }
}
