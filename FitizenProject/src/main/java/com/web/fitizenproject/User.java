package com.web.fitizenproject;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Data
@NoArgsConstructor
public class User
{
    private String id;
    private String pwd;
    private String name;
    private String email;
    private java.sql.Date birth;
    private java.sql.Date reg_date;
    private java.sql.Date up_date;

    public void setBirth(String bDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date udate = sdf.parse(bDate);
            this.birth = new java.sql.Date(udate.getTime());
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void setRegDate(String rDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date urdate = sdf.parse(rDate);
            this.reg_date = new java.sql.Date(urdate.getTime());
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void setUpDate(String sDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date usdate = sdf.parse(sDate);
            this.up_date = new java.sql.Date(usdate.getTime());
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}