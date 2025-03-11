#include "Eletronico.hpp"
using namespace std;

Eletronico::Eletronico() : Produto(), garantia(0) {}

Eletronico::Eletronico(string& nome, double preco, int garantia) : Produto(nome, preco), garantia(garantia) {}

int Eletronico::getGarantia() {
    return garantia;
}

void Eletronico::setGarantia(int garantia) {
    this->garantia = garantia;
}

string Eletronico::getDetalhes() const {
    return Produto::getDetalhes() + ", Garantia: " + to_string(garantia) + " anos";
}