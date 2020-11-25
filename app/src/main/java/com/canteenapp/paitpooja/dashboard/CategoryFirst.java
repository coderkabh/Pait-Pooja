package com.canteenapp.paitpooja.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.canteenapp.paitpooja.Adapters.RecipeAdapter;
import com.canteenapp.paitpooja.Models.RecipeModel;
import com.canteenapp.paitpooja.R;

import java.util.ArrayList;

public class  CategoryFirst extends Fragment {
    ArrayList<RecipeModel>list;
    /* private Object RecyclerView; */


    public static CategoryFirst getInstance() {
        return new CategoryFirst();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.category_first, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclarView);
        RecipeAdapter adapter=new RecipeAdapter(list, getContext());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         list = new ArrayList<>();
        list.add(new RecipeModel(R.drawable.bgimg, "Category1    food1"));
        list.add(new RecipeModel(R.drawable.bgimg, "Category1    food2"));
        list.add(new RecipeModel(R.drawable.bgimg, "Category1    food3"));
        list.add(new RecipeModel(R.drawable.bgimg, "Category1    food4"));
        list.add(new RecipeModel(R.drawable.bgimg, "Category1    food5"));
        list.add(new RecipeModel(R.drawable.bgimg, "Category1    food6"));
        list.add(new RecipeModel(R.drawable.bgimg, "Category1    food7"));
        list.add(new RecipeModel(R.drawable.bgimg, "Category1    food8"));
        list.add(new RecipeModel(R.drawable.bgimg, "Category1    food9"));
        list.add(new RecipeModel(R.drawable.bgimg, "Category1    food10"));

    }





    }