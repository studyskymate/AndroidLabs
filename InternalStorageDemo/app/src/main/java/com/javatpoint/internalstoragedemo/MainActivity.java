package com.javatpoint.internalstoragedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText editTextFileName,editTextData;
    Button saveButton,readButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          editTextFileName=findViewById(R.id.editText1);
          editTextData= findViewById(R.id.editText2);
          saveButton=findViewById(R.id.button1);
          readButton=findViewById(R.id.button2);

          saveButton.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  String filename= editTextFileName.getText().toString();
                  String data= editTextData.getText().toString();

                  FileOutputStream fos;

                  try {
                      fos=openFileOutput(filename,Context.MODE_PRIVATE);
                      fos.write(data.getBytes());
                      fos.close();

                      Toast.makeText(MainActivity.this, filename + "Saved! ", Toast.LENGTH_SHORT).show();

                  } catch (FileNotFoundException e) {
                      e.printStackTrace();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }

              }
          });

          //read button action

        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename=editTextFileName.getText().toString();
                StringBuffer stringBuffer=new StringBuffer();

                try {
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(openFileInput(filename)));

                    String inputString;

                    while ( (inputString=bufferedReader.readLine())!=null){
                        stringBuffer.append(inputString+"\n");
                    }

                    //Display Data

                    Toast.makeText(MainActivity.this, stringBuffer.toString(), Toast.LENGTH_SHORT).show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
