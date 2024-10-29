package com.example.firstdz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class other extends AppCompatActivity {

    public static final String ans = "";
    public static final String guess = "";
    Button bOk;
    EditText eText;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_other);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent data = getIntent();
        String Guess = data.getStringExtra(guess);

        eText = findViewById(R.id.et);
        bOk = findViewById(R.id.bOk);
        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = eText.getText().toString();
                String answer = Guess + " " + val;
                Intent res = new Intent();
                res.putExtra(ans, answer);
                setResult(RESULT_OK, res);
                finish();
            }
        });
    }
}