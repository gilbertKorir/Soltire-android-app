package com.example.soltire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Score extends AppCompatActivity {
    @BindView(R.id.invalidListView) ListView mInvalidListView;
    @BindView(R.id.scoringListView) ListView mScoringListView;
    @BindView(R.id.homeButton) Button mHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String userWordsString = intent.getStringExtra("wordArray");
        String[] userWordsArray = userWordsString.split(", ");
        List<String> invalidWordsArray = new ArrayList<String>();
        List<String> scoringWordsArray = new ArrayList<String>();

        for (String word: userWordsArray) {
            if (word.length() < 3) {
                invalidWordsArray.add(word);
            } else {
                scoringWordsArray.add(word);
            }
        }

        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, invalidWordsArray);
        mInvalidListView.setAdapter(adapter1);
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, scoringWordsArray);
        mScoringListView.setAdapter(adapter2);

        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Score.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}