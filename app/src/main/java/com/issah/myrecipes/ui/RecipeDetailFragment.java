package com.issah.myrecipes.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.issah.myrecipes.Constants;
import com.issah.myrecipes.R;
import com.issah.myrecipes.models.Hit;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipeDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipeDetailFragment extends Fragment  implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    @BindView(R.id.recipeimage) ImageView mRecipeImageView;
    @BindView(R.id.recipeLabel) TextView mLabelTextView;
    @BindView(R.id.ingredientTextView2) TextView mIngredientLinesTextView;
    @BindView(R.id.websiteTextView) TextView mRecipeUrl;
    @BindView(R.id.saveRecipeButton) Button mSaveRecipeButton;


    // TODO: Rename and change types of parameters
    private Hit mRecipe;

    public RecipeDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment RecipeDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecipeDetailFragment newInstance(Hit recipe) {
        RecipeDetailFragment recipeDetailFragment= new RecipeDetailFragment();
        Bundle args = new Bundle();
       args.putParcelable("recipe", Parcels.wrap(recipe));
        recipeDetailFragment.setArguments(args);
        return recipeDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       assert  getArguments() != null;
       mRecipe = Parcels.unwrap(getArguments().getParcelable("recipe"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        ButterKnife.bind(this, view);
        mIngredientLinesTextView.setText(mRecipe.getRecipe().getIngredientLines().toString());
        mLabelTextView.setText(mRecipe.getRecipe().getLabel());
        mRecipeUrl.setOnClickListener(this);
        mSaveRecipeButton.setOnClickListener(this);
        Picasso.get().load(mRecipe.getRecipe().getImage()).into(mRecipeImageView);

        return  view;
    }

    @Override
    public void onClick(View v) {

        if(v == mRecipeUrl){
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mRecipe.getRecipe().getUrl()));
            startActivity(webIntent);
        }
        if(v == mSaveRecipeButton){

            DatabaseReference recipeRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_RECIPES);
            recipeRef.push().setValue(mRecipe);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }

    }
}