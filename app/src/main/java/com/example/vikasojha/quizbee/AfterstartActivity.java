package com.example.vikasojha.quizbee;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;

public class AfterstartActivity extends AppCompatActivity {

    
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterstart);

        TextView textView=findViewById(R.id.DispName1);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
            textView.setText("Hello " + name);
        Button JAVA= findViewById(R.id.java);
        Button cpp= findViewById(R.id.cpp);
        Button c= findViewById(R.id.c);
        Button python= findViewById(R.id.python);

        JAVA.setOnClickListener(v -> {
            Intent intent1 = new Intent(getApplicationContext(), QuestionsActivity.class);
            intent1.putExtra("testname", "java");
            startActivity(intent1);

    });
        cpp.setOnClickListener(v -> {
            Intent intent1 = new Intent(getApplicationContext(), QuestionsActivity.class);
            intent1.putExtra("testname", "cpp");
            startActivity(intent1);
        });
        c.setOnClickListener(v -> {

            Intent intent1 = new Intent(getApplicationContext(), QuestionsActivity.class);
            intent1.putExtra("testname", "c");
            startActivity(intent1);
        });
        python.setOnClickListener(v -> {

            Intent intent1 = new Intent(getApplicationContext(), QuestionsActivity.class);
            intent1.putExtra("testname", "python");
            startActivity(intent1);
        });

    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent1 =new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent1);
                        finish();
                    }
                }).setNegativeButton("no", null).show();
    }
}