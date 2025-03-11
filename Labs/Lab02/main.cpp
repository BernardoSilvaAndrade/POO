#include <iostream>
#include <string>
#include "Livro.hpp"
#include "Autor.hpp"
#include "Biblioteca.hpp"

using namespace std;

int main()
{
    Biblioteca biblioteca;
    int opcao;

    do
    {
        cout << "Menu da Biblioteca:" << endl;
        cout << "1. Adicionar Livro" << endl;
        cout << "2. Buscar Livro" << endl;
        cout << "3. Mostrar Todos os Livros" << endl;
        cout << "0. Sair" << endl;
        cout << "Escolha uma opcao: ";
        cin >> opcao;
        cin.ignore(); // Limpa o buffer de entrada

        switch (opcao)
        {
        case 1:
        {
            string titulo, isbn, nomeAutor, dataNascimentoAutor;

            cout << "Digite o titulo do livro: ";
            getline(cin, titulo);
            cout << "Digite o ISBN do livro: ";
            getline(cin, isbn);
            cout << "Digite o nome do autor: ";
            getline(cin, nomeAutor);
            cout << "Digite a data de nascimento do autor: ";
            getline(cin, dataNascimentoAutor);

            Autor autor(nomeAutor, dataNascimentoAutor);
            Livro livro(titulo, isbn, autor);
            biblioteca.adicionarLivro(livro);
            cout << "Livro adicionado com sucesso!" << endl;
            break;
        }
        case 2:
        {
            string titulo;
            cout << "Digite o titulo do livro a ser buscado: ";
            getline(cin, titulo);

            Livro *encontrado = biblioteca.buscarLivro(titulo);
            if (encontrado != nullptr)
            {
                cout << "Livro encontrado: " << endl;
                cout << "Titulo: " << encontrado->getTitulo() << endl;
                cout << "ISBN: " << encontrado->getISBN() << endl;
                cout << "Autor: " << encontrado->getAutor().getNome() << endl;
            }
            else
            {
                cout << "Livro nao encontrado." << endl;
            }
            break;
        }
        case 3:
            biblioteca.mostrarLivros();
            break;
        case 0:
            cout << "Encerrando o programa..." << endl;
            break;
        default:
            cout << "Opcao invalida. Tente novamente." << endl;
            break;
        }
    } while (opcao != 0);

    return 0;
}
