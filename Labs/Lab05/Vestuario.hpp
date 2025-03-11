#ifndef VESTUARIO_HPP
#define VESTUARIO_HPP
#include "Produto.hpp"

class Vestuario : public Produto {
private:
    std::string tamanho;

public:
    Vestuario();
    Vestuario(std::string& nome, double preco, std::string& tamanho);

    std::string getTamanho() ;
    void setTamanho( std::string& tamanho);

    std::string getDetalhes() const override;
};
#endif