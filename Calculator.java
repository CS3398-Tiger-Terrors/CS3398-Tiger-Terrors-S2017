package Calculator;

/**
 * Created by calumklesel on 2/26/17.
 */

public class Calculator {

    protected double alk;
    protected double chl;
    protected double c_acid;
    protected double hard;
    protected double ph;
    protected int pool_volume;

    // Default constructor takes no arguments and initializes all private member variables to 0.
    public Calculator(){
        alk = 0;
        chl = 0;
        c_acid = 0;
        hard = 0;
        ph = 0;
        pool_volume = 0;
    }

    // Constructor accepts arguments for the starting values of the pool and initializes all private member variables
    // to the called argument values.
    public Calculator(double alk, double chl, double c_acid, double hard, double ph, int pool_volume) {
        this.alk = alk;
        this.chl = chl;
        this.c_acid = c_acid;
        this.hard = hard;
        this.ph = ph;
        this.pool_volume = pool_volume;
    }

    // Used instead of the other constructors when the pool volume is not known
    public Calculator(double alk, double chl, double c_acid, double hard, double ph,
                      int length, int width, int height, String shape)

    {
        this.alk = alk;
        this.chl = chl;
        this.c_acid = c_acid;
        this.hard = hard;
        this.ph = ph;
        this.pool_volume = calc_pool_volume(length, width, height, shape);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Getters and setters
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public double getAlk(){
        return alk;
    }

    public double getC_acid() {
        return c_acid;
    }

    public double getChl() {
        return chl;
    }

    public double getHard() {
        return hard;
    }

    public double getPh() {
        return ph;
    }

    public int getPool_volume() {
        return pool_volume;
    }

    public void setAlk(double alk) {
        this.alk = alk;
    }

    public void setC_acid(double c_acid) {
        this.c_acid = c_acid;
    }

    public void setChl(double chl) {
        this.chl = chl;
    }

    public void setHard(double hard) {
        this.hard = hard;
    }

    public void setPh(double ph) {
        this.ph = ph;
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

    public static double calc_alk(double alk, int pool_volume) {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    public static double calc_chl(double chl, int pool_volume) {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    public static double calc_c_acid(double c_acid, int pool_volume) {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    public static double calc_hard(double hard, int pool_volume) {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

    public static double calc_ph(double ph, int pool_volume) {
        return 0; //FIXME CALCULATIONS DONE HERE
    }

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

    public double calc_ph() {
        return 0; //FIXME CALCULATIONS DONE HERE
    }
}
