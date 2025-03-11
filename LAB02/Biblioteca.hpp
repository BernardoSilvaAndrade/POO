#ifndef __BIBLIOTECA_HPP
#define __BIBLIOTECA_HPP

#include <vector>
#include "Livro.hpp"

using namespace std;

class Biblioteca
{
private:
    vector<Livro> livros;

public:
    Biblioteca();
    void adicionarLivro(Livro livro);
    void mostrarLivros();
    Livro *buscarLivro(string titulo);
};

#endif
