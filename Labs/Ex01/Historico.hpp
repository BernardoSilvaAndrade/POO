#ifndef HISTORICO_H
#define HISTORICO_H

#include <iostream>
#include <stack>
#include <string>

using namespace std;

class Historico
{
private:
    stack<string> pilha;

public:
    void adicionarSite(const string &site);
    void removerSite();
    void exibirHistorico() const;
    bool estaVazio() const;
    void visualizarTopo() const;
};

#endif
