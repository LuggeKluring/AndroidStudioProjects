package com.example.williamanderssonber.carcompanion;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterRefuel extends AppCompatActivity {

    Calendar c = Calendar.getInstance();
    static String addRefuelDateString;
    EditText addRefuelDate;
    static double addRefuelAmountNum;
    EditText addRefuelAmount;
    static double addRefuelCostNum;
    EditText addRefuelCost;
    static int addRefuelMileageNum;
    EditText addRefuelMileage;
    Button addRefuelSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_refuel);
        //
        //******* Initierar databasen *******
        //
        final App databasen = new App();
        databasen.onCreate(this);
        //
        addRefuelAmount = findViewById(R.id.add_refuel_amount);
        addRefuelCost = findViewById(R.id.add_refuel_cost);
        addRefuelMileage = findViewById(R.id.add_refuel_mileage);
        addRefuelDate = findViewById(R.id.add_refuel_date);
        addRefuelSubmit = findViewById(R.id.add_refuel_submit);
        updateLabel();
        //
        //****** Öppnar en DatePicker när man klickar på "date-fältet" *******
        //
        addRefuelDate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                new DatePickerDialog(RegisterRefuel.this, date, c.get(Calendar.YEAR), c.get(Calendar.MONTH),
                        c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        //
        //****** Skickar iväg all data till databasen när man klickar på "submitknappen" ******
        //
        addRefuelSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addRefuelAmountString = addRefuelAmount.getText().toString();
                String addRefuelCostString = addRefuelCost.getText().toString();
                String addRefuelMileageString = addRefuelMileage.getText().toString();
                addRefuelDateString = addRefuelDate.getText().toString();
                //
                //****** Kollar om alla fält är ifyllda för att undvika ett parsing-error p.g.a. tomt fält, visar isf en toast ******
                //
                if(addRefuelAmountString.matches("") && addRefuelCostString.matches("") && addRefuelMileageString.matches("") && addRefuelDateString.matches("")){
                    Toast.makeText(RegisterRefuel.this, "Fyll i alla fält!", Toast.LENGTH_SHORT).show();
                }
                //
                else{
                    //
                    //****** Konverterar de strings man får från textinmatningen till nummer ******
                    //
                    addRefuelAmountNum = Double.parseDouble(addRefuelAmountString);
                    addRefuelCostNum = Double.parseDouble(addRefuelCostString);
                    addRefuelMileageNum = Integer.parseInt(addRefuelMileageString);
                    //
                    //****** Skapar en ny "tuppel" (Objekt i databasen) och definerar datan till kolumnerna ******
                    //
                    Refuels tank = new Refuels();
                    tank.setMileage(addRefuelMileageNum);
                    tank.setAmount(addRefuelAmountNum);
                    tank.setCost(addRefuelCostNum);
                    tank.setDate(addRefuelDateString);
                    databasen.get().getDB().refuelsDao().insert(tank);
                    Intent backToFragment = new Intent(RegisterRefuel.this, MainActivity.class);
                    startActivity(backToFragment);

                    //
                    //
                }
            }
        });
        //
        //

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
