#include "Modulo.hpp"
#include <iostream>

Modulo::Modulo(char tipo) : tipo(tipo)
{
}

Modulo::Modulo()
{
}
char Modulo::getTipo()
{
    return tipo;
}
bool Modulo::podeAcessar()
{
    return true;
}