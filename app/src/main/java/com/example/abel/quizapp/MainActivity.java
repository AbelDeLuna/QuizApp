package com.example.abel.quizapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements QuestionListFragment.QuestionListFragmentListener, QuestionFragment.ScorePlus {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int screenSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;

        Intent i = new Intent(MainActivity.this, QuestionList.class);

        switch(screenSize) {
            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
                setContentView(R.layout.activity_main);
                break;
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                setContentView(R.layout.activity_main);
                break;
            default:
                startActivity(i);
        }

    }

    @Override
    public void itemClicked(long id) {
        Log.d("MainActivity", "Question #" + (int) id + " clicked.");
        QuestionFragment questionView = new QuestionFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        questionView.setQuestion(id);
        ft.replace(R.id.frame_question, questionView);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    @Override
    public void increaseScore() {
        QuestionListFragment listFragment = (QuestionListFragment) getFragmentManager().findFragmentById(R.id.fragment);
        listFragment.increaseScore();
    }
}
