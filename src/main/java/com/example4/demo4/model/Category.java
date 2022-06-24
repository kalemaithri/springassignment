package com.example4.demo4.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Category {
    @Id
    @GeneratedValue
    @Column(name="catid")
    private int id;
    @Column(unique =true)
    private String idcat;
    public String getCategory_id() {
        return idcat;
    }
    public void setCategory_id(String category_id) {
        this.idcat = category_id;
    }
    @Column(unique = true)
    private  String category_name;
    public int getId() {
        return id;
    }
    public Category() {
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCategory_name() {
        return category_name;
    }
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    

    

}
