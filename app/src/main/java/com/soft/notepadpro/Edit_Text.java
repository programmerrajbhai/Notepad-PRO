package com.soft.notepadpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Edit_Text extends AppCompatActivity {


    EditText edText,des;
    TextView addValue;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public static ArrayList<HashMap<String,String>> arrayList= new ArrayList<>();
    public static HashMap<String,String> hashMap = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        ImageView backk= findViewById(R.id.backk);
        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Edit_Text.this,MainActivity.class));
            }
        });


        edText= findViewById(R.id.edText);
        des= findViewById(R.id.des);
        addValue= findViewById(R.id.addValue);
       /* showvalue= findViewById(R.id.showvalue);*/

        sharedPreferences= getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        editor= sharedPreferences.edit();


        addValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dess= des.getText().toString().trim();
                if (dess.isEmpty()){

                    des.setError("Please Input Your Notes");
                /*

*/
                }else {
                    hashMap = new HashMap<>();
                    hashMap.put("name", edText.getText().toString());
                    hashMap.put("desc", des.getText().toString());
                    arrayList.add(hashMap);

                    startActivity(new Intent(Edit_Text.this,MainActivity.class));
                }



            }
        });

      /*  showvalue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(MainActivity.this,MainActivity2.class));
            }
        });

*/


        String Securely = sharedPreferences.getString("YOUR_KEY", null);
        if (Securely != null) {
            Type type = new TypeToken<ArrayList<HashMap<String, String>>>() {
            }.getType();
            List<HashMap<String, String>> list = new Gson().fromJson(Securely, type);

            if (list != null && list.size() > 0) {
                arrayList.clear();
                arrayList.addAll(list);


            }




        }




    }



    @Override
    protected void onStop() {
        super.onStop();

        Gson gson = new Gson();

        String arraylist_in_string = gson.toJson(arrayList); //Converting it to String
        editor.putString("YOUR_KEY", arraylist_in_string); //now saving the String
        editor.commit();
    }
}