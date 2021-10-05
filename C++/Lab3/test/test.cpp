// tests.cpp
#include "../src/MathFunctions.hpp"
#include "../src/MathFunctions.cpp"
#include <gtest/gtest.h>
 
TEST(GreatestCommonFactorTest, PositineNumbers) { 
    Dual *dual = NULL;

    dual = new Dual{34, 51};
    ASSERT_EQ(17, MathFunctions::greatestCommonFactor(*dual));
    free(dual);

    dual = new Dual{39, 7};
    ASSERT_EQ(1, MathFunctions::greatestCommonFactor(*dual));
    free(dual);

    dual = new Dual{12, 36};
    ASSERT_EQ(12, MathFunctions::greatestCommonFactor(*dual));
    free(dual);

    dual = new Dual{51, 34};
    ASSERT_EQ(17, MathFunctions::greatestCommonFactor(*dual));
    free(dual);

    dual = new Dual{7, 39};
    ASSERT_EQ(1, MathFunctions::greatestCommonFactor(*dual));
    free(dual);

    dual = new Dual{36, 12};
    ASSERT_EQ(12, MathFunctions::greatestCommonFactor(*dual));
    free(dual);
}

TEST(GreatestCommonFactorTest, NegativeNumbers) { 
    Dual *dual = NULL;
    dual = new Dual{-34, -51};
    ASSERT_ANY_THROW(MathFunctions::greatestCommonFactor(*dual));
    free(dual);
}

TEST(CreateNumberTest, PositiveNumbers) {
    ASSERT_EQ(1357, MathFunctions::createNumber(12345678));
    ASSERT_EQ(2468, MathFunctions::createNumber(123456789));
}

TEST(CreateNumberTest, NegativeNumbers) {
    ASSERT_EQ(1357, MathFunctions::createNumber(-12345678));
    ASSERT_EQ(2468, MathFunctions::createNumber(-123456789));
}

TEST(CreateNumberTest, NoEvenDigits) {
    ASSERT_ANY_THROW(MathFunctions::createNumber(8));
    ASSERT_ANY_THROW(MathFunctions::createNumber(-8));
}

TEST(SumMatrixTest, PositiveNumbers) {
    int rows = 3;
    int columns = 5;

    float *array = (float *)calloc(rows * columns, sizeof(float));

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            *(array + i * columns + j) = i * columns + 0.125*j;
        }
    }    

    ASSERT_EQ(22.125, MathFunctions::sumMatrix(array, 3, 5));
    ASSERT_EQ(0.375, MathFunctions::sumMatrix(array, 5, 3));
    ASSERT_EQ(0.375, MathFunctions::sumMatrix(array, 3, 3));
}

TEST(SumMatrixTest, NegativeNumbers) {
    int rows = 3;
    int columns = 5;

    float *array = (float *)calloc(rows * columns, sizeof(float));

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            *(array + i * columns + j) = (-1) * (i * columns + 0.125*j);
        }
    }    

    ASSERT_EQ(-22.125, MathFunctions::sumMatrix(array, 3, 5));
    ASSERT_EQ(-0.375, MathFunctions::sumMatrix(array, 5, 3));
    ASSERT_EQ(-0.375, MathFunctions::sumMatrix(array, 3, 3));
}

TEST(SumMatrixTest, ExeptionsTest) {
    int rows = 3;
    int columns = 5;

    float *array = (float *)calloc(rows * columns, sizeof(float));

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            *(array + i * columns + j) = (-1) * (i * columns + 0.125*j);
        }
    }  

    ASSERT_ANY_THROW(MathFunctions::sumMatrix(array, -5, 3));
    ASSERT_ANY_THROW(MathFunctions::sumMatrix(array, 5, -3));
    ASSERT_ANY_THROW(MathFunctions::sumMatrix(array, -5, -3));
    ASSERT_ANY_THROW(MathFunctions::sumMatrix(array, 0, 3));
    ASSERT_ANY_THROW(MathFunctions::sumMatrix(array, 5, 0));
    ASSERT_ANY_THROW(MathFunctions::sumMatrix(array, 0, 0));
}

