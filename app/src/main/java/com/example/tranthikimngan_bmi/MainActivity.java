package com.example.tranthikimngan_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText editTextCC, editTextCN;
    Button buttonDG;
    TextView textViewDG, textViewBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDG    =   (Button) findViewById(R.id.buttontinh);
        editTextCC  =   (EditText) findViewById(R.id.textChieucao);
        editTextCN  =   (EditText) findViewById(R.id.textCannang);
        textViewBMI =   (TextView) findViewById(R.id.textBMI);
        textViewDG  =   (TextView) findViewById(R.id.textketqua);

        buttonDG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewBMI.setText("");
                textViewDG.setText("");
                if (editTextCC.getText().toString().isEmpty() && editTextCN.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Thiếu dữ liệu chiều cao và cân nặng", Toast.LENGTH_LONG).show();
                    editTextCC.requestFocus();
                } else if (editTextCC.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Thiếu dữ liệu chiều cao", Toast.LENGTH_LONG).show();
                    editTextCC.requestFocus();
                } else if (editTextCN.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Thiếu dữ liệu cân nặng", Toast.LENGTH_LONG).show();
                    editTextCN.requestFocus();
                } else {
                    double CC           =   Double.parseDouble(editTextCC.getText()+"");
                    double CN           =   Double.parseDouble(editTextCN.getText()+"");
                    DecimalFormat dcf   =   new DecimalFormat("0.00");
                    double BMI          =   CN / Math.pow(CC, 2) * 10000;
                    if ((CC == 0) || (CN ==  0)) {
                        Toast.makeText(MainActivity.this, "Chiều cao và cân nặng phải khác 0", Toast.LENGTH_LONG).show();
                    }
                    else {
                        textViewBMI.setText(": " + dcf.format(BMI));
                        if (BMI < 18) {
                            textViewDG.setText("Bạn quá gầy!!!");
                        } else if (18 <= BMI && BMI < 24.9) {
                            textViewDG.setText("Bạn gầy!");
                        } else if (25 <= BMI && BMI < 29.9) {
                            textViewDG.setText("Bạn đang béo phì cấp độ I");
                        } else if (30 <= BMI && BMI < 34.9) {
                            textViewDG.setText("Bạn đang béo phì cấp độ II");
                        } else {
                            textViewDG.setText("Bạn đang béo phì cấp độ III");
                        }
                    }
                }
            }
        });
    }
}