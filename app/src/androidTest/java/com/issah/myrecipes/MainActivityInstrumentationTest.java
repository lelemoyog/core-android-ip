package com.issah.myrecipes;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.issah.myrecipes.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class MainActivityInstrumentationTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void validateEditText() {
        onView(withId(R.id.ingredientEditText)).perform(typeText("Maize"))
                .check(matches(withText("Maize")));
    }

    @Test
    public void ingredientIsSentToRestaurantsActivity() {
        String ingredient = "Maize";
        onView(withId(R.id.ingredientEditText)).perform(typeText(ingredient)).perform(closeSoftKeyboard());
        try {                             // the sleep method requires to be checked and handled so we use try block
            Thread.sleep(250);
        } catch (InterruptedException e){
            System.out.println("got interrupted!");
        }
        onView(withId(R.id.myRecipes)).perform(click());
        onView(withId(R.id.ingredientTextView)).check(matches
                (withText("My Recipes with the following ingredients:" + ingredient)));
    }
}
