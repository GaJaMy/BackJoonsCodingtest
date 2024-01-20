#include <string>
#include <vector>
#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int BFS(vector<vector<int>> matrix, vector<bool> visit,int N,int M)
{
	int rlt = 0;
	
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			if (matrix[i][j] == 1)
			{
				queue<pair<int, int>> q;

				q.push({ i,j });
				rlt++;
				while (!q.empty())
				{
					pair<int, int> q_coor = q.front();
					q.pop();

					if (!visit[q_coor.first * M + q_coor.second])
					{
						matrix[q_coor.first][q_coor.second] = -1;
					
						if (q_coor.first - 1 >= 0)
						{
							if (matrix[q_coor.first - 1][q_coor.second] == 1)
							{
								q.push({ q_coor.first - 1 ,q_coor.second });
							}
						}

						if (q_coor.second - 1 >= 0)
						{
							if (matrix[q_coor.first][q_coor.second - 1] == 1)
							{
								q.push({ q_coor.first,q_coor.second - 1 });
							}
						}

						if (q_coor.first + 1 < N)
						{
							if (matrix[q_coor.first + 1][q_coor.second] == 1)
							{
								q.push({ q_coor.first + 1,q_coor.second });
							}
						}

						if (q_coor.second + 1 < M)
						{
							if (matrix[q_coor.first][q_coor.second + 1] == 1)
							{
								q.push({ q_coor.first,q_coor.second + 1 });
							}
						}

						visit[q_coor.first * M + q_coor.second] = true;
					}

				}
			}
		}
	}
	return rlt;
}

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);


	int T;
	int M, N, NUM;
	cin >> T;

	vector<int> result;
	for (int i = 0; i < T; i++)
	{
		cin >> M >> N >> NUM;
		vector<vector<int>> matrix(N, vector<int>(M, 0));
		vector<bool> visit(M*N, false);

		for (int i = 0; i < NUM; i++)
		{
			int a, b;
			cin >> a >> b;
			matrix[b][a] = 1;
		}
		result.push_back(BFS(matrix, visit, N, M));
	}

	for (int i = 0; i < result.size(); i++)
	{
		cout << result[i] << "\n";
	}
	
	return 0;
}
