package com.issah.myrecipes.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.issah.myrecipes.models.Hit;
import com.issah.myrecipes.ui.RecipeDetailFragment;

import java.util.List;

public class RecipePagerAdapter extends FragmentPagerAdapter {
    private List<Hit> mRecipes;

    public RecipePagerAdapter(@NonNull FragmentManager fm, int behavior, List<Hit> mRecipes) {
        super(fm, behavior);
        this.mRecipes = mRecipes;
    }


    @Override
    public Fragment getItem(int position) {
        return RecipeDetailFragment.newInstance(mRecipes.get(position));
    }

    @Override
    public int getCount() {
        return mRecipes.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mRecipes.get(position).getRecipe().getLabel();
    }
}

