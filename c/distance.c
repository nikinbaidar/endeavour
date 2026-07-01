#include "mathutils.h"
#include <math.h>
#include <stdio.h>

int main() {
  struct Point *A;
  struct Point *B;

  A = makepoint(2, 4);
  B = makepoint(2, 0.54);

  printf("%0.2f\n", distance(A, B));
  printf("%0.2f\n", (0.5 * 4 * (2 * sqrt(3))));
  printf("%0.2f", (sqrt(3) * 4));

  // 3.46

  return 0;
}
