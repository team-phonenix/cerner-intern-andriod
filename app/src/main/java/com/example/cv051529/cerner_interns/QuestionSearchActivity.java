package com.example.cv051529.cerner_interns;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

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
        final ListView myView = (ListView)findViewById(R.id.questionListView);
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
        myView.setClickable(true);
        myView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Question currentQuestion = (Question)myView.getItemAtPosition(i);
                goToQuestion(currentQuestion, view);
            }
        });
        /*
        final TextView mTextView = (TextView) findViewById(R.id.textView2);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://10.190.232.162:3000/question";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        mTextView.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!: " + error.getMessage());
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);*/

        final TextView mTxtDisplay;
        ImageView mImageView;
        mTxtDisplay = (TextView) findViewById(R.id.textView2);
        String url = "http://10.190.232.162:3000/question";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        mTxtDisplay.setText("Response: " + response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        mTxtDisplay.setText("You done gooffed: " + error.getMessage());
                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);
    }



    void goToQuestion(Question q, View view)
    {
        Snackbar.make(view,q.title,
                Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

}