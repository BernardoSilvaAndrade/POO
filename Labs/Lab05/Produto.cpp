#include "Produto.hpp"
using namespace std;

Produto::Produto() : nome(""), preco(0.0) {}

Produto::Produto(std::string& nome, double preco) : nome(nome), preco(preco) {}

double Produto::getPreco() const {
    return preco;
}

string Produto::getNome(){
    return nome;
}

void Produto::setNome(string nome) {
    this->nome = nome;
}

void Produto::setPreco(double preco) {
    this->preco = preco;
}

string Produto::getDetalhes() const{
    return "Produto: " + nome + ", Preço: R$ " + to_string(preco);
}
