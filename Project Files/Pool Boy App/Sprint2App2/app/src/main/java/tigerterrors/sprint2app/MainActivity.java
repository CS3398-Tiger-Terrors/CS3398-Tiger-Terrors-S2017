package tigerterrors.sprint2app;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import tigerterrors.sprint2app.calculator.Calculator;

public class MainActivity extends AppCompatActivity {
    // Keys
    public final static String ALKALINITY_KEY = "tigerterrors.poolboy.alkalinity_key";
    public final static String CHLORINE_KEY0 = "tigerterrors.poolboy.chlorine_key0";
    public final static String CHLORINE_KEY1 = "tigerterrors.poolboy.chlorine_key1";
    public final static String CHLORINE_KEY2 = "tigerterrors.poolboy.chlorine_key2";
    public final static String CYACID_KEY = "tigerterrors.poolboy.cyAcid_key";
    public final static String HARDNESS_KEY = "tigerterrors.poolboy.hardness_key";
    public final static String PH_KEY0 = "tigerterrors.poolboy.ph_key0";
    public final static String PH_KEY1 = "tigerterrors.poolboy.ph_key1";
    public final static String PH_KEY2 = "tigerterrors.poolboy.ph_key2";
    public final static String SALT_KEY = "tigerterrors.poolboy.salt_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonCalculate(View view) {
        // Make the EditText objects and find the inputted values.
        EditText poolVolumeText = (EditText) findViewById(R.id.poolVolume);
        EditText alkalinityCurrentText = (EditText) findViewById(R.id.alkalinityCurrent);
        EditText chlorineCurrentText = (EditText) findViewById(R.id.chlorineCurrent);
        EditText cyanuricAcidCurrentText = (EditText) findViewById(R.id.cyanuricAcidCurrent);
        EditText hardnessCurrentText = (EditText) findViewById(R.id.hardnessCurrent);
        EditText phCurrentText = (EditText) findViewById(R.id.phCurrent);
        EditText saltCurrentText = (EditText) findViewById(R.id.saltCurrent);

        int poolVolume = Integer.parseInt(poolVolumeText.getText().toString());
        double alkalinityCurrent = Double.parseDouble(alkalinityCurrentText.getText().toString());
        double chlorineCurrent = Double.parseDouble(chlorineCurrentText.getText().toString());
        double cyanuricAcidCurrent = Double.parseDouble(cyanuricAcidCurrentText.getText().toString());
        double hardnessCurrent = Double.parseDouble(hardnessCurrentText.getText().toString());
        double phCurrent = Double.parseDouble(phCurrentText.getText().toString());
        double saltCurrent = Double.parseDouble(saltCurrentText.getText().toString());
        // Final result values.
        double alkAmount, cyanuricAcidAmount, hardnessAmount, saltAmount;
        double [] chlorineAmount = new double[3];
        double [] phAmount = new double[3];

        Calculator poolCalculator = new Calculator(alkalinityCurrent, chlorineCurrent,
                                        cyanuricAcidCurrent, hardnessCurrent, phCurrent, poolVolume);
        alkAmount = poolCalculator.calcAlkalinity();
        chlorineAmount = poolCalculator.calcChlorine();
        cyanuricAcidAmount = poolCalculator.calcCyAcid();
        hardnessAmount = poolCalculator.calcHardness();
        phAmount = poolCalculator.calcPh();
        // TODO Add salt calculation method
        saltAmount = 0.0;

        String chlorineAmount0 = Double.toString(chlorineAmount[0]);
        String chlorineAmount1 = Double.toString(chlorineAmount[1]);
        String chlorineAmount2 = Double.toString(chlorineAmount[2]);
        String phAmount0 = Double.toString(phAmount[0]);
        String phAmount1 = Double.toString(phAmount[1]);
        String phAmount2 = Double.toString(phAmount[2]);

        // Create the Intent for the ResultsActivity and bundle the data to pass to it.
        Intent resultsIntent = new Intent(this, ResultsActivity.class);

        Bundle bundledResults = new Bundle();
        bundledResults.putString(ALKALINITY_KEY, Double.toString(alkAmount));
        bundledResults.putString(CHLORINE_KEY0, chlorineAmount0);
        bundledResults.putString(CHLORINE_KEY1, chlorineAmount1);
        bundledResults.putString(CHLORINE_KEY2, chlorineAmount2);
        bundledResults.putString(PH_KEY0, phAmount0);
        bundledResults.putString(PH_KEY1, phAmount1);
        bundledResults.putString(PH_KEY2, phAmount2);
        bundledResults.putString(CYACID_KEY, Double.toString(cyanuricAcidAmount));
        bundledResults.putString(HARDNESS_KEY, Double.toString(hardnessAmount));
        bundledResults.putString(SALT_KEY, Double.toString(saltAmount));

        resultsIntent.putExtras(bundledResults);

        startActivity(resultsIntent);
    }
}
