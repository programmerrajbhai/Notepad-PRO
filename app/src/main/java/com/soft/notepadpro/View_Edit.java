package com.soft.notepadpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class View_Edit extends AppCompatActivity {

    public static String TITLE="";
    public static String Description="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_edit);


        ImageView back= findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(View_Edit.this,MainActivity.class));
            }
        });


        EditText titleview=findViewById(R.id.titleview);
        TextView des=findViewById(R.id.des);


        titleview.setText(TITLE);
        des.setText(Description);
    }
}