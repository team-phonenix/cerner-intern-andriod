package com.example.cv051529.cerner_interns;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class QuestionSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        FirstExample ex = new FirstExample();
        TextView txt2 = (TextView)findViewById(R.id.textView2);
        txt2.setText("hi how r u");
        //String testArray[] = ex.myMain();
        //ArrayAdapter testList = new ArrayAdapter(this, android.R.layout.simple_list_item_1,testArray);
        ListView myView = (ListView)findViewById(R.id.questionListView);
        //myView.setAdapter(testList);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        ArrayList<Question> questionArray = new ArrayList<Question>();
        try {

            questionArray.add(new Question("Stupid Question", "Blarg",
                    sdf.parse("06/20/2017"), "leroy.jenkins@Cerner.com", 1, false));
            questionArray.add(new Question("Even Stupider Question", "BlargX2",
                    sdf.parse("06/17/2017"), "bilbogiligan.juniorIII@Cerner.com", 2, false));
            questionArray.add(new Question("Da Stupidest Question Eva", "BlargX3",
                    sdf.parse("06/15/2017"), "hogi.johnson@Cerner.com", 3, false));
            //questionArray.add();
        }
        catch (ParseException e)
        {

        }
        QuestionAdapter adapter = new QuestionAdapter(this, questionArray);
        myView.setAdapter(adapter);
    }

}