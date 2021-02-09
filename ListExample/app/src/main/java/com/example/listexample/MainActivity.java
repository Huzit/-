package com.example.listexample;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //list view의 id값은 가져왔다.
        list = (ListView)findViewById(R.id.list);
        /*이제 데이터를 저장해볼 시간,
          데이터를 저장하기 위해 스트링 타입의 배열 하나를 만들어 준다.*/
        List<String> data = new ArrayList<>();

        //ListView에 데이터를 연결해주려면 Adapter가 필요하다
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter); //ListView에 adapter을 셋팅해준다(연결)

        //이제 연결을 했으니 아이템을 추가해보자
        data.add("신과같은 시선에 있는자");
        data.add("'나'라는 신이 이곳에 존재하고 있지");
        data.add("아아 그렇다");

        //데이터를 변경했다면 저장 해줘야 한다.
        adapter.notifyDataSetChanged();

    }}