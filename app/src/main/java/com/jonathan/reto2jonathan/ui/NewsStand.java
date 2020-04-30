package com.jonathan.reto2jonathan.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jonathan.reto2jonathan.R;
import com.jonathan.reto2jonathan.adpater.RecyclerViewAdapater;
import com.jonathan.reto2jonathan.model.Category;

import java.util.ArrayList;
import java.util.List;

public class NewsStand extends Fragment {
    List<Category> categoryList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LayoutInflater lf = getActivity().getLayoutInflater();
        View view =  lf.inflate(R.layout.fragment_newsstand, container, false);

        categoryList = new ArrayList<>();
        categoryList.add(new Category(R.drawable.entertainment,"Entertainment"));
        categoryList.add(new Category(R.drawable.food_and_drink,"Food & Drink"));
        categoryList.add(new Category(R.drawable.gym,"Health & Fitness"));
        categoryList.add(new Category(R.drawable.garden,"Home & Garden"));
        categoryList.add(new Category(R.drawable.ciudad,"News & Politics"));
        categoryList.add(new Category(R.drawable.tecnologia,"Science & Technology"));
        categoryList.add(new Category(R.drawable.manualidades,"Crafts"));
        categoryList.add(new Category(R.drawable.deporte,"Sports"));

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        RecyclerViewAdapater adapater = new RecyclerViewAdapater(getContext(),categoryList);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        }
        recyclerView.setAdapter(adapater);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}
