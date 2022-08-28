package com.nantus.loginportal;
import javax.persistence.*;

@Entity
@Table(name ="Administrator")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int admin_id; 
    @Column(nullable = false, length = 45)
    private String admin_name; 
    @Column(nullable = false, length = 64)
    private String admin_password;
    @Column(nullable = false, length = 45, unique = true)
    private String admin_email; 
    
    public Admin() {
    }

    public Admin(String admin_name, String admin_email, String admin_password) {
        this.admin_name = admin_name;
        this.admin_email = admin_email;
        this.admin_password = admin_password;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    } 
}
