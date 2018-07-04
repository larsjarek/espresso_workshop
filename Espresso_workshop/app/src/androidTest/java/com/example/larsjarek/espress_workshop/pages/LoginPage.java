package com.example.larsjarek.espress_workshop.pages;

import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;

import com.example.larsjarek.espresso_workshop.R;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;


public class LoginPage {

    //matchers
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
    public void fillLoginField(String login){
        onView(loginField()).perform(click());
        onView(loginField()).perform(typeText(login));
    }

    public void fillPasswordField(String password){
        onView(passwordField()).perform(click());
        onView(passwordField()).perform(typeText(password));
    }

    public void clickLoginButton(){
        onView(loginButton()).perform(click());
    }

    public void check(){
        onView(loginField()).check(matches(isDisplayed()));
    }

    public void logIn(String login, String password){
        fillLoginField(login);
        fillPasswordField(password);
        clickLoginButton();
    }













}
