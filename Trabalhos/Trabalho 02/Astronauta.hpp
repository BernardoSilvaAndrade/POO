#pragma once
#include <string>

using namespace std;

class Astronauta
{
private:
    string nome;
    int nivelSaude;
    int atendimentoUrgente;
    int x;
    int y;

public:
    Astronauta(string nome, int nivelSaude, int atendimentoUrgente, int x, int y);

    int getX() const;
    int getY() const;
    void setX(int x);
    void setY(int y);
    string getNome() const;
    int getNivelSaude() const;
    int isAtendimentoUrgente() const;
    string toString() const;
};
