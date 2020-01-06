package com.example.lab2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lab2.R;
import com.example.lab2.model.Task;
import com.example.lab2.util.FileUtil;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        final EditText taskName = findViewById(R.id.update_task_name_field);
        final EditText dueDate = findViewById(R.id.update_due_date_day_edit_field);
        final EditText dueTime = findViewById(R.id.update_due_time_edit_field);
        final EditText taskNotes = findViewById(R.id.update_notes_edit_field);

        ImageView saveTask = findViewById(R.id.action_bar_done);
        ImageView backButton = findViewById(R.id.action_bar_back_arrow);

        if (getIntent().getExtras() != null) {
            Task taskFromFile = FileUtil.getTaskFormFileByDate(getIntent().getStringExtra("date"));
            if (taskFromFile != null) {
                taskName.setText(taskFromFile.getTaskName());
                dueDate.setText(taskFromFile.getTaskDueDate());
                dueDate.setEnabled(false);
                dueTime.setText(taskFromFile.getTaskDueTime());
                taskNotes.setText(taskFromFile.getTaskNotes());
            }
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        saveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task newTask = new Task.Builder()
                        .setTaskName(taskName.getText().toString())
                        .setTaskDueDate(dueDate.getText().toString())
                        .setTaskDueTime(dueTime.getText().toString())
                        .setTaskNotes(taskNotes.getText().toString())
                        .build();

                FileUtil.updateTask(newTask);
                Toast.makeText(UpdateActivity.this, "Task Updated", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}
