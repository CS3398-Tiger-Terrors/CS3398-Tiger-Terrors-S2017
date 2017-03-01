package Calculator;

/**
 * Created by calumklesel on 2/26/17.
 * v1.03
 */

public class Calculator {
    // Member variables that start with curr are the current value of the attribute.
    // Member variables that end with amount are the final amount to add to get to a desired range of the attribute.
    private double currAlk;
    private double alkAmount;
    private double currChl; // chlorine measured in ppm
    private double chlAmount;
    private double currCyAcid; // Conditioner/Cyanuric Acid levels measured in ppm
    private double cyAcidAmount;
    private double currHard;
    private double hardAmount;
    private double currPh;
    private double phAmount;
    private int pool_volume; // volume measured in gallons
    private int volumeFactor; // volumeFactor is dependent upon the pool volume

    // Default constructor takes no arguments and initializes all private member variables to 0.
    public Calculator(){
        currAlk = 0;
        currChl = 0;
        currCyAcid = 0;
        currHard = 0;
        currPh = 0;
        pool_volume = 0;
        volumeFactor = 0;
    }

    // Constructor accepts arguments for the starting values of the pool and initializes all private member variables
    // to the called argument values.
    public Calculator(double currAlk, double currChl, double currCyAcid, double currHard, double currPh, int pool_volume) {
        this.currAlk = currAlk;
        this.currChl = currChl;
        this.currCyAcid = currCyAcid;
        this.currHard = currHard;
        this.currPh = currPh;
        this.pool_volume = pool_volume;
        calcVolumeFactor();
    }

    // Used instead of the other constructors when the pool volume is not known
    public Calculator(double currAlk, double currChl, double currCyAcid, double currHard, double currPh,
                      int length, int width, int height, String shape)
    {
        this.currAlk = currAlk;
        this.currChl = currChl;
        this.currCyAcid = currCyAcid;
        this.currHard = currHard;
        this.currPh = currPh;
        this.pool_volume = calcPoolVolume(length, width, height, shape);
        calcVolumeFactor();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Getters and setters
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public double getCurrAlk(){
        return currAlk;
    }

    public double getCurrCyAcid() {
        return currCyAcid;
    }

    public double getCurrChl() {
        return currChl;
    }

    public double getCurrHard() {
        return currHard;
    }

    public double getCurrPh() {
        return currPh;
    }

    public int getPool_volume() {
        return pool_volume;
    }

    public void setCurrAlk(double currAlk) {
        this.currAlk = currAlk;
    }

    public void setCurrCyAcid(double currCyAcid) {
        this.currCyAcid = currCyAcid;
    }

    public void setCurrChl(double currChl) {
        this.currChl = currChl;
    }

    public void setCurrHard(double currHard) {
        this.currHard = currHard;
    }

    public void setCurrPh(double currPh) {
        this.currPh = currPh;
    }

    public void setPool_volume(int pool_volume) {
        this.pool_volume = pool_volume;
    }

    public void setPool_volume(int length, int width, int height, String shape) {
        pool_volume = calcPoolVolume(length, width,height, shape);
    }

    // Static method to calculate the pool volume from anywhere
    public static int calcPoolVolume(int length, int width, int height, String shape) {
        double multiplier = 0;
        switch (shape) {
            case "rectangle":
                multiplier = 7.5;
                break;
            case "oval":
                multiplier = 6.7;
                break;
            case "round":
                multiplier = 5.9;
                break;
            default:
                multiplier = 1;
        }
        return (int) (length * width * height * multiplier);
    }

    // Static method to calculate the volumeFactor from anywhere
    public static int calcVolumeFactor(int pool_volume) {
        return (pool_volume / 10000);
    }

    private void calcVolumeFactor() {
        volumeFactor = pool_volume / 10000;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Methods for calculating the chemical values
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public double calcAlkalinity() {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    public double calcChlorine() {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    public double calcCyAcid() {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    public double calcHardness() {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    // Calculate and return the desired amount of chemicals to add to gain the ideal pH.
    public double calcPh() {
        Ph phObject = new Ph(currPh, pool_volume);
        phAmount = phObject.calcPh();
        return phAmount;
    }
}
