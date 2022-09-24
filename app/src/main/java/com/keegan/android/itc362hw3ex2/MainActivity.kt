package com.keegan.android.itc362hw3ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
    private ConstraintSet set;
    private ConstraintLayout layout;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (ConstraintLayout) findViewById(R.id.CL_1);

    }
}