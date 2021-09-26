package com.issah.myrecipes.adapters;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Parcel;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.issah.myrecipes.R;
import com.issah.myrecipes.models.Hit;
import com.issah.myrecipes.ui.IngredientsDetailActivity;
import com.issah.myrecipes.ui.MyRecipesActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>{

    private List<Hit> mRecipes;
    private  Context mContext;


    public RecipeListAdapter(Context Context,List<Hit> mRecipes) {
        this.mRecipes = mRecipes;
        this.mContext = Context;
    }


    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item,parent,false);
        RecipeViewHolder viewHolder = new RecipeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.RecipeViewHolder holder, int position) {
        holder.bindRecipe(mRecipes.get(position));
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    public class  RecipeViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.recipeimage) ImageView mRecipeImageView;
        @BindView(R.id.recipeLabel) TextView mLabelTextView;



        public RecipeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }
        public  void  bindRecipe (Hit recipe){
            mLabelTextView.setText(recipe.getRecipe().getLabel());
            Picasso.get().load(recipe.getRecipe().getImage()).into(mRecipeImageView);

        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, IngredientsDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("recipes", Parcels.wrap(mRecipes));
            mContext.startActivity(intent);
        }
    }
}