#include <vector>
#include <string>
#include <fstream>
#include <iostream>
#include <sstream>
#include "EstacaoEspacial.hpp"
#include "RoboDeResgate.hpp"
#include "Astronauta.hpp"
#include "Modulo.hpp"

using namespace std;

bool checarTamanho(const std::vector<std::vector<int>> &matriz, int linhas, int colunas)
{
    if (matriz.size() != linhas)
        return false;

    for (const auto &linha : matriz)
    {
        if (linha.size() != colunas)
            return false;
    }

    return true;
}

void imprimirCaminhoRobo(const vector<vector<char>> &matriz)
{
    cout << "\nCaminho feito pelo robô:\n";
    for (int i = 0; i < matriz.size(); i++)
    {
        for (int j = 0; j < matriz[0].size(); j++)
        {
            if (matriz[i][j] == 'R' || matriz[i][j] == 'K' || matriz[i][j] == 'S' || matriz[i][j] == 'A')
            {
                cout << matriz[i][j];
            }
            else if (matriz[i][j] == '#' || matriz[i][j] == '~' || matriz[i][j] == 'F')
            {
                cout << matriz[i][j];
            }
            else
            {
                cout << ".";
            }
        }
        cout << endl;
    }
}
bool encontrarCaminho(int x, int y, vector<vector<char>> &matriz,
                      vector<vector<bool>> &visitado, int &passos,
                      int destinoX, int destinoY,
                      vector<pair<int, int>> &caminho)
{

    if (x < 0 || y < 0 || x >= matriz.size() || y >= matriz[0].size() ||
        visitado[x][y] || matriz[x][y] == '#' || matriz[x][y] == '~')
    {
        return false;
    }

    for (int i = -1; i <= 1; i++)
    {
        for (int j = -1; j <= 1; j++)
        {
            int newX = x + i;
            int newY = y + j;
            if (newX >= 0 && newX < matriz.size() &&
                newY >= 0 && newY < matriz[0].size() &&
                matriz[newX][newY] == 'F')
            {
                return false;
            }
        }
    }

    visitado[x][y] = true;
    caminho.push_back({x, y});

    char original = matriz[x][y];

    if (matriz[x][y] != 'S' && matriz[x][y] != 'A')
    {
        matriz[x][y] = 'R';
    }

    if (original == 'A')
    {
        matriz[x][y] = 'A';
    }

    if (x == destinoX && y == destinoY)
    {
        passos += caminho.size() - 1;
        return true;
    }

    vector<pair<int, int>> direcoes = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    for (const auto &dir : direcoes)
    {
        int newX = x + dir.first;
        int newY = y + dir.second;

        if (encontrarCaminho(newX, newY, matriz, visitado, passos, destinoX, destinoY, caminho))
        {
            return true;
        }
    }

    if (matriz[x][y] == 'R')
    {
        matriz[x][y] = original;
    }
    visitado[x][y] = false;
    caminho.pop_back();

    return false;
}

void DFS(int startX, int startY, vector<vector<char>> &matriz,
         vector<vector<bool>> &visitado, int &passos, RoboDeResgate &robo,
         vector<Astronauta> &astronautas, vector<Astronauta> &resgatados,
         ofstream &saida)
{

    for (auto it = astronautas.begin(); it != astronautas.end();)
    {

        vector<vector<bool>> visitadoTemp(matriz.size(), vector<bool>(matriz[0].size(), false));
        vector<pair<int, int>> caminho;

        if (encontrarCaminho(startX, startY, matriz, visitadoTemp, passos,
                             it->getX(), it->getY(), caminho))
        {

            matriz[it->getX()][it->getY()] = 'K';
            resgatados.push_back(*it);

            visitadoTemp = vector<vector<bool>>(matriz.size(), vector<bool>(matriz[0].size(), false));
            vector<pair<int, int>> caminhoVolta;
            encontrarCaminho(it->getX(), it->getY(), matriz, visitadoTemp, passos, startX, startY, caminhoVolta);

            it = astronautas.erase(it);
        }
        else
        {
            ++it;
        }
    }
}

