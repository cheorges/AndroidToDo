package com.zotteljedi.todo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     private ToDoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewTodos = findViewById(R.id.listViewTodos);

        adapter = new ToDoAdapter(getApplicationContext(), R.layout.todo_item, new ArrayList<ToDo>());

        listViewTodos.setAdapter(adapter);

        adapter.add(new ToDo("Einkaufen", false));
        adapter.add(new ToDo("Putzen", true));
    }

    public void createNewToDo(View view) {
        // ToDo erstellen und zur Liste hinzufügen
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        final View alertView = getLayoutInflater().inflate(R.layout.create_todo, null);
        alertDialogBuilder.setView(alertView);
        alertDialogBuilder.setTitle("Neue Erinnerung erstellen");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                EditText txtNewTodo = alertView.findViewById(R.id.txtNewToDo);
                ToDo toDo = new ToDo(txtNewTodo.getText().toString());
                adapter.add(toDo);
            }
        });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialogBuilder.show();
    }
}
