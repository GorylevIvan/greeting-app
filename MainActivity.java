package com.example.firstdz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button bOk;
    EditText edText;
    TextView text;
    @SuppressLint("MissingInflatedId") //?
    private static final int OTHER_ACT = 1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edText = findViewById(R.id.et);
        bOk = findViewById(R.id.bOk);
        text = findViewById(R.id.textview);
        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = edText.getText().toString();
                Intent i = new Intent(MainActivity.this, other.class);
                i.putExtra(other.guess, value);
                startActivityForResult(i, OTHER_ACT);
            }
        });
    }
    @SuppressLint("MissingSuperCall")
    public void onActivityResult(int recCode, int resCode, Intent data)
    {
        switch (recCode)
        {
            case (OTHER_ACT):
                if (resCode == RESULT_OK)
                {
                    String word = data.getStringExtra(other.ans);
                    text.setText(word);
                }
                break;
        }
    }
}