#pragma once
#include <string>
#include "Modulo.hpp"

using namespace std;

class ModuloSeguranca : public Modulo
{
public:
    ModuloSeguranca(char tipo);
    bool podeAcessar() override;
};