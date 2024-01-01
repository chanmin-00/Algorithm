#include <iostream>
#include <algorithm>

using namespace::std;

int zero(int n, int *&arr);
int one(int n, int*& arr);

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

    int n;
    cin >> n;

    int* input_arr = new int[n];
    for (int i = 0; i < n; i++) {
        cin >> input_arr[i];
    }
    

    for (int i = 0; i < n; i++) {
        int* zero_arr = new int[input_arr[i] + 1];
        int* one_arr = new int[input_arr[i] + 1];
        for (int j = 1; j <= input_arr[i]; j++) {
            zero_arr[j] = -1;
        }
        for (int j = 1; j <= input_arr[i]; j++) {
            one_arr[j] = -1;
        }
        zero(input_arr[i], zero_arr);
        one(input_arr[i], one_arr);
        cout << zero_arr[input_arr[i]] << " " << one_arr[input_arr[i]] << endl;
    }
    

}

int zero(int n, int* &zero_arr) {
    int result;
    
    if (n == 0) {
       result = 1;
       zero_arr[0] = result;
       return result;
    }
    if (n == 1) {
        result = 0;
        zero_arr[1] = result;
        return result;
    }
    if (zero_arr[n] != -1) {
        result = zero_arr[n];
    }
    else {
        result = zero(n - 1, zero_arr) + zero(n - 2, zero_arr);
        zero_arr[n] = result;
    }
    
    return result;
}

int one(int n, int*& one_arr) {
    int result;

    if (n == 0) {
        result = 0;
        one_arr[0] = result;
        return result;
    }
    if (n == 1) {
        result = 1;
        one_arr[1] = result;
        return result;
    }
    if (one_arr[n] != -1) {
        result = one_arr[n];
    }
    else {
        result = one(n - 1, one_arr) + one(n - 2, one_arr);
        one_arr[n] = result;
    }

    return result;
}