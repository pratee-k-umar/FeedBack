package org.example.models;

public class Comment {
    private int id;
    private String email;
    private String phone;
    private String comment;

    public Comment(int id, String email, String phone, String comment) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getComment() {
        return comment;
    }
}