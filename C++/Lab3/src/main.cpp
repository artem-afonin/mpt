#include <iostream>

#include "MathFunctions.hpp"

int main() {
    int i = 1;
    Triple *triple;

    triple = new Triple{1, 1, 1};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{1, 1, 2};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{1, 1, 3};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{1, 2, 1};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{1, 2, 2};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{1, 2, 3};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{1, 3, 1};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{1, 3, 2};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{1, 3, 3};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{2, 1, 1};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{2, 1, 2};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{2, 1, 3};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{2, 2, 1};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{2, 2, 2};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{2, 2, 3};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{2, 3, 1};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{2, 3, 2};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{2, 3, 3};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{3, 1, 1};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{3, 1, 2};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{3, 1, 3};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{3, 2, 1};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{3, 2, 2};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{3, 2, 3};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{3, 3, 1};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{3, 3, 2};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    triple = new Triple{3, 3, 3};
    MathFunctions::sortTriple(triple);
    std::cout << i++ << " x: " << triple->x << " y: " << triple->y << " z: " << triple->z << std::endl;

    return 0;
}
