#pragma once
#include "Modulo.hpp"
#include "Astronauta.hpp"
#include <iostream>
#include <stdexcept>
#include "Modulo.hpp"
#include "Astronauta.hpp"
#include "EstacaoEspacial.hpp"
#include "ModuloNormal.hpp"
#include "ModuloObstaculo.hpp"
#include "ModuloVazia.hpp"
#include "ModuloSeguranca.hpp"
#include "ModuloComFogo.hpp"
#include "ModuloComAstronauta.hpp"
#include <vector>
#include <iostream>
#include <vector>
#include <string>
#include <list>

using namespace std;

class EstacaoEspacial
{
private:
    vector<vector<Modulo>> matriz;
    vector<Astronauta> astronautas;
    int linhas;
    int colunas;

public:
    EstacaoEspacial(const vector<vector<char>> &matriz, int linhas, int colunas, const vector<Astronauta> astronautas);

    void adicionarModulo(int linhas, int colunas, char tipo);
    void adicionarAstronauta(Astronauta astronautas);
    vector<vector<Modulo>> getMatriz();
    vector<Astronauta> getAstronautas();
    int getLinhas();
    int getColunas();
};