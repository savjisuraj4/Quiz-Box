package com.example.vikasojha.quizbee;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    String[] questions;
    String[] opt;
    String[] answers;
    RadioButton rb1,rb2,rb3,rb4;
    CountDownTimer count;
    long pressedTime;
    String[] JAVA = {
                            "Which method can be defined only once in a program?",
                            "Which of these is not a bitwise operator?",
                            "Which keyword is used by method to refer to the object that invoked it?",
                            "Which of these keywords is used to define interfaces in Java?",
                            "Which of these access specifiers can be used for an interface?",
                            "Which of the following is correct way of importing an entire package ‘pkg’?",
                            "What is the return type of Constructors?",
                            "Which of the following package stores all the standard java classes?",
                            "Which of these method of class String is used to compare two String objects for their equality?",
                            "An expression involving byte, int, & literal numbers is promoted to which of these?"
                         };
    String[] JAVAanswers = {"main method","<=","this","interface","public","import pkg.*","None of the mentioned","java","equals()","int"};
    String[] JAVAopt = {
                    "finalize method","main method","static method","private method",
                    "&","&=","|=","<=",
                    "import","this","catch","abstract",
                    "Interface","interface","intf","Intf",
                    "public","protected","private","All of the mentioned",
                    "Import pkg.","import pkg.*","Import pkg.*","import pkg.",
                    "int","float","void","None of the mentioned",
                    "lang","java","util","java.packages",
                    "equals()","Equals()","isequal()","Isequal()",
                     "int","long","byte","float"
                   };


    String[] PYTHON ={
            "Is Python case sensitive when dealing with identifiers?",
            "Which of the following is an invalid variable?",
"            Which of the following is the correct extension of the Python file?",
            "Which keyword is used for function in Python language ?",
            "Which of the following character is used to give single-line comments in Python?",
            "Which of the following functions can help us to find the version of python that we are currently working on?",
            "Python supports the creation of anonymous functions at runtime, using a construct called __________",
            "Which of the following functions is a built-in function in python?",
            " Which of the following is not a core data type in Python programming?",
            "Which one of the following is not a keyword in Python language?"
    };
    String[] PYTHONopt ={
            "no","yes", "machine dependent", "none of the mentioned",
            "my_string_1", "1st_string", "foo", "str",
            ".python ",".pl",".py",".p",
            "Function" ,"def" , "Fun" ,"Define",
            "//", "#", "!", "/*",
            "sys.version(1)", "sys.version(0)", "sys.version()" ,"sys.version",
            "pi","anonymous","lambda","none of the mentioned",
            "factorial()", "print()" ,"seed()" ,"add()",
            "Tuples", "Lists", "Class","Dictionary",
            "pass", "eval", "assert", "nonlocal",
    };
    String[] PYTHONanswers ={"yes","1st_string",".py","def","#","sys.version(1)","lambda","print()","Class","eval"
    };


    String[] CPP ={
            "Which of the following is not a C++ keyword?",
            "____ is a variable that holds a memory address.",
            "Which one of the following is a membership operator?",
            "____ Operator requires two operands.",
            "Binary plus (+) and Binary minus (-) are ___ operator.",
            "Which operator requires three operands?",
            "____ data types are structure, union, class and enumeration.",
            "Which operator is used to compare numerical values?",
            "____ allocates memory, based on the data type of the variable",
            "The function bad( ) is declared in the header file"
    };
    String[] CPPopt ={"This", "New", "Cont", "If",
            "Long double", "Float", "Char", "Pointer",
            "!", "&", "::", ".",
            "Logical", "Binary", "Unary", "Ternary",
            "Additive", "Multiplicative", "Shift", "Bitwise",
            "Unary", "Binary", "Ternary","Bitwise",
            "Derived", "Integer", "Built-in", "User defined",
            "Relational", "Conditional" ,"Assignment" ,"Arithmetic",
            "Interpreter", "Link", "Converter","Compiler",
            "<iostream.h>","<stdio.h>","<math.h>","<stdlib.h>"
    };
    String[] CPPanswers ={"Cont","Pointer","::","Binary","Additive","Ternary","User defined","Relational","Compiler","<math.h>"
    };

    String[] C={
            "The address of a variable can be obtained using _____ operator.",
            "Which of the following is not a valid C variable name?",
            "Which keyword is used to prevent any changes in the variable within a C program?",
            "What is an example of iteration in C?",
            "Which of the following return-type cannot be used for a function in C?",
            "In C language, FILE is of which data type?",
            "What is the sizeof(char) in a 32-bit C compiler?",
            "scanf() is a predefined function in______header file.",
            " Which of the following is used for comments in C?",
           "Which of the following function is more appropriate for reading in a multi-word string?"
    };
    String[] Copt={" *", "&", "?", ";",
            "int number;", "float rate;","int variable_count;","int $main;",
            "immutable", "mutable","const", "volatile",
            "for", "while", "do-while", "all of the mentioned",
            "char " ,"struct" ,"void", "none of the mentioned",
            "int", "char *" ,"struct","None of the mentioned",
            "1 bit", "2 bits", "1 Byte", "2 Bytes",
            "stdlib. h", "ctype. h", "stdio. h", "stdarg. h",
            "/* comment */", "// comment */", "// comment", "both // comment or /* comment */",
            "printf();", "scanf();", "gets();", "puts()"
    };
    String[] Canswers={"&","int $main;","const","all of the mentioned","none of the mentioned","struct","1 Byte","stdio. h","both // comment or /* comment */","gets();"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = findViewById(R.id.textView4);
        TextView textView=findViewById(R.id.editTextTime);
        count=new CountDownTimer(300000,1000){
            public void onTick(long millisUntilFinished) {
                // Used for formatting digit to be in 2 digits only
                NumberFormat f = new DecimalFormat("00");
                //long hour = (millisUntilFinished / 3600000) % 24;
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                textView.setText("Time Remained : " +f.format(min) + ":" + f.format(sec));
            }

            public void onFinish() {
                Toast.makeText(getApplicationContext(),"Time Over",Toast.LENGTH_SHORT).show();
                Intent intent1 =new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent1);
            }
        };


        Intent intent = getIntent();
        String testname= intent.getStringExtra("testname").toLowerCase();

        submitbutton=findViewById(R.id.button3);
        quitbutton= findViewById(R.id.buttonquit);
        tv= findViewById(R.id.tvque);

        radio_g= findViewById(R.id.answersgrp);
        rb1=findViewById(R.id.radioButton);
        rb2=findViewById(R.id.radioButton2);
        rb3= findViewById(R.id.radioButton3);
        rb4=findViewById(R.id.radioButton4);
        count.start();
        switch (testname) {
            case "java":
                questions = JAVA;
                answers = JAVAanswers;
                opt = JAVAopt;
                break;
            case "python":
                questions = PYTHON;
                answers = PYTHONanswers;
                opt = PYTHONopt;
                break;
            case "cpp":
                questions = CPP;
                answers = CPPanswers;
                opt = CPPopt;
                break;
            case "c":
                questions=C;
                answers=Canswers;
                opt=Copt;
        }
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(v -> {
            if(radio_g.getCheckedRadioButtonId()==-1)
            {
                Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                return;
            }
            RadioButton uans = findViewById(radio_g.getCheckedRadioButtonId());
            String ansText = uans.getText().toString();

            if(ansText.equals(answers[flag])) {
                correct++;
                Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
            }
            else {
                wrong++;
                Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
            }

            flag++;

            if (score != null)
                score.setText(""+correct);

            if(flag<10)
            {
                tv.setText(questions[flag]);
                rb1.setText(opt[flag*4]);
                rb2.setText(opt[flag*4 +1]);
                rb3.setText(opt[flag*4 +2]);
                rb4.setText(opt[flag*4 +3]);
            }

            else
            {
                marks=correct;
                Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(in);
            }
            radio_g.clearCheck();
        });

        quitbutton.setOnClickListener(v -> {
            Intent intent1 =new Intent(getApplicationContext(),ResultActivity.class);
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

                        Intent intent1 =new Intent(getApplicationContext(),ResultActivity.class);
                        startActivity(intent1);
                        finish();
                    }
                }).setNegativeButton("no", null).show();
    }
}