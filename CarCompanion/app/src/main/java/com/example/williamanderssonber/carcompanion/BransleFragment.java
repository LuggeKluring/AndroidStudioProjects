package com.example.williamanderssonber.carcompanion;


        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;


public class BransleFragment extends Fragment {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bransle, container, false);
        
    }
    TextView fuelAverage;
    double fuelAverageValue = 8.6;
    public void writeStats(){
        fuelAverage = getView().findViewById(R.id.fuel_average_value);
        fuelAverage.setText(fuelAverageValue+" l/100km");
    }

    public void fuelFABClick(View view){

    }

    public void onStart() {
        super.onStart();
        writeStats();
    }



}
