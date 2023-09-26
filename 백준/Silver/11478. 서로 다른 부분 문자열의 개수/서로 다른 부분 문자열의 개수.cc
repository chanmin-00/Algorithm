#include <iostream>
#include <set>

using namespace std;

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	string str;
	cin >> str;
	int len = str.length();
	set<string> str_set;
	string sub_str;

	for (int i = 0; i <len; i++)
	{
		for (int j = 1; j <= len; j++)
		{
			sub_str = str.substr(i, j);
			str_set.insert(sub_str);
		}
	}
	cout << str_set.size() << endl;
	return 0;;
}
