package com.example.larsjarek.espresso_workshop.page;

import com.example.larsjarek.espresso_workshop.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class LoginPage2 {

    public LoginPage2 enterLogin(String login){
        onView(withId(R.id.login_input_field)).perform(click());
        onView(withId(R.id.login_input_field)).perform(typeText(login));
        return new LoginPage2();
    }

    public LoginPage2 enterPassword(String password){
        onView(withId(R.id.password_input_field)).perform(click());
        onView(withId(R.id.password_input_field)).perform(typeText(password));
        return new LoginPage2();
    }

    public WelcomePage clickLoginButton(){
        onView(withId(R.id.login_button)).perform(click());
        return new WelcomePage();
    }

    public LoginPage2 isPageOpened(){
        onView(withId(R.id.login_button)).check(matches(isDisplayed()));
        return new LoginPage2();
    }
}
