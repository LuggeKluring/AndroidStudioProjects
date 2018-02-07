package com.example.williamanderssonber.carcompanion;


        import android.annotation.SuppressLint;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.design.widget.FloatingActionButton;
        import android.support.v4.app.Fragment;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import java.text.DecimalFormat;
        import java.text.NumberFormat;
        import java.util.List;


public class BransleFragment extends Fragment {

    List<Refuels> kalle;

    TextView fuelAverage;
    TextView fuelTotalCost;
    TextView fuelAveragePrice;
    TextView fuelAmountRefueled;
    public static double fuelAverageValue;
    public static double fuelTotalCostValue;
    public static double fuelAmountRefueledValue;
    double fuelAveragePriceValue;
    NumberFormat formatter = new DecimalFormat("#.##");

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //
        //******* Initierar databasen och hämtar en lista med alla registrerade tankningar *******
        //
        App databasen = new App();
        databasen.onCreate(getContext());
        kalle = App.get().getDB().refuelsDao().getAll();

        //
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bransle, container, false);
    }
    public void onStart() {
        super.onStart();
        FloatingActionButton addRefuelFab = getView().findViewById(R.id.addRefuelFab);
        addRefuelFab.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Handle the click.
                Intent loadRegisterRefuel = new Intent(getActivity(), RegisterRefuel.class);
               // loadRegisterRefuel.putExtra("parent",);

                startActivity(loadRegisterRefuel);
            }
        });
        writeStats();
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        writeStats();
        fuelAverage.invalidate();
        fuelAmountRefueled.invalidate();
        fuelTotalCost.invalidate();
        fuelAveragePrice.invalidate();
    }
    @SuppressLint("SetTextI18n")
    public void writeStats(){
        //
        //******* Reset:ar datan innan den hämtas igen för att undvika dubbelberäkning******
        //
        fuelAverageValue = 0;
        fuelTotalCostValue = 0;
        fuelAmountRefueledValue = 0;
        fuelAveragePriceValue = 0;
        //
        //******* Adderar all data från databasen om det finns någon data*******
        //
        if(!kalle.isEmpty()){
            for(Refuels tank: kalle){
                fuelAmountRefueledValue += tank.amount;
                fuelTotalCostValue += tank.cost;
                fuelAveragePriceValue = fuelTotalCostValue/fuelAmountRefueledValue;
            }
        } else {
            Log.d("DATABAS", "Is empty ");
        }
        //
        //*******Skriver ut datan från databasen i "korten"*********
        //
        fuelAverage = getView().findViewById(R.id.fuel_average_value);
        fuelAverage.setText(fuelAverageValue + " l/100km");
        fuelTotalCost = getView().findViewById(R.id.fuel_money_spent_text);
        fuelTotalCost.setText(fuelTotalCostValue+" sKr");
        fuelAveragePrice = getView().findViewById(R.id.fuel_average_cost_text);
        fuelAveragePrice.setText(formatter.format(fuelAveragePriceValue)+" kr/l");
        fuelAmountRefueled = getView().findViewById(R.id.fuel_amount_refueled_text);
        fuelAmountRefueled.setText(fuelAmountRefueledValue+" liter");
        //
    }






}
