package com.example.shreyagupta.login_register;

/**
 * Created by Shreya Gupta on 19-12-2016.
 */

public class Contact{
    int id ;
    String age,contact_no;
            String name,gender;

    public void setId (int id) {
        this.id = id ;
    }

    public int getId () {
        return  this.id ;
    }

    public void setage(String age){
        this.age=age;

    }

    public String getage(){
        return  age;
    }

    public void setContact_no(String contact_no){
        this.contact_no=contact_no;

    }

    public String getContact_no(){
        return  contact_no;
    }

    public void setname(String name){
        this.name=name;

    }

    public String getname(){
        return name;
    }

    public void setgender(String gender){
        this.gender=gender;

    }

    public String  getgender(){
        return gender;
    }

}
