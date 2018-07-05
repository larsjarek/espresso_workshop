package com.example.larsjarek.espresso_workshop.test;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.larsjarek.espresso_workshop.MainActivity;
import com.example.larsjarek.espresso_workshop.R;
import com.example.larsjarek.espresso_workshop.page.LoginPage;
import com.example.larsjarek.espresso_workshop.page.LoginPageV2;
import com.example.larsjarek.espresso_workshop.page.WelcomePage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class LoginTest {
    private LoginPage lp = new LoginPage();
    private WelcomePage wp = new WelcomePage();

    @Before
    public void setUp(){
        Log.w("test", "SetUp");
    }

    @After
    public void tearDown(){
        Log.w("test", "tearDown");
    }

    @BeforeClass
    public static void setUpClass(){
        Log.w("test", "SetUpClass");
    }

    @AfterClass
    public static void tearDownClass(){
        Log.w("test", "tearDownClass");
    }

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validLogIn(){
        Log.w("test", "validLogIn");
        onView(ViewMatchers.withId(com.example.larsjarek.espresso_workshop.R.id.login_input_field)).perform(click());
        onView(ViewMatchers.withId(com.example.larsjarek.espresso_workshop.R.id.login_input_field)).perform(typeText("login"));
        onView(ViewMatchers.withId(com.example.larsjarek.espresso_workshop.R.id.password_input_field)).perform(click());
        onView(ViewMatchers.withId(com.example.larsjarek.espresso_workshop.R.id.password_input_field)).perform(typeText("password"));
        onView(ViewMatchers.withId(com.example.larsjarek.espresso_workshop.R.id.login_button)).perform(click());

        onView(ViewMatchers.withId(R.id.welcome_text)).check(matches(isDisplayed()));
    }

    @Test
    public void validLogInV2(){
        Log.w("test", "validLogInV2");
        lp.logIn("login", "password");
        wp.isPageOpened();
    }

    public void validLogInV3(){
        new LoginPageV2().
                fillLoginField("login").
                fillPasswordField("password").
                clickLoginButton().
                isPageOpened();
    }


}