TEST(SortTripleTest, PositiveNumbers) {
    Triple *triple;

    triple = new Triple{1, 2, 3};
    MathFunctions::sortTriple(triple);
    ASSERT_TRUE(triple->x >= triple->y && triple->y >= triple->z);
    free(triple);

    triple = new Triple{1, 3, 2};
    MathFunctions::sortTriple(triple);
    ASSERT_TRUE(triple->x >= triple->y && triple->y >= triple->z);
    free(triple);

    triple = new Triple{3, 1, 2};
    MathFunctions::sortTriple(triple);
    ASSERT_TRUE(triple->x >= triple->y && triple->y >= triple->z);
    free(triple);

    triple = new Triple{2, 1, 3};
    MathFunctions::sortTriple(triple);
    ASSERT_TRUE(triple->x >= triple->y && triple->y >= triple->z);
    free(triple);

    triple = new Triple{2, 3, 1};
    MathFunctions::sortTriple(triple);
    ASSERT_TRUE(triple->x >= triple->y && triple->y >= triple->z);
    free(triple);

    triple = new Triple{3, 2, 1};
    MathFunctions::sortTriple(triple);
    ASSERT_TRUE(triple->x >= triple->y && triple->y >= triple->z);
    free(triple);

    triple = new Triple{1, 1, 1};
    MathFunctions::sortTriple(triple);
    ASSERT_TRUE(triple->x >= triple->y && triple->y >= triple->z);
    free(triple);

    triple = new Triple{2, 1, 1};
    MathFunctions::sortTriple(triple);
    ASSERT_TRUE(triple->x >= triple->y && triple->y >= triple->z);
    free(triple);

    triple = new Triple{1, 2, 1};
    MathFunctions::sortTriple(triple);
    ASSERT_TRUE(triple->x >= triple->y && triple->y >= triple->z);
    free(triple);    

    triple = new Triple{1, 1, 2};
    MathFunctions::sortTriple(triple);
    ASSERT_TRUE(triple->x >= triple->y && triple->y >= triple->z);
    free(triple);
}

TEST(SortTripleTest, NegativeNumbers) {
    Triple *triple;

    triple = new Triple{-1, -2, -3};
    MathFunctions::sortTriple(triple);
    ASSERT_TRUE(triple->x >= triple->y && triple->y >= triple->z);
    free(triple);

    triple = new Triple{-1, -3, -2};
    MathFunctions::sortTriple(triple);
    ASSERT_TRUE(triple->x >= triple->y && triple->y >= triple->z);
    free(triple);

    triple = new Triple{-3, -1, -2};
    MathFunctions::sortTriple(triple);
    ASSERT_TRUE(triple->x >= triple->y && triple->y >= triple->z);
    free(triple);

    triple = new Triple{-2, -1, -3};
    MathFunctions::sortTriple(triple);
    ASSERT_TRUE(triple->x >= triple->y && triple->y >= triple->z);
    free(triple);

    triple = new Triple{-2, -3, -1};
    MathFunctions::sortTriple(triple);
    ASSERT_TRUE(triple->x >= triple->y && triple->y >= triple->z);
    free(triple);

    triple = new Triple{-3, -2, -1};
    MathFunctions::sortTriple(triple);
    ASSERT_TRUE(triple->x >= triple->y && triple->y >= triple->z);
    free(triple);

    triple = new Triple{-1, -1, -1};
    MathFunctions::sortTriple(triple);
    ASSERT_TRUE(triple->x >= triple->y && triple->y >= triple->z);
    free(triple);

    triple = new Triple{-2, -1, -1};
    MathFunctions::sortTriple(triple);
    ASSERT_TRUE(triple->x >= triple->y && triple->y >= triple->z);
    free(triple);

    triple = new Triple{-1, -2, -1};
    MathFunctions::sortTriple(triple);
    ASSERT_TRUE(triple->x >= triple->y && triple->y >= triple->z);
    free(triple);    

    triple = new Triple{-1, -1, -2};
    MathFunctions::sortTriple(triple);
    ASSERT_TRUE(triple->x >= triple->y && triple->y >= triple->z);
    free(triple);
}

TEST(SortTripleTest, NullPointer) {
    Triple *triple = NULL;
    ASSERT_ANY_THROW(MathFunctions::sortTriple(triple));
} 

int main(int argc, char **argv) {
    testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}