package com.example.larsjarek.espress_workshop.tests;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.view.View;

import com.example.larsjarek.espress_workshop.pages.LoginPage;
import com.example.larsjarek.espress_workshop.pages.LoginPageV2;
import com.example.larsjarek.espress_workshop.pages.WelcomePage;
import com.example.larsjarek.espresso_workshop.MainActivity;
import com.example.larsjarek.espresso_workshop.R;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.Console;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

@RunWith(AndroidJUnit4.class)
public class LoginTest {
    private LoginPage lp = new LoginPage();
    private WelcomePage wp = new WelcomePage();

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp(){
        Log.w("test","setup");
    }

    @After
    public void tearDown(){
        Log.w("test","tearDown");
    }

    @BeforeClass
    public static void setUpClass(){
        Log.w("test","setUpClass");
    }

    @AfterClass
    public static void tearDownClass(){
        Log.w("test","tearDownClass");
    }

    @Test
    public void validLoginTest(){
        Log.w("test","validLoginTest");
        onView(ViewMatchers.withId(R.id.login_input_field)).perform(click());
        onView(ViewMatchers.withId(R.id.login_input_field)).perform(typeText("login"));
        onView(ViewMatchers.withId(R.id.password_input_field)).perform(click());
        onView(ViewMatchers.withId(R.id.password_input_field)).perform(typeText("password"));
        onView(ViewMatchers.withId(R.id.login_button)).perform(click());

        onView(ViewMatchers.withId(R.id.welcome_text)).check(matches(isDisplayed()));
    }

    @Test
    public void validLoginTestV2(){
        Log.w("test","validLoginTestV2");
        lp.logIn("login", "password");
        wp.check();
    }

    @Test
    public void validLoginTestV3(){
        Log.w("test","validLoginTestV3");
        new LoginPageV2().fillLoginField("login").
                fillPasswordField("password").
                clickLoginButton().
                check();
    }





}
