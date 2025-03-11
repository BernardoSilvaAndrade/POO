#ifndef PRODUTO_HPP
#define PRODUTO_HPP

#include <iostream>

using namespace std;

class Produto
{
    protected:
        string nome;
        double preco;

    public:
        Produto();
        Produto(string& nome, double preco);

        string getNome();

        double getPreco() const;

        void setNome(string nome);

        void setPreco(double preco);

        virtual std::string getDetalhes() const;
        virtual ~Produto() = default;
};
#endif