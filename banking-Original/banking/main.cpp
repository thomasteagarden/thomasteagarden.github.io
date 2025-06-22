/*Thomas Teagarden
Southern New Hampshire University 
CS - 210
Project 2*/

#include <iostream>
#include <string>
#include <iomanip>

using namespace std;



int main() {
    // Declare variable for program
    double initialAmount;
    double monthlyDeposit;
    double annualInterest;
    double numMonths;
    double numYears;
    double totalAmt;
    double interestAmt;
    double yearTotalInt;

    // Ask user to input values for the menu
    cout << "\n**********************************************************" << endl;
    cout << "********************* Data Input *************************" << endl;
    cout << "Inital Investment Amount: $";
    cin >> initialAmount;
    cout << "Monthly Deposit: $";
    cin >> monthlyDeposit;
    cout << "Annual Interest: %";
    cin >> annualInterest;
    cout << "Number of years: ";
    cin >> numYears;
    numMonths = numYears * 12;

    system("PAUSE");
    
    // Initalize total amount
    totalAmt = initialAmount;

    // Create display for no additional monthly deposits
    cout << "  Balance and Interest Without Additional Monthly Deposits   " << endl;
    cout << "=============================================================" << endl;
    cout << "Year\t\tYear End Balance\t Year End Earned Interest" << endl;
    cout << "-------------------------------------------------------------" << endl;
    for (int i = 0; i < numYears; i++) {
        // calculate the total for the number of years
        interestAmt = (totalAmt) * ((annualInterest / 100));
        totalAmt = totalAmt + interestAmt;
        // format output
        cout << (i + 1) <<"\t\t$" << fixed << setprecision(2) << setw(3) << totalAmt << "\t\t\t$" << setw(3) << interestAmt << endl;
    }
    // initalize total amount for new display
    totalAmt = interestAmt;
    // display for additonal monthly deposists
    cout << "\n  Balance and Interest With Additional Monthly Deposits   " << endl;
    cout << "=============================================================" << endl;
    cout << "Year\t\tYear End Balance\t Year End Earned Interest" << endl;
    cout << "-------------------------------------------------------------" << endl;
    for (int i = 0; i < numYears; i++) {
        yearTotalInt = 0;
        for (int j = 0; j < 12; j++) {
            // calcualte the compounded interest and totals for monthly deposit table
            interestAmt = (totalAmt + monthlyDeposit) * ((annualInterest / 100) / 12);
            yearTotalInt = yearTotalInt + initialAmount;
            totalAmt = totalAmt + monthlyDeposit + interestAmt;
        }
        //format and display the table
        cout << (i + 1) << "\t\t$" << fixed << setprecision(2) << setw(7) << totalAmt << "\t\t$" <<setw(6) << yearTotalInt << endl;
        
    }
    // stop the program from closing so the user can see the results
    system("PAUSE");
    return 0;
}