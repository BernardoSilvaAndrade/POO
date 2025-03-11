#ifndef __LIVRO_HPP
#define __LIVRO_HPP

#include <string>
#include "Autor.hpp"

using namespace std;

class Livro
{
private:
    string Titulo;
    string ISBN;
    Autor autor;

public:
    Livro(string t, string is, Autor a);
    Livro();

    string getTitulo();
    void setTitulo(string titulo);
    string getISBN();
    void setISBN(string isbn);
    Autor getAutor();
    void setAutor(Autor a);
};

#endif
