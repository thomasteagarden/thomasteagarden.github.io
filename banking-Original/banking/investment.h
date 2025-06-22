#include <iostream>
#include <string>
#include <iomanip>

using namespace std;



int main() {
    double initialAmount;
    double monthlyDeposit;
    double annualInterest;
    double numMonths;
    double numYears;
    double totalAmt;
    double interestAmt;

    cout << "**********************************************************" << endl;
    cout << "********************* Data Input *************************" << endl;
    cout << "Inital Investment Amount: " << endl;
    cout << "Monthly Deposit: " << endl;
    cout << "Annual Interest: " << endl;
    cout << "Number of years: " << endl;

    system("PAUSE");

    cout << "**********************************************************" << endl;
    cout << "********************* Data Input *************************" << endl;
    cout << "Inital Investment Amount: $" << initialAmount << endl;
    cin >> initialAmount;
    cout << "Monthly Deposit: $" << monthlyDeposit << endl;
    cin >> monthlyDeposit;
    cout << "Annual Interest: %" << annualInterest << endl;
    cin >> annualInterest;
    cout << "Number of years: " << numYears << endl;
    cin >> numYears;
    numMonths = numYears * 12;

    system("PAUSE");

    totalAmt = initialAmount;

    cout << "  Balance and Interest Without Additional Monthly Deposits   " << endl;
    cout << "=============================================================" << endl;
    cout << "Year\t\tYear End Balance\t Year End Earned Interest" << endl;
    cout << "-------------------------------------------------------------" << endl;
    for (int i = 0; i < years; i++) {

        interestAmt = (totalAmt) * ((annualInterest / 100));
        totalAmt = totalAmt + interestAmt;

        cout << (i + 1) <<"\t\t" << fixed << setpercision(2) << totalAmt << "\t\t\t" << interestAmt << endl;
    }

    totalAmt = interestAmt;

    cout << "  Balance and Interest With Additional Monthly Deposits   " << endl;
    cout << "=============================================================" << endl;
    cout << "Year\t\tYear End Balance\t Year End Earned Interest" << endl;
    cout << "-------------------------------------------------------------" << endl;
    for (int i = 0; i < years; i++) {
        yearTotalInt = 0;
        for (int j = 0; j < 12; j++) {

            interestAmt = (totalAmt + monthlyDeposit) * ((annualInterest / 100) / 12);
            yearTotalInt = yearTotalInt + initialAmount;
            totalAmt = totalAmt + monthlyDeposit + interestAmt;
        }

        cout << (i + 1) << "\t\t\t" << fixed << setpercision(2) << totalAmt << "\t\t\t" << yearTotalInt << endl;
    }
    return 0;
}