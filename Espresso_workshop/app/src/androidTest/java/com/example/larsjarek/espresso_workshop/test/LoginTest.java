package com.example.larsjarek.espresso_workshop.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import com.example.larsjarek.espresso_workshop.MainActivity;
import com.example.larsjarek.espresso_workshop.R;
import com.example.larsjarek.espresso_workshop.page.LoginPage;
import com.example.larsjarek.espresso_workshop.page.LoginPage2;
import com.example.larsjarek.espresso_workshop.page.WelcomePage;

@RunWith(AndroidJUnit4.class)
public class LoginTest {
    private LoginPage lp = new LoginPage();
    private LoginPage2 lp2 = new LoginPage2();
    private WelcomePage wp = new WelcomePage();

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void correctLoginTest(){
        onView(ViewMatchers.withId(com.example.larsjarek.espresso_workshop.R.id.login_input_field)).perform(click());
        onView(ViewMatchers.withId(com.example.larsjarek.espresso_workshop.R.id.login_input_field)).perform(typeText("login"));
        onView(ViewMatchers.withId(com.example.larsjarek.espresso_workshop.R.id.password_input_field)).perform(click());
        onView(ViewMatchers.withId(com.example.larsjarek.espresso_workshop.R.id.password_input_field)).perform(typeText("password"));
        onView(ViewMatchers.withId(com.example.larsjarek.espresso_workshop.R.id.login_button)).perform(click());
        onView(ViewMatchers.withId(com.example.larsjarek.espresso_workshop.R.id.welcome_text)).check(matches(isDisplayed()));
    }

    @Test
    public void correctLoginTest_v2(){
        lp.login("login", "password");
        wp.isPageOpened();
    }

    @Test
    public void correctLoginTest_v3(){
        lp2.enterLogin("login").
                enterPassword("password").
                clickLoginButton().
                isPageOpened();
    }
}

