package com.lisixing.ProBarView.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lisixing.ProBarView.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,View.OnFocusChangeListener{
    private ConstraintLayout login,load;
    private Button button;
    private boolean isLoad=true;
    private Animation load_up,load_down,text_up,text_down;
    private EditText name_ed,password_ed,phone_ed,token_ed;
    private TextView name_tx,password_tx,load_btn,login_btn,phone_tx,token_tx;
    private ConstraintLayout load_layout,login_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        initAnima();
    }

    private void init(){
        login=findViewById(R.id.login);
        load=findViewById(R.id.load);
        button=findViewById(R.id.button);
        name_ed=findViewById(R.id.name_ed);
        name_tx=findViewById(R.id.name_tx);
        password_ed=findViewById(R.id.password_ed);
        password_tx=findViewById(R.id.password_tx);
        load_btn=findViewById(R.id.load_btn);
        login_btn=findViewById(R.id.login_btn);
        load_layout=findViewById(R.id.load_layout);
        login_layout=findViewById(R.id.login_layout);
        phone_ed=findViewById(R.id.phone_ed);
        token_ed=findViewById(R.id.token_ed);
        phone_tx=findViewById(R.id.phone_tx);
        token_tx=findViewById(R.id.token_tx);

        button.setOnClickListener(this);
        name_ed.setOnFocusChangeListener(this);
        password_ed.setOnFocusChangeListener(this);
        phone_ed.setOnFocusChangeListener(this);
        token_ed.setOnFocusChangeListener(this);

    }

    private void initAnima(){
        load_up= AnimationUtils.loadAnimation(this,R.anim.load_up);
        load_down=AnimationUtils.loadAnimation(this,R.anim.load_down);
        text_up=AnimationUtils.loadAnimation(this,R.anim.text_up);
        text_down=AnimationUtils.loadAnimation(this,R.anim.text_down);

        login.startAnimation(load_down);
        login.setZ(login.getZ()-1);
        login_btn.setVisibility(View.INVISIBLE);
        login_layout.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                move();
                break;
        }
    }

    public void move(){
        if(isLoad){
            login.startAnimation(load_up);
            login.setZ(login.getZ()+1);
            load.startAnimation(load_down);
            load.setZ(load.getZ()-1);
            load_btn.setVisibility(View.INVISIBLE);
            login_btn.setVisibility(View.VISIBLE);
            load_layout.setVisibility(View.INVISIBLE);
            login_layout.setVisibility(View.VISIBLE);
            isLoad=false;
        }else{
            login.startAnimation(load_down);
            login.setZ(login.getZ()-1);
            login_btn.setVisibility(View.INVISIBLE);
            login_layout.setVisibility(View.INVISIBLE);
            load.startAnimation(load_up);
            load.setZ(load.getZ()+1);
            load_btn.setVisibility(View.VISIBLE);
            load_layout.setVisibility(View.VISIBLE);
            isLoad=true;
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()){
            case R.id.name_ed:
                if(name_ed.getText().toString().length()==0){
                    if(hasFocus){
                        name_tx.setTextSize(14);
                        name_tx.startAnimation(text_up);
                    }else{
                        name_tx.setTextSize(18);
                        name_tx.startAnimation(text_down);
                    }
                }
                break;
            case R.id.password_ed:
                if(password_ed.getText().toString().length()==0){
                    if(hasFocus){
                        password_tx.setTextSize(14);
                        password_tx.startAnimation(text_up);
                    }else{
                        password_tx.setTextSize(18);
                        password_tx.startAnimation(text_down);
                    }
                }
                break;
            case R.id.phone_ed:
                if(phone_ed.getText().toString().length()==0){
                    if(hasFocus){
                        phone_tx.setTextSize(14);
                        phone_tx.startAnimation(text_up);
                    }else{
                        phone_tx.setTextSize(18);
                        phone_tx.startAnimation(text_down);
                    }
                }
                break;
            case R.id.token_ed:
                if(token_ed.getText().toString().length()==0){
                    if(hasFocus){
                        token_tx.setTextSize(14);
                        token_tx.startAnimation(text_up);
                    }else{
                        token_tx.setTextSize(18);
                        token_tx.startAnimation(text_down);
                    }
                }
                break;
        }
    }
}