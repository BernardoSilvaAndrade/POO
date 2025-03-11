#include "ModuloVazia.hpp"

ModuloVazia::ModuloVazia(char tipo) : Modulo(tipo) {}

bool ModuloVazia::podeAcessar()
{
    return false;
}