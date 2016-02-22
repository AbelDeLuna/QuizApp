package com.example.abel.quizapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class QuestionAdapter extends ArrayAdapter<Question> {

    private final Context context;
    private final Question[] values;

    public QuestionAdapter(Context newContext, Question[] newValues) {
        super(newContext, R.layout.question_list_row, newValues);
        this.context = newContext;
        this.values = newValues;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.question_list_row, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);

        textView.setText(values[position].toString());
        imageView.setBackgroundResource(values[position].getQuestionIcon());

        return rowView;
    }
}
