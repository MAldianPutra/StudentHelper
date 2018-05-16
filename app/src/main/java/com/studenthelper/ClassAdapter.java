package com.studenthelper;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.studenthelper.Class.BuildClass;

import java.util.List;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder> {
    private List<BuildClass> items;
    private int itemLayout;

    public ClassAdapter(List<BuildClass> items, int itemLayout) {
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @NonNull
    @Override
    public ClassAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ClassAdapter.ViewHolder holder, int position) {
        BuildClass item = items.get(position);
        holder.className.setText(item.getClassName());
        holder.lecturerName.setText(item.getLecturerName());
        holder.dayDate.setText(item.getDateTime());
        holder.comment.setText(item.getCommentText());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView className;
        public TextView lecturerName;
        public TextView dayDate;
        public TextView comment;

        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}
