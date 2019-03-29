#include "cpplib.h"


void hello() {
}


void executeMe(const main_struct_t* main) {
  for (int i = 0; i < 100; i++) {
    main->function(main, 42);
  }
}



void doSomethingWith(value_struct_t* c) {
  c->v *= 100;
}

void doSomethingConst(const value_struct_t* c) {
  //NOP
}


void functionWithCallback( sub_struct_t (*foo)(int x) ) {
  foo(42);
}

