package com.example.android.music;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SeekBar moodBar;
    TextView nowPlaying;
    TextView playlist;
    TextView songNowPlaying;
    TextView artistNowPlaying;
    TextView albumNowPlaying;
    int progress;
    String moodStatus;
    public static ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onInitialize();

        //Set onClickListener for playlist view
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create a new intent to open the {@link PlaylistActivity.java}
                Intent numbersIntent = new Intent(MainActivity.this, PlaylistActivity.class);
                numbersIntent.putExtra("moodValue", progress);
                //Start the new activity
                startActivity(numbersIntent);
            }
        });

        //Set onSeekBarChangeListener for mood seekbar view
        moodBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                checkMood();
                createPlaylist();
                Toast.makeText(getBaseContext(), "Enjoy this " + moodStatus + " playlist", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Run this method onCreate
     */
    public void onInitialize() {
        moodBar = (SeekBar) findViewById(R.id.setMoodBar);
        nowPlaying = (TextView) findViewById(R.id.nowPlayingText);
        playlist = (TextView) findViewById(R.id.playlistText);
        songNowPlaying = (TextView)findViewById(R.id.songTitleNP_text_view);
        artistNowPlaying = (TextView)findViewById(R.id.songArtistNP_text_view);
        albumNowPlaying = (TextView)findViewById(R.id.songAlbumNP_text_view);
        progress = getIntent().getIntExtra("moodValue", progress);
        moodBar.setProgress(progress);
        songs = new ArrayList<Song>();
        createPlaylist();
    }

    /**
     * Check and set SeekBar progress
     */
    public void checkMood() {
        if (progress >= 0 && progress <= 3) {
            moodStatus = "sad";
        } else if (progress > 3 && progress < 7) {
            moodStatus = "chill";
        } else if (progress >= 7) {
            moodStatus = "happy";
        }
    }

    /**
     * Create Playlist based on mood progress
     */
    public void createPlaylist() {
    //Create a String array of songs
         if(progress >= 0 && progress <=3) {
         songs.clear();
            songs.add(new Song("Ekki Múkk", "Sigur Rós", "Valtari"));
            songs.add(new Song("I can Almost See You", "Hammock", "Raising Your Voice Trying to Stop an Echo"));
            songs.add(new Song("Quiet", "This Will Destroy You", "Young Mountains"));
            songs.add(new Song("Particles", "Ólafur Arnalds", "Island Songs"));
            songs.add(new Song("Hengilás", "Jónsi", "Go"));
            songs.add(new Song("Fljótavík", "Sigur Rós", "Með suð í eyrum við spilum endalaust"));
            getNowPlaying(0);

        } else if(progress >3 && progress < 7) {
         songs.clear();
            songs.add(new Song("Underflow", "Emma Louise", "Supercry"));
            songs.add(new Song("Ljósið", "Ólafur Arnalds", "Found Songs"));
            songs.add(new Song("Andvari", "Sigur Rós", "Takk..."));
            songs.add(new Song("Your Hand in Mine", "Explosions in the Sky", "The Earth Is Not a Cold Dead Place"));
            songs.add(new Song("Raising Your Voice... Trying to Stop an Echo", "Hammock", "Raising Your Voice Trying to Stop an Echo"));
            songs.add(new Song("Kolniður", "Jónsi", "Go"));
            getNowPlaying(0);
         } else {
         songs.clear();
            songs.add(new Song("Hoppípolla", "Sigur Rós", "Takk.."));
            songs.add(new Song("Walking with Happiness", "The Best Pessimist", "I Just Want to Be Your Everything"));
            songs.add(new Song("Near Light", "Ólafur Arnalds", "Living Room Songs"));
            songs.add(new Song("Go Do", "Jónsi", "Go"));
            songs.add(new Song("All Is Violent All Is Bright", "God Is an Astronaut", "All Is Violent All Is Bright"));
            songs.add(new Song("Animal Arithmetic", "Jónsi", "Go"));
            getNowPlaying(0);
        }
    }

    /**
     * Update Now Playing Views based on track
     *
     * @param track is the current song playing
     */
    public void getNowPlaying(int track) {
        songNowPlaying.setText(songs.get(track).getSongTitle());
        artistNowPlaying.setText(songs.get(track).getSongArtist());
        albumNowPlaying.setText(songs.get(track).getSongAlbum());

    }
}

