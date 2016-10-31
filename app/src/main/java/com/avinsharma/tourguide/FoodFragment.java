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
        places.add(new Place("Gordhan Thaal",R.drawable.gordhan_thaal,"Gujarati","11 AM to 3 PM, 7 PM to 10:30 PM" +
                "\nVegetarian Only" +
                "\n₹600 for two people (approx.)","Ground Floor, Sapath Complex, Opposite Rajpath Club, S G Highway, Satellite, Ahmedabad\n" +
                "079 26871222\n" +
                "079 26873555\n" +
                "079 26871222"));
        places.add(new Place("Java++ - Courtyard By Marriott",R.drawable.java,"Cafe","6:30AM to 11:45PM\n" +
                "₹1,000 for two people (approx.)","Courtyard By Marriott, Ramdevnagar Cross Road, Satellite, Ahmedabad\n" +
                "079 30920625"));
        places.add(new Place("Spezia Bistro & Grills House",R.drawable.spezia,"European, Mexican, Italian","11 AM to 11 PM\n" +
                "₹1,300 for two people (approx.)","Ground Floor, Acropolis Mall, S.G Highway, Thaltej, Ahmedabad\n" +
                "079 30920346\n" +
                "Table booking recommended"));
        places.add(new Place("Hoglatto",R.drawable.hoglatto,"Desserts, Beverages","11 AM to 10:30 PM\n" +
                "₹250 for two people (approx.)","GF/8, Galaxy Bazaar Complex, Opposite Himalaya Mall, Sunrise Park Road, Vastrapur, Ahmedabad"));
        return places;
    }

}
