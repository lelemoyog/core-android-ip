package com.issah.myrecipes;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.not;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.issah.myrecipes.ui.MyRecipesActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MyRecipesActivityInstrumentationTest {
    @Rule
    public ActivityScenarioRule<MyRecipesActivity> activityTestRule =
            new ActivityScenarioRule<>(MyRecipesActivity.class);
    private View activityDecorView;

    @Before
    public void setUp() {
        activityTestRule.getScenario().onActivity(new ActivityScenario.ActivityAction<MyRecipesActivity>() {
            @Override
            public void perform(MyRecipesActivity activity) {
                activityDecorView = activity.getWindow().getDecorView();
            }
        });
    }
    @Test
    public void listItemClickDisplaysToastWithCorrectRecipe() {
        String recipe = "Vegan Food";
        onData(anything())
                .inAdapterView(withId(R.id.listView))
                .atPosition(0)
                .perform(click());
        onView(withText(recipe)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(recipe)));
    }
}
