package com.example.android.wroclawtour;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class Hotels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sights);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Best Western", "Kiełbaśnicza 16-19, Stare Miasto\n" +
                "Phone:+48 778 954 214\n", R.drawable.best_western, "geo:51.1124849, 17.0299593"));
        words.add(new Word("Campanille", "ul. Jagiełły 7, Śródmieście\n" +
                "Phone:+48 789 521 685\n", R.drawable.campanille, "geo:51.1167056, 17.0260999"));
        words.add(new Word("Piast", "Piłsudskiego 98, Stare Miasto\n" +
                "Phone:+48 512 563 589\n", R.drawable.piast, "geo:51.1001248, 17.0356911"));
        words.add(new Word("Sky Tower", "Powstańców Śląskich 95, Krzyki\n" +
                "Phone:+48 858 452 356\n", R.drawable.sky_tower, "geo:51.0944615, 17.0198436"));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(word.getPositionOnMap()));
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
            }

        });

    }
}