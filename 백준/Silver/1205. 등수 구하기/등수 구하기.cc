#include <iostream>
#include <algorithm>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int  n, p;
	int rank = 1;
	long newGrade;
	long* rankList;

	cin >> n >> newGrade >> p;
	rankList = new long[p];

	for (int i = 0; i < p; i++) {
		if (i < n) {
			cin >> rankList[i];
		}
		else {
			rankList[i] = -1;
		}
	}

	bool exitFlag = false;
	for (int i = 0; i < p; i++) {
		if (rankList[i] < newGrade) {
			exitFlag = true;
			break;
		}
		else if (rankList[i] == newGrade) {
			if (rankList[p - 1] != newGrade) {
				exitFlag = true;
				break;
			}
		}
		else {
			rank++;
		}
	}

	if (!exitFlag) {
		rank = -1;
	}

	cout << rank << endl;
}