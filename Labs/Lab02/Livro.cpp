#include "Livro.hpp"

Livro::Livro(string t, string is, Autor a) : Titulo(t), ISBN(is), autor(a) {}

Livro::Livro() {}

string Livro::getTitulo()
{
    return Titulo;
}

void Livro::setTitulo(string titulo)
{
    this->Titulo = titulo;
}

string Livro::getISBN()
{
    return ISBN;
}

void Livro::setISBN(string isbn)
{
    this->ISBN = isbn;
}

Autor Livro::getAutor()
{
    return autor;
}

void Livro::setAutor(Autor a)
{
    this->autor = a;
}
