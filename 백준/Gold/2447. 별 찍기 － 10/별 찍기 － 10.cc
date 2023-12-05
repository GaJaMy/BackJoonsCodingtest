#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <math.h>
using namespace std;

void star(int i, int j, int n,vector<vector<char>> &arr)
{
	if ((i/n) % 3 == 1 && (j/n) % 3 == 1)
		arr[i][j] = ' ';
	else
	{
		if (n / 3 == 0)
			return;

		star(i, j, n / 3,arr);
	}

}

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n;
	cin >> n;
	
	vector<vector<char>> arr(n, vector<char>(n, '*'));

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			star(i, j,n,arr);
		}
	}


	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cout << arr[i][j];
		}
		cout << "\n";
	}
	return 0;
}
