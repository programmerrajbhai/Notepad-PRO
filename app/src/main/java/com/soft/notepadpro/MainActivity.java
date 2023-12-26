package com.soft.notepadpro;

import static com.soft.notepadpro.Edit_Text.arrayList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {



    TextView tvid;

    Button mainpage;
    SharedPreferences sharedPreferences;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton addID= findViewById(R.id.addID);
        addID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,Edit_Text.class));

            }
        });




        sharedPreferences= getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);

     /*   tvid= findViewById(R.id.tvid);
        mainpage= findViewById(R.id.mainpage);*/
        listView= findViewById(R.id.listView);


    /*    mainpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity2.this,MainActivity.class));

            }
        });*/


        createTable();


        MyAdapter myAdapter= new MyAdapter();
        listView.setAdapter(myAdapter);




    }



    //<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>//

    private void createTable(){

        //  String mytext = sharedPreferences.getString("name","");



    }

    //<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>//

    //<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>//

    private class MyAdapter extends BaseAdapter {

        SharedPreferences sharedPreferences;

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {


            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View myview = layoutInflater.inflate(R.layout.simple_design,viewGroup,false);

            TextView title= myview.findViewById(R.id.title);
            TextView des= myview.findViewById(R.id.des);
            LinearLayout itemView=myview.findViewById(R.id.itemView);


            HashMap<String,String> hashMap= arrayList.get(position);
            String name = hashMap.get("name");
            String desc = hashMap.get("desc");

            if (name.isEmpty()){
                title.setText("Untitled");
                des.setText(desc);
            }else {
                title.setText(name);
                des.setText(desc);
            }




            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String ttData= title.getText().toString().trim();
                    String dsData= des.getText().toString().trim();

                    View_Edit.TITLE= ttData;
                    View_Edit.Description= dsData;
                    startActivity(new Intent(MainActivity.this,View_Edit.class));


                }
            });



            return myview;
        }
    }

}