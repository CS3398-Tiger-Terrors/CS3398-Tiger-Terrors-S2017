// AUTHOR: Leo
// C++ code. No input validation.
// Only calculates for a brand new pool starting with tap water.
// Pool Boy App recommends 3/4 of suggested chemicals to be added to the pool.

#include <iostream>
using namespace std;

//===============================================================================
// A round ring pool, 48 inches tall and 15 feet across, holds 4,978 gallons.
// An in-ground pool can hold 31,000 gallons or more. To find the number
// of gallons in a pool, measure and multiply together the length, width and
// average depth, then multiply by 7.5 for a rectangular pool, 6.7 for an oval
// pool or 5.9 for a round pool.
//===============================================================================
float poolSizeSubroutine(float length, float width, float depth)
{
    float rectangularPool = 7.5;
    float ovalPool = 6.7;
    float roundPool = 5.9;
    int choice;

    cout << "Is the pool rectangular(1), oval(2), or round(3)? ";
    cin >> choice;

    if (choice==1)
        return (length*width*depth*rectangularPool);
    if (choice==2)
        return (length*width*depth*ovalPool);
    if (choice==3)
        return (length*width*depth*roundPool);
}

//===============================================================================
// The basic balance of chlorine to water is between 1 and 3 ppm, or 0.00013
// ounces of chlorine per gallon of water. Before you add the chlorine, you need
// to know how many gallons of water are in the pool. Before adding chlorine to
// the pool, test the current chlorine level with a pool chlorine test strip.
// Generally, you should maintain the pool's chlorine level between 1 and 3 ppm.
// Thus, if the chlorine level is already 1 ppm and you want it higher,
// add 0.00013 ounces per gallon to raise the chlorine by 1 ppm. Simply multiply
// the number of gallons in the pool, such as 4,978, by 0.00013 to find that you
// should add -- in this example -- .65 ounces of chlorine
//===============================================================================
float chlorineSubroutine(float poolSize)
{
    float chlorineStandard = 0.00013;

    return poolSize*chlorineStandard; //*0.75?
}

//===============================================================================
// Chlorine works best when the pool's pH level is between 7.2 and 7.8.
// If your pH is still low, try adding sodium carbonate, commonly called soda ash.
// Never add more than 2 lbs of soda ash per 10,000 gallons of water in your pool
// in any single treatment. Sodium bisulfate, also called dry acid, and is used
// to reduce pH in swimming pools, Dosage: 20 oz per 10,000 gallons.
//===============================================================================
void phSubroutine(float phLevel, float poolSize)
{
    if (phLevel < 7.2)
    {
        float sodaAshAmount = (poolSize/10000)*2*0.75;
        cout << "Pool's pH level is currently low." << endl;
        cout << "Add " << sodaAshAmount << " pounds of Soda Ash to the new pool.\n";
        return;
    };

    if (phLevel > 7.8)
    {
        float dryAcidAmount = (poolSize/10000)*20*0.75;
        cout << "Pool's pH level is currently high." << endl;
        cout << "Add " << dryAcidAmount << " ounces of Dry Acid to the new pool.\n";
        return;
    };

    cout << "Pool's pH level is currently good." << endl;
    return;
}

//===============================================================================
// Use 2 oz. of calcium chloride for every 1,000 gallons of water to raise the
// ppm by 10. For example, if your pool holds 10,000 gallons of water, and you
// wish to raise the ppm by 20, you must add 40 oz., or 2.5 lbs, of calcium
// chloride to the water. If you add too much calcium chloride to your water, you
// can easily reduce the levels by draining some water from your pool and
// replacing it with clean water.
//===============================================================================
void hardnessSubroutine(float calciumHardnessLevel, float poolSize)
{
    if (calciumHardnessLevel < 200)
    {
        float calciumChlorideAmount = (poolSize/1000)*2*(200-calciumHardnessLevel); //*0.75?
        cout << "Pool's Hardness level is currently low." << endl;
        cout << "Add " << calciumChlorideAmount << " ounces of calcium chloride to the new pool.\n";
        return;
    };

    if (calciumHardnessLevel > 400)
    {
        cout << "Poo's Hardness level is currently high." << endl;
        cout << "Draining some water from your pool and replace it with clean water." << endl;
        return;
    };

    cout << "Pool's hardness level is currently good." << endl;
    return;
}

int main()
{
    float length, width, depth;
    //float poolBoyRecommends = 0.75;

    cout << "Pool Boy v1.1.1" << endl << endl;
    cout << "Enter length, width, and average depth of your pool (in feet): ";
    cin >> length >> width >> depth;
    //cout << length << " " << width << " " << depth << endl;

    float poolSize = poolSizeSubroutine(length, width, depth);
    //cout << poolSize << endl;

    float chlorineOunces;
    chlorineOunces = chlorineSubroutine(poolSize);
    cout << "\nFor your new pool with " << poolSize << " gallons of water, add ";
    cout << chlorineOunces << " ounces of chlorine to it." << endl;

    float phLevel;
    cout << "\nWhat is the pool's current measured pH level? ";
    cin >> phLevel;
    phSubroutine(phLevel, poolSize);

    float calciumHardnessLevel;
    cout << "\nWhat is the pool's current measured hardness level (in ppm)? ";
    cin >> calciumHardnessLevel;
    hardnessSubroutine(calciumHardnessLevel, poolSize);

    return 0;
}
