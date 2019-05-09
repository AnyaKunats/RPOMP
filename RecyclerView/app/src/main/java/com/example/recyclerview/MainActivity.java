package com.example.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ExampleAdapter.onClickList {
    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;
    private RequestQueue mRequestQueue;
    public static final String EXTRA_URL = "imagwUrl";
    public static final String EXTRA_CREATOR = "creatorName";
    public static final String EXTRA_LIKES="likecount";
    public static final String EXTRA_FAVORITES="favoritesCount";
    public static final String EXTRA_COMMENTS="commentsCount";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mExampleList = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON() {
        String url = "https://pixabay.com/api/?key=12409410-c7d0541a5a10af5a04b49f3e9&q=image&image_type=photo&pretty=true";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject hit = jsonArray.getJSONObject(i);
                                String creatorName = hit.getString("user");
                                String imageUrl = hit.getString("webformatURL");
                                int likeCount = hit.getInt("likes");
                                int favoritesCount = hit.getInt("favorites");
                                int commentsCount = hit.getInt("comments");
                                mExampleList.add(new ExampleItem(imageUrl, creatorName, likeCount, favoritesCount, commentsCount));

                            }
                            mExampleAdapter = new ExampleAdapter(MainActivity.this, mExampleList);
                            mExampleAdapter.setOnClickListener(MainActivity.this);
                            mRecyclerView.setAdapter(mExampleAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }

    @Override
    public void onItemClic(int position) {
        Intent detalIntent=new Intent(this,DetailActivity.class);
        ExampleItem clickedItem=mExampleList.get(position);
        detalIntent.putExtra(EXTRA_URL, clickedItem.getmImageUrl());
        detalIntent.putExtra(EXTRA_CREATOR,clickedItem.getmCreator());
        detalIntent.putExtra(EXTRA_LIKES,clickedItem.getmLikes());
        detalIntent.putExtra(EXTRA_FAVORITES,clickedItem.getmFavorites());
        detalIntent.putExtra(EXTRA_COMMENTS,clickedItem.getmComments());
        startActivity(detalIntent);
    }
}
