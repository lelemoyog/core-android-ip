package com.issah.myrecipes.ui;

import static com.issah.myrecipes.Constants.APP_ID;
import static com.issah.myrecipes.Constants.APP_KEY;
import static com.issah.myrecipes.Constants.SEARCH_TYPE;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.issah.myrecipes.R;
import com.issah.myrecipes.RecipesArrayAdapter;
import com.issah.myrecipes.adapters.RecipeListAdapter;
import com.issah.myrecipes.models.Hit;
import com.issah.myrecipes.models.Links__1;
import com.issah.myrecipes.models.MyrecipesSearchResponse;
import com.issah.myrecipes.network.EdamamApi;
import com.issah.myrecipes.network.EdamamClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyRecipesActivity extends AppCompatActivity {

    private static final String TAG = MyRecipesActivity.class.getSimpleName();
    @BindView(R.id.ingredientTextView) TextView mIngredientTextView;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    private RecipeListAdapter mAdapter;

    public  List<Hit> recipes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrecipes);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String ingredient= intent.getStringExtra("ingredient");
        String app_id = APP_ID;
        String app_key = APP_KEY;
        String type = SEARCH_TYPE;


        EdamamApi client = EdamamClient.getClient();
        Call<MyrecipesSearchResponse> call = client.getRecipes(app_id,app_key,type,ingredient);

        call.enqueue(new Callback<MyrecipesSearchResponse>() {

            @Override
            public void onResponse(Call<MyrecipesSearchResponse> call, Response<MyrecipesSearchResponse> response) {
                hideProgressBar();

                if (response.isSuccessful()) {
                   recipes =  response.body().getHits();
                   mAdapter = new RecipeListAdapter(MyRecipesActivity.this,recipes);
                   mRecyclerView.setAdapter(mAdapter);
                   RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MyRecipesActivity.this);
                   mRecyclerView.setLayoutManager(layoutManager);
                   mRecyclerView.setHasFixedSize(true);

                    Log.e(TAG,String.valueOf(recipes));

                   showRecipes();
                }else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<MyrecipesSearchResponse> call, Throwable t) {
                Log.e("Error Message", "onFailure: ",t );
                hideProgressBar();
                showFailureMessage();
            }
        });

    }
    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showRecipes() {
        mRecyclerView.setVisibility(View.VISIBLE);
        mIngredientTextView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}
