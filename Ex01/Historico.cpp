#include "Historico.hpp"

void Historico::adicionarSite(const string &site)
{
    pilha.push(site);
}

void Historico::removerSite()
{
    if (!pilha.empty())
    {
        cout << "Removendo:" << pilha.top() << endl;
        pilha.pop();
    }
    else
    {
        cout << "Historico vazia!" << endl;
    }
}

void Historico::exibirHistorico() const
{
    stack<string> temp = pilha;
    cout << "Historico de navegacao: " << endl;
    while (!temp.empty())
    {
        cout << temp.top() << endl;
        temp.pop();
    }
}

bool Historico::estaVazio() const
{
    return pilha.empty();
}

void Historico::visualizarTopo() const
{
    if (!pilha.empty())
    {
        std::cout << "Topo: " << pilha.top() << std::endl;
    }
    else
    {
        std::cout << "Historico vazio!" << std::endl;
    }
}