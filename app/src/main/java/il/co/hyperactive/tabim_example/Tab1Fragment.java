package il.co.hyperactive.tabim_example;

import android.support.v4.app.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Tab1Fragment extends Fragment {
    private ListView listView;
 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.tab1_view, container, false);
     // Get ListView object from xml
         listView = (ListView) V.findViewById(R.id.listStudents);

     // Defined Array values to show in ListView
     String[] values = new String[] { "Tamara","Bonder","moshe","michael","adi","matan","viktor","gilad","nitzan"
                                ,"Tamara","Bonder","moshe","michael","adi","matan","viktor","gilad","nitzan"};

     ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
             android.R.layout.simple_list_item_1, android.R.id.text1, values);

     // Assign adapter to ListView
     listView.setAdapter(adapter);
     return V;
    }
}