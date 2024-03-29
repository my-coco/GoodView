package com.lisixing.ProBarView.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lisixing.ProBarView.R;
import com.lisixing.ProBarView.widget.ProgressBar.CircleProBarView;
import com.lisixing.ProBarView.widget.ProgressBar.RectProBarView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private RectProBarView rectProBarView;
    private CircleProBarView circleProBarView;
    private float progress=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        rectProBarView=findViewById(R.id.rectProBarView);
        circleProBarView=findViewById(R.id.circleProBarView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress+=10;
                rectProBarView.setProgress(progress);
                circleProBarView.setProgress(progress);
            }
        });
    }
}