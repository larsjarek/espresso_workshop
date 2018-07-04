package com.example.larsjarek.espress_workshop.pages;

import android.graphics.Color;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;

import com.example.larsjarek.espresso_workshop.R;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.example.larsjarek.espress_workshop.MainLibrary.hasBackgroundColor;
import static com.example.larsjarek.espress_workshop.MainLibrary.scrollAndClick;


public class WelcomePage{

    //matchers
    public Matcher<View> welcomeText() {
        return withId(R.id.welcome_text);
    }

    public Matcher<View> colorButton() {
        return withId(R.id.color_button);
    }

    //functions

    public void clickColorButton(){
        onView(colorButton()).perform(scrollAndClick());
    }
    public void isColorButtonRed() {
        onView(colorButton()).check(matches(hasBackgroundColor(Color.RED)));
    }

    public void check(){
        onView(welcomeText()).check(matches(isDisplayed()));
    }
}
