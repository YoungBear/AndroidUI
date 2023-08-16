package com.example.androidui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidui.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class LoopTask2Activity extends AppCompatActivity {

    private TextView txtShow;

    private final Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop_task2);
        initViews();
    }

    private void initViews() {

        txtShow = (TextView) findViewById(R.id.txt_show);
        Button  btnStart = (Button) findViewById(R.id.btn_start);
        Button btnEnd = (Button) findViewById(R.id.btn_end);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.schedule(timerTask,
                        5 * 1000,//延迟5秒执行
                        1000);//周期为1秒
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
            }
        });

    }

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

    /**
     * 定义并初始化定时器任务
     * */
    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            /**
             * 此处执行任务,如网络访问,数据库操作等,然后可以通知UI线程更新UI
             * */
            mHanlder.sendEmptyMessage(1);//通知UI更新
        }
    };
}
