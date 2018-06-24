package com.example.larsjarek.espresso_workshop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    RelativeLayout relativeLayout;
    private EditText loginInputField;
    private RelativeLayout.LayoutParams loginInputFieldParams;
    private EditText passwordInputField;
    private RelativeLayout.LayoutParams passwordInputFieldParams;
    private Button loginButton;
    private RelativeLayout.LayoutParams loginButtonParams;
    private String login;
    private String password;
    private String correctLogin;
    private String correctPassword;
    private Toast invalidCredentialsToast;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        correctLogin = "login";
        correctPassword = "password";
        super.onCreate(savedInstanceState);
        context = getApplicationContext();

        //Getting screen size
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        int space = height/40;

        relativeLayout = new RelativeLayout(this);


        //loginInputField
        loginInputFieldParams = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        loginInputFieldParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        loginInputFieldParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        loginInputFieldParams.setMargins(0, space*10, 0, 0);
        loginInputField = new EditText(this);
        loginInputField.setTextSize(convertPixelsToDp(16, this) * getResources().getDisplayMetrics().scaledDensity);
        loginInputField.setTextColor(Color.BLACK);
        loginInputField.setBackgroundColor(Color.GRAY);
        loginInputField.setWidth(width/2);
        loginInputField.setMaxWidth(width/2);
        loginInputField.setHeight(space*3);
        loginInputField.setMaxHeight(space*3);
        loginInputField.setTypeface(null, Typeface.BOLD);
        loginInputField.setId(R.id.login_input_field);
        loginInputField.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(MotionEvent.ACTION_UP == event.getAction())
                    loginInputField.setText("");
                return false;
            }
        });
        loginInputField.setText("login");

        passwordInputFieldParams = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        passwordInputFieldParams.addRule(RelativeLayout.BELOW, loginInputField.getId());
        passwordInputFieldParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        passwordInputFieldParams.setMargins(0, space*2, 0, 0);
        passwordInputField = new EditText(this);
        passwordInputField.setTextSize(convertPixelsToDp(16, this) * getResources().getDisplayMetrics().scaledDensity);
        passwordInputField.setTextColor(Color.BLACK);
        passwordInputField.setBackgroundColor(Color.GRAY);
        passwordInputField.setWidth(width/2);
        passwordInputField.setMaxWidth(width/2);
        passwordInputField.setHeight(space*3);
        passwordInputField.setMaxHeight(space*3);
        passwordInputField.setTypeface(null, Typeface.BOLD);
        passwordInputField.setId(R.id.password_input_field);
        passwordInputField.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(MotionEvent.ACTION_UP == event.getAction())
                    passwordInputField.setText("");
                return false;
            }
        });
        passwordInputField.setText("password");

        loginButtonParams = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        loginButtonParams.addRule(RelativeLayout.BELOW, passwordInputField.getId());
        loginButtonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        loginButtonParams.setMargins(0, space*2, 0, 0);
        loginButton = new Button(this);
        loginButton.setTextSize(convertPixelsToDp(16, this) * getResources().getDisplayMetrics().scaledDensity);
        loginButton.setTextColor(Color.BLACK);
        loginButton.setBackgroundColor(Color.GRAY);
        loginButton.setWidth(width/3);
        loginButton.setMaxWidth(width/3);
        loginButton.setHeight(space*3);
        loginButton.setMaxHeight(space*3);
        loginButton.setTypeface(null, Typeface.BOLD);
        loginButton.setId(R.id.login_button);
        loginButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(MotionEvent.ACTION_UP == event.getAction()) {
                    login = loginInputField.getText().toString();
                    password = passwordInputField.getText().toString();
                    if (login.equals(correctLogin) && password.equals(correctPassword)) {
                        startActivity(new Intent(MainActivity.this, SecondActivity.class));
                        finish();
                    } else {
                        invalidCredentialsToast = Toast.makeText(context, "Wrong login or password", Toast.LENGTH_SHORT);
                        invalidCredentialsToast.show();
                    }
                }
                return true;
            }
        });
        loginButton.setText("LOGIN");

        // Add views to layout
        relativeLayout.addView(loginInputField, loginInputFieldParams);
        relativeLayout.addView(passwordInputField, passwordInputFieldParams);
        relativeLayout.addView(loginButton, loginButtonParams);

        //turn title off
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //set to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(relativeLayout);
    }

    public static float convertPixelsToDp(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return (px / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}