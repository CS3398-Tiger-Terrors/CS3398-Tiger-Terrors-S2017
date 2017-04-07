package Calculator;

/*
Created by Cody
v 1.00
*/

import tigerterrors.sprint2app.calculator.Calculator;

public class Salt extends Calculator {
	private double currSalt;
	private double targetSalt;
	private int poolVolume;
	private double volumeFactor; //This is dependent on pool volume
	private double totalAmount;
	
	public Salt() {
		currSalt = 0;
		targetSalt = 0;
		poolVolume = 0;
		volumeFactor = 0;
		totalAmount = 0;
	}
	
	public Salt(double currSalt, double targetSalt, int poolVolume) {
		this.currSalt = currSalt;
		this.targetSalt = targetSalt;
		this.poolVolume = poolVolume;
		volumeFactor = Calculator.calcVolumeFactor(poolVolume);
		totalAmount = 0;
	}
	
	/* If Current Salinity is below target Salinity, it will
		return the amount of salt in lbs to be added.
		If current salinity is above target Salinity, it will return -1
		If current salinity is equal to target, it will return 0
	*/
	//@Override
	public double calcSalinity() {
		if(currSalt == targetSalt)
			totalAmount = 0.0;
		else if (currSalt > targetSalt)
			totalAmount = -1.0;
		else
			totalAmount = (.75 * volumeFactor * (targetSalt - currSalt)) / 16;
		return totalAmount;
	}
	
	//getters and setters
	
	//@Override
	public double getCurrSalt() { return currSalt; }
	
	public int getPoolVolume() { return poolVolume; }

    public double getTotalAmount() { return totalAmount; }

    public void setPoolVolume (int poolVolume) { this.poolVolume = poolVolume; }

    //@Override
    public void setCurrSalt (double currSalt, double targetSalt) {
		this.currSalt = currSalt;
		this.targetSalt = targetSalt;
	}
}