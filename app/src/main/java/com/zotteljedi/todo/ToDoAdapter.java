package com.zotteljedi.todo;

import android.content.Context;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.todo_item, parent, false);
        }

        ToDo toDo = getItem(position);

        CheckBox checkBoxToDo = convertView.findViewById(R.id.checkboxIsDone);
        ImageButton btnDelete = convertView.findViewById(R.id.btnDelete);

        checkBoxToDo.setText(toDo.getTask());
        checkBoxToDo.setChecked(toDo.isDone());

        return convertView;
    }
}
