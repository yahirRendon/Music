package com.example.android.music;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yahir on 6/20/2018.
 */

public class WordAdapter extends ArrayAdapter<Song> {

    public WordAdapter(Activity context, ArrayList<Song> songs) {
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
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        //Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        //Find the TextView in the list_item.xml layout with the ID songTitle_text_view
        TextView songTextView = (TextView)listItemView.findViewById(R.id.songTitle_text_view);
        //Get the song title from the current Song object and set this text
        songTextView.setText(currentSong.getSongTitle());

        //Find the TextView in the list_item.xml layout with the ID songArtist_text_view
        TextView artistTextView = (TextView)listItemView.findViewById(R.id.songArtist_text_view);
        //Get the artist name from the current Song object and set this text
        artistTextView.setText(currentSong.getSongArtist());

        //Find the TextView in the list_item.xml layout with the ID songAlbum_text_view
        TextView albumTextView = (TextView)listItemView.findViewById(R.id.songAlbum_text_view);
        //Get the ablum name from the current Song object and set this text
        albumTextView.setText("Album: " + currentSong.getSongAlbum());

        return listItemView;
    }
}

