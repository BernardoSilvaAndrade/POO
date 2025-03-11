#include "RoboDeResgate.hpp"
using namespace std;

RoboDeResgate::RoboDeResgate(int posicaoInicialX, int posicaoInicialY, EstacaoEspacial estacao) : posicaoInicialX(posicaoInicialX), posicaoInicialY(posicaoInicialY), estacao(estacao) {}

void RoboDeResgate::iniciarResgate()
{
    int destinoX = estacao.getLinhas();
    int destinoY = estacao.getColunas();

    while (posicaoInicialX != destinoX || posicaoInicialY != destinoY)
    {
        if (posicaoInicialX < destinoX)
            posicaoInicialX++;
        else if (posicaoInicialX > destinoX)
            posicaoInicialX--;

        if (posicaoInicialY < destinoY)
            posicaoInicialY++;
        else if (posicaoInicialY > destinoY)
            posicaoInicialY--;
    }
}

void RoboDeResgate::calcularDistancia(int x, int y)
{
    int distanciaX = abs(posicaoInicialX - x);
    int distanciaY = abs(posicaoInicialY - y);
    int distanciaTotal = distanciaX + distanciaY;
    cout << "Distância até o ponto (" << x << ", " << y << "): " << distanciaTotal << endl;
}

bool RoboDeResgate::proximoAoFogo(int x, int y)
{
    int distanciaX = abs(posicaoInicialX - x);
    int distanciaY = abs(posicaoInicialY - y);
    int distanciaTotal = distanciaX + distanciaY;
    return distanciaTotal <= 1;
}

void RoboDeResgate::resgatarAstronauta(Astronauta astronauta, int x, int y)
{
    if (proximoAoFogo(x, y))
    {
        cout << "Resgatando astronauta " << astronauta.getNome() << " na posição (" << x << ", " << y << ")" << endl;
    }
    else
    {
        cout << "Astronauta " << astronauta.getNome() << " não está próximo ao fogo na posição (" << x << ", " << y << ")" << endl;
    }
}

bool RoboDeResgate::foiResgatado(const Astronauta &astro) const
{
    for (const auto &resgatado : resgatados)
    {
        if (resgatado.getNome() == astro.getNome())
        {
            return true;
        }
    }
    return false;
}

void RoboDeResgate::gerarRelatorio(ofstream &saida, const vector<Astronauta> &resgatados,
                                   const vector<Astronauta> &naoResgatados, int passos)
{
    saida << "\nRelatório de Resgate:\n";
    saida << "- Número de astronautas resgatados: " << resgatados.size() << "\n\n";

    for (const auto &astronauta : resgatados)
    {
        saida << "- " << astronauta.getNome() << ": Saúde " << astronauta.getNivelSaude()
              << ", Atendimento Médico Urgente: " << (astronauta.isAtendimentoUrgente() ? "Sim" : "Não")
              << ", Posição: (" << astronauta.getX() << ", " << astronauta.getY() << ")\n";
    }

    if (!naoResgatados.empty())
    {
        saida << "\n- Lista de astronautas não resgatados:\n";
        for (const auto &astronauta : naoResgatados)
        {
            saida << "- " << astronauta.getNome() << ": Saúde " << astronauta.getNivelSaude()
                  << ", Atendimento Médico Urgente: " << (astronauta.isAtendimentoUrgente() ? "Sim" : "Não")
                  << ", Posição: (" << astronauta.getX() << ", " << astronauta.getY() << ")\n";
        }
    }

    saida << "\n- Tempo total da operação de resgate: " << passos << " passos\n";
}

vector<vector<bool>> RoboDeResgate::getVisitado() const
{
    return visitado;
}
