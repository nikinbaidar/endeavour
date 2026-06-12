#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Client Client;

struct Client{
    char name[256];
};

int main() {

    static const char *cannotfocus[] = {
        "Display Message",
        "Some other window name",
        "dwm",
    };

    Client *c = malloc(sizeof(Client));

    strcpy(c->name, "notdwm");

    for (int i = 0; i < (sizeof(cannotfocus) / sizeof(cannotfocus[0])) ; i++) {
        if (!strcmp(c->name, cannotfocus[i])) {
            free(c);
            printf("Match\n");
            return 0;
        }
    }
    free(c);

    printf("No match\n");
    return 0;

}
