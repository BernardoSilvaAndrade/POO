#pragma once
#include "Modulo.hpp"
#include <string>

using namespace std;

class ModuloNormal : public Modulo
{
public:
    ModuloNormal(char tipo);
    bool podeAcessar();
};