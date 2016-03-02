package com.example.abel.quizapp;


import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class QuestionListFragment extends Fragment {

    interface QuestionListFragmentListener {
        void itemClicked(long id);
    }

    private QuestionListFragmentListener listener;
    private int score = 0;

    public QuestionListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_question_list, container, false);
        ListView questionsListView = (ListView) rootView.findViewById(R.id.questions_lv);
        questionsListView.setAdapter(new QuestionAdapter(getActivity(), Question.questions));

        questionsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.itemClicked(id);
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (QuestionListFragmentListener) context;
    }

    public void increaseScore() {
        this.score++;
        TextView scoreText = (TextView) getView().findViewById(R.id.score_tv);
        scoreText.setText("Score " + score);
        if (this.score >= 10) {
            Intent intent = new Intent(getActivity().getApplicationContext(), BestScore.class);
            PendingIntent notificationIntent = PendingIntent.getActivity(getActivity(), 0, intent, 0);
            Notification notif = new Notification.Builder(getActivity().getApplicationContext())
                    .setContentTitle("Congratulations!")
                    .setContentText("You reached a score of " + this.score)
                    .setSmallIcon(R.drawable.nineplus)
                    .setContentIntent(notificationIntent)
                    .setAutoCancel(true)
                    .addAction(R.drawable.question, "Get your prize!", notificationIntent)
                    .build();
            NotificationManager notificationManager = (NotificationManager) getActivity().getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(1001, notif);
        }
    }
}
