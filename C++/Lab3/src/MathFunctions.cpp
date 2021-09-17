#include <stdexcept>

#include "MathFunctions.hpp"

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void MathFunctions::sortTriple(Triple *triple) {
    if (nullptr == triple) {
        throw std::runtime_error("triple is null");
    }

    int temp = 0;
    if (triple->y >= triple->x) {
        if (triple->z > triple->y) {
            // swap z and x
            swap(&triple->z, &triple->x);
        } else if (triple->z < triple->x) {
            // swap y and x
            swap(&triple->y, &triple->x);
        } else {
            // swap z and x, then swap y and x
            swap(&triple->z, &triple->x);
            swap(&triple->y, &triple->x);
        }
    } else {
        if (triple->z > triple->x) {
            // swap z and x, then swap y and z
            swap(&triple->z, &triple->x);
            swap(&triple->y, &triple->z);
        } else if (triple->y < triple->z) {
            // swap NOTHING
        } else {
            // swap z and y
//            swap(&triple->z, &triple->y);
//            swap(&triple->x, &triple->z);
        }
    }
}
