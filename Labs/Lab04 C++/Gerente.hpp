#ifndef GERENTE_HPP
#define GERENTE_HPP

#include "Funcionario.hpp"
class Gerente : virtual public Funcionario
{
protected:
    int numero_de_equipes;

public:
    Gerente(const std::string &nome, int salario_base, int numero_de_equipes);
    int getNumero_de_equipes();
    virtual ~Gerente() = default;
    int bonus() const;
};

#endif
