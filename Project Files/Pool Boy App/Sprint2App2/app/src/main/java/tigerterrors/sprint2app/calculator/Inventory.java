package tigerterrors.sprint2app.calculator;

/* Created by Cody.
v1.00
*/


/*N.B.
this class is not currently functional.
I do not understand the workings of the actual app code/activities well enough to dive into them
and what I'm researching says I would need to edit these to get it functional.
I do not want to do this before I speak with the team, instead of risking bricking their code.
 */

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Inventory {
    Context context = Activity.getApplicationContext();

    SharedPreferences preferences = context.getSharedPreferences("TIGER_PREF", 0);
    SharedPreferences.Editor editor = preferences.edit();


    public void saveDi(double di) {
        editor.putFloat("dichlor", (float)di);
        editor.apply();
    }

    public void saveTri(double tri) {
        editor.putFloat("trichlor", (float)tri);
        editor.apply();
    }

    public void saveLiq(double liq) {
        editor.putFloat("liquid", (float)liq);
        editor.apply();
    }

    public void saveBicarb(double bicarb) {
        editor.putFloat("bicarb", (float)bicarb);
        editor.apply();
    }

    public void saveAsh(double ash) {
        editor.putFloat("ash", (float)ash);
        editor.apply();
    }


    public void saveAcid(double acid) {
        editor.putFloat("acid", (float)acid);
        editor.apply();
    }

    public void saveDry(double dry) {
        editor.putFloat("dry", (float)dry);
        editor.apply();
    }

    public void saveCya(double cya) {
        editor.putFloat("cya", (float)cya);
        editor.apply();
    }

    public void saveSalt(double salt) {
        editor.putFloat("salt", (float)salt);
        editor.apply();
    }

    public void saveHard(double hard) {
        editor.putFloat("hard", (float)hard);
        editor.apply();
    }

    public void saveShock(double shock) {
        editor.putFloat("shock", (float)shock);
        editor.apply();
    }

    public void updateInv(double[] inv) {
        editor.putFloat("dichlor", (float)inv[0]);
        editor.putFloat("trichlor", (float)inv[1]);
        editor.putFloat("liquid", (float)inv[2]);
        editor.putFloat("bicarb", (float)inv[3]);
        editor.putFloat("ash", (float)inv[4]);
        editor.putFloat("acid", (float)inv[5]);
        editor.putFloat("dry", (float)inv[6]);
        editor.putFloat("cya", (float)inv[7]);
        editor.putFloat("salt", (float)inv[8]);
        editor.putFloat("hard", (float)inv[9]);
        editor.putFloat("shock", (float)inv[10]);
        editor.apply();
    }

    public double getDi() {
        return (double)preferences.getFloat("dichlor", -1.0f);
    }

    public double getTri() {
        return (double)preferences.getFloat("trichlor", -1.0f);
    }

    public double getLiq() {
        return (double)preferences.getFloat("liquid", -1.0f);
    }

    public double getBicarb() {
        return (double)preferences.getFloat("bicarb", -1.0f);
    }

    public double getAsh() {
        return (double)preferences.getFloat("ash", -1.0f);
    }

    public double getAcid() {
        return (double)preferences.getFloat("acid", -1.0f);
    }

    public double getCya() {
        return (double)preferences.getFloat("cya", -1.0f);
    }

    public double getSalt() {
        return (double)preferences.getFloat("salt", -1.0f);
    }

    public double getHard() {
        return (double)preferences.getFloat("hard", -1.0f);

    }

    public double getShock() {
        return (double)preferences.getFloat("shock", -1.0f);
    }

    public double[] getInv() {
        double [] inventory = new double[10];
        inventory[0] = (double)preferences.getFloat("dichlor", -1f);
        inventory[1] = (double)preferences.getFloat("trichlor", -1f);
        inventory[2] = (double)preferences.getFloat("liquid", -1f);
        inventory[3] = (double)preferences.getFloat("bicarb", -1f);
        inventory[4] = (double)preferences.getFloat("ash", -1f);
        inventory[5] = (double)preferences.getFloat("acid", -1f);
        inventory[6] = (double)preferences.getFloat("dry", -1f);
        inventory[7] = (double)preferences.getFloat("cya", -1f);
        inventory[8] = (double)preferences.getFloat("salt", -1f);
        inventory[9] = (double)preferences.getFloat("hard", -1f);
        inventory[10] = (double)preferences.getFloat("shock", -1f);

        return inventory;
    }
}