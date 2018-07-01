package com.example.android.music;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {
    TextView nowPlaying;
    TextView footerText;
    ArrayList songs = MainActivity.songs;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        onInitialize(); //Run onInitialize method

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter adapter =
                new WordAdapter(this, songs);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_listyout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        //Set onClickListener for MainActivity view
        nowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create a new intent to open the {@link MainActivity}
                Intent nowPlayingIntent = new Intent(PlaylistActivity.this, MainActivity.class);
                nowPlayingIntent.putExtra("moodValue", progress);
                //Start the new activity
                startActivity(nowPlayingIntent);
            }
        });
    }

    /**
     * Run this method onCreate
     */
    public void onInitialize() {
        nowPlaying = (TextView)findViewById(R.id.nowPlayingText);
        footerText = (TextView)findViewById(R.id.footer_text);
        progress = getIntent().getIntExtra("moodValue", progress); //update progress value from MainActivity
    }

}
