package com.example.cv051529.cerner_interns;

import java.util.Date;

/**
 * Created by DR051643 on 6/19/2017.
 */

public class Question {
    public String title;
    public int questionIndex;
    public String description;
    public Date date;
    public String userEmail;
    public boolean verified;

    public Question(String title, String description, Date date, String userEmail,
                    int questionIndex, boolean verified)
    {
        this.title = title;
        this.description = description;
        this.date = date;
        this.userEmail = userEmail;
        this.questionIndex = questionIndex;
        this.verified = verified;
    }
}
