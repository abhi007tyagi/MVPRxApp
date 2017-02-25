package com.tyagiabhinav.mvprxapp;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.view.KeyEvent;

import com.tyagiabhinav.mvprxapp.view.ui.MainScreen.MainActivity;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by abhinavtyagi on 09/01/17.
 */


@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRestaurantListUI {

    private static final String TAG = TestRestaurantListUI.class.getSimpleName();

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    /**
     * Test activity_main items visibility on launch of app
     */
    @Test
    public void test01_UIViewsPresenceOnLoad() {
        Log.d(TAG, "running test01_UIViewsPresenceOnLoad..");

        // checks if recycler view is present
        onView(withId(R.id.restaurant_list)).check(matches(isDisplayed()));

        // checks if sorting filter is present
        onView(withId(R.id.action_spinner)).check(matches(isDisplayed()));

        // checks if query search is present
        onView(withId(R.id.action_search)).check(matches(isDisplayed()));

    }

    /**
     * Test action bar items visibility
     */
    @Test
    public void test02_SortFilterItemDisplayAndClick() {
        Log.d(TAG, "running test02_SortFilterItemDisplayAndClick..");

        // checks if sorting filter is present
        onView(withId(R.id.action_spinner)).check(matches(isDisplayed()));

        // perform click operation to open filter menu
        onView(withId(R.id.action_spinner)).perform(click());

        // check if filter item "price" is present
        onData(allOf(is(instanceOf(String.class)), is("price"))).check(matches(isDisplayed()));

        // perform click operation on filter item "price"
        onData(allOf(is(instanceOf(String.class)), is("price"))).perform(click());

        // check if filter item "rating" is present
        onData(allOf(is(instanceOf(String.class)), is("rating"))).check(matches(isDisplayed()));

        // perform click operation on filter item "rating"
        onData(allOf(is(instanceOf(String.class)), is("rating"))).perform(click());

        // check if filter item "open" is present
        onData(allOf(is(instanceOf(String.class)), is("open"))).check(matches(isDisplayed()));

        // perform click operation on filter item "open"
        onData(allOf(is(instanceOf(String.class)), is("open"))).perform(click());

        // check if filter item "distance" is present
        onData(allOf(is(instanceOf(String.class)), is("distance"))).check(matches(isDisplayed()));

        // perform click operation on filter item "distance"
        onData(allOf(is(instanceOf(String.class)), is("distance"))).perform(click());

    }

    /**
     * Test items visibility on Search click
     */
    @Test
    public void test03_SearchButtonClickUIChanges() {
        Log.d(TAG, "running test03_SearchButtonClickUIChanges..");

        // checks if search button is present
        onView(withId(R.id.action_search)).check(matches(isDisplayed()));

        // get the fab button and perform click operation
        onView(withId(R.id.action_search)).perform(click());

        // enter text to search
        onView(withId(android.support.design.R.id.search_src_text)).perform(typeText("chinese"), pressKey(KeyEvent.KEYCODE_ENTER));

        // checks if recycler view is present
        onView(withId(R.id.restaurant_list)).check(matches(isDisplayed()));

    }

}
