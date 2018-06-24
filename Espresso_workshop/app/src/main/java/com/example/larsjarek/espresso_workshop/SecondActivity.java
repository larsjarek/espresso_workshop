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
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
    RelativeLayout relativeLayout;
    ScrollView scrollView;
    private TextView title;
    private RelativeLayout.LayoutParams titleParams; 
    private Button colorButton;
    private RelativeLayout.LayoutParams colorButtonParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Getting screen size
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        int space = height/40;

        relativeLayout = new RelativeLayout(this);
        scrollView = new ScrollView(this);


        //loginInputField
        titleParams = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        titleParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        titleParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        titleParams.setMargins(0, space*10, 0, 0);
        title = new TextView(this);
        title.setTextSize(convertPixelsToDp(30, this) * getResources().getDisplayMetrics().scaledDensity);
        title.setTextColor(Color.BLACK);
        title.setTypeface(null, Typeface.BOLD);
        title.setId(R.id.welcome_text);
        title.setText("Welcome");


        colorButtonParams = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        colorButtonParams.addRule(RelativeLayout.BELOW, title.getId());
        colorButtonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        colorButtonParams.setMargins(0, height, 0, space * 10);
        colorButton = new Button(this);
        colorButton.setTextSize(convertPixelsToDp(16, this) * getResources().getDisplayMetrics().scaledDensity);
        colorButton.setTextColor(Color.BLACK);
        colorButton.setBackgroundColor(Color.GRAY);
        colorButton.setWidth(width/3);
        colorButton.setMaxWidth(width/3);
        colorButton.setHeight(space*3);
        colorButton.setMaxHeight(space*3);
        colorButton.setTypeface(null, Typeface.BOLD);
        colorButton.setId(R.id.color_button);
        colorButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(MotionEvent.ACTION_UP == event.getAction()) {
                    colorButton.setBackgroundColor(Color.RED);
                }
                return true;
            }
        });
        colorButton.setText("LOGIN");

        // Add views to layout
        relativeLayout.addView(title, titleParams);
        relativeLayout.addView(colorButton, colorButtonParams);
        scrollView.addView(relativeLayout);

        //turn title off
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //set to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(scrollView);
    }

    public static float convertPixelsToDp(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return (px / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
