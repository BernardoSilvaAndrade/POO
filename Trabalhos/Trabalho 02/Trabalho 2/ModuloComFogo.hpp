#pragma once
#include <string>
#include "Modulo.hpp"

using namespace std;

class ModuloComFogo : public Modulo
{
public:
    ModuloComFogo(char tipo);
    bool podeAcessar();
};