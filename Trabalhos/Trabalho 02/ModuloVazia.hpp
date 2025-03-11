#pragma once
#include <string>
#include "Modulo.hpp"

using namespace std;

class ModuloVazia : public Modulo
{
public:
    ModuloVazia(char tipo);
    bool podeAcessar();
};