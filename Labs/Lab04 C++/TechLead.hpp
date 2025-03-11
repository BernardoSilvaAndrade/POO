#ifndef TECHLEAD_HPP
#define TECHLEAD_HPP

#include "Gerente.hpp"
#include "Desenvolvedor.hpp"

class TechLead : public Gerente, public Desenvolvedor
{
private:
    int projetos_em_andamento;

public:
    TechLead(const std::string &nome, int salario_base, int numero_equipes, const std::string &linguagem_principal, int projetos_em_andamento);

    int getProjetosEmAndamento();
    std::string descricao() override;
    ~TechLead() override = default;
};

#endif
