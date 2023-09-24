#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct team_goal {
	int goal;
	int second;
	int result;
	int victory; // 이기고 있는지 판단
};

int main(void)
{
	int goal_count;
	int team;
	char time[6];

	struct team_goal team1;
	struct team_goal team2;
	team1.goal = 0;
	team1.second = 0;
	team1.result = 0;
	team1.victory = 0;
	team2.goal = 0;
	team2.second = 0;
	team2.result = 0;
	team2.victory = 0;

  	scanf("%d", &goal_count);
	char min[3];
	char sec[3];
	min[2] = '\0';
	sec[2] = '\0';
	for (int i = 0; i < goal_count; i++)
	{
		scanf("%d", &team);
		scanf("%s", time);
		min[0] = time[0];
		min[1] = time[1];
		sec[0] = time[3];
		sec[1] = time[4];
		if (team == 1)
		{
			team1.goal++;
			if (team1.goal > team2.goal)
			{
				if (team1.victory == 0)
					team1.second = atoi(min) * 60 + atoi(sec); // 이기기 시작한 시점 고르기
				team1.victory = 1;
			}
			else if (team1.goal == team2.goal) // 동점이 됨, 원래는 2가 이기고 있었음
			{
				team2.result += ((atoi(min) * 60 + atoi(sec)) - team2.second);
				team2.victory = 0;
			}
		}
		else if (team == 2)
		{
			team2.goal++;
			if (team1.goal < team2.goal)
			{
				if (team2.victory == 0)
					team2.second = atoi(min) * 60 + atoi(sec);
				team2.victory = 1;
			}
			else if (team1.goal == team2.goal) // 원래 1이 이기고 있던 상황
			{
				team1.result += ((atoi(min) * 60 + atoi(sec))- team1.second);
				team1.victory = 0;
			}
		}
	}
	if (team1.goal < team2.goal)
		team2.result += 60 * 48 - (team2.second);
	else if (team1.goal > team2.goal)
		team1.result += 60 * 48 - team1.second;
	printf("%d", team1.result/60/10);
	printf("%d", team1.result/60%10);
	printf("%s", ":");
	printf("%d", team1.result%60/10);
        printf("%d\n", (team1.result%60)%10);

	printf("%d", team2.result/60/10);
        printf("%d", team2.result/60%10);
        printf("%s", ":");
        printf("%d", team2.result%60/10);
        printf("%d\n", (team2.result%60)%10);
}

