#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void print_properties()
{
    time_t timer;
    struct tm *local;

    /* 現在時刻を取得 */
    timer = time(NULL);
    local = localtime(&timer); /* 地方時に変換 */

    printf("=====================================================================================\n");
    printf("%-10s: %4d/%02d/%02d %02d:%02d:%02d\n",
            "Date",
            local->tm_year + 1900,
            local->tm_mon + 1,
            local->tm_mday,
            local->tm_hour,
            local->tm_min,
            local->tm_sec);
    printf("%-10s: %s\n", "Language", "C");
    printf("=====================================================================================\n");
}
