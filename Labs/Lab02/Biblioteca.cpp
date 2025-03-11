#include <iostream>
#include "Biblioteca.hpp"

using namespace std;

Biblioteca::Biblioteca() {}

void Biblioteca::adicionarLivro(Livro livro)
{
    livros.push_back(livro);
}

void Biblioteca::mostrarLivros()
{
    if (livros.empty())
    {
        cout << "Nenhum livro na biblioteca." << endl;
        return;
    }

    for (size_t i = 0; i < livros.size(); i++)
    {
        cout << "Livro [" << i + 1 << "]:" << endl;
        cout << "Titulo: " << livros[i].getTitulo() << endl;
        cout << "ISBN: " << livros[i].getISBN() << endl;
        cout << "Autor: " << livros[i].getAutor().getNome() << endl;
        cout << "Data de Nascimento do Autor: " << livros[i].getAutor().getdataNascimento() << endl;
        cout << "----------------------------" << endl;
    }
}

Livro *Biblioteca::buscarLivro(string titulo)
{
    for (size_t i = 0; i < livros.size(); i++)
    {
        if (livros[i].getTitulo() == titulo)
        {
            return &livros[i];
        }
    }
    return nullptr;
}
