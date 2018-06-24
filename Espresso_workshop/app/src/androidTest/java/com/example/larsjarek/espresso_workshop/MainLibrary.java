package com.example.larsjarek.espresso_workshop;

import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorRes;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;

public class MainLibrary {

    public static ViewAction scrollAndClick(){
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isAssignableFrom(View.class);
            }

            @Override
            public String getDescription() {
                return "scroll and click";
            }

            @Override
            public void perform(UiController uiController, View view) {
                scrollTo().perform(uiController, view);
                click().perform(uiController, view);
            }
        };
    }

    public static Matcher<View> hasBackgroundColor(@ColorRes final int colorId) {
        return new TypeSafeMatcher<View>() {
            @Override
            public boolean matchesSafely(View view) {
                return ((ColorDrawable) view.getBackground()).getColor() == colorId;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Check if view has desired background color");
            }
        };
    }
}
