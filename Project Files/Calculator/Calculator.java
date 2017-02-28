package Calculator;

/**
 * Created by calumklesel on 2/26/17.
 * v1.02
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
        calc_volumeFactor();
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
        this.pool_volume = calc_pool_volume(length, width, height, shape);
        calc_volumeFactor();
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
        pool_volume = calc_pool_volume(length, width,height, shape);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Static Methods for calculating values without creating an object of the calculator class. Can be used if one
    // needs to calculate a single a few chemical levels without having to make a whole calculator object.
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*    public static double calc_alk(double currAlk, int pool_volume) {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    public static double calc_alk() {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    public static double calc_chl(double currChl, int pool_volume) {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    public static double calc_chl() {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    public static double calc_c_acid(double currCyAcid, int pool_volume) {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    public static double calc_c_acid() {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    public static double calc_hard(double currHard, int pool_volume) {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    public static double calc_hard() {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    public static double calc_ph(double currPh, int pool_volume) {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    public static double calc_ph() {
        return 0; //FIXME CALCULATIONS DONE HERE
    }*/

    public static int calc_pool_volume(int length, int width, int height, String shape) {
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

    public static int calc_volumeFactor(int pool_volume) {
        return (pool_volume / 10000);
    }

    private void calc_volumeFactor() {
        volumeFactor = pool_volume / 10000;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Methods for calculating the chemical values
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public double calc_alk() {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    public double calc_chl() {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    public double calc_c_acid() {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    public double calc_hard() {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    // Calculate and return the desired amount of chemicals to add to gain the ideal pH.
    public double calc_ph() {
        Ph phObject = new Ph(currPh, pool_volume);
        phAmount = phObject.calc_ph();
        return phAmount;
    }
}
