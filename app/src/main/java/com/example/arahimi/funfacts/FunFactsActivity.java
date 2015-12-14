package com.example.arahimi.funfacts;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Button;
import java.util.Random;


public class FunFactsActivity extends AppCompatActivity {

    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR =  "KEY_COLOR";
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    private Button mShowFactButton;
    private TextView mFactLabel;
    private RelativeLayout mFunFactsLayout;
    private String mFact = mFactBook.mfacts[0];
    private int mColor = Color.parseColor(mColorWheel.mColors[8]);


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_FACT, mFact);
        outState.putInt(KEY_COLOR, mColor);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mFact = savedInstanceState.getString(KEY_FACT);
        mFactLabel.setText(mFact);
        mColor = savedInstanceState.getInt(KEY_COLOR);
        mFunFactsLayout.setBackgroundColor(mColor);
        mShowFactButton.setTextColor(mColor);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Declare our View variables and assign the views from the layout file
        mFactLabel = (TextView) findViewById(R.id.factTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mFunFactsLayout = (RelativeLayout) findViewById(R.id.funFactsLayout);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFact = mFactBook.getFact();
                mColor = mColorWheel.getColor();
                mFactLabel.setText(mFact);
                mFunFactsLayout.setBackgroundColor(mColor);
                mShowFactButton.setTextColor(mColor);
            }
        };
        mShowFactButton.setOnClickListener(listener);

    }
}
