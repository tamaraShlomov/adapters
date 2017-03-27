package il.co.hyperactive.tabim_example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Tom on 26/03/2017.
 */public class Tab4Fragment extends Fragment {
    //private GridView gridView;
    ArrayList<Integer> mThumbIds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.tab4_view, container, false);
        GridView gridview = (GridView) V.findViewById(R.id.gridView1);
        // references to our images
        this.initArrayIds();

        gridview.setAdapter(new ImageAdapter(getActivity(),mThumbIds));

   /*    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(), "position=" + position+" ,id="+id,
                        Toast.LENGTH_SHORT).show();
                /////
                Log.e("position",position+"");
                Log.e("id",id+"");

                ////
            }
        });*/
        return V;
    }

    private void initArrayIds() {

             mThumbIds = new ArrayList<>(Arrays.asList(
            R.drawable.bbishop, R.drawable.bbishop, R.drawable.bbishop,
                    R.drawable.bqueen, R.drawable.bking, R.drawable.bbishop,
                    R.drawable.bbishop, R.drawable.bbishop,
                    R.drawable.bpawn,R.drawable.bpawn,
                    R.drawable.bpawn,R.drawable.bpawn,
                    R.drawable.bpawn,R.drawable.bpawn,
                    R.drawable.bpawn,R.drawable.bpawn));


        for(int i=1;i<=4;i++)
            for(int j=1;j<=8;j++)
                mThumbIds.add(-1);

        mThumbIds.addAll(Arrays.asList( R.drawable.wpawn,R.drawable.wpawn,
                R.drawable.wpawn,R.drawable.wpawn,
                R.drawable.wpawn,R.drawable.wpawn,
                R.drawable.wpawn,R.drawable.wpawn,
                R.drawable.wpawn, R.drawable.wpawn, R.drawable.wpawn,
                R.drawable.wqueen, R.drawable.wking, R.drawable.wpawn,
                R.drawable.wpawn, R.drawable.wpawn
               ));

    }
}