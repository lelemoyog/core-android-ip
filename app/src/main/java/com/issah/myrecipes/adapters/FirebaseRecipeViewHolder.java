package com.issah.myrecipes.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.issah.myrecipes.Constants;
import com.issah.myrecipes.R;
import com.issah.myrecipes.models.Hit;
import com.issah.myrecipes.ui.IngredientsDetailActivity;
import com.issah.myrecipes.util.ItemTouchHelperViewHolder;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirebaseRecipeViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {

    View mView;
    Context mContext;
    public ImageView mRecipeImageView;

    public FirebaseRecipeViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindRecipe(Hit recipe) {

        mRecipeImageView = (ImageView) mView.findViewById(R.id.recipeimage);
        TextView labelTextView = (TextView) mView.findViewById(R.id.recipeLabel);


        Picasso.get().load(recipe.getRecipe().getImage()).into(mRecipeImageView);
        labelTextView.setText(recipe.getRecipe().getLabel());

    }

    @Override
    public void onItemSelected(){
        //Log.d("Animation", "onItemSelected");
        // we will add animations here
        itemView.animate()
                .alpha(0.7f)
                .scaleX(0.9f)
                .scaleY(0.9f)
                .setDuration(500);
    }

    @Override
    public void onItemClear(){
        //Log.d("Animation", "onItemClear");
        // we will add animations here
        itemView.animate()
                .alpha(1f)
                .scaleX(1f)
                .scaleY(1f);
    }

}