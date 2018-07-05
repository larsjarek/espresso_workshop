package com.example.larsjarek.espresso_workshop.test;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.larsjarek.espresso_workshop.MainActivity;
import com.example.larsjarek.espresso_workshop.R;
import com.example.larsjarek.espresso_workshop.page.LoginPage;
import com.example.larsjarek.espresso_workshop.page.WelcomePage;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)

public class ColorTest {
    private LoginPage lp = new LoginPage();
    private WelcomePage wp = new WelcomePage();

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkColorTest(){
        lp.logIn("login", "password");
        wp.clickColorButton();
        wp.checkIfButtonIsRed();
    }
}
