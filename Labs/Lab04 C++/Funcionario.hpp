#ifndef FUNCIONARIO_HPP
#define FUNCIONARIO_HPP

#include <string>

class Funcionario
{
protected:
    std::string nome;
    int salario_base;

public:
    Funcionario(const std::string &nome, int salario_base);

    virtual std::string descricao() ;

    std::string getNome() const;
    int getSalario_base();

    virtual ~Funcionario() = default;
};
#endif