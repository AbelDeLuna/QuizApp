package com.example.abel.quizapp;


import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionFragment extends Fragment implements View.OnClickListener {

    interface ScorePlus {
        void increaseScore();
    }

    private ScorePlus sp;
    private Question selectedQuestion;
    private int answerSelected = -1;

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.sp = (ScorePlus) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        Button validateButton = (Button) view.findViewById(R.id.button_validate);
        Button hintButton = (Button) view.findViewById(R.id.button_hint);
        validateButton.setOnClickListener(this);
        hintButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        Log.d("onStart", view + " " + this.selectedQuestion);
        if (view != null && this.selectedQuestion != null) {
            TextView questionTitle = (TextView) view.findViewById(R.id.question_title);
            TextView question = (TextView) view.findViewById(R.id.question_text);
            Log.d("onStart", "questionTitle " + questionTitle);
            Log.d("onStart", "question " + question);
            questionTitle.setText(this.selectedQuestion.getQuestionTitle());
            question.setText(this.selectedQuestion.getQuestionText());
            final ListView answersList = (ListView) view.findViewById(R.id.answers_list);
            answersList.setAdapter(new AnswerAdapter(getActivity(), selectedQuestion.getAnswerList()));
            answersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    view.setSelected(true);
                    answerSelected = (int) answersList.getAdapter().getItemId(position);
                }
            });
        }
    }

    public void setQuestion(long id) {
        this.selectedQuestion = Question.questions[(int) id];
    }

    public void onClickHint(View view) {
        Intent search = new Intent(Intent.ACTION_WEB_SEARCH);
        search.putExtra(SearchManager.QUERY, this.selectedQuestion.getGoogleHint());
        startActivity(search);
    }

    public void onClickValidate(View view) {
        if (answerSelected == -1) {
            Toast.makeText(getActivity().getApplicationContext(), "You need to select an answer first!", Toast.LENGTH_LONG).show();
        }
        else {
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_hint:
                Log.d("Button click", "HINT");
                Intent search = new Intent(Intent.ACTION_WEB_SEARCH);
                search.putExtra(SearchManager.QUERY, this.selectedQuestion.getGoogleHint());
                startActivity(search);
                break;
            case R.id.button_validate:
                if (this.answerSelected == -1) {
                    Toast.makeText(getActivity().getApplicationContext(), "You need to select an answer first!", Toast.LENGTH_LONG).show();
                }
                else if (this.answerSelected == this.selectedQuestion.getCorrectAnswerNumber()) {
                    this.sp.increaseScore();
                }
                break;
        }
    }

}
