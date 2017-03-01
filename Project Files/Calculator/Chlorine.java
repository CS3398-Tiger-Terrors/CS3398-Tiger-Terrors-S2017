package Calculator;

/**
 * Created by John on 2/28/17
 * v1.00
 */
public class Chlorine extends Calculator {
    private double currChl;
    private int poolVolume;
    private double amtNeeded; // Amount needed in fl oz is multiplied the volumeFactor
    private double volumeFactor; // volumeFactor is dependent upon the pool volume
    private double totalAmount; // Total amount to add of the chemical to get the desired Chlorine
    private boolean trichlor;
    private boolean dichlor;

    public Chlorine() {
        currChl = 0;
        poolVolume = 0;
        amtNeeded = 0;
        volumeFactor = 0;
        totalAmount = 0;
        trichlor = false;
        dichlor = false;
    }

    public Chlorine(double currChl, int poolVolume) {
        this.currChl = currChl;
        this.poolVolume = poolVolume;
        amtNeeded = 0;
        volumeFactor = Calculator.calcVolumeFactor(poolVolume);
        totalAmount = 0;
        trichlor = false;
        dichlor = false;
    }

    @Override
    public double calcChlorine() {
        // FIXME - dependent upone the amtNeeded. multiply the amtNeeded by volumeFactor and set it to totalAmount.
        return totalAmount;
    }

    private void calcAmtNeeded() {
        if(currChl < 3) {
            // FIXME - flag the bool value for which chemical to use and set amtNeeded to the amtNeeded factor
            // Unsure of which chemical to use because both increase chlorine levels. Need some guidance here by Cody.
        } else if(currChl > 3) {
            // FIXME - flag the bool value for which chemical to use and set amtNeeded to the amtNeeded factor
        }
    }

    public boolean getTrichlor() { return trichlor; }

    public boolean getDichlor() { return dichlor; }

    @Override
    public double getCurrChl() { return currChl; }

    @Override
    public int getPoolVolume() { return poolVolume; }

    public double getTotalAmount() { return totalAmount; }

    @Override
    public void setPoolVolume (int poolVolume) { this.poolVolume = poolVolume; }

    @Override
    public void setCurrChl (double currChl) { this.currChl = currChl; }
}
