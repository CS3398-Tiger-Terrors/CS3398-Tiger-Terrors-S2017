package tigerterrors.sprint2app.calculator;

/**
 * Created by Calum Klesel on 2/28/17.
 * v1.00
 * Updated by Calum Klesel on 4/05/17.
 * v1.01
 */


public class Alkalinity extends Calculator {

    private double currAlk;
    private int poolVolume;
    private double amtNeeded; // Amount needed in fl oz is multiplied the volumeFactor
    private double volumeFactor; // volumeFactor is dependent upon the pool volume
    private double totalAmount; // Total amount to add of the chemical to get the desired Alkalinity
    private boolean muriaticAcid;
    private boolean bicarb;

    public Alkalinity() {
        currAlk = 0;
        poolVolume = 0;
        amtNeeded = 0;
        volumeFactor = 0;
        totalAmount = 0;
        muriaticAcid = false;
        bicarb = false;
    }

    public Alkalinity(double currAlk, int poolVolume) {
        this.currAlk = currAlk;
        this.poolVolume = poolVolume;
        amtNeeded = 0;
        volumeFactor = Calculator.calcVolumeFactor(poolVolume);
        totalAmount = 0;
        muriaticAcid = false;
        bicarb = false;
    }
    // If the current alkalinity is below 100 it will be increased to a maximum of 100 and a minimum of 99.1.
    // If the current alkalinity is above 100 it will be decreased to a maximum of 100.9 and a minimum of 100.
    // Returns the totalAmount needed to add of the chemical in order to reach the target alkalinity.
    // In order to see which chemical to use, call getMuriaticAcid() or getBicarb().
    @Override
    public double calcAlkalinity() {
        double alkAdjustment = currAlk;
        this.calcAmtNeeded();
        if(muriaticAcid){
            while(alkAdjustment > 100.9){
                totalAmount += (amtNeeded * volumeFactor);
                alkAdjustment--;
            }
        } else if(bicarb) {
            while(alkAdjustment < 99.1){
                totalAmount += (amtNeeded * volumeFactor);
                alkAdjustment++;
            }
        }
        return totalAmount;
    }

    private void calcAmtNeeded() {
        if(currAlk > 100) {
            muriaticAcid = true;
            amtNeeded = 2.56;
        } else if(currAlk < 100) {
            bicarb = true;
            amtNeeded = 2.24;
        }
    }

    // Getters and Setters

    public boolean getMuriaticAcid() { return muriaticAcid; }

    public boolean getBicarb() { return bicarb; }

    @Override
    public double getCurrAlk() { return currAlk; }

    public int getPoolVolume() { return poolVolume; }

    public double getTotalAmount() { return totalAmount; }

    public void setPoolVolume (int poolVolume) { this.poolVolume = poolVolume; }

    @Override
    public void setCurrAlk (double currAlk) { this.currAlk = currAlk; }
}
