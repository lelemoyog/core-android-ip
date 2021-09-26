package com.issah.myrecipes.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import com.issah.myrecipes.R;
import com.issah.myrecipes.models.Hit;
import com.issah.myrecipes.models.Recipe;
import com.issah.myrecipes.ui.IngredientsDetailActivity;
import com.issah.myrecipes.util.ItemTouchHelperAdapter;
import com.issah.myrecipes.util.OnStartDragListener;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Collections;

public class FirebaseRecipeListAdapter extends FirebaseRecyclerAdapter<Hit, FirebaseRecipeViewHolder>  implements ItemTouchHelperAdapter {
    private Query mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;
    private ChildEventListener mChildEventListener;
    private ArrayList<Hit> mRecipe = new ArrayList<>();


    public  FirebaseRecipeListAdapter(FirebaseRecyclerOptions<Hit> options,
                                      Query ref,
                                      OnStartDragListener onStartDragListener,
                                      Context context){
        super(options);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;

        mChildEventListener = mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                mRecipe.add(dataSnapshot.getValue(Hit.class));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    protected void onBindViewHolder(@NonNull FirebaseRecipeViewHolder holder, int position, @NonNull Hit recipe) {
       holder.bindRecipe(recipe);
       holder.mRecipeImageView.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                   mOnStartDragListener.onStartDrag(holder);
               }
               return false;
           }
       });

       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(mContext,IngredientsDetailActivity.class);
               intent.putExtra("position", holder.getAdapterPosition());
               intent.putExtra("recipes", Parcels.wrap(mRecipe));
               mContext.startActivity(intent);
           }
       });


    }

    @NonNull
    @Override
    public FirebaseRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item_drag,parent,false);
        return new FirebaseRecipeViewHolder(view);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mRecipe , fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        setIndexInFirebase();
        return false;
    }

    private void setIndexInFirebase(){
        for(Hit recipe: mRecipe){
            int index = mRecipe.indexOf(recipe);
            DatabaseReference mReference = getRef(index);
            recipe.setIndex(Integer.toString(index));
            mReference.setValue(recipe);
        }
    }


    @Override
    public void onItemDismiss(int position) {
        mRecipe.remove(position);
        getRef(position).removeValue();
    }

    @Override
    public void stopListening(){
        super.stopListening();
        mRef.removeEventListener(mChildEventListener);
    }

}
