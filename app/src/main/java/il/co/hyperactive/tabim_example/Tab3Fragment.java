package il.co.hyperactive.tabim_example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 26/03/2017.
 */

public class Tab3Fragment extends Fragment {
    private ListView listView;
    private CustomAdapter adapter;
    private RecyclerView mCrimeRecyclerView;
    private PostAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3_view, container, false);
        mCrimeRecyclerView = (RecyclerView) view
                .findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }
    private void updateUI() {
        mAdapter = new PostAdapter(initPostArray());
        mCrimeRecyclerView.setAdapter(mAdapter);
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

    private class PostHolder extends RecyclerView.ViewHolder {
        public TextView mstudentname;
        public TextView mposttext;
        public ImageView mprofileImage;
        public ImageView mBigPicture;
        private Post mpost;

        public PostHolder(View itemView) {
            super(itemView);
            mstudentname = (TextView) itemView.findViewById(R.id.studentName_textView);
            mposttext = (TextView) itemView.findViewById(R.id.post_textView);
            mprofileImage = (ImageView) itemView.findViewById(R.id.profilePicture);
            mBigPicture = (ImageView) itemView.findViewById(R.id.bigImage);

        }

        public void bindPost(Post post) {
            mpost = post;
            mprofileImage.setImageDrawable(getActivity().getResources().getDrawable(mpost.getProfileImageid()));
            mstudentname.setText(mpost.getStudentName());
            mposttext.setText(mpost.getDisc());
            mBigPicture.setImageDrawable(getActivity().getResources().getDrawable(mpost.getBigImageid()));
        }
    }

    private class PostAdapter extends RecyclerView.Adapter<PostHolder> {
        private List<Post> mPosts;

        public PostAdapter(List<Post> posts) {
            mPosts = posts;
        }

        @Override
        public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.line_content, parent, false);
            return new PostHolder(view);
        }
        @Override
        public void onBindViewHolder(PostHolder holder, int position) {
            Post post = mPosts.get(position);
            holder.bindPost(post);
        }
        @Override
        public int getItemCount() {
            return mPosts.size();
        }
    }
}