package com.example.remindme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private ArrayList<TaskToRemind> mTaskList;
    private Context mContext;

    public TaskAdapter(Context context, ArrayList<TaskToRemind> taskList) {
        mTaskList = taskList;
        mContext = context;
    }

    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.task_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position) {
        TaskToRemind currentTask = mTaskList.get(position);
        holder.bindTo(currentTask);
    }

    @Override
    public int getItemCount() {
        return mTaskList.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mNameTextView;
        private TextView mDetailTextView;

        private ViewHolder(View itemView) {
            super(itemView);

            mNameTextView = itemView.findViewById(R.id.taskName_textview);
            mDetailTextView = itemView.findViewById(R.id.taskDetails_textview);
        }

        private void bindTo(TaskToRemind taskList) {
            mNameTextView.setText(taskList.getTask_name());
            mDetailTextView.setText(taskList.getTask_details());
        }
    }
}
