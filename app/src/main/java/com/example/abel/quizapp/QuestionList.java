package com.example.abel.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionList extends AppCompatActivity {

    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);

        ListView questionsListView = (ListView) findViewById(R.id.questions_lv);
        questionsListView.setAdapter(new QuestionAdapter(this, Question.questions));

        questionsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast toast = Toast.makeText(getApplicationContext(), "Question " + position, Toast.LENGTH_SHORT);
//                toast.show();
                Intent intent = new Intent(QuestionList.this, QuestionActivity.class);
                intent.putExtra(Question.EXTRA_QUESTION_NO, (int) id);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 0) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                this.score++;
                TextView scoreText = (TextView) findViewById(R.id.score_tv);
                scoreText.setText("Score " + this.score);
            }
        }
    }

}
