#ifndef CLIENTE_HPP
#define CLIENTE_HPP
#include <string>
#include <vector>
#include <sstream>
#include "Produto.hpp"

class Cliente {
private:
    std::string nome;
    std::string CPF;
    std::vector<Produto> compras;

public:
    Cliente();
    Cliente( std::string& nome, std::string& CPF);

    std::string getNome();
    std::string getCPF();

    void setNome(std::string& nome);
    void setCPF(std::string& CPF);

    void adicionaCompra( Produto& produto);
    double calculaTotal() ;

    std::string getDetalhes();
};

#endif