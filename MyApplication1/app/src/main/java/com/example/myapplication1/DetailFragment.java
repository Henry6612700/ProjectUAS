package com.example.myapplication1;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    TextView name,detail;
    ImageView image;
    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.name);
        detail = view.findViewById(R.id.detail);
        image = view.findViewById(R.id.imageRumah);
//        And this is how you retrieve it
        String placeName = getArguments().getString("name");
        String placeDetail = getArguments().getString("detail");
        String placeImage = getArguments().getString("image");
//        Set the text and image
        name.setText(placeName);
        detail.setText(placeDetail);
        Picasso.get().load(placeImage).into(image);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

}
