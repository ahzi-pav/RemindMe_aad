package com.example.remindme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<TaskToRemind> mTaskList;
    private TaskAdapter mAdapter;
    private ArrayList<TaskToRemind> taskList;

    private DialogFragment dialogFragment;

    private TextView mNameTextView;
    private TextView mDetailTextView;

    private EditText name;
    private EditText detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = findViewById(R.id.recyclerView);
        mTaskList = new ArrayList<>();
        mAdapter = new TaskAdapter(this, mTaskList);
        taskList = new ArrayList<>();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        mNameTextView = findViewById(R.id.taskName_textview);
        mDetailTextView = findViewById(R.id.taskDetails_textview);

    }

    public void onOpenDialog(View view) {
        dialogFragment = new AddItemFragment();
        dialogFragment.show(getSupportFragmentManager(), "Dialog Fragment");
    }

    public void setData() {
        EditText name = dialogFragment.getDialog().findViewById(R.id.name_editText);
        EditText detail = dialogFragment.getDialog().findViewById(R.id.detail_editText);
        taskList.add(new TaskToRemind(name.getText().toString(), detail.getText().toString()));
    }
}