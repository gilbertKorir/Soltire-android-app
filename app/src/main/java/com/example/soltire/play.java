package com.example.soltire;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class play extends AppCompatActivity {
    @BindView(R.id.button1) Button mButton1;
    @BindView(R.id.button2) Button mButton2;
    @BindView(R.id.button3) Button mButton3;
    @BindView(R.id.button4) Button mButton4;
    @BindView(R.id.button5) Button mButton5;
    @BindView(R.id.button6) Button mButton6;
    @BindView(R.id.button7) Button mButton7;
    @BindView(R.id.button8) Button mButton8;
    @BindView(R.id.button9) Button mButton9;
    @BindView(R.id.userEditText) EditText mUserEditText;
    @BindView(R.id.addWordButton) Button mAddWordButton;
    @BindView(R.id.getScoreButton) Button mGetScoreButton;

    private List<String> letterArray = new ArrayList<String>();
    private List<String> wordArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        final String consonant1 = intent.getStringExtra("consonant1");
        final String consonant2 = intent.getStringExtra("consonant2");
        final String consonant3 = intent.getStringExtra("consonant3");
        final String consonant4 = intent.getStringExtra("consonant4");
        final String consonant5 = intent.getStringExtra("consonant5");
        final String consonant6 = intent.getStringExtra("consonant6");
        final String vowel1 = intent.getStringExtra("vowel1");
        final String vowel2 = intent.getStringExtra("vowel2");
        final String vowel3 = intent.getStringExtra("vowel3");

        mButton1.setText(consonant1);
        mButton2.setText(vowel1);
        mButton3.setText(consonant2);
        mButton4.setText(consonant3);
        mButton5.setText(vowel2);
        mButton6.setText(consonant4);
        mButton7.setText(vowel3);
        mButton8.setText(consonant5);
        mButton9.setText(consonant6);

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letterArray.add(consonant1);
                mUserEditText.setText(TextUtils.join("", letterArray));
                mButton1.setVisibility(view.INVISIBLE);
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letterArray.add(vowel1);
                mUserEditText.setText(TextUtils.join("", letterArray));
                mButton2.setVisibility(view.INVISIBLE);
            }
        });

        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letterArray.add(consonant2);
                mUserEditText.setText(TextUtils.join("", letterArray));
                mButton3.setVisibility(view.INVISIBLE);
            }
        });
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letterArray.add(consonant3);
                mUserEditText.setText(TextUtils.join("", letterArray));
                mButton4.setVisibility(view.INVISIBLE);
            }
        });
        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letterArray.add(vowel2);
                mUserEditText.setText(TextUtils.join("", letterArray));
                mButton5.setVisibility(view.INVISIBLE);
            }
        });
        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letterArray.add(consonant4);
                mUserEditText.setText(TextUtils.join("", letterArray));
                mButton6.setVisibility(view.INVISIBLE);
            }
        });
        mButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letterArray.add(vowel3);
                mUserEditText.setText(TextUtils.join("", letterArray));
                mButton7.setVisibility(view.INVISIBLE);
            }
        });
        mButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letterArray.add(consonant5);
                mUserEditText.setText(TextUtils.join("", letterArray));
                mButton8.setVisibility(view.INVISIBLE);
            }
        });
        mButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letterArray.add(consonant6);
                mUserEditText.setText(TextUtils.join("", letterArray));
                mButton9.setVisibility(view.INVISIBLE);
            }
        });


        mAddWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wordArray.add(TextUtils.join("", letterArray));
                letterArray.clear();
                mUserEditText.setText("");
                mButton1.setVisibility(view.VISIBLE);
                mButton2.setVisibility(view.VISIBLE);
                mButton3.setVisibility(view.VISIBLE);
                mButton4.setVisibility(view.VISIBLE);
                mButton5.setVisibility(view.VISIBLE);
                mButton6.setVisibility(view.VISIBLE);
                mButton7.setVisibility(view.VISIBLE);
                mButton8.setVisibility(view.VISIBLE);
                mButton9.setVisibility(view.VISIBLE);
            }
        });

        mGetScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(play.this, Score.class);
                intent.putExtra("wordArray", TextUtils.join(", ", wordArray));
                startActivity(intent);
            }
        });

    }
    }