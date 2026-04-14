package com.learn.model;

public class Student {

    private int    id;
    private String name;
    private String email;
    private String course;
    private double marks;

    // Default constructor
    public Student() {}

    // Parameterized constructor
    public Student(int id, String name, String email,
                   String course, double marks) {
        this.id     = id;
        this.name   = name;
        this.email  = email;
        this.course = course;
        this.marks  = marks;
    }

    // Getters and Setters
    public int    getId()     { return id; }
    public String getName()   { return name; }
    public String getEmail()  { return email; }
    public String getCourse() { return course; }
    public double getMarks()  { return marks; }

    public void setId(int id)         { this.id = id; }
    public void setName(String name)   { this.name = name; }
    public void setEmail(String e)     { this.email = e; }
    public void setCourse(String c)    { this.course = c; }
    public void setMarks(double m)     { this.marks = m; }
}

