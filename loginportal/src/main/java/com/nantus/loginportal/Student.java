package com.nantus.loginportal;

import javax.persistence.*;

@Entity
@Table(name ="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id; 
    @Column(nullable = false, length = 45)
    private String student_name; 
    @Column(nullable = false, length = 45)
    private String student_address; 
    @Column(nullable = false, length = 45, unique = true)
    private String student_email; 
    @Column(nullable = false, length = 64)
    private String student_password; 
    @Column(nullable = false, length = 45)
    private int student_course;

    
    
    public Student() {
    }

    public Student(String student_name, String student_address,int student_course, String student_email, String student_password) {
        this.student_name = student_name;
        this.student_address = student_address;
        this.student_email = student_email;
        this.student_password = student_password;
        this.student_course = student_course;
    }
    
    public int getStudent_id() {
        return student_id;
    }
    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
    public String getStudent_name() {
        return student_name;
    }
    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
    public String getStudent_address() {
        return student_address;
    }
    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }
    public String getStudent_email() {
        return student_email;
    }
    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }
    public String getStudent_password() {
        return student_password;
    }
    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }
    public int getStudent_course() {
        return student_course;
    }
    public void setStudent_course(int student_course) {
        this.student_course = student_course;
    } 
}
