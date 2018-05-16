package com.studenthelper.Class;

public class BuildClass {
    private String ClassName;
    private String LecturerName;
    private String dateTime;
    private String commentText;

    public BuildClass(String className, String lecturerName, String dateTime, String commentText) {
        ClassName = className;
        LecturerName = lecturerName;
        this.dateTime = dateTime;
        this.commentText = commentText;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getLecturerName() {
        return LecturerName;
    }

    public void setLecturerName(String lecturerName) {
        LecturerName = lecturerName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
