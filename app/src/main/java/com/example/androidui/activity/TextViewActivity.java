package com.example.androidui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidui.R;

public class TextViewActivity extends AppCompatActivity {

    private TextView txtShow;
    private EditText et1;
    private Button btnConfirm;
    private Button btnStart;
    private Button btnMiddle;
    private Button btnEnd;
    private Button btnMarquee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        initView();
    }

    private void initView(){

        txtShow = (TextView) findViewById(R.id.txt_show);
        et1 = (EditText) findViewById(R.id.et1);
        btnConfirm = (Button) findViewById(R.id.btn_confirm);
        btnStart = (Button) findViewById(R.id.btn_start);
        btnMiddle = (Button) findViewById(R.id.btn_middle);
        btnEnd = (Button) findViewById(R.id.btn_end);
        btnMarquee = (Button) findViewById(R.id.btn_marquee);

        btnConfirm.setOnClickListener(btnClickListener);
        btnStart.setOnClickListener(btnClickListener);
        btnMiddle.setOnClickListener(btnClickListener);
        btnEnd.setOnClickListener(btnClickListener);
        btnMarquee.setOnClickListener(btnClickListener);

    }

    private View.OnClickListener btnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.btn_confirm:
                    String content = et1.getText().toString();
                    txtShow.setText(content);
                    break;
                case R.id.btn_start:
                    txtShow.setEllipsize(TextUtils.TruncateAt.START);
                    break;
                case R.id.btn_middle:
                    txtShow.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                    break;
                case R.id.btn_end:
                    txtShow.setEllipsize(TextUtils.TruncateAt.END);
                    break;
                case R.id.btn_marquee:
                    txtShow.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                    txtShow.setMarqueeRepeatLimit(-1);
                    break;

            }
        }
    };
}
