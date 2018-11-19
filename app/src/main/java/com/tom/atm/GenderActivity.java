package com.tom.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        EditText Gendser =findViewById(R.id.ed_gender);
        String gender =getSharedPreferences("atm",MODE_PRIVATE).getString("Gender","");
        Gendser.setText(gender);
    }
    public void next(View view){
        String gender =((EditText) findViewById(R.id.ed_gender)).getText().toString();
        getSharedPreferences("atm" ,MODE_PRIVATE)
                .edit()
                .putString("Gender" , gender)
                .apply();
        Intent main =new Intent(this ,MainActivity.class);
        startActivity(main);
    }
    public void back (View view){
        Intent age =new Intent(this ,AgeActivity.class);
        startActivity(age);
    }
}
