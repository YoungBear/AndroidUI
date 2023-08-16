package com.example.androidui.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidui.R;

public class PreferenceTestActivity extends AppCompatActivity {

    private SharedPreferences mSharedPreferences;

    private TextView txtShow;
    private Button btnGet;
    private Button btnSet;
    private EditText etSet;

    private static final String PREF_NAME = "test_pref";
    private static final String PREF_KEY = "test_key";

    private static final String PREF_DEFAULT_VALUE = "default_value_string";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_test);
        mSharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        initViews();
    }

    private void initViews() {
        txtShow = (TextView) findViewById(R.id.txt_show);

        btnGet = (Button) findViewById(R.id.btn_get);
        btnSet = (Button) findViewById(R.id.btn_set);

        etSet = (EditText) findViewById(R.id.et_set);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = mSharedPreferences.getString(PREF_KEY, PREF_DEFAULT_VALUE);
                txtShow.setText(value);
            }
        });

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = etSet.getText().toString();
                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.putString(PREF_KEY, value);
                editor.apply();
            }
        });

    }

    /**
     * SharedPreference.Editor的apply和commit方法异同
     * 这两个方法的区别在于：
     * 1. apply没有返回值而commit返回boolean表明修改是否提交成功
     * 2. apply是将修改数据原子提交到内存, 而后异步真正提交到硬件磁盘,
     * 而commit是同步的提交到硬件磁盘，因此，在多个并发的提交commit的时候，
     * 他们会等待正在处理的commit保存到磁盘后在操作，从而降低了效率。
     * 而apply只是原子的提交到内容，后面有调用apply的函数的将会直接覆盖前面的内存数据，这样从一定程度上提高了很多效率。
     * 3. apply方法不会提示任何失败的提示。
     * 由于在一个进程中，sharedPreference是单实例，一般不会出现并发冲突，如果对提交的结果不关心的话，建议使用apply，
     * 当然需要确保提交成功且有后续操作的话，还是需要用commit的。
     * */

    @Override
    protected void onResume() {
        super.onResume();
        /**
         * 注册监听变化Listener的时候，不要使用匿名内部类，
         * */

        mSharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
//        mSharedPreferences.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
//            @Override
//            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
//                String value = sharedPreferences.getString(key, "default_value_string");
//                Log.d("bearyang", "key: " + key + ", value: " + value);
//                Toast.makeText(PreferenceTestActivity.this,
//                        "key: " + key + ", value: " + value,
//                        Toast.LENGTH_LONG).show();
//            }
//        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }


    private OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

            String value = sharedPreferences.getString(key, "default_value_string");
            Log.d("bearyang", "key: " + key + ", value: " + value);
            Toast.makeText(PreferenceTestActivity.this,
                    "key: " + key + ", value: " + value,
                    Toast.LENGTH_LONG).show();

        }
    };
}
