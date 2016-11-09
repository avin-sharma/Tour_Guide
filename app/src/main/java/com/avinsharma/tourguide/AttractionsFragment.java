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
public class AttractionsFragment extends Fragment {


    public AttractionsFragment() {
        // Required empty public constructor
    }

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attractions, container, false);

        ArrayList<Place> places = generateData();
        PlaceAdapter adapter = new PlaceAdapter(getContext(), places);
        listView = (ListView) view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Place place = (Place) listView.getAdapter().getItem(i);
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("place", place);
                startActivity(intent);
            }
        });
        return view;
    }

    private ArrayList<Place> generateData() {
        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.attraction_0), R.drawable.sabarmat_ashram,getString(R.string.attraction_description_0), getString(R.string.attraction_address_0)));
        places.add(new Place(getString(R.string.attraction_1),R.drawable.vastrapur_lake,getString(R.string.attraction_description_1),getString(R.string.attraction_address_1)));
        places.add(new Place(getString(R.string.attraction_2),R.drawable.manek_chok,getString(R.string.attraction_description_2),getString(R.string.attraction_address_2)));
        places.add(new Place(getString(R.string.attraction_3),R.drawable.rani_no_hajiro,getString(R.string.attraction_description_3),getString(R.string.attraction_address_3)));
        places.add(new Place(getString(R.string.attraction_4),R.drawable.nagina_wadi,getString(R.string.attraction_description_4),getString(R.string.attraction_address_4)));

        return places;
    }

}
