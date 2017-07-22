package com.example.android.wroclawtour;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class Restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sights);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Przystan Restaurant", getString(R.string.przystan_restaurant_descryption), R.drawable.restauracja_przystan, "geo:51.0910664, 17.0322784"));
        words.add(new Word("Przedwojenna", getString(R.string.przedwojenna_restaurant_descryption), R.drawable.przedwojenna, "geo:51.1038326, 17.0573795"));
        words.add(new Word("Jadka Restaurant", getString(R.string.jadka_restaurant_descryption), R.drawable.restauracja_jadka, "geo:51.108029, 17.020205"));
        words.add(new Word("Piec na Szewskiej", getString(R.string.piec_restaurant_descryption), R.drawable.piec_na_szewskiej, "geo:51.1078852, 17.0385376"));

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