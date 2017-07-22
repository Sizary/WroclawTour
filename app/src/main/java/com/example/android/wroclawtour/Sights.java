package com.example.android.wroclawtour;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Sights extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sights);

        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.market_square), getString(R.string.market_square_description), R.drawable.rynek, "geo:51.1111606, 17.0384867"));
        locations.add(new Location(getString(R.string.ostrow_tumski), getString(R.string.ostrow_tumski_description), R.drawable.ostrow_tumski, "geo:51.1144633, 17.0467344"));
        locations.add(new Location(getString(R.string.panorama), getString(R.string.panorama_raclawicka_description), R.drawable.panorama_raclawicka, "geo:51.1101287, 17.0443431"));
        locations.add(new Location(getString(R.string.fountain), getString(R.string.wroclaw_fountain_description), R.drawable.fontanna, "geo:51.108763, 17.078923"));

        // Create an {@link LocationAdapter}, whose data source is a list of {@link Location}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(this, locations, R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link LocationAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Location} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                // Get the {@link Location} object at the given position the user clicked on
                Location location = locations.get(position);

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(location.getPositionOnMap()));
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
            }

        });

    }
}