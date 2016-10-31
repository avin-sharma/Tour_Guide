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
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hotels, container, false);

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
        places.add(new Place("Ginger Hotel",R.drawable.ginger_hotel,"Ginger Ahmedabad rooms have been thoughtfully designed keeping in mind the needs of a business & leisure traveller. All rooms are equipped with comfortable bed and world class amenities which makes Ginger Hotel Ahmedabad one of the finest budget hotels in Ahmedabad.","Ginger Hotel Ahmedabad, Behind Himalaya Mall, Drive-In road, Ahmedabad - 380 015"));
        places.add(new Place("Hyatt Regency",R.drawable.hyatt_hotel,"Hyatt Regency Ahmedabad features 210 generously sized luxury rooms including 18 suites and one Presidential Suite. Guestrooms range from 33 to 150 square meters, with rich woods and textures, innovative materials and warm colours are the hallmarks of their design. These guestrooms offer the latest services and facilities to meet the needs of today’s travellers. ","Hyatt Regency Ahmedabad\n" +
                "17/A, Ashram Road\n" +
                "Ahmedabad,  India, 380014\n" +
                "Tel: +91 79 4017 1234"));
        places.add(new Place("The Fern",R.drawable.fern_hotel,"A business hotel in Ahmedabad , The Fern, is Gujarat’s first ecotel. A contemporary hotel of 96 rooms and suites, the hotel is an elegant combination of European linear design and the deep roots of the traditional Gujarati themes. The hotel’s award-winning experience includes an exclusive club service, executive lounge, spa and indoor swimming pool.","Nr. Sola Overbridge, S.G. Highway,, Ahmedabad Gujrat India -380054\n" +
                "\n" +
                "The Fern An Ecotel Hotel, Ahmedabad"));
        places.add(new Place("Fortune Landmark",R.drawable.fortune_hotel,"Conveniently located in the heart of the city, Fortune Landmark is an upscale, contemporary business hotel in Ahmedabad. The hotel offers first class services and facilities, combining comfort of home with Fortune Hotels’ efficient service.","Fortune Landmark, Ahmedabad\n" +
                "Ashram Road, Ahmedabad - 380013, Gujarat"));
        places.add(new Place("Ramada",R.drawable.ramada_hotel,"Our hotel features 2 meeting rooms, which can be arranged to accommodate 110 conference guests or 400 banquet guests. Plan your next meeting or special event with us. We also arrange great rates for groups — large or small.","Ramada Ahmedabad\n" +
                "Corporate Road, , Ahmedabad, 380015 IN\n" +
                "9-191-794-0250000"));
        return places;
    }

}
