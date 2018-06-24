package com.example.larsjarek.espresso_workshop.test;

import android.support.test.rule.ActivityTestRule;

import com.example.larsjarek.espresso_workshop.MainActivity;
import com.example.larsjarek.espresso_workshop.page.LoginPage;
import com.example.larsjarek.espresso_workshop.page.WelcomePage;

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
        lp.login("login", "password");
        wp.clickColorButton();
        wp.isColorButtonRed();
    }
}
