#ifndef LAB3_MATHFUNCTIONS_HPP
#define LAB3_MATHFUNCTIONS_HPP

#include <iostream>
#include <math.h>
typedef struct Triple {
    int x;
    int y;
    int z;
} Triple;

typedef struct Dual {
    int x;
    int y;
} Dual;

class MathFunctions {
public:
    static void sortTriple(Triple *triple);
    static int greatestCommonFactor(Dual dual); 
    static int createNumber(int a);
    static float sumMatrix(float *array, int rows, int columns);
};


#endif//LAB3_MATHFUNCTIONS_HPP
