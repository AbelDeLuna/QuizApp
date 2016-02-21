package com.example.abel.quizapp;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class QuestionActivity extends AppCompatActivity {

    private Question questionSelected;
    private int answerSelected = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent intent = getIntent();
        this.questionSelected = Question.questions[(int) intent.getIntExtra(Question.EXTRA_QUESTION_NO, 0)];
        final ListView answersList = (ListView) findViewById(R.id.answers_list);

        answersList.setAdapter(new AnswerAdapter(this, this.questionSelected.getAnswerList()));

        TextView questionTitle = (TextView) findViewById(R.id.question_title);
        TextView questionText = (TextView) findViewById(R.id.question_text);

        questionTitle.setText(this.questionSelected.getQuestionTitle());
        questionText.setText(this.questionSelected.getQuestionText());

        answersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);
                answerSelected = (int) answersList.getAdapter().getItemId(position);
            }
        });
    }

    public void onClickHint(View view) {
        Intent search = new Intent(Intent.ACTION_WEB_SEARCH);
        search.putExtra(SearchManager.QUERY, this.questionSelected.getGoogleHint());
        startActivity(search);
    }

    public void onClickValidate(View view) {
        if (answerSelected == -1) {
            Toast.makeText(getApplicationContext(), "You need to select an answer first!", Toast.LENGTH_LONG).show();
        }
        else {
            if (answerSelected == this.questionSelected.getCorrectAnswerNumber()) {
                setResult(RESULT_OK);
            }
            else {
                setResult(RESULT_CANCELED);
            }
            finish();
        }
    }
}
