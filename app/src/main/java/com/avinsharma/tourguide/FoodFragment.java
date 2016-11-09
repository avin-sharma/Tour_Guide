package com.avinsharma.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food, container, false);

        ArrayList<Place> places = generateData();
        PlaceAdapter adapter = new PlaceAdapter(getContext(),places);
        listView =(ListView) view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Place place =(Place) listView.getAdapter().getItem(i);
                Intent intent = new Intent(getContext(),DetailsActivity.class);
                intent.putExtra("place",place);
                startActivity(intent);
            }
        });
        return view;
    }

    private ArrayList<Place> generateData(){
        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.food_0),R.drawable.gordhan_thaal,getString(R.string.food_cuisine_0),getString(R.string.food_description_0),getString(R.string.food_address_0    )));
        places.add(new Place(getString(R.string.food_1),R.drawable.java,getString(R.string.food_cuisine_1),getString(R.string.food_description_1),getString(R.string.food_address_1)));
        places.add(new Place(getString(R.string.food_2),R.drawable.spezia,getString(R.string.food_cuisine_2),getString(R.string.food_description_2),getString(R.string.food_address_2)));
        places.add(new Place(getString(R.string.food_3),R.drawable.hoglatto,getString(R.string.food_cuisine_3),getString(R.string.food_description_3),getString(R.string.food_address_3)));
        return places;
    }

}
