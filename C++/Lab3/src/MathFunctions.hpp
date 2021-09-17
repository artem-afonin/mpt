#ifndef LAB3_MATHFUNCTIONS_HPP
#define LAB3_MATHFUNCTIONS_HPP

#include <ostream>
typedef struct Triple {
    int x;
    int y;
    int z;
} Triple;

class MathFunctions {
public:
    static void sortTriple(Triple *triple);
};


#endif//LAB3_MATHFUNCTIONS_HPP
