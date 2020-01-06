package com.example.lab2.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2.R;
import com.example.lab2.util.FileUtil;

public class DeleteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        FileUtil.removeTask(getIntent().getStringExtra("date"));
        Toast.makeText(DeleteActivity.this, "Task deleted successful", Toast.LENGTH_SHORT).show();
        finish();
    }
}
