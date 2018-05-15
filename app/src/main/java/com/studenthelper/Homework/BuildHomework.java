package com.studenthelper.Homework;

public class BuildHomework {
    private String name;
    private String className;
    private String deadlineDate;
    private String reminderDate;
    private String commentText;

    public BuildHomework(String name, String className, String deadlineDate, String reminderDate, String commentText) {
        this.name = name;
        this.className = className;
        this.deadlineDate = deadlineDate;
        this.reminderDate = reminderDate;
        this.commentText = commentText;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public String getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(String reminderDate) {
        this.reminderDate = reminderDate;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
