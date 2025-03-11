#ifndef ELETRONICO_HPP
#define ELETRONICO_HPP
#include "Produto.hpp"

class Eletronico : public Produto {
private:
    int garantia; // Garantia em anos

public:
    Eletronico();
    Eletronico(std::string& nome, double preco, int garantia);

    int getGarantia() ;
    void setGarantia(int garantia);

    std::string getDetalhes() const override;
};

#endif