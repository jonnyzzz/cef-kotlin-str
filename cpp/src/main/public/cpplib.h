#ifndef _CPPLIB_H_
#define _CPPLIB_H_


#ifdef __cplusplus
extern "C" {
#endif


void hello();

typedef struct _sub_struct {
  int v;
} sub_struct_t;

typedef struct _main_struct {
  sub_struct_t* (*function)(const struct _main_struct* main, int x);
} main_struct_t;


typedef struct _value_struct {
  int v;
} value_struct_t;



void doSomethingWith(value_struct_t* c);
void doSomethingConst(const value_struct_t* c);

void executeMe(const main_struct_t* main);

#ifdef __cplusplus
}
#endif
#endif

