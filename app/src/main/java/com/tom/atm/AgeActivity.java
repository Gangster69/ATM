package com.tom.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

public class AgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        EditText Age =findViewById(R.id.ed_age);
        String age =getSharedPreferences("atm",MODE_PRIVATE).getString("Age" , "");
        Age.setText(age);
    }
    public void next(View view){
        int age =Integer.parseInt(((EditText)findViewById(R.id.ed_age)).getText().toString());
        getSharedPreferences("atm",MODE_PRIVATE)
                .edit()
                .putInt("Age",age)
                .apply();
        Intent gender = new Intent(this,GenderActivity.class);
        startActivity(gender);
    }
    public void back(View view){
        finish();
    }
}
