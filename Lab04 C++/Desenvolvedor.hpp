#ifndef DESENVOLVEDOR_HPP
#define DESENVOLVEDOR_HPP

#include "Funcionario.hpp"

class Desenvolvedor : virtual public Funcionario
{
protected:
    std::string linguagem_principal;

public:
    Desenvolvedor(const std::string &nome, int salario_base, const std::string &linguagem_principal);

    std::string getLinguagemPrincipal() const;
    virtual ~Desenvolvedor() = default;
    std::string projetos_realizados() const;
};

#endif
