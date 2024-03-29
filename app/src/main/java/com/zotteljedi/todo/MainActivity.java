package com.zotteljedi.todo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ToDoAdapter adapter;
    private boolean showMenuTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewTodos = findViewById(R.id.listViewTodos);

        adapter = new ToDoAdapter(this, R.layout.todo_item, new ArrayList<ToDo>());

        listViewTodos.setAdapter(adapter);

        adapter.add(new ToDo("Einkaufen", false));
        adapter.add(new ToDo("Putzen", true));
        adapter.add(new ToDo("Katze füttern", true));
        adapter.add(new ToDo("Tomaten anbauen", false));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MenuDeleteCompletedTask:
                for (ToDo toDo : adapter.getCopyToDos()) {
                    if (toDo.isDone()) {
                        adapter.remove(toDo);
                    }
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void createNewToDo(View view) {
        final View customAlertView = getLayoutInflater().inflate(R.layout.create_todo, null);

        AlertDialog.Builder myAlertDialogBuilder = new AlertDialog.Builder(this);
        myAlertDialogBuilder.setView(customAlertView);
        myAlertDialogBuilder.setTitle("Neue Erinnerung erstellen");
        myAlertDialogBuilder.setCancelable(true);
        myAlertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText newTask = customAlertView.findViewById(R.id.txtNewToDo);
                String task = newTask.getText().toString();
                adapter.add(new ToDo(task));
            }
        });
        myAlertDialogBuilder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        myAlertDialogBuilder.show();
    }
}
