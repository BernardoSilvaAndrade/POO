#include "ModuloSeguranca.hpp"
#include <iostream>
ModuloSeguranca::ModuloSeguranca(char tipo) : Modulo(tipo)
{
}

bool ModuloSeguranca::podeAcessar()
{
    return true;
}