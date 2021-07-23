package com.example.demo1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
//import org.mariuszgromada.math.mxparser.*;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaration
    EditText display;
    Button ac;
    Button clean;
    Button mod;
    Button div;
    Button mul;
    Button add;
    Button sub;
    Button n0;
    Button n2;
    Button n3;
    Button n1;
    Button n4;
    Button n5;
    Button n6;
    Button n7;
    Button n8;
    Button n9;
    Button per;
    Button dott;
    Button eq;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //Memory Allocation
        display=findViewById(R.id.display);
        ac=findViewById(R.id.ac);
        mod=findViewById(R.id.mod);
        clean=findViewById(R.id.clean);
        div=findViewById(R.id.div);
        mul=findViewById(R.id.mul);
        add=findViewById(R.id.add);
        sub=findViewById(R.id.sub);
        n0=findViewById(R.id.n0);
        n1=findViewById(R.id.n1);
        n2=findViewById(R.id.n2);
        n3=findViewById(R.id.n3);
        n4=findViewById(R.id.n4);
        n5=findViewById(R.id.n5);
        n6=findViewById(R.id.n6);
        n7=findViewById(R.id.n7);
        n8=findViewById(R.id.n8);
        n9=findViewById(R.id.n9);
        per=findViewById(R.id.per);
        dott=findViewById(R.id.dott);
        eq=findViewById(R.id.eq);
    //Codding
        display.setShowSoftInputOnFocus(false);

    //Listeners
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
       ac.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            display.setText("");
           }
       });
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             updateText("^");
            }
        });
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 int cursorPos=display.getSelectionStart();
                 int textlen=display.getText().length();
                 if(cursorPos!=0 && textlen!=0){
                     SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
                     selection.replace(cursorPos-1,cursorPos,"");
                     display.setText(selection);
                     display.setSelection(cursorPos-1);
                 }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("÷");
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("×");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("+");
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("-");
            }
        });
        n0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("0");
            }
        });
        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("1");
            }
        });
        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("2");
            }
        });
        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("3");
            }
        });
        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("4");
            }
        });
        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("5");
            }
        });
        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("6");
            }
        });
        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("7");
            }
        });
        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("8");
            }
        });
        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("9");
            }
        });
        per.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dott.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText(".");
            }
        });
        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String str=display.getText().toString();
               // str=str.replaceAll( "÷" , "/" );
               // str=str.replaceAll("×","*");
               // Expression exp= new Expression(str);
                //String result=String.valueOf(exp.calculate());
                //display.setText(result);
                //display.setSelection(result.length());
            }
        });
    }
    //Functions
    private void updateText(String str){
        String oldString,leftString,rightString;
        oldString=display.getText().toString();
        int cursorPos=display.getSelectionStart();
        leftString=oldString.substring(0,cursorPos);
        rightString=oldString.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(str);
            display.setSelection(cursorPos + 1);
        }
        else {
            display.setText(String.format("%s%s%s", leftString, str, rightString));
            display.setSelection(cursorPos + 1);
        }
    }
}