#pragma once
#include <string>
#include "Modulo.hpp"

using namespace std;

class ModuloObstaculo : public Modulo
{
public:
    ModuloObstaculo(char tipo);
    bool podeAcessar();
};