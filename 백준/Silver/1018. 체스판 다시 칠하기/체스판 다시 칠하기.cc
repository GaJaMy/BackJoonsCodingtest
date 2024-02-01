#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int M, N;
	cin >> M >> N;
	vector<string> input(M);
	char src1[8][8]{
		'B','W','B','W','B','W','B','W',
		'W','B','W','B','W','B','W','B',
		'B','W','B','W','B','W','B','W',
		'W','B','W','B','W','B','W','B',
		'B','W','B','W','B','W','B','W',
		'W','B','W','B','W','B','W','B',
		'B','W','B','W','B','W','B','W',
		'W','B','W','B','W','B','W','B'
	};

	char src2[8][8]{
		'W','B','W','B','W','B','W','B',
		'B','W','B','W','B','W','B','W',
		'W','B','W','B','W','B','W','B',
		'B','W','B','W','B','W','B','W',
		'W','B','W','B','W','B','W','B',
		'B','W','B','W','B','W','B','W',
		'W','B','W','B','W','B','W','B',
		'B','W','B','W','B','W','B','W'
	};
	
	for (int i = 0; i < M; i++)
	{
		for (int j = 0; j < N; j++)
		{
			char val;
			cin >> val;
			input[i].push_back(val);
		}
	}

	vector<int> c_arr;
	for (int i = 0; i <= M-8; i++)
	{
		for (int j = 0; j <= N-8; j++)
		{
			int c1 = 0;
			int c2 = 0;

			for (int p = 0; p < 8; p++)
			{
				for (int q = 0; q < 8; q++)
				{
					if (input[i + p][j + q] != src1[p][q])
					{
						c1++;
					}

					if (input[i + p][j + q] != src2[p][q])
					{
						c2++;
					}

				}
			}
			c_arr.push_back(c1);
			c_arr.push_back(c2);
		}
	}

	cout << *min_element(c_arr.begin(), c_arr.end())<<"\n";

	return 0;
}
