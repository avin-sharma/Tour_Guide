 package com.avinsharma.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

 //Details screen Activity

 public class DetailsActivity extends AppCompatActivity {

     ImageView photo;
     TextView cuisine;
     TextView cuisineText;
     TextView name;
     TextView description;
     TextView address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        Place place = intent.getExtras().getParcelable("place");

        photo = (ImageView) findViewById(R.id.photo_image_view);
        cuisine = (TextView) findViewById(R.id.cuisine_text_view);
        cuisineText = (TextView) findViewById(R.id.cuisise_text);
        name = (TextView) findViewById(R.id.name_text_view);
        description = (TextView) findViewById(R.id.description_text_view);
        address = (TextView) findViewById(R.id.address_text_view);

        if (place != null) {
            Log.v("DetailsActivity", place.toString());
            //photo.setImageResource(place.getmImageviewResource());
            Picasso.with(getBaseContext()).load(place.getmImageviewResource()).fit().centerCrop().into(photo);
            name.setText(place.getmName());
            description.setText(place.getmDescription());
            address.setText(place.getmAddress());
            if (place.getmCuisine() != null){
                cuisineText.setVisibility(View.VISIBLE);
                cuisine.setVisibility(View.VISIBLE);
                cuisine.setText(place.getmCuisine());
            }
            else {
                cuisineText.setVisibility(View.GONE);
                cuisine.setVisibility(View.GONE);
            }
        }
    }
}
