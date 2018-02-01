package com.example.williamanderssonber.carcompanion;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterRefuel extends AppCompatActivity {

    Calendar c = Calendar.getInstance();
    static String addRefuelDateValue;
    static EditText addRefuelDate;
    static double addRefuelAmountNum;
    static EditText addRefuelAmount;
    static double addRefuelCostNum;
    static EditText addRefuelCost;
    static int addRefuelMileageNum;
    static EditText addRefuelMileage;
    static Button addRefuelSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_refuel);
        addRefuelAmount = findViewById(R.id.add_refuel_amount);
        addRefuelAmountNum = Double.parseDouble(addRefuelAmount.getText().toString());

        addRefuelCost = findViewById(R.id.add_refuel_cost);
        addRefuelCostNum = Double.parseDouble(addRefuelCost.getText().toString());

        addRefuelMileage = findViewById(R.id.add_refuel_mileage);
        addRefuelMileageNum = Integer.parseInt(addRefuelMileage.getText().toString());

        addRefuelDate = findViewById(R.id.add_refuel_date);
        addRefuelDateValue = addRefuelDate.getText().toString();
        addRefuelDate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                new DatePickerDialog(RegisterRefuel.this, date, c.get(Calendar.YEAR), c.get(Calendar.MONTH),
                        c.get(Calendar.DAY_OF_MONTH)).show();
                Refuels tank = new Refuels();
                tank.setMileage(addRefuelMileageNum);
                tank.setDate(addRefuelDateValue);
                tank.setAmount(addRefuelAmountNum);

                BransleFragment.databasen.get().getDB().refuelsDao().insertAll(tank);
            }
        });
        addRefuelSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

    }


    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, monthOfYear);
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };

    private void updateLabel(){
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.GERMAN);
        addRefuelDate.setText(sdf.format(c.getTime()));
    }


}
