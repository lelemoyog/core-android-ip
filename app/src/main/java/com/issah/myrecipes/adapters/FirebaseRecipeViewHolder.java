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
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirebaseRecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    View mView;
    Context mContext;
    public ImageView mRecipeImageView;

    public FirebaseRecipeViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindRecipe(Hit recipe) {

        mRecipeImageView = (ImageView) mView.findViewById(R.id.recipeimage);
        TextView labelTextView = (TextView) mView.findViewById(R.id.recipeLabel);


        Picasso.get().load(recipe.getRecipe().getImage()).into(mRecipeImageView);
        labelTextView.setText(recipe.getRecipe().getLabel());

    }

    @Override
    public void onClick(View v) {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        final ArrayList<Hit> recipes = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_RECIPES).child(uid);

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    recipes.add(snapshot.getValue(Hit.class));
                }
                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, IngredientsDetailActivity.class);
                intent.putExtra("position",itemPosition + "");
                intent.putExtra("recipes", Parcels.wrap(recipes));

                mContext.startActivity(intent) ;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}