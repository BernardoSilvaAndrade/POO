#include "Autor.hpp"

Autor::Autor(string n, string dN) : nome(n), dataNascimento(dN) {}

Autor::Autor() {}

string Autor::getNome()
{
    return nome;
}

void Autor::setNome(string n)
{
    this->nome = n;
}

string Autor::getdataNascimento()
{
    return dataNascimento;
}

void Autor::setdataNascimento(string dN)
{
    this->dataNascimento = dN;
}
