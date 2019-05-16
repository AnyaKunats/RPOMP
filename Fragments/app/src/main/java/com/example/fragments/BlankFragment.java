package com.example.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import java.util.List;
import java.util.Objects;

public class BlankFragment extends Fragment implements ExampleAdapter.onClickList {
    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList = new ArrayList<>();
    private RequestQueue mRequestQueue;
    public static final String EXTRA_URL = "imagwUrl";
    public static final String EXTRA_CREATOR = "creatorName";
    public static final String EXTRA_LIKES = "likecount";
    public static final String EXTRA_FAVORITES = "favoritesCount";
    public static final String EXTRA_COMMENTS = "commentsCount";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mExampleAdapter);
        mRequestQueue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()));
        parseJSON();
        return view;
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
                            mExampleAdapter = new ExampleAdapter(getActivity(), mExampleList);
                            mExampleAdapter.setOnClickListener(getActivity());
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
        Intent detalIntent=new Intent(this,BlankFragment2);
        ExampleItem clickedItem=mExampleList.get(position);
        detalIntent.putExtra(EXTRA_URL, clickedItem.getImageUrl());
        detalIntent.putExtra(EXTRA_CREATOR,clickedItem.getCreator());
        detalIntent.putExtra(EXTRA_LIKES,clickedItem.getLikes());
        detalIntent.putExtra(EXTRA_FAVORITES,clickedItem.getFavorites());
        detalIntent.putExtra(EXTRA_COMMENTS,clickedItem.getComments());
        startActivity(detalIntent);
    }
}
