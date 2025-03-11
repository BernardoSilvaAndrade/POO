#pragma once
#include <string>
#include "Modulo.hpp"

using namespace std;

class ModuloComAstronauta : public Modulo
{
public:
    ModuloComAstronauta(char tipo);
    bool podeAcessar();
};