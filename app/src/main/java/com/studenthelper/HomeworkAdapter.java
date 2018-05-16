package com.studenthelper;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.studenthelper.Homework.BuildHomework;

import org.w3c.dom.Text;

import java.util.List;

public class HomeworkAdapter extends RecyclerView.Adapter<HomeworkAdapter.ViewHolder>{
    private List<BuildHomework> items;
    private int itemLayout;

    public HomeworkAdapter(List<BuildHomework> items, int itemLayout) {
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @NonNull
    @Override
    public HomeworkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.homework_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeworkAdapter.ViewHolder holder, int position) {
        BuildHomework item = items.get(position);
        holder.name.setText(item.getName());
        holder.classname.setText(item.getClassName());
        holder.deadlinedate.setText(item.getDeadlineDate());
        holder.reminderdate.setText(item.getReminderDate());
        holder.comment.setText(item.getCommentText());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView classname;
        public TextView deadlinedate;
        public TextView reminderdate;
        public TextView comment;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.homeworkName);
            classname = (TextView) itemView.findViewById(R.id.className);
            deadlinedate = (TextView) itemView.findViewById(R.id.deadlineDate);
            reminderdate = (TextView) itemView.findViewById(R.id.reminderdate);
            comment = (TextView) (TextView) itemView.findViewById(R.id.comment);
        }
    }
}
