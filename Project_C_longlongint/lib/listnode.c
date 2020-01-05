#include <stdlib.h>
#include "../include/listnode.h"

ArrayList* ArrayList_New()
{
    ArrayList* arr = (ArrayList *)malloc(sizeof(ArrayList));
    arr->root = (ListNode *)malloc(sizeof(ListNode));
    arr->endnode = arr->root;
    arr->length = 0;

    return arr;
}

void ArrayList_Add(ArrayList* arr, long long int val)
{
    arr->endnode->val = val;
    arr->endnode->next = (ListNode *)malloc(sizeof(ListNode));
    arr->endnode = arr->endnode->next;
    arr->length++;
}

long long int ArrayList_Get(ArrayList* arr, int index)
{
    ListNode* head = arr->root;

    for (int i = 0; i < index; i++) {
        if (head->next == NULL) {
            return 0;
        }

        head = head->next;
    }

    return head->val;
}
