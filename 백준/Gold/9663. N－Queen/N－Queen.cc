#include <iostream>
using namespace std;

void nqueen(int idx);
bool check(int idx);

int N;
int cnt;
int board[15];


int main() {

	scanf("%d", &N);
	nqueen(0);
	printf("%d", cnt);
	
}

void nqueen(int x) {
	if (x == N) {
		cnt++;
		return;
	}

	for (int i = 0; i < N; i++) {
		board[x] = i;

		if (check(x)) nqueen(x + 1);
	}
}

bool check(int idx) {
	for (int i = 0; i < idx; i++)
		if (board[i] == board[idx] || abs(board[idx] - board[i]) == idx - i)
			return false;

	return true;
}