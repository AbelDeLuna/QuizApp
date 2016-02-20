package com.example.abel.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class QuestionList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);

        ListView questionsListView = (ListView) findViewById(R.id.questions_lv);
        questionsListView.setAdapter(new QuestionAdapter(this, Question.questions));
    }
}
