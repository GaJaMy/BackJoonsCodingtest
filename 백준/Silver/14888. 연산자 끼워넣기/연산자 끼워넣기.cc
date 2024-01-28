#include <vector>
#include <iostream>
#include <string>
#include <algorithm>
#include <functional>
#include <map>
using namespace std;


void dfs(vector<long long> arr, vector<long long> &op, long long &min, long long &max, long long val, int count)
{	
	if (count == arr.size() - 1)
	{
		if (val < min)
			min = val;
		if (val > max)
			max = val;
		return;
	}

	for (int i = 0; i < op.size(); i++)
	{
		if (op[i] != 0)
		{
			if (i == 0)
			{
				val = val + arr[count + 1];
				op[i]--;
				dfs(arr, op, min, max, val, count+1);
				op[i]++;
				val = val - arr[count + 1];
			}
			else if (i == 1)
			{
				val = val - arr[count + 1];
				op[i]--;
				dfs(arr, op, min, max, val, count+1);
				op[i]++;
				val = val + arr[count + 1];
			}
			else if (i == 2)
			{
				val = val*arr[count + 1];
				op[i]--;
				dfs(arr, op, min, max, val, count+1);
				op[i]++;
				val = val / arr[count + 1];
			}
			else if (i == 3)
			{
				if (val < 0)
					val = -(abs(val) / (double)(arr[count + 1]));
				else
					val = val / (double)(arr[count + 1]);
				op[i]--;
				dfs(arr, op, min, max, val, count+1);
				op[i]++;
				val = val*arr[count + 1];
			}
		}
	}
}

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int N;
	cin >> N;

	vector<long long> arr(N,0);
	vector<long long> op(4,0);

	for (int i = 0; i < N; i++)
		cin >> arr[i];
	
	for (int i = 0; i < 4; i++)
		cin >> op[i];


	long long min = INT64_MAX;
	long long max = INT64_MIN;

	dfs(arr, op, min, max, arr[0], 0);
	cout << max << "\n" << min << "\n";
	return 0;
}
