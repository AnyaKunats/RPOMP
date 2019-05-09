package com.example.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.recyclerview.MainActivity.EXTRA_COMMENTS;
import static com.example.recyclerview.MainActivity.EXTRA_CREATOR;
import static com.example.recyclerview.MainActivity.EXTRA_FAVORITES;
import static com.example.recyclerview.MainActivity.EXTRA_LIKES;
import static com.example.recyclerview.MainActivity.EXTRA_URL;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String ImageUrl = intent.getStringExtra(EXTRA_URL);
        String creatorName = intent.getStringExtra(EXTRA_CREATOR);
        int likeCount = intent.getIntExtra(EXTRA_LIKES, 0);
        int favoritesCount = intent.getIntExtra(EXTRA_FAVORITES, 0);
        int commentsCount = intent.getIntExtra(EXTRA_COMMENTS, 0);

        ImageView imageView = findViewById(R.id.image);
        TextView creator = findViewById(R.id.text);
        TextView like = findViewById(R.id.text_like);
        TextView favorites = findViewById(R.id.text_favorites);
        TextView comments = findViewById(R.id.text_comments);

        Picasso.get().load(ImageUrl).fit().centerInside().into(imageView);
        creator.setText("User: " + creatorName);
        like.setText("Likes: " + likeCount);
        favorites.setText("Favorites: " + favoritesCount);
        comments.setText("Comments: " + commentsCount);

    }
}
