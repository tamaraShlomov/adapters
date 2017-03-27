package il.co.hyperactive.tabim_example;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Tom on 26/03/2017.
 */

public class Tab2Fragment extends Fragment {
    private ListView listView;
    private CustomAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.tab2_view, container, false);
        // Get ListView object from xml
        listView = (ListView) V.findViewById(R.id.listInfo);
        ArrayList<Post> arrayOfUsers =initPostArray();
        //Resources res =getResources();
        adapter=new CustomAdapter(getActivity(),arrayOfUsers);
        listView.setAdapter(adapter);
        return V;
    }

    public ArrayList<Post> initPostArray(){
        ArrayList<Post> arr = new ArrayList<Post>();
        Post post1=new Post(R.drawable.tomhike,"Tom","first post bla bla bla",R.drawable.yumm);
        Post post2=new Post(R.drawable.adi,"bonder","second post bla bla bla",R.drawable.cat2);
        Post post3=new Post(R.drawable.micha,"michael","third post bla bla bla",R.drawable.cat5);
        arr.add(post1);
        arr.add(post2);
        arr.add(post3);
        return arr;
    }
}
