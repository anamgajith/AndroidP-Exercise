package com.anamgajith.jsonproject;

import com.google.gson.annotations.SerializedName;

public class Student {
    private int cc;
    private String email;
    private String name;
    @SerializedName("course")
    private Course mCourse;

    public Student(int cc, String email, String name, Course mCourse) {
        this.cc = cc;
        this.email = email;
        this.name = name;
        this.mCourse = mCourse;
    }
}
