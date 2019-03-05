#ifndef _CPPLIB_H_
#define _CPPLIB_H_

extern "C" {

  void hello();

  typedef struct _sub_struct {
    int v;
  } sub_struct_t;

  typedef struct _main_struct {
    sub_struct_t* (*function)(const struct _main_struct* main, int x);
  } main_struct_t;


  void executeMe(const main_struct_t* main);

}

#endif