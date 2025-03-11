#pragma once
#include "Astronauta.hpp"
#include "EstacaoEspacial.hpp"
#include <vector>
#include <string>
#include <fstream>
#include <iostream>
#include <list>

using namespace std;

class RoboDeResgate
{
private:
    int posicaoInicialX;
    int posicaoInicialY;
    EstacaoEspacial estacao;
    vector<Astronauta> resgatados;
    vector<Astronauta> naoResgatados;
    int passos;
    vector<vector<bool>> visitado;
    vector<vector<int>> distancia;
    vector<Astronauta> astronautas;
    vector<string> matriz;

public:
    RoboDeResgate(int posicaoInicialX, int posicaoInicialY, EstacaoEspacial estacao);

    void iniciarResgate();
    void calcularDistancia(int x, int y);
    bool proximoAoFogo(int x, int y);
    void resgatarAstronauta(Astronauta astronauta, int x, int y);
    void gerarRelatorio(ofstream &saida, const vector<Astronauta> &resgatados, const vector<Astronauta> &naoResgatados, int passos);
    void gerarRelatorio(const string &obj);
    vector<vector<bool>> getVisitado() const;
    bool foiResgatado(const Astronauta &astro) const;
};
