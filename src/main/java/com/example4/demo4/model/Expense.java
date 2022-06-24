package com.example4.demo4.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Expense {
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true)
    private int expense_id;
    private String date;
    private String  description;
    private String location;
    private int categoryid;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getExpense_id() {
        return expense_id;
    }
    public void setExpense_id(int expense_id) {
        this.expense_id = expense_id;
    }
    public Expense() {
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getLoaction() {
        return location;
    }
    public void setLoaction(String loaction) {
        this.location = loaction;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getCategoryid() {
        return categoryid;
    }
    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }
 


    
}
