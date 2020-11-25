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

public class CategorySecond extends Fragment {
    ArrayList<RecipeModel>list1;
    public static CategorySecond getInstance() {
        CategorySecond categorySecond = new CategorySecond();
        return categorySecond;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.category_second, container, false);
         RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclarView);
        RecipeAdapter adapter=new RecipeAdapter(list1, getContext());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list1 = new ArrayList<>();
        list1.add(new RecipeModel(R.drawable.bgimg, "Category2    food1"));
        list1.add(new RecipeModel(R.drawable.bgimg, "Category2    food2"));
        list1.add(new RecipeModel(R.drawable.bgimg, "Category2    food3"));
        list1.add(new RecipeModel(R.drawable.bgimg, "Category2    food4"));
        list1.add(new RecipeModel(R.drawable.bgimg, "Category2    food5"));
        list1.add(new RecipeModel(R.drawable.bgimg, "Category2    food6"));
        list1.add(new RecipeModel(R.drawable.bgimg, "Category2    food7"));
        list1.add(new RecipeModel(R.drawable.bgimg, "Category2    food8"));
        list1.add(new RecipeModel(R.drawable.bgimg, "Category2    food9"));
        list1.add(new RecipeModel(R.drawable.bgimg, "Category2    food10"));

    }

}
