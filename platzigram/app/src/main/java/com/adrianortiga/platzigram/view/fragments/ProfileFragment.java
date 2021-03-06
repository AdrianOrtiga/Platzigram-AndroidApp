package com.adrianortiga.platzigram.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adrianortiga.platzigram.R;
import com.adrianortiga.platzigram.adapter.PictureAdapterRecyclerView;
import com.adrianortiga.platzigram.model.Picture;

import java.util.ArrayList;


public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        showToolbar("", false, view);

        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureProfileRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView picturesAdapterRecyclerView =
                new PictureAdapterRecyclerView(buildPictures(), R.layout.cardview_picture, getActivity());

        picturesRecycler.setAdapter(picturesAdapterRecyclerView);

        return view;
    }

    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("https://img.difoosion.com/wp-content/blogs.dir/28/files/2016/06/fondo5.jpg", "Adrian", "4 días", "1 Me gusta"));
        pictures.add(new Picture("https://img.difoosion.com/wp-content/blogs.dir/28/files/2016/06/fondo1.jpg", "Adrian", "4 días", "1 Me gusta"));
        pictures.add(new Picture("https://img.difoosion.com/wp-content/blogs.dir/28/files/2016/06/fondo2.jpg", "Adrian", "4 días", "1 Me gusta"));
        pictures.add(new Picture("https://img.difoosion.com/wp-content/blogs.dir/28/files/2016/06/fondo3.jpg", "Adrian", "4 días", "1 Me gusta"));
        pictures.add(new Picture("https://img.difoosion.com/wp-content/blogs.dir/28/files/2016/06/fondo4.jpg", "Adrian", "4 días", "1 Me gusta"));
        pictures.add(new Picture("https://img.difoosion.com/wp-content/uploads/2015/05/difoosion-ipadizate-600x600.jpg", "Adrian", "4 días", "1 Me gusta"));

        return pictures;
    }

    public void showToolbar(String tittle, boolean upButton, View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
