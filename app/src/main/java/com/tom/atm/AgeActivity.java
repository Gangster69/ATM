package com.tom.atm;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

public class AgeActivity extends BaseActivity {
    int[] number ={19,20,21,22,23,24,25};
    String[] rainbow =null;
    private EditText edAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        RecyclerView recyclerView =findViewById(R.id.recycler);
        rainbow =getResources().getStringArray(R.array.rainbow);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AgeAdapter());
    }
    public void next(View view){
        int age =Integer.parseInt(((EditText)findViewById(R.id.ed_age)).getText().toString());
        user.setAge(age);
        Intent gender = new Intent(this,GenderActivity.class);
        startActivity(gender);
    }
    public void back(View view){
        finish();
    }
    class AgeAdapter extends RecyclerView.Adapter<AgeAdapter.AgeHolder>{

        @NonNull
        @Override
        public AgeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view =getLayoutInflater().inflate(R.layout.age_row , parent , false);
            return new AgeHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AgeHolder holder, final int position) {
            /*holder.ageText.setText(number[position]+" ");
            if(number[position] == 20){
                holder.ageText.setTextColor(Color.GREEN);
            }*/
            holder.itemView.setBackgroundColor(Color.parseColor(rainbow[position%7]));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("MainActivity", "onClick " +number[position]);
                    edAge = findViewById(R.id.ed_age);
                }
            });
        }

        @Override
        public int getItemCount() {
            return number.length;
        }

        class AgeHolder extends RecyclerView.ViewHolder{
            TextView ageText;
            public AgeHolder(View itemView){
                super(itemView);
                ageText =itemView.findViewById(R.id.tv_age);
            }
        }
    }
}
