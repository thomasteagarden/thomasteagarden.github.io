
"""
Thomas Teagrden
Southern New Hampshire University
CS 499 Enhancement
Software Engineering and Design
"""

def getPositiveFloat(prompt):
    while True:
        try:
            value = float(input(prompt))
            if value < 0:
                print("Please enter a non-negative number.")
            else:
                return value
        except ValueError:
            print("Invalid input. Please enter a valid number.")

def displayReport(initialAmount, monthlyDeposit, annualInterest, numYears, includeMonthly):
    title = "💹 Balance and Interest Report " + ("With Monthly Deposits" if includeMonthly else "Without Monthly Deposits")

    print("\n" + "=" * 70)
    print(f"{title:^70}")
    print("=" * 70)
    print(f"{'📅 Year':<10}{'💰 Year End Balance':<30}{'📈 Year End Interest'}")
    print("-" * 70)

    balance = initialAmount
    for year in range(1, int(numYears) + 1):
        totalInterest = 0
        for _ in range(12):
            if includeMonthly:
                balance += monthlyDeposit
            interest = balance * (annualInterest / 100 / 12)
            totalInterest += interest
            balance += interest
        print(f"{year:<10} ${balance:>18,.2f} {'':4}${totalInterest:>18,.2f}")

    print("=" * 70)


def main():
    while True:
        print("\n" + "=" * 60)
        print("{:^60}".format("💼 Investment Calculator"))
        print("=" * 60)

        print("\nPlease enter the following details:\n")

        initialAmount = getPositiveFloat("  📌 Initial Investment Amount: $")
        monthlyDeposit = getPositiveFloat("  💵 Monthly Deposit: $")
        annualInterest = getPositiveFloat("  📈 Annual Interest Rate (%): ")
        numYears = getPositiveFloat("  ⏳ Number of Years: ")

        input("\n✅ Press Enter to view your investment report...")

        if (monthlyDeposit == 0):
            print("\n" + "-" * 60)
            print("{:^60}".format("📊 REPORT WITHOUT MONTHLY DEPOSITS"))
            print("-" * 60)
            displayReport(initialAmount, 0, annualInterest, numYears, False)
        else:
            print("\n" + "-" * 60)
            print("{:^60}".format("📊 REPORT WITH MONTHLY DEPOSITS"))
            print("-" * 60)
            displayReport(initialAmount, monthlyDeposit, annualInterest, numYears, True)

        print("\n" + "=" * 60)
        choice = input("🔁 Would you like to perform another calculation? (yes/no): ").strip().lower()
        if choice not in ('yes', 'y'):
            print("\n👋 Exiting program. Thank you and goodbye!")
            input("\n Press any button to exit the program!")
            break

if __name__ == "__main__":
    main()
