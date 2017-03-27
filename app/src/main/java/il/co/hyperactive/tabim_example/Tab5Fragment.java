package il.co.hyperactive.tabim_example;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tom on 27/03/2017.
 */

public class Tab5Fragment extends Fragment {


    private RecyclerView mPhotoRecyclerView;
    private ArrayList<Integer> mThumbIds;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    /*
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    while(true) {
                        sleep(1000);
                        handler.post(this);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
*/
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab5_view, container, false);
        this.initArrayIds();
        mPhotoRecyclerView = (RecyclerView) v
                .findViewById(R.id.recyclerView_gridView);
        mPhotoRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 8));
       // mPhotoRecyclerView.setAdapter(new PhotoAdapter(mThumbIds));
        return v;
    }

    private void setupAdapter() {
        if (isAdded()) {
            mPhotoRecyclerView.setAdapter(new PhotoAdapter(mThumbIds));
        }
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
    private class PhotoHolder extends RecyclerView.ViewHolder {
        private final ImageView mItemImageView;

        public PhotoHolder(View itemView) {
            super(itemView);
            mItemImageView = (ImageView) itemView
                    .findViewById(R.id.chess_icon);
        }

        public void bindDrawable(Drawable drawable) {
            mItemImageView.setImageDrawable(drawable);

        }

       /* public void bindGalleryItem(GalleryItem galleryItem) {
            Picasso.with(getActivity())
                    .load(galleryItem.getUrl())
                    .placeholder(R.drawable.bill_up_close)
                    .into(mItemImageView);
        } */

    }

    private class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder> {
        private List<Integer> photosids;

        public PhotoAdapter(List<Integer> photosids) {
            this.photosids = photosids;
        }

        @Override
        public PhotoHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.line_image, viewGroup, false);
            return new PhotoHolder(view);

        }

        @Override
        public void onBindViewHolder(PhotoHolder photoHolder, int position) {
            Integer photoid = photosids.get(position);
            //photoHolder.bindGalleryItem(galleryItem);
            if(photoid!=-1)
            photoHolder.bindDrawable(getResources().getDrawable(photoid));

        }

        @Override
        public int getItemCount() {
            return photosids.size();
        }

    }
}