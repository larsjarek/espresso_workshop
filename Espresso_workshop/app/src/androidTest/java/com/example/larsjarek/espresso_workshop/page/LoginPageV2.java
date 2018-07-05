package com.example.larsjarek.espresso_workshop.page;


import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;


import com.example.larsjarek.espresso_workshop.R;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

public class LoginPageV2 {

    //constructor
    public LoginPageV2(){
        onView(loginField()).check(matches(isDisplayed()));
    }

    //locators
    private Matcher<View> loginField(){
        return ViewMatchers.withId(R.id.login_input_field);
    }

    private Matcher<View> passwordField(){
        return ViewMatchers.withId(R.id.password_input_field);
    }

    private Matcher<View> loginButton(){
        return ViewMatchers.withId(R.id.login_button);
    }

    //functions
    public LoginPageV2 fillLoginField(String login){
        onView(loginField()).perform(click());
        onView(loginField()).perform(typeText(login));
        return new LoginPageV2();
    }

    public LoginPageV2 fillPasswordField(String password){
        onView(passwordField()).perform(click());
        onView(passwordField()).perform(typeText(password));
        return new LoginPageV2();
    }

    public WelcomePage clickLoginButton(){
        onView(loginButton()).perform(click());
        return new WelcomePage();
    }
}
