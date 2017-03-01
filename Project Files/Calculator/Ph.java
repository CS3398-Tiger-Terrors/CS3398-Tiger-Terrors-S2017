package Calculator;

/**
 * Created by calumklesel on 2/27/17.
 * v1.03
 */
public class Ph extends Calculator {
    private double currPh;
    private int pool_volume;
    private boolean sodaAsh;
    private boolean dryAcid;
    private double amtNeeded; // Amount needed in fl oz is multiplied the volumeFactor
    private double volumeFactor; // volumeFactor is dependent upon the pool volume
    private double totalAmount; // Total amount to add of the chemical to get the desired pH


    public Ph(double currPh, int pool_volume) {
        this.currPh = currPh;
        this.pool_volume = pool_volume;
        amtNeeded = 0;
        sodaAsh = false;
        dryAcid = false;
        volumeFactor = Calculator.calcVolumeFactor(pool_volume);
        totalAmount = 0;
    }

    // Only calculates accurately for a current pH that is at least 6.8 or no greater than 8.4,
    // but will suggest a value for levels that are not within that range.
    // In order to know which chemical to add call the getDryAcid() or getSodaAsh() methods.
    // Returns the total amount needed to add to get the target pH. (ie totalAmount)
    @Override
    public double calcPh() {
        calcAmtNeeded();
        totalAmount = amtNeeded * volumeFactor;
        return totalAmount;
    }

    // Getter and setters.
    // Note: not able to get or set values other than currPh, pool_volume, totalAmount, sodaAsh, and dryAcid.
    @Override
    public void setCurrPh(double currPh) {
        this.currPh = currPh;
    }

    @Override
    public void setPool_volume(int pool_volume) { this.pool_volume = pool_volume; }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean getSodaAsh() {
        if (sodaAsh) return true;
        else return false;
    }

    public boolean getDryAcid() {
        if (dryAcid) return true;
        else return false;
    }

    private void calcAmtNeeded() {
        if(currPh < 6.8) {
            currPh = 6.8;
        } else if(currPh > 8.4) {
            currPh = 8.4;
        } else if((currPh > 7.2) && (currPh < 7.8)) {
            currPh = 7.2;
        } else if((currPh >= 6.8) || (currPh <= 7.2)) {
            sodaAsh = true;
            String phString = Double.toString(currPh);
            switch (phString) {
                case "6.8":
                case "6.9":
                    amtNeeded = 12.0;
                    break;

                case "7":
                case "7.0":
                case "7.1":
                    amtNeeded = 8.0;
                    break;

                case "7.2":
                    amtNeeded = 6.0;
                    break;

                default:
                    break;
            }
        } else {
            dryAcid = true;
            String phString = Double.toString(currPh);
            switch (phString) {
                case "7.8":
                case "7.9":
                    amtNeeded = 15.0;
                    break;

                case "8":
                case "8.0":
                case "8.1":
                case "8.2":
                case "8.3":
                    amtNeeded = 20.0;
                    break;

                case "8.4":
                    amtNeeded = 30.0;
                    break;

                default:
                    break;
            }
        }
    }

}
