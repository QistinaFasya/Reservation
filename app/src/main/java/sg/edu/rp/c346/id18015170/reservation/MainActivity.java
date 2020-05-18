package sg.edu.rp.c346.id18015170.reservation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etNum;
    EditText etPax;
    CheckBox cbSmoke;
    DatePicker dp;
    TimePicker tp;
    Button btnReset;
    Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etName = findViewById(R.id.editTextName);
        etNum = findViewById(R.id.editTextNum);
        etPax = findViewById(R.id.sizeOfGrp);
        cbSmoke = findViewById(R.id.checkBoxSmoke);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnReset = findViewById(R.id.buttonReset);
        btnSubmit = findViewById(R.id.buttonSubmit);

        dp.updateDate(2020, 5, 1);
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);


        btnReset.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {

                etName.setText("");
                etNum.setText("");
                etPax.setText("");
                cbSmoke.setChecked(false);
                dp.updateDate(2020, 5, 1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);

            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String output = "";

                if(cbSmoke.isChecked()){
                    output = "Smoking Area";
                }
                else{
                    output = "Non-smoking area";
                }

                Toast.makeText(MainActivity.this,
                        "Name: " + etName.getText().toString() +
                                ",Mobile Number: " + etNum.getText().toString() +
                                ", Size of Group: " + etPax.getText().toString() +
                                ", Type of Area: " + output +
                                ", Date: " + dp.getDayOfMonth()+"/"+(dp.getMonth()+1)+"/"+dp.getYear() +
                                ", Time: " + tp.getCurrentHour()+":"+tp.getCurrentMinute()
                        , Toast.LENGTH_LONG).show();
            }
        });


    }
}
