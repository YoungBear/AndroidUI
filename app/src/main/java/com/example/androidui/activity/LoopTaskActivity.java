package com.example.androidui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidui.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LoopTaskActivity extends Activity {

    private TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop_task);
        initViews();
    }

    private void initViews() {

        txtShow = (TextView) findViewById(R.id.txt_show);
        Button btnStart = (Button) findViewById(R.id.btn_start);
        Button btnEnd = (Button) findViewById(R.id.btn_end);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHanlder.postDelayed(task, 1000);//第一次调用,延迟1秒执行task
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHanlder.removeCallbacks(task);
            }
        });

    }

    /**
     * Handler可以用来更新UI
     * */
    private Handler mHanlder = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                    Date currentDate = new Date();
                    String displayTime1 = format1.format(currentDate);

                    txtShow.setText(displayTime1);
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };

    private Runnable task = new Runnable() {
        @Override
        public void run() {
            /**
             * 此处执行任务,如网络访问,数据库操作等,然后可以通知UI线程更新UI
             * */
            mHanlder.sendEmptyMessage(1);
            mHanlder.postDelayed(this, 5 * 1000);//延迟5秒,再次执行task本身,实现了循环的效果
        }
    };
}
