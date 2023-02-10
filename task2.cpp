#include <iostream>
using namespace std;

int debit_notes(int balance, int notes[], int count[], int &num)
{
    if (balance == 0)
    {
        return 0;
    }
    if (num >= 4) 
    {
        return 1;
    }

    if (balance >= notes[num] && count[num] > 0)
    {
        int c = min(balance / notes[num], count[num] / 2);
        balance -= c * notes[num];
        count[num] -= c;
    }

    ++num;
    return debit_notes(balance, notes, count, num);
}

int main()
{
    int notes[] = { 2000, 500, 200, 100};
    int count[] = { 0, 0, 0, 0 };
    int n = 4;
    int balance = 0, amount;

    cout << "Welcome to ATM Bank" << endl;
    cout<<"Enter number of 2000 notes:";
    cin >>count[0];
    cout<<"Enter number of 500 notes:";
    cin >>count[1];
    cout<< "Enter number of 200 notes:";
    cin >>count[2];
    cout<<"Enter number of 100 notes:";
    cin >>count[3];
    for (int i = 0; i < n; i++)
    {
        balance += count[i] * notes[i];
    }
    cout <<"Enter amount to be debited:";
    cin>>amount;
    if (balance < amount)
    {
        cout << "Insufficient balance" << endl;
        return 0;
    }
    int num = 0;
    int debited_count[4];
    for (int i = 0; i < n; i++)
    {
        debited_count[i] = count[i];
    }
    debit_notes(amount, notes, debited_count, num);

    cout << "Denomination of debited amount is : ";
    for (int i = 0; i < n; i++)
    {
        if (debited_count[i] < count[i])
        {
            cout << notes[i] << "x" << count[i] - debited_count[i] << ",";
        }
        else
        {
            cout << notes[i] << "x" << "0" << ",";
        }
    }
    cout << endl;
    cout << "Remaining balance in denominations is : ";
    for (int i = 0; i < n; i++)
    {
        if (debited_count[i] > 0)
        {
            cout << notes[i] << "x" << debited_count[i] << ",";
        }
        else
        {
            cout << notes[i] << "x" << "0" << ",";
        }
    }
    cout << endl;
    return 0;
}
