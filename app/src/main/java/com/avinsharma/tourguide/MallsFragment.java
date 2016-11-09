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
public class MallsFragment extends Fragment {


    public MallsFragment() {
        // Required empty public constructor
    }

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_malls, container, false);

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

        // Inflate the layout for this fragment
        return view;
    }

    private ArrayList<Place> generateData() {
        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.mall_0),R.drawable.apha_one,getString(R.string.mall_description_0),getString(R.string.mall_address_0)));
        places.add(new Place(getString(R.string.mall_1),R.drawable.himalaya_mall_ahmedabad,getString(R.string.mall_description_1),getString(R.string.mall_address_1)));
        places.add(new Place(getString(R.string.mall_2),R.drawable.iscon_mall,getString(R.string.mall_description_2),getString(R.string.mall_address_2)));

        return places;
    }
}
