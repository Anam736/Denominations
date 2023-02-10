import java.util.Scanner;

public class Task2 {
    public static int func(int bal, int[] notes, int[] count, int val) {
        if (bal == 0) {
            return 0;
        }
        if (val >= 4) {
            return 1;
        }
        if (bal >= notes[val] && count[val] > 0) {
            int c = Math.min(bal / notes[val], count[val] / 2);
            bal = bal - (c * notes[val]);
            count[val] = count[val] - c;
        }
        ++val;
        return func(bal, notes, count, val);
    }

    public static void main(String[] args) {
        int[] notes = { 2000, 500, 200, 100 };
        int[] count = { 0, 0, 0, 0 };
        int n = 4, bal = 0, amount;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to ATM Bank");
        System.out.print("Enter number of 2000 notes:");
        count[0] = sc.nextInt();
        System.out.print("Enter number of 500 notes:");
        count[1] = sc.nextInt();
        System.out.print("Enter number of 200 notes:");
        count[2] = sc.nextInt();
        System.out.print("Enter number of 100 notes:");
        count[3] = sc.nextInt();
        for (int i = 0; i < n; i++) {
            bal = bal + count[i] * notes[i];
        }
        System.out.print("Enter amount to be debited:");
        amount = sc.nextInt();
        if (bal < amount) {
            System.out.println("Insufficient balance");
            return;
        }
        int val = 0;
        int[] debitedCount = count.clone();
        func(amount, notes, debitedCount, val);

        System.out.print("Denomination of debited amount is:");
        for (int i = 0; i < n; i++) {
            if (debitedCount[i] < count[i]) {
                System.out.print(notes[i] + "x" + (count[i] - debitedCount[i]) + ",");
            } else {
                System.out.print(notes[i] + "x" + "0" + ",");
            }
        }
        System.out.println();
        System.out.print("Remaining balance in denominations is:");
        for (int i = 0; i < n; i++) {
            if (debitedCount[i] > 0) {
                System.out.print(notes[i] + "x" + debitedCount[i] + ",");
            }

            else {
                System.out.print(notes[i] + "x" + "0" + ",");
            }

        }
    }
}
