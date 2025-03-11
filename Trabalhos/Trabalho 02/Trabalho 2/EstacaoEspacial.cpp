#include "EstacaoEspacial.hpp"

EstacaoEspacial::EstacaoEspacial(const vector<vector<char>> &matriz, int linhas, int colunas, const std::vector<Astronauta> astronautas)
    : astronautas(astronautas), linhas(linhas), colunas(colunas)
{
    this->matriz = vector<vector<Modulo>>(linhas, vector<Modulo>(colunas));

    for (int i = 0; i < linhas; i++)
    {
        for (int j = 0; j < colunas; j++)
        {
            this->matriz[i][j].getTipo();
        }
    }

    if (static_cast<int>(matriz.size()) != linhas)
    {
        throw invalid_argument("Número de linhas da matriz não corresponde ao esperado.");
    }

    for (int i = 0; i < linhas; i++)
    {
        if (static_cast<int>(matriz[i].size()) != colunas)
        {
            throw invalid_argument("Número de colunas na linha " + to_string(i) + " não corresponde ao esperado.");
        }
    }

    for (int i = 0; i < linhas; i++)
    {
        for (int j = 0; j < colunas; j++)
        {
            this->adicionarModulo(i, j, matriz[i][j]);
        }
    }
}

void EstacaoEspacial::adicionarModulo(int x, int y, char tipo)
{
    switch (tipo)
    {
    case '.':
        matriz[x][y] = ModuloNormal(tipo);
        break;
    case '#':
        matriz[x][y] = ModuloObstaculo(tipo);
        break;
    case '~':
        matriz[x][y] = ModuloVazia(tipo);
        break;
    case 'S':
    {
        ModuloSeguranca mm = ModuloSeguranca(tipo);
        this->matriz[x][y] = mm;
        break;
    }
    case 'F':
        matriz[x][y] = ModuloComFogo(tipo);
        break;
    case 'A':
        matriz[x][y] = ModuloComAstronauta(tipo);
        break;
    default:
        throw invalid_argument("Tipo de módulo inválido ou matriz mal formatada");
    }
}

void EstacaoEspacial::adicionarAstronauta(Astronauta astronauta)
{
    astronautas.push_back(astronauta);
}

vector<vector<Modulo>> EstacaoEspacial::getMatriz()
{
    return matriz;
}

vector<Astronauta> EstacaoEspacial::getAstronautas()
{
    return astronautas;
}

int EstacaoEspacial::getLinhas()
{
    return linhas;
}

int EstacaoEspacial::getColunas()
{
    return colunas;
}