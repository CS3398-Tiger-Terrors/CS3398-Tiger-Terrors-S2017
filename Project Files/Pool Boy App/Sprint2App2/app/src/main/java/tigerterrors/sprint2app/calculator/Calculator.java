package tigerterrors.sprint2app.calculator;

/**
 * Created by Calum Klesel on 2/26/17.
 * v1.03
 * Updated by Calum Klesel on 4/05/17.
 * v1.04
 */

public class Calculator {
    // Member variables that start with curr are the current value of the attribute.
    // Member variables that end with amount are the final amount to add to get to a desired range of the attribute.
    private double currAlk;
    private double alkAmount;
    private boolean alkAdj;  // 1 if we're raising (bicarb), 0 if we're lowering or staying the same
    private double currChl; // chlorine measured in ppm
    private double chlAmountDi; // amount of diChlor needed
    private double chlAmountTri; // amount of triChlor needed
    private double chlAmountLiq; // amount of liquid chlorine needed
    private double currCyAcid; // Conditioner/Cyanuric Acid levels measured in ppm
    private double cyAcidAmount;
    private double currHard;
    private double hardAmount;
    private double currPh;
    private double phAmountDry;
    private double phAmountWet;
    private double phAmountAsh;
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

    public double calcAlkalinity(){
        Alkalinity alkObject = new Alkalinity(currAlk, pool_volume);
        alkAmount = alkObject.calcAlkalinity();
        alkAdj = alkObject.getBicarb();
        return alkAmount;
    }

    public double[] calcChlorine() {
        Chlorine chlObject = new Chlorine(currChl, pool_volume);
        chlObject.calcChlorine();
        chlAmountDi = chlObject.getDiNeed();
        chlAmountTri = chlObject.getTriNeed();
        chlAmountLiq = chlObject.getLiqNeed();
        double [] chlAmountArr = new double [3];
        chlAmountArr[1] = chlAmountDi;
        chlAmountArr[2] = chlAmountTri;
        chlAmountArr[3] = chlAmountLiq;
        return chlAmountArr;
    }

    public double calcCyAcid() {
        CyAcid cyObject = new CyAcid(currCyAcid, pool_volume);
        cyAcidAmount = cyObject.calcCyAcid();
        return cyAcidAmount;
    }

    public double calcHardness() {
        Hardness hardObject = new Hardness(currHard, pool_volume);
        hardAmount = hardObject.calcHardness();
        return hardAmount;
    }

    // Calculate and return the desired amount of chemicals to add to gain the ideal pH.
    // The array that is returned holds the amount needed of Dry, Wet, and Ash in index 0, 1, and
    // 2 respectively.
    public double[] calcPh() {
        Ph phObject = new Ph(currPh, pool_volume);
        phObject.calcPh();
        phAmountDry = phObject.getAmtNeededDry();
        phAmountWet = phObject.getAmtNeededWet();
        phAmountAsh = phObject.getAmtNeededAsh();
        double[] phArray = new double[3];
        phArray[0] = phAmountDry;
        phArray[1] = phAmountWet;
        phArray[2] = phAmountAsh;
        return phArray;
    }
}
