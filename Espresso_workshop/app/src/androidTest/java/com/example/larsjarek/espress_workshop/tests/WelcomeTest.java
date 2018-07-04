package com.example.larsjarek.espress_workshop.tests;

import android.support.test.rule.ActivityTestRule;

import com.example.larsjarek.espress_workshop.pages.LoginPage;
import com.example.larsjarek.espress_workshop.pages.WelcomePage;
import com.example.larsjarek.espresso_workshop.MainActivity;

import org.junit.Rule;
import org.junit.Test;


public class WelcomeTest {
    private LoginPage lp = new LoginPage();
    private WelcomePage wp = new WelcomePage();

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void correctLoginTest_v2(){
        lp.logIn("login", "password");
        wp.clickColorButton();
        wp.isColorButtonRed();
    }
}