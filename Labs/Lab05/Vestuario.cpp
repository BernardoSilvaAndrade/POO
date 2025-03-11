#include "Vestuario.hpp"
using namespace std;

Vestuario::Vestuario() : Produto(), tamanho("") {}

Vestuario::Vestuario( std::string& nome, double preco, std::string& tamanho) : Produto(nome, preco), tamanho(tamanho) {}

string Vestuario::getTamanho(){
    return tamanho;
}

void Vestuario::setTamanho( string& tamanho) {
    this->tamanho = tamanho;
}

string Vestuario::getDetalhes() const{
    return Produto::getDetalhes() + ", Tamanho: " + tamanho;
}