package com.zotteljedi.todo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewTodos = findViewById(R.id.listViewTodos);

        ToDoAdapter adapter = new ToDoAdapter(getApplicationContext(), R.layout.todo_item, new ArrayList<ToDo>());

        listViewTodos.setAdapter(adapter);

        adapter.add(new ToDo("Einkaufen", false));
        adapter.add(new ToDo("Putzen", true));
    }
}
