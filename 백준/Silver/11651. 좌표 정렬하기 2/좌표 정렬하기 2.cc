#include <vector>
#include <iostream>
#include <string>
#include <algorithm>
#include <functional>
using namespace std;

bool compair(pair<int, int> &a, pair<int, int> &b)
{
	if (a.second == b.second)
		return a.first < b.first;
	else
		return a.second < b.second;
}

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int N;
	vector<pair<int, int>> coor;

	cin >> N;

	for (int i = 0; i < N; i++)
	{
		int x,y;
		cin >> x;
		cin >> y;
		coor.push_back({ x,y });
	}

	sort(coor.begin(), coor.end(), compair);

	for (int i = 0; i < N; i++)
	{
		cout << coor[i].first << " " << coor[i].second << "\n";
	}
		
	return 0;
}
