package com.keegan.android.itc362hw3ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    private ConstraintSet set;
    private ConstraintLayout layout;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.CL_1);
        layout.setBackgroundColor(Color.parseColor("#c89b6d"));
        set = new ConstraintSet();
        set.clone(layout);

        //Button 1
        Button button = new Button(this);
        button.setText(R.string.plum);
        button.setId(View.generateViewId());
        button.setTag("btn1");
        button.setBackgroundColor(Color.parseColor("#ac7d50"));
        button.setOnClickListener(ShadeChangeListener);
        layout.addView(button);
        set.connect(button.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 50);
        set.connect(button.getId(),ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT,0);
        set.connect(button.getId(),ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,0);
        set.constrainHeight(button.getId(), 200);
        set.applyTo(layout);


        //Button 2:
        Button button2 = new Button(this);
        button2.setText(getString(R.string.blue));
        button2.setId(View.generateViewId());
        button2.setTag("btn2");
        button2.setBackgroundColor(Color.parseColor("#ac7d50"));
        button2.setOnClickListener(ShadeChangeListener);
        layout.addView(button2);
        set.connect(button2.getId(), ConstraintSet.TOP, button.getId(), ConstraintSet.BOTTOM, 10);
        set.connect(button2.getId(),ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT,0);
        set.connect(button2.getId(),ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,0);
        set.constrainHeight(button2.getId(), 200);
        set.applyTo(layout);

        //Button 3:
        button3 = new Button(this);
        button3.setText(getString(R.string.gold));
        button3.setId(View.generateViewId());
        button3.setTag("btn3");
        button3.setBackgroundColor(Color.parseColor("#ac7d50"));
        button3.setOnClickListener(ShadeChangeListener);
        layout.addView(button3);
        set.connect(button3.getId(), ConstraintSet.TOP, button2.getId(), ConstraintSet.BOTTOM, 10);
        set.connect(button3.getId(),ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT,0);
        set.connect(button3.getId(),ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,0);
        set.constrainHeight(button3.getId(), 200);
        set.applyTo(layout);

    }

    private View.OnClickListener ShadeChangeListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String description = (String) view.getTag();

            TextView textView = new TextView(MainActivity.this);
            textView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setGravity(Gravity.CENTER);
            switch ((String) view.getTag()){
                case "btn1":
                    textView.setText(R.string.plum_is);
                    break;
                case "btn2":
                    textView.setText(R.string.blue_is);
                    break;
                case "btn3":
                    textView.setText(R.string.gold_is);
                    break;
            }

            textView.setBackgroundColor(Color.parseColor("#ac7d50"));
            textView.setId(View.generateViewId());
            layout.addView(textView);

            set.connect(textView.getId(), ConstraintSet.TOP, button3.getId(), ConstraintSet.BOTTOM, 50);
            set.connect(textView.getId(),ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT,0);
            set.connect(textView.getId(),ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,0);
            set.constrainHeight(textView.getId(), 400);
            set.applyTo(layout);
        }
    };
}