package com.example.abel.quizapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AnswerAdapter extends ArrayAdapter<Answer> {

    private final Context context;
    private final Answer[] values;

    public AnswerAdapter(Context newContext, Answer[] newValues) {
        super(newContext, R.layout.answer_list_row, newValues);
        this.context = newContext;
        this.values = newValues;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.answer_list_row, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);

        textView.setText(values[position].toString());
        imageView.setBackgroundResource(values[position].getAnswerIcon());

        return rowView;
    }

}
