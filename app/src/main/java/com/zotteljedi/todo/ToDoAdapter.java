package com.zotteljedi.todo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;

import java.util.List;

public class ToDoAdapter extends ArrayAdapter<ToDo> {

    public ToDoAdapter(Context context, int resource, List<ToDo> toDos) {
        super(context, resource, toDos);
    }

    @Override
    public View getView(int position, View toDoRowView, ViewGroup parent) {
        if (toDoRowView == null) {
            toDoRowView = LayoutInflater.from(getContext()).inflate(R.layout.todo_item, parent, false);
        }

        final ToDo toDo = getItem(position);

        CheckBox checkBoxToDo = toDoRowView.findViewById(R.id.checkboxIsDone);
        ImageButton btnDelete = toDoRowView.findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myAlertDialogBuilder = new AlertDialog.Builder(getContext());
                myAlertDialogBuilder.setTitle("Löschen");
                myAlertDialogBuilder.setMessage("Erinnerung wirklich löschen?");
                myAlertDialogBuilder.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        remove(toDo);
                    }
                });
                myAlertDialogBuilder.setNegativeButton("Nein", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                myAlertDialogBuilder.show();
            }
        });

        checkBoxToDo.setText(toDo.getTask());
        checkBoxToDo.setChecked(toDo.isDone());

        return toDoRowView;
    }
}
