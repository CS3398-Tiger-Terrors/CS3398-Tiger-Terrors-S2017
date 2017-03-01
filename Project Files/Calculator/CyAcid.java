package Calculator;

/**
 * Created by calumklesel on 2/27/17.
 * v1.01
 */
public class CyAcid extends Calculator {

    private final double amtNeeded = 1.3; // Amount needed in fl oz is multiplied by the volumeFactor
    private double currCyAcid;
    private int pool_volume;
    private double volumeFactor; // volumeFactor is dependent upon the pool volume
    private double totalAmount;

    public CyAcid(double currCyAcid, int pool_volume) {
        this.currCyAcid = currCyAcid;
        this.pool_volume = pool_volume;
        volumeFactor = Calculator.calcVolumeFactor(pool_volume);
    }

    public double calcCyAcid() {
        if((currCyAcid >= 30) || (currCyAcid <= 100)) {
            return totalAmount;
        }
        else if(currCyAcid < 30) {
            String cyAcidString = Double.toString(currCyAcid);
            switch (cyAcidString) {
                case "0":
                    totalAmount = (volumeFactor * amtNeeded) * 30;
                    break;
                case "1":
                    totalAmount = (volumeFactor * amtNeeded) * 29;
                    break;
                case "2":
                    totalAmount = (volumeFactor * amtNeeded) * 28;
                    break;
                case "3":
                    totalAmount = (volumeFactor * amtNeeded) * 27;
                    break;
                case "4":
                    totalAmount = (volumeFactor * amtNeeded) * 26;
                    break;
                case "5":
                    totalAmount = (volumeFactor * amtNeeded) * 25;
                    break;
                case "6":
                    totalAmount = (volumeFactor * amtNeeded) * 24;
                    break;
                case "7":
                    totalAmount = (volumeFactor * amtNeeded) * 23;
                    break;
                case "8":
                    totalAmount = (volumeFactor * amtNeeded) * 22;
                    break;
                case "9":
                    totalAmount = (volumeFactor * amtNeeded) * 21;
                    break;
                case "10":
                    totalAmount = (volumeFactor * amtNeeded) * 20;
                    break;
                case "11":
                    totalAmount = (volumeFactor * amtNeeded) * 19;
                    break;
                case "12":
                    totalAmount = (volumeFactor * amtNeeded) * 18;
                    break;
                case "13":
                    totalAmount = (volumeFactor * amtNeeded) * 17;
                    break;
                case "14":
                    totalAmount = (volumeFactor * amtNeeded) * 16;
                    break;
                case "15":
                    totalAmount = (volumeFactor * amtNeeded) * 15;
                    break;
                case "16":
                    totalAmount = (volumeFactor * amtNeeded) * 14;
                    break;
                case "17":
                    totalAmount = (volumeFactor * amtNeeded) * 13;
                    break;
                case "18":
                    totalAmount = (volumeFactor * amtNeeded) * 12;
                    break;
                case "19":
                    totalAmount = (volumeFactor * amtNeeded) * 11;
                    break;
                case "20":
                    totalAmount = (volumeFactor * amtNeeded) * 10;
                    break;
                case "21":
                    totalAmount = (volumeFactor * amtNeeded) * 9;
                    break;
                case "22":
                    totalAmount = (volumeFactor * amtNeeded) * 8;
                    break;
                case "23":
                    totalAmount = (volumeFactor * amtNeeded) * 7;
                    break;
                case "24":
                    totalAmount = (volumeFactor * amtNeeded) * 6;
                    break;
                case "25":
                    totalAmount = (volumeFactor * amtNeeded) * 5;
                    break;
                case "26":
                    totalAmount = (volumeFactor * amtNeeded) * 4;
                    break;
                case "27":
                    totalAmount = (volumeFactor * amtNeeded) * 3;
                    break;
                case "28":
                    totalAmount = (volumeFactor * amtNeeded) * 2;
                    break;
                case "29":
                    totalAmount = (volumeFactor * amtNeeded) * 1;
                    break;
            }
            return totalAmount;
        }
        totalAmount = -1;
        return totalAmount;
    }

    @Override
    public void setPool_volume(int pool_volume) { this.pool_volume = pool_volume; }

    @Override
    public void setCurrCyAcid(double currCyAcid) { this.currCyAcid = currCyAcid; }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public double getCurrCyAcid() { return currCyAcid; }

    @Override
    public int getPool_volume() { return pool_volume; }
}
