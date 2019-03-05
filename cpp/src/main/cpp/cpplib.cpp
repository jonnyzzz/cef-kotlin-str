#include "cpplib.h"


void hello() {
}


void executeMe(const main_struct_t* main) {
  for (int i = 0; i < 100; i++) {
    main->function(main, 42);
  }
}