int main()
{

    for (int i = 1; i <= 10; i++)
    {
        string nomeArquivo = "entrada" + to_string(i) + ".txt";
        ifstream arquivo(nomeArquivo);
        if (!arquivo)
        {
            cout << "Erro ao abrir o arquivo: " << nomeArquivo << endl;
            continue;
        }

        int linhas, colunas;
        arquivo >> linhas >> colunas;
        if (arquivo.fail())
        {
            cout << "Erro: Formato inválido no início do arquivo " << nomeArquivo << "." << endl;
            continue;
        }
        arquivo.ignore();

        cout << "Lendo arquivo: " << nomeArquivo << endl;
        cout << "Linhas esperadas: " << linhas << ", Colunas esperadas: " << colunas << endl;

        vector<vector<char>> matrizTemp(linhas, vector<char>(colunas));
        string linha;

        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < colunas; j++)
            {
                if (!(arquivo >> matrizTemp[i][j]))
                {
                    throw std::runtime_error("Erro ao ler dados da matriz");
                }
            }
        }

        ofstream saida("saida" + to_string(i) + ".txt");
        if (!saida)
        {
            cout << "Erro ao abrir o arquivo de saída: saida" << i << ".txt" << endl;
            continue;
        }

        cout << "Arquivo " << nomeArquivo << " processado com sucesso!" << endl;

        int startX = -1, startY = -1;
        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < colunas; j++)
            {
                if (matrizTemp[i][j] == 'S')
                {
                    startX = i;
                    startY = j;
                    break;
                }
            }
            if (startX != -1)
                break;
        }

        cout << "InicioX: " << startX << " InicioY: " << startY << endl;

        if (startX == -1 || startY == -1)
        {
            cout << "Erro: Posição inicial do robô não encontrada!" << endl;
            continue;
        }

        vector<vector<char>> matriz(linhas, vector<char>(colunas));
        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < colunas; j++)
            {
                matriz[i][j] = matrizTemp[i][j];
            }
        }

        vector<Astronauta> astronautas;
        string nome;
        int nivelSaude, atendimentoUrgente;

        string linhha;
        arquivo >> linhha;

        std::string linhan;
        while (std::getline(arquivo, linhan))
        {
            if (linhan.find("Posições dos astronautas na matriz:") != string::npos || linhan.find("Posições dos astronautas:") != string::npos)
            {
                break;
            }

            std::istringstream ss(linhan);
            std::string nome;
            int nivelSaude, urgenciaMedico;

            std::getline(ss, nome, ',');

            nome.erase(0, nome.find_first_not_of(" "));
            nome.erase(nome.find_last_not_of(" ") + 1);

            if (ss >> nivelSaude)
            {

                ss.ignore(1, ',');
                if (ss >> urgenciaMedico)
                {
                    Astronauta astronauta(nome, nivelSaude, urgenciaMedico, -1, -1);
                    astronautas.push_back(astronauta);
                }
            }
        }

        while (!arquivo.eof() && getline(arquivo, linhan))
        {
            if (linhan.empty() || linhan.find(':') == string::npos)
                continue;

            size_t colonPos = linhan.find(':');
            string nome = linhan.substr(0, colonPos);
            string coords = linhan.substr(colonPos + 1);

            auto trim = [](std::string &str)
            {
                str.erase(0, str.find_first_not_of(" \t\n\r\f\v"));
                str.erase(str.find_last_not_of(" \t\n\r\f\v") + 1);
                return str;
            };

            nome = trim(nome);
            coords = trim(coords);

            int x = -1, y = -1;
            if (sscanf(coords.c_str(), "(%d,%d)", &x, &y) == 2)
            {
                for (Astronauta &astronauta : astronautas)
                {
                    if (astronauta.getNome() == nome)
                    {
                        astronauta.setX(x);
                        astronauta.setY(y);
                        break;
                    }
                }
            }
        }

        EstacaoEspacial estacao(matriz, linhas, colunas, astronautas);

        RoboDeResgate robo(startX, startY, estacao);

        int passos = 0;
        vector<Astronauta> resgatados;
        vector<pair<int, int>> caminho;
        vector<vector<bool>> visitado(linhas, vector<bool>(colunas, false));
        DFS(startX, startY, matriz, visitado, passos, robo, astronautas, resgatados, saida);

        imprimirCaminhoRobo(matriz);

        saida << "Caminho final do robô:\n";
        for (int i = 0; i < matriz.size(); i++)
        {
            for (int j = 0; j < matriz[0].size(); j++)
            {
                if (matriz[i][j] == 'R' || matriz[i][j] == 'K' || matriz[i][j] == 'S')
                {
                    saida << matriz[i][j];
                }
                else if (matriz[i][j] == '#' || matriz[i][j] == '~' || matriz[i][j] == 'F')
                {
                    saida << matriz[i][j];
                }
                else
                {
                    saida << ".";
                }
            }
            saida << endl;
        }
        robo.gerarRelatorio(saida, resgatados, astronautas, passos);

        saida.close();
    }
}