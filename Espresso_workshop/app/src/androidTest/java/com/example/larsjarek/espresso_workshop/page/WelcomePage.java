package com.example.larsjarek.espresso_workshop.page;


import android.graphics.Color;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;

import com.example.larsjarek.espresso_workshop.R;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static com.example.larsjarek.espresso_workshop.lib.MainLibrary.hasBackgroundColor;
import static com.example.larsjarek.espresso_workshop.lib.MainLibrary.scrollAndClick;

public class WelcomePage {
    //locators
    private Matcher<View> welcomeText(){
        return ViewMatchers.withId(R.id.welcome_text);
    }

    private Matcher<View> colorButton(){
        return ViewMatchers.withId(R.id.color_button);
    }


    //functions
    public void isPageOpened(){
        onView(welcomeText()).check(matches(isDisplayed()));
    }

    public void clickColorButton(){
        onView(colorButton()).perform(scrollAndClick());
    }

    public void checkIfButtonIsRed(){
        onView(colorButton()).check(matches(hasBackgroundColor(Color.RED)));
    }
}
