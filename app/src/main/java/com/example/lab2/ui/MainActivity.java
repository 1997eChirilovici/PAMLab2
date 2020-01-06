package com.example.lab2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.lab2.R;
import com.example.lab2.util.DateUtil;
import com.example.lab2.util.FileUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CalendarView calendarView = findViewById(R.id.main_calendar);

        final ConstraintLayout addTask = findViewById(R.id.add_task_button);
        final ConstraintLayout editTask = findViewById(R.id.edit_task_button);
        final ConstraintLayout deleteTask = findViewById(R.id.delete_task_button);
        Log.d("CAL", "onCreate() returned: " + calendarView.getDate());


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull final CalendarView calendarView, int year, int month, int dayOfMonth) {

                String currentDate = year + "-" + month + "-" + dayOfMonth;
                final String newDate = DateUtil.convertToDate(currentDate);
                Log.d("CALND", "onSelectedDayChange() returned: " + newDate);

                addTask.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (FileUtil.getTaskFormFileByDate(newDate) == null) {
                            Intent intent = new Intent(MainActivity.this, AddActivity.class);
                            intent.putExtra("date", newDate);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Task Exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                editTask.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (FileUtil.getTaskFormFileByDate(newDate) != null) {
                            Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                            intent.putExtra("date", newDate);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Task don't Exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                deleteTask.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (FileUtil.getTaskFormFileByDate(newDate) != null) {
                            Intent intent = new Intent(MainActivity.this, DeleteActivity.class);
                            intent.putExtra("date", newDate);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Task don't Exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}
