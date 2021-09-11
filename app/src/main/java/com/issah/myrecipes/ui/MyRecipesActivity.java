package com.issah.myrecipes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.issah.myrecipes.R;
import com.issah.myrecipes.RecipesArrayAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyRecipesActivity extends AppCompatActivity {

    @BindView(R.id.imageView2) ImageView imageView;
    @BindView(R.id.ingredientTextView) TextView mIngredientTextView;
    @BindView(R.id.listView) ListView mListView;

    private String[] recipes = new String[] {"Vegan Food", " gluten free", "Fishs Dishs",
            "Scandinavian", "Coffee", "English Food", "Burgers", "Fast Food", "Noodle Soups",
            "vegan", "BBQ", "Cuban", "vegetarian", "pescetarian", "high protein", "Mexican" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrecipes);

        ButterKnife.bind(this);

        RecipesArrayAdapter adapter = new RecipesArrayAdapter(this, android.R.layout.simple_list_item_1,recipes);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String recipes = ((TextView)view).getText().toString();

                Toast.makeText(MyRecipesActivity.this,recipes, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String ingredient= intent.getStringExtra("ingredient");
        mIngredientTextView.setText("My Recipes with the following ingredients:" + ingredient);
    }
}
