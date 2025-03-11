#include "Cliente.hpp"
using namespace std;

Cliente::Cliente() : nome(""), CPF("") {}

Cliente::Cliente(string& nome,string& CPF) : nome(nome), CPF(CPF) {}

string Cliente::getNome() {
    return nome;
}

string Cliente::getCPF() {
    return CPF;
}

void Cliente::setNome(string& nome) {
    this->nome = nome;
}

void Cliente::setCPF(string& CPF) {
    this->CPF = CPF;
}

void Cliente::adicionaCompra(Produto& produto) {
    compras.push_back(produto);
}

double Cliente::calculaTotal() {
    double total = 0.0;
    for (const auto& produto : compras) {
        total += produto.getPreco();
    }
    return total;
}

string Cliente::getDetalhes() {
    stringstream detalhes;
    detalhes << "Nome: " << nome << "\nCPF: " << CPF << "\nCompras:\n";
    for (const auto& produto : compras) {
        detalhes << produto.getDetalhes() << "\n";
    }
    detalhes << "Total: R$ " << calculaTotal();
    return detalhes.str();
}
