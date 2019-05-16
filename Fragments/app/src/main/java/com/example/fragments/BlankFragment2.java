package com.example.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import static com.example.fragments.BlankFragment.EXTRA_COMMENTS;
import static com.example.fragments.BlankFragment.EXTRA_CREATOR;
import static com.example.fragments.BlankFragment.EXTRA_FAVORITES;
import static com.example.fragments.BlankFragment.EXTRA_LIKES;
import static com.example.fragments.BlankFragment.EXTRA_URL;



public class BlankFragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_blank_fragment2, container, false);

        String ImageUrl = this.getArguments().getString("webformatURL");
        String creatorName = this.getArguments().getString("user");
        int likeCount = this.getArguments().getInt("likes");
        int favoritesCount = this.getArguments().getInt("favorites");
        int commentsCount = this.getArguments().getInt("comments");

        ImageView imageView = view.findViewById(R.id.image);
        TextView creator = view.findViewById(R.id.text);
        TextView like = view.findViewById(R.id.text_like);
        TextView favorites = view.findViewById(R.id.text_favorites);
        TextView comments = view.findViewById(R.id.text_comments);

        Picasso.get().load(ImageUrl).fit().centerInside().into(imageView);
        creator.setText("User: " + creatorName);
        like.setText("Likes: " + likeCount);
        favorites.setText("Favorites: " + favoritesCount);
        comments.setText("Comments: " + commentsCount);

        return view;
    }

}
