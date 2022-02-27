package com.example.dynamicradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEtNumOfRadioBtns;
    Button mBtnAdd;
    String TAG = "TestActivity";
    RadioGroup mRgAllButtons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtNumOfRadioBtns = findViewById(R.id.et_no);
        mBtnAdd = findViewById(R.id.btn);
        mRgAllButtons = findViewById(R.id.radiogroup);
        //
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(mEtNumOfRadioBtns.getText().toString().trim());
                addRadioButtons(number);
            }
        });
    }

    public void addRadioButtons(int number) {
        mRgAllButtons.setOrientation(LinearLayout.VERTICAL);
        //
        for (int i = 1; i <= number; i++) {
            RadioButton rdbtn = new RadioButton(this);
            rdbtn.setId(View.generateViewId());
            rdbtn.setText("Radio " + rdbtn.getId());
            rdbtn.setOnClickListener(this);
            mRgAllButtons.addView(rdbtn);
        }
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, " Name " + ((RadioButton)v).getText() +" Id is "+v.getId());
    }
    }
