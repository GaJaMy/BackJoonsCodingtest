#include <vector>
#include <iostream>
#include <string>
#include <algorithm>
#include <functional>
#include <map>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	
	int N;
	cin >> N;

	vector<vector<int>> triangle(N, vector<int>(N, 0));

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < i + 1; j++)
		{
			cin >> triangle[i][j];
		}
	}

	for (int i = 1; i < N; i++)
	{
		for (int j = 0; j < i + 1;j++)
		{
			int left;
			if (j - 1 > 0)
				left = triangle[i - 1][j - 1] + triangle[i][j];
			else
				left = triangle[i - 1][0] + triangle[i][j];

			int right = triangle[i - 1][j] + triangle[i][j];
			triangle[i][j] = left > right ? left : right;
		}
	}
	
	cout << *max_element(triangle[N - 1].begin(), triangle[N - 1].end()) << "\n";
	return 0;
}
