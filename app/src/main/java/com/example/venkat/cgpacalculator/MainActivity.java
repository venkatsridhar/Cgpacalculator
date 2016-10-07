package com.example.venkat.cgpacalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1=(Button)findViewById(R.id.bt1);
        final EditText edt=(EditText)findViewById(R.id.edt1);




        final DBHelper db=new DBHelper(this);
        db.createtable();
        db.insertRecord(3030,8.20,8.4,8.5,9.0,9.4,8.9);
        db.insertRecord(3042,9.4,9.2,9.3,9.0,9.4,8.9);
        db.insertRecord(3044,9.3,9.2,9.4,9.0,9.4,8.9);
        db.insertRecord(3045,9.6,9.3,9.7,9.0,9.4,8.9);
        db.insertRecord(3049,9.3,9.4,9.5,9.0,9.4,8.9);

        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                String text=edt.getText().toString();
                int regno=Integer.parseInt(text);

                double val=db.getData(regno);
                //int val=c.getInt(0);
                //double one=Double.parseDouble(c.getString(0));
                /*double two=Double.parseDouble(c.getString(1));
                double three=Double.parseDouble(c.getString(2));
                double four=Double.parseDouble(c.getString(3));
                double five=Double.parseDouble(c.getString(4));
                double six=Double.parseDouble(c.getString(5));
                double res;
                res=one*23+two*23+three*23+four*23;
                res+=five*24+six*24;
                res=res/140;*/
                //String s=String.valueOf();

                edt.setText(val+"");


            }
        });






    }
}
