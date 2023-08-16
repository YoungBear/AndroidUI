package com.example.androidui.activity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidui.R;

public class DisplayActivity extends AppCompatActivity {

    private TextView txtContent;
    private TextView txtString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        initView();

    }


    private void initView() {
        txtContent = (TextView) findViewById(R.id.txt_content);
        txtString = (TextView) findViewById(R.id.txt_string);

        txtContent.setScrollContainer(true);

        txtContent.setText(getDisplayInfo());
    }

    private String getDisplayInfo() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
        float widthPixels = dm.widthPixels;
        float heightPixels = dm.heightPixels;
        float densityDpi = dm.densityDpi;
        float xdpi = dm.xdpi;
        float ydpi = dm.ydpi;
        String result = "density: " + density
                + "\nwidthPixels: " + widthPixels
                + "\nheightPixels: " + heightPixels
                + "\ndensityDpi: " + densityDpi
                + "\nxdpi: " + xdpi
                + "\nydpi: " + ydpi;
        return result;
    }



}
