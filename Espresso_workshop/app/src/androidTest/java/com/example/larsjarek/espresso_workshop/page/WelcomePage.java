package com.example.larsjarek.espresso_workshop.page;

import android.graphics.Color;

import com.example.larsjarek.espresso_workshop.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.example.larsjarek.espresso_workshop.MainLibrary.hasBackgroundColor;
import static com.example.larsjarek.espresso_workshop.MainLibrary.scrollAndClick;

public class WelcomePage {
    public void clickColorButton(){
        onView(withId(R.id.color_button)).perform(scrollAndClick());
    }

    public void isColorButtonRed(){
        onView(withId(R.id.color_button)).check(matches(hasBackgroundColor(Color.RED)));
    }

    public void isPageOpened(){
        onView(withId(R.id.welcome_text)).check(matches(isDisplayed()));
    }
}
