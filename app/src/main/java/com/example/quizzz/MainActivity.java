package com.example.quizzz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button yes;
    Button no;
    TextView question;
    private String[] questions = {"Garbage Collection is manual process.",
            "In an instance method or a constructor, \"this\" is a reference to the current object.",
            "int x[] = new int[]{10,20,30};\nArrays can also be created and initialize as in above statement.",
            "Constructor overloading is not possible in Java.",
            "Assignment operator is evaluated Left to Right."
    };

    private boolean[] answers = {false, true, true, false, false};
    private int index = 0;
    private int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question = findViewById(R.id.question);
        question.setText(index+1 + ". "+ questions[index]);
        no.setBackgroundColor(Color.RED);
        yes.setBackgroundColor(Color.GREEN);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index <= questions.length-1) {
                    // if you have given correct answer
                    if (answers[index]) {
                        score++;
                    }
                    // go to next question
                    index++;
                    if (index <= questions.length - 1) {
                        question.setText(index+1 + ". " +questions[index]);
                    } else {
                        Toast.makeText(MainActivity.this, "Your score is " + score, Toast.LENGTH_SHORT).show();

                    }
                    if (index == questions.length) {
//                        question.setText("You have finished the Quiz !" + "\n\n" + "Your score is " + score + "/" + questions.length);
                        if (score >= (questions.length/2.0)){
                            question.setText("You have finished the Quiz !" + "\n\n" + "Your score is " + score + "/" + questions.length+"\n\n"+"Played Well !");
                        }
                        else {
//                            Toast.makeText(MainActivity.this, "Practice More", Toast.LENGTH_SHORT).show();
                            question.setText("You have finished the Quiz !" + "\n\n" + "Your score is " + score + "/" + questions.length+"\n\n"+"Practice more !");
                        }

                    }
                }
                else {
//                    question.setText("You have finished the Quiz "+"\n\n"+"Your score is "+ score + "/" + questions.length);
                    Toast.makeText(MainActivity.this, "Please restart the app to play again", Toast.LENGTH_SHORT).show();
                }

            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if array is not going out of bound
                if(index <= questions.length-1) {
                    // if you have given correct answer
                    if (!answers[index]) {
                        score++;
                    }
                    // go to next question
                    index++;
                    if (index <= questions.length - 1) {
                        question.setText(index+1 + ". "+questions[index]);
                    } else {
                        Toast.makeText(MainActivity.this, "Your score is " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();

                    }
                    if (index == questions.length) {
//                        question.setText("You have finished the Quiz " + "\n\n" + "Your score is " + score + "/" + questions.length);
                        if (score >= (questions.length/2.0)){
                            question.setText("You have finished the Quiz !" + "\n\n" + "Your score is " + score + "/" + questions.length+"\n\n"+"Played Well !");
                        }
                        else {
//                            Toast.makeText(MainActivity.this, "Practice More", Toast.LENGTH_SHORT).show();
                            question.setText("You have finished the Quiz !" + "\n\n" + "Your score is " + score + "/" + questions.length+"\n\n"+"Practice more !");
                        }

                    }
                }
                else {

                    Toast.makeText(MainActivity.this, "Please restart the app to play again", Toast.LENGTH_SHORT).show();
                }
//                if(index == questions.length-1){
//                    question.setText("You have finished the Quiz "+"\n\n"+"Your score is "+ score + "/" + questions.length);
//                }

            }
        });
    }
}