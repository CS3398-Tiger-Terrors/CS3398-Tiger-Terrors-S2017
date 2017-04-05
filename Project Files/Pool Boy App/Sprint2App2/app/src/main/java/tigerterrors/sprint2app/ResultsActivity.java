package tigerterrors.sprint2app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_results);
        // Get the bundled data from the previous actvity
        Bundle bundledData = getIntent().getExtras();
        // Assign the bundled data to variables
        String alkAmount = bundledData.getString(ALKALINITY_KEY);
        String chlorineAmount0 = bundledData.getString(CHLORINE_KEY0);
        String chlorineAmount1 = bundledData.getString(CHLORINE_KEY1);
        String chlorineAmount2 = bundledData.getString(CHLORINE_KEY2);
        String cyAcidAmount = bundledData.getString(CYACID_KEY);
        String hardnessAmount = bundledData.getString(HARDNESS_KEY);
        String phAmount0 = bundledData.getString(PH_KEY0);
        String phAmount1 = bundledData.getString(PH_KEY1);
        String phAmount2 = bundledData.getString(PH_KEY2);
        String saltAmount = bundledData.getString(SALT_KEY);
        // Make TextView objects and match them with the TextViews in the UI
        TextView alkAmountText = (TextView) findViewById(R.id.alkalinity_amount);
        TextView chlorineAmount0Text = (TextView) findViewById(R.id.chlorine0_amount);
        TextView chlorineAmount1Text = (TextView) findViewById(R.id.chlorine1_amount);
        TextView chlorineAmount2Text = (TextView) findViewById(R.id.chlorine2_amount);
        TextView cyAcidAmountText = (TextView) findViewById(R.id.cy_acid_amount);
        TextView hardnessAmountText = (TextView) findViewById(R.id.hardness_amount);
        TextView phAmount0Text = (TextView) findViewById(R.id.ph0_amount);
        TextView phAmount1Text = (TextView) findViewById(R.id.ph1_amount);
        TextView phAmount2Text = (TextView) findViewById(R.id.ph2_amount);
        TextView saltAmountText = (TextView) findViewById(R.id.salt_amount);
        // Assign the TextViews the string values
        alkAmountText.setText(alkAmount);
        chlorineAmount0Text.setText(chlorineAmount0);
        chlorineAmount1Text.setText(chlorineAmount1);
        chlorineAmount2Text.setText(chlorineAmount2);
        cyAcidAmountText.setText(cyAcidAmount);
        hardnessAmountText.setText(hardnessAmount);
        phAmount0Text.setText(phAmount0);
        phAmount1Text.setText(phAmount1);
        phAmount2Text.setText(phAmount2);
        saltAmountText.setText(saltAmount);
    }

}
