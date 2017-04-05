package tigerterrors.sprint2app.calculator;

import tigerterrors.sprint2app.calculator.Calculator;

/**
 * Created by John on 2/28/17
 * v1.00
 * Updated by Calum Klesel on 4/05/17.
 * v1.01
 */

public class Chlorine extends Calculator {
    private double currChl;
    private int poolVolume;
    //private double amtNeeded; // Amount needed in fl oz is multiplied the volumeFactor
    private double diNeed;    // Amount of dichlor for adjustment
    private double triNeed;   // Amount of trichlor for adjustment
    private double liqNeed;  // Amount of Liquid Chlorine for adjustment
    private double volumeFactor; // volumeFactor is dependent upon the pool volume
    //private double totalAmount; // Total amount to add of the chemical to get the desired Chlorine
    //private boolean trichlor;
    //private boolean dichlor;  //commenting out the bools as the class can give all values on command

    public Chlorine() {
        currChl = 0;
        poolVolume = 0;
        //amtNeeded = 0;
        volumeFactor = 0;
        diNeed = triNeed = liqNeed = 0;
        //totalAmount = 0;
        //trichlor = false;
        //dichlor = false;
    }

    public Chlorine(double currChl, int poolVolume) {
        this.currChl = currChl;
        this.poolVolume = poolVolume;
        //amtNeeded = 0;
        volumeFactor = Calculator.calcVolumeFactor(poolVolume);
        diNeed = triNeed = liqNeed = 0;
        //trichlor = false;
        //dichlor = false;
    }

    @Override
    public void calcChlorine() {
        if(currChl < 3) {
            diNeed = (2.15 * volumeFactor * (3-currChl));
            triNeed = (1.5 * volumeFactor * (3-currChl));
            liqNeed = (12.8 * volumeFactor * (3-currChl));

        } else if(currChl >= 3) {
            diNeed = triNeed = liqNeed = 0;
        }
    }

    //public boolean getTrichlor() { return trichlor; }

    //public boolean getDichlor() { return dichlor; }

    public double getDiNeed() { return diNeed; }

    public double getTriNeed() { return triNeed; }

    public double getLiqNeed() { return liqNeed; }

    @Override
    public double getCurrChl() { return currChl; }

    //@Override
    //public int getPoolVolume() { return poolVolume; }

    //public double getTotalAmount() { return totalAmount; }

    //@Override
    //public void setPoolVolume (int poolVolume) { this.poolVolume = poolVolume; }

    @Override
    public void setCurrChl (double currChl) { this.currChl = currChl; }
}
