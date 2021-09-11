package com.issah.myrecipes.ui;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.issah.myrecipes.R;

public class FindRecipesActivity extends AppCompatActivity {



    GridView gridView;
    Integer[] image = {
            R.drawable.bbq,R.drawable.bergers,R.drawable.british,R.drawable.coffee,
            R.drawable.fastfood,R.drawable.fishdish,R.drawable.glutenfree,R.drawable.noodlesoup,
            R.drawable.scandinavian,R.drawable.vegan
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findrecipes);


        

    }




}
