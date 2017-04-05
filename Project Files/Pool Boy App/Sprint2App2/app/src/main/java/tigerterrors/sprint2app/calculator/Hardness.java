package tigerterrors.sprint2app.calculator;

/**
 * Created by Cody on 2/28/17.
 * v1.00
 * Updated by Calum Klesel on 4/05/17.
 * v1.04
 */

public class Hardness extends Calculator {

    private double currHard;
    private int poolVolume;
    private double volumeFactor; // volumeFactor is dependent upon the pool volume
    private double totalAmount; // Total amount to add of the chemical to get the desired Hardness


    public Hardness() {
        currHard = 0;
        poolVolume = 0;
        volumeFactor = 0;
        totalAmount = 0;

    }

    public Hardness(double currHard, int poolVolume) {
        this.currHard = currHard;
        this.poolVolume = poolVolume;
        volumeFactor = Calculator.calcVolumeFactor(poolVolume);
        totalAmount = 0;

    }
    // If the current hardness is below 200 it will be increased to 220
    // If the current Hardness is between 200 and 400, it does nothing
    // If the current hardness is above 400, it returns -1
    // Returns the totalAmount needed to add of the chemical in order to reach the target hardness
    @Override
    public double calcHardness() {
        if(currHard > 400)
            totalAmount = -1.0;
        else if (currHard >=200 && currHard <=400)
            totalAmount = 0;
        else
            totalAmount = 1.44 * volumeFactor * (220 - currHard);
        return totalAmount;
    }


    // Getters and Setters

    @Override
    public double getCurrHard() { return currHard; }

    public int getPoolVolume() { return poolVolume; }

    public double getTotalAmount() { return totalAmount; }

    public void setPoolVolume (int poolVolume) { this.poolVolume = poolVolume; }

    @Override
    public void setCurrHard (double currHard) { this.currHard = currHard; }
}
