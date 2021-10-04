#include <iostream>

#include "MathFunctions.hpp"

int main() {
    int i = 1;
    float answer = 0;
    int input = 0;
    Triple *triple;
    Dual *dual;

/*
    triple = new Triple{1, 1, 1};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{1, 1, 2};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{1, 1, 3};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{1, 2, 1};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{1, 2, 2};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{1, 2, 3};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{1, 3, 1};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);
    triple = new Triple{1, 3, 2};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{1, 3, 3};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{2, 1, 1};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{2, 1, 2};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);
    
    triple = new Triple{2, 1, 3};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{2, 2, 1};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{2, 2, 2};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{2, 2, 3};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{2, 3, 1};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{2, 3, 2};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{2, 3, 3};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{3, 1, 1};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{3, 1, 2};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{3, 1, 3};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{3, 2, 1};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{3, 2, 2};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{3, 2, 3};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{3, 3, 1};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{3, 3, 2};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    triple = new Triple{3, 3, 3};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;
    free(triple);

    dual = new Dual{32, 24};
    answer = MathFunctions::greatestCommonFactor(*dual);
    std::cout << "x: " << dual->x << " y: " << dual->y << " gcf: " << answer << std::endl;
    free(dual);

    dual = new Dual{49, 13};
    answer = MathFunctions::greatestCommonFactor(*dual);
    std::cout << "x: " << dual->x << " y: " << dual->y << " gcf: " << answer << std::endl;
    free(dual);

    dual = new Dual{34, 51};
    answer = MathFunctions::greatestCommonFactor(*dual);
    std::cout << "x: " << dual->x << " y: " << dual->y << " gcf: " << answer << std::endl;
    free(dual);

    input = 123456;
    answer = MathFunctions::createNumber(input);
    std::cout << "input: " << input << " answer: " << answer << std::endl;

    input = 56789;
    answer = MathFunctions::createNumber(input);
    std::cout << "input: " << input << " answer: " << answer << std::endl;

    input = -123456;
    answer = MathFunctions::createNumber(input);
    std::cout << "input: " << input << " answer: " << answer << std::endl;

    input = -56789;
    answer = MathFunctions::createNumber(input);
    std::cout << "input: " << input << " answer: " << answer << std::endl;
*/

    int rows = 3;
    int columns = 3;
    float *array = (float *)calloc(rows * columns, sizeof(float));

    for (int i = 0; i < rows; i++) {
    for (int j = 0; j < columns; j++) {
        *(array + i * columns + j) = i * columns + 0.125*j;
        std::cout << *(array + i * columns + j) << "\t";
    }
    std::cout << std::endl;
    }  

    answer = MathFunctions::sumMatrix(array, rows, columns);
    std::cout << "sum: " << answer << std::endl;

    return 0;
}
