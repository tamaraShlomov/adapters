package il.co.hyperactive.tabim_example;

/**
 * Created by Tom on 26/03/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/********* Adapter class extends with BaseAdapter***********/
public class CustomAdapter implements ListAdapter {
    Context context;
    ArrayList<Post> posts;
    public CustomAdapter(Context context,ArrayList<Post> posts)
    {
        this.context = context;
        this.posts = posts;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }


    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if(convertView == null)
        {
            v = ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.line_content,null);
        }
        else
        {
            v = convertView;
        }
        Post currentPhoto = posts.get(position);
        ((ImageView)v.findViewById(R.id.profilePicture)).setImageDrawable(
                context.getResources().getDrawable(currentPhoto.getProfileImageid()));
        ((TextView)v.findViewById(R.id.studentName_textView)).setText(currentPhoto.getStudentName());
        ((TextView)v.findViewById(R.id.post_textView)).setText(currentPhoto.getDisc());
        ((ImageView)v.findViewById(R.id.bigImage)).setImageDrawable(
                context.getResources().getDrawable(currentPhoto.getBigImageid()));

        return v;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return posts.size() == 0;
    }
}
