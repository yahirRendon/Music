package com.example.android.music;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yahir on 6/24/2018.
 */

public class NPwordAdapter extends ArrayAdapter<Song> {

    public NPwordAdapter(Activity context, ArrayList<Song> songs) {
        /**
         * Here we initialize the ArrayAdapter's internal storage for the context and the list.
         * The second argument is used when the ArrayAdapter is populating a single TextView.
         * Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
         * going to use this second argument, so it can be any value. Here, we used 0.
         */
        super(context, 0, songs);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Check if the existing view is being reused, otherwise inflate the view
        View nowPlayingItem = convertView;
        if(nowPlayingItem == null) {
            nowPlayingItem = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, parent, false);
        }
        //Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        //Find the TextView in the list_item.xml layout with the ID songTitle_text_view
        TextView songTextView = (TextView)nowPlayingItem.findViewById(R.id.songTitleNP_text_view);
        //Get the song title from the current Song object and set this text
        songTextView.setText(currentSong.getSongTitle());

        //Find the TextView in the list_item.xml layout with the ID songArtist_text_view
        TextView artistTextView = (TextView)nowPlayingItem.findViewById(R.id.songArtistNP_text_view);
        //Get the artist name from the current Song object and set this text
        artistTextView.setText(currentSong.getSongArtist());

        //Find the TextView in the list_item.xml layout with the ID songAlbum_text_view
        TextView albumTextView = (TextView)nowPlayingItem.findViewById(R.id.songAlbumNP_text_view);
        //Get the album name from the current Song object and set this text
        albumTextView.setText("Album: " + currentSong.getSongAlbum());

        return nowPlayingItem;
    }
}

