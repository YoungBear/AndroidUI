package com.example.androidui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidui.activity.BuildInfoActivity;
import com.example.androidui.activity.DisplayActivity;
import com.example.androidui.activity.LoopTask2Activity;
import com.example.androidui.activity.LoopTaskActivity;
import com.example.androidui.activity.PreferenceTestActivity;
import com.example.androidui.activity.TextViewActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        Button btnDisplay = (Button) findViewById(R.id.btn_display);
        Button btnTextView = (Button) findViewById(R.id.btn_textview);
        Button btnBuildInfo = (Button) findViewById(R.id.btn_build_info);
        Button btnLoopTask = (Button) findViewById(R.id.btn_loop_task);
        Button btnLoopTask2 = (Button) findViewById(R.id.btn_loop_task2);
        Button btnPreference = (Button) findViewById(R.id.btn_preference);

        btnDisplay.setOnClickListener(buttonListener);
        btnTextView.setOnClickListener(buttonListener);
        btnBuildInfo.setOnClickListener(buttonListener);
        btnLoopTask.setOnClickListener(buttonListener);
        btnLoopTask2.setOnClickListener(buttonListener);
        btnPreference.setOnClickListener(buttonListener);

    }

    private void startActivity(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    private View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.btn_display:
                    startActivity(DisplayActivity.class);
                    break;
                case R.id.btn_textview:
                    startActivity(TextViewActivity.class);
                    break;
                case R.id.btn_build_info:
                    startActivity(BuildInfoActivity.class);
                    break;
                case R.id.btn_loop_task:
                    startActivity(LoopTaskActivity.class);
                    break;
                case R.id.btn_loop_task2:
                    startActivity(LoopTask2Activity.class);
                    break;
                case R.id.btn_preference:
                    startActivity(PreferenceTestActivity.class);
                    break;
                default:
                    break;

            }
        }
    };
}
