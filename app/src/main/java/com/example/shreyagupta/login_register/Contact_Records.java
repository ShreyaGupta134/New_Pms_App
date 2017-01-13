package com.example.shreyagupta.login_register;

/**
 * Created by Shreya Gupta on 06-01-2017.
 */

public class Contact_Records {
    String pre_med ,type, diagnosis,date,id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPre_med() {

        return pre_med;

    }

    public void setPre_med(String pre_med) {
        this.pre_med = pre_med;
    }


    public void setDiagnosis(String diagnosis) {

        this.diagnosis = diagnosis;
    }



      public void setDate(String date) {

        this.date = date;
    }

    public String getDiagnosis() {
        return diagnosis;
    }


    public String getDate() {

        return date;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {

        return type;
    }

}
