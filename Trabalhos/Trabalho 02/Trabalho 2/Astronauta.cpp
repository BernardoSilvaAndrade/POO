#include "Astronauta.hpp"

Astronauta::Astronauta(std::string nome, int nivelSaude, int atendimentoUrgente, int x, int y)
    : nome(nome), nivelSaude(nivelSaude), atendimentoUrgente(atendimentoUrgente), x(x), y(y) {}

std::string Astronauta::getNome() const
{
    return nome;
}
int Astronauta::getNivelSaude() const
{
    return nivelSaude;
}

int Astronauta::isAtendimentoUrgente() const
{
    return atendimentoUrgente;
}

int Astronauta::getX() const
{
    return x;
};

int Astronauta::getY() const
{
    return y;
};

void Astronauta::setX(int x)
{
    this->x = x;
};
void Astronauta::setY(int y)
{
    this->y = y;
};

string Astronauta::toString() const
{
    return "Nome: " + nome + ", Saúde: " + std::to_string(nivelSaude) +
           ", Atendimento Urgente: " + (atendimentoUrgente ? "Sim" : "Não") +
           ", Posição: (" + std::to_string(x) + ", " + std::to_string(y) + ")";
};