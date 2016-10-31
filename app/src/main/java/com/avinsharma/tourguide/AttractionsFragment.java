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
        places.add(new Place("Sabarmati Ashram", R.drawable.sabarmat_ashram, "Sabarmati Ashram (also known as Gandhi Ashram, Harijan Ashram, or Satyagraha Ashram) is located in the Sabarmati suburb of Ahmedabad, Gujarat, adjoining the Ashram Road, on the banks of the River Sabarmati, four miles from the town hall. This was one of the residences of Mohandas Karamchand Gandhi, generally called Mahatma Gandhi, who lived there for about twelve years along with his wife, Kasturba Gandhi.\n" +
                "It was from his base here that Gandhi led the Dandi march also known as the Salt Satyagraha on 12 March 1930. In recognition of the significant influence that this march had on the Indian independence movement the Indian government has established the ashram as a national monument.", "Gandhi Smarak Sangrahalaya, Ahmedabad, Gujarat 380027"));
        places.add(new Place("Vastrapur Lake",R.drawable.vastrapur_lake,"Vastrapur Lake is situated in western part of Ahmedabad. It is officially named after Narsinh Mehta. The lake was beautified by the AMC after 2002 and has since become a popular spot in the city.\n" +
                "Every weekend, a large number of people visit this lake. It currently boasts an open-air theater and children's park. There is a pathway all around the lake which serves many walkers and joggers in the early mornings and in the evenings.\n" +
                "The lush green lawns surrounding this lake also serve as a central hub of Ahmedabad, wherein various cultural events take place regularly.","Vastrapur Lake, Vastrapur, Ahmedabad, Gujarat 380052"));
        places.add(new Place("Manek Chok",R.drawable.manek_chok,"This bustling open square near the center of the city functions as a vegetable market in the morning and a jewellery market in the afternoon, the second biggest in India, at an apparently 3 million rupees of annual turnover. It is most famous, however, for its food stalls that start to emerge around 9:30 in the evening and continue till late night, with various local street snacks. Manek chowk is best known for its Kulfi.","Manek Chowk, Khadia, Ahmedabad, Gujarat 380001"));
        places.add(new Place("Rani no Hajiro",R.drawable.rani_no_hajiro,"The courtyard contains eight marble tombs of queens of Ahmed Shah I and other Gujarat Sultanate rulers. They are elaborately carved and inlaid with work of mother-of-pearl and metal.\n" +
                "The principal tomb belongs to Mughalai Bibi, the wife of Muhammad Shah II and mother of Mahmud Begada. It is richly carved in white marble, and girt with a Persian inscription in minute relief. An adjacent tomb in black marble, once inlaid with mother-of-pearl, belongs to Mirki or Murki Bibi, the wife of Shah e Alam, the sister of queen and the daughter of Jam of Sindh. These tombs are covered with rich brocade works, the textile style developed during reign of Ahmed Shah I. The intricate stone tracery and carving is an amalgamation of Hindu, Jain, and Islamic architectural styles. Some Muslim families live inside complex which take care of the tombs","Gandhi Rd, Manek Chowk, Khadia, Ahmedabad, Gujarat 380001"));
        places.add(new Place("Nagina Wadi",R.drawable.nagina_wadi,"Nagina Wadi is a garden themed entertainment ground in the center of the circular Kankaria Lake at the Ahmedabad metropolitan area in Gujarat, India. Built for sole entertainment of the Mughal royals, Nagina Wadi is accessed by a straight, concrete, tree-lined walkway traversing half of the lake. In early 2009, the Ahmedabad Municipal Corporation (AMC) and AIL Amrapali Industries Limited ( Amrapali Group ) built and completed a large lighted musical fountain, featuring brilliant multicolored laser lights displayed during the night.","In Center of Kankaria Lake, Kankaria, Ahmedabad, Gujarat 380002"));

        return places;
    }

}
