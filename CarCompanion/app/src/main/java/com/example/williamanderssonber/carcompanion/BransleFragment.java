package com.example.williamanderssonber.carcompanion;


        import android.content.Intent;
        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.v4.app.Fragment;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import java.util.List;


public class BransleFragment extends Fragment {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        App databasen = new App();
        databasen.onCreate(getContext());
        Refuels tank = new Refuels();

        kalle = databasen.get().getDB().refuelsDao().getAll();

        Log.d("DatabasBös", "onCreate: "+kalle.get(0).amount);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bransle, container, false);

    }
    List<Refuels> kalle;

    TextView fuelAverage;
    TextView fuelTotalCost;
    TextView fuelAveragePrice;
    TextView fuelAmountRefueled;
    public double fuelAverageValue;
    public double fuelTotalCostValue;
    public double fuelAmountRefueledValue;
    public double fuelAveragePriceValue = fuelTotalCostValue/fuelAmountRefueledValue;
    public void writeStats(){
        fuelAverage = getView().findViewById(R.id.fuel_average_value);
        fuelAverage.setText(fuelAverageValue + " l/100km");
        fuelTotalCost = getView().findViewById(R.id.fuel_money_spent_text);
        fuelTotalCost.setText(fuelTotalCostValue+" sKr");
        fuelAveragePrice = getView().findViewById(R.id.fuel_average_cost_text);
        fuelAveragePrice.setText(fuelAveragePriceValue+" kr/l");
        fuelAmountRefueled = getView().findViewById(R.id.fuel_amount_refueled_text);
        fuelAmountRefueled.setText(fuelAmountRefueledValue+" liter");
    }



    public void onStart() {
        super.onStart();
        writeStats();
        FloatingActionButton addRefuelFab = getView().findViewById(R.id.addRefuelFab);
        addRefuelFab.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Handle the click.
                Intent loadRegisterRefuel = new Intent(getActivity(), RegisterRefuel.class);
                startActivity(loadRegisterRefuel);
            }
        });
    }



}
