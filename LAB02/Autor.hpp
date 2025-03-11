#ifndef __AUTOR_HPP
#define __AUTOR_HPP

#include <string>

using namespace std;

class Autor
{
private:
    string nome;
    string dataNascimento;

public:
    Autor(string n, string dN);
    Autor();

    string getNome();
    void setNome(string n);
    string getdataNascimento();
    void setdataNascimento(string dN);
};

#endif
