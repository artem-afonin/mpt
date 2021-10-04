cmake_minimum_required(VERSION 3.16)
project(Lab3)

set(CMAKE_CXX_STANDARD 11)

add_executable(Lab3 src/main.cpp src/MathFunctions.cpp src/MathFunctions.hpp)

find_package(GTest REQUIRED)
include_directories(${GTEST_INCLUDE_DIRS})
 
add_executable(runTests test/test.cpp)
target_link_libraries(runTests ${GTEST_LIBRARIES} pthread)