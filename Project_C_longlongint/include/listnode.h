struct ListNode {
    long long int val;
    struct ListNode* next;
};

typedef struct ListNode ListNode;

struct ArrayList {
    ListNode* root;
    ListNode* endnode;
    int length;
};

typedef struct ArrayList ArrayList;

ArrayList* ArrayList_New();
void ArrayList_Add(ArrayList* arr, long long int val);
long long int ArrayList_Get(ArrayList* arr, int index);
