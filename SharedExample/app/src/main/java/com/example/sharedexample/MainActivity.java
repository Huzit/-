package com.example.sharedexample;

import android.content.SharedPreferences;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private EditText et_save;
    String shared = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText)findViewById(R.id.et_save);

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        //불러온다.
        String value = sharedPreferences.getString("park", "");

        //불러와서 셋팅해준다.
        et_save.setText(value);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //임시저장
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        //저장할 때 항상 에디터를 불러와줘야 한다.
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String value = et_save.getText().toString();
        //텍스트를 에디터에 넣어줬다.
        editor.putString("park", value);
        //커밋함
        editor.commit();
    }
}