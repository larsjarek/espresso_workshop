package com.example.larsjarek.espresso_workshop.page;

import com.example.larsjarek.espresso_workshop.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class LoginPage {

    public void enterLogin(String login){
        onView(withId(R.id.login_input_field)).perform(click());
        onView(withId(R.id.login_input_field)).perform(typeText(login));
    }

    public void enterPassword(String password){
        onView(withId(R.id.password_input_field)).perform(click());
        onView(withId(R.id.password_input_field)).perform(typeText(password));
    }

    public void clickLoginButton(){
        onView(withId(R.id.login_button)).perform(click());
    }

    public void login(String login, String password){
        enterLogin(login);
        enterPassword(password);
        clickLoginButton();
    }

    public void isPageOpened(){
        onView(withId(R.id.login_button)).check(matches(isDisplayed()));
    }
}
