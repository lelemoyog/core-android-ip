package com.issah.myrecipes.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.issah.myrecipes.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.findRecipes) Button mFindRecipesButton;
    @BindView(R.id.myRecipes) Button mMyRecipesButton;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mFindRecipesButton.setOnClickListener(this);
        mMyRecipesButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mMyRecipesButton){
            Intent intent = new Intent(MainActivity.this, MyRecipesActivity.class);
            startActivity(intent);
        }
        if(view == mFindRecipesButton){
            Intent intent = new Intent(MainActivity.this, SavedRecipesActivity.class);
            startActivity(intent);
        }
    }
}