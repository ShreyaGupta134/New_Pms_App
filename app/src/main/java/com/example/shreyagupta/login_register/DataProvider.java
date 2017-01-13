package com.example.shreyagupta.login_register;

/**
 * Created by Shreya Gupta on 28-12-2016.
 */

public class DataProvider {

    private String name;
    private String age;
    private String Contact_no,id;


    public String getContact_no() {

        return Contact_no;

    }

    public void setContact_no(String contact_no) {
        Contact_no = contact_no;
    }

    public String getAge() {

        return age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(String age) {

        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

     public DataProvider(String name, String age, String Contact_no,String id){

         this.name=name;
         this.age=age;
         this.Contact_no=Contact_no;
         this.id=id;

     }



}