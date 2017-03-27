package il.co.hyperactive.tabim_example;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Tom on 26/03/2017.
 */
public class ImageAdapter extends BaseAdapter implements AdapterView.OnItemClickListener{
    private Context mContext;
    private ArrayList<Integer> mThumbIds;
    public ImageAdapter(Context c,ArrayList<Integer> mThumbIds) {
        mContext = c;
        this.mThumbIds=mThumbIds;
    }

    public int getCount() {
        return mThumbIds.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes

            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(150,150));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);



        } else {
            imageView = (ImageView) convertView;
        }
        if(mThumbIds.get(position)!=-1)
        imageView.setImageResource(mThumbIds.get(position));
        return imageView;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

    }
}