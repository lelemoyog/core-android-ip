package com.issah.myrecipes;

import android.content.Context;
import android.widget.ArrayAdapter;

public class RecipesArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mRecipes;

    public RecipesArrayAdapter(Context mContext, int resource,String[] mRecipes ){
        super(mContext, resource);
        this.mContext = mContext;
        this.mRecipes = mRecipes;
    }

    @Override
    public Object getItem(int position) {
        String recipes = mRecipes[position];
        return recipes;
    }



    @Override
    public int getCount() {
        return mRecipes.length;
    }

}
