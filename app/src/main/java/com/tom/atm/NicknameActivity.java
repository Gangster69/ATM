package com.tom.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NicknameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
    }
    public void next(View view){
       String nickname =((EditText)findViewById(R.id.ed_nickname)).getText().toString();
       getSharedPreferences("atm" ,MODE_PRIVATE)
               .edit()
               .putString("Nickname",nickname)
               .apply();
        Intent age =new Intent(this ,AgeActivity.class);
        startActivity(age);

    }
}
