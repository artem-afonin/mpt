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

    if (triple->x < triple->y) {
        if (triple->z > triple->y) {
            swap(&triple->z, &triple->x);
        } else if (triple->z < triple->x) {
            swap(&triple->x, &triple->y);
        } else {
            swap(&triple->y, &triple->z);
            swap(&triple->z, &triple->x);
        }
    } else {
        if (triple->z > triple->x) {
            swap(&triple->z, &triple->x);
            swap(&triple->y, &triple->z);
        } else if (triple->z > triple->y) {
            swap(&triple->z, &triple->y);
        }
    }
}

int MathFunctions::greatestCommonFactor(Dual dual) {
    if (0 >= dual.x || 0 >= dual.y) {
        throw std::runtime_error("input number is negative");
    }

    int temp = 0;

    if (dual.x > dual.y) {
        swap(&dual.x, &dual.y);
    }
    while (0 != dual.y) {
        temp = dual.x % dual.y;
        dual.x = dual.y;
        dual.y = temp;
    }

    return dual.x;
}

int MathFunctions::createNumber(int a) {
    if (0 == a / 10) {
        throw std::runtime_error("no even digits");
    }

    int digit = 0;
    int b = 0;
    for (int i = 0;;i+=2) {
        digit = a % 100 / 10;
        b += digit * pow(10, i/2);
        a /= 100;
        if (0 == a)
        {
            break;
        }
    }

    if (0 > b) {
        b *= -1;
    }
    return b;
}

float MathFunctions::sumMatrix(float *array, int rows, int columns) {
    if (nullptr == array) {
        throw std::runtime_error("array is null");
    }
    
    if (0 >= rows || 0 >= columns) {
        throw std::runtime_error("wrong parameters");
    }
    
    float sum = 0;

    for (int i = 0; i < rows; i++) {
        for (int j = i + 1; j < columns; j++) {
            if ((int)(*(array + i * columns + j)) % 2 == 0) {
                sum += *(array + i * columns + j);
            }
        }
    }

    return sum;
}
