package com.example.myalki;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class CocktailDetailActivity extends AppCompatActivity {

    TextView AingredientsTV,AnameTV,AinstructionsTV;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail_detail);

        Intent i = getIntent();

        String name = i.getStringExtra("name");
        ArrayList<String> ingredients = (ArrayList<String>) i.getStringArrayListExtra("ingredients");
        String instructions = i.getStringExtra("instructions");

        AingredientsTV = findViewById(R.id.ingredientsTV);
        AinstructionsTV = findViewById(R.id.instructionsTV);
        AnameTV = findViewById(R.id.nameTV);

        AingredientsTV.setText(String.valueOf(ingredients));
        AnameTV.setText(name);
        AinstructionsTV.setText(instructions);



    }
}