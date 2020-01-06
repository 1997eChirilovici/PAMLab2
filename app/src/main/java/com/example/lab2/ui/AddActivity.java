package com.example.lab2.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2.model.Task;
import com.example.lab2.util.FileUtil;
import com.example.lab2.R;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        final EditText taskName = findViewById(R.id.task_name_edit_field);
        final EditText dueDate = findViewById(R.id.due_date_day_edit_field);
        final EditText dueTime = findViewById(R.id.due_time_edit_field);
        final EditText taskNotes = findViewById(R.id.notes_edit_field);

        ImageView saveTask = findViewById(R.id.action_bar_done);
        ImageView backButton = findViewById(R.id.action_bar_back_arrow);

        if (getIntent().getExtras() != null) {
            dueDate.setText(getIntent().getStringExtra("date"));
            dueDate.setEnabled(false);
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        saveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task newTask = new Task.Builder()
                        .setTaskName(taskName.getText().toString())
                        .setTaskDueDate(dueDate.getText().toString())
                        .setTaskDueTime(dueTime.getText().toString())
                        .setTaskNotes(taskNotes.getText().toString())
                        .build();

                FileUtil.saveContentInFile(newTask);
                Toast.makeText(AddActivity.this, "Task Saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

}
