package com.example.cv051529.cerner_interns;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
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

        Uri originalPage = getIntent().getData();

        Uri uri = Uri.parse("http://10.190.232.162:8081/LoginServices");
        final Intent logInPage = new Intent(Intent.ACTION_VIEW, uri);

        Button btnLogIn = (Button) (findViewById(R.id.log_in_btn));
        btnLogIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                startActivity(logInPage);
            }
        });
        try {
            String email = originalPage.getQueryParameter("email");
            goToMainActivity(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToMainActivity(String email)
    {
        Intent mainActivityIntent = new Intent(this,MainActivity.class);
        mainActivityIntent.putExtra("email", email);
        startActivity(mainActivityIntent);
    }

}
