#include <iostream>
#include "ListaClientes.hpp"
#include "NodoPessoa.hpp"
#include "Pessoa.hpp"

using namespace std;

ListaClientes::ListaClientes() : inicio(nullptr) {}

void ListaClientes::adicionarCliente(string nome, string cpf)
{
	if (buscarCliente(cpf) != nullptr)
	{
		cout << "Cliente com CPF " << cpf << " ja cadastrado.\n";
		return;
	}
	Pessoa *novaPessoa = new Pessoa(nome, cpf);
	NodoPessoa *novoNodo = new NodoPessoa(novaPessoa);
	novoNodo->prox = inicio;
	inicio = novoNodo;
	cout << "Cliente " << nome << " adicionado com sucesso!\n";
}

Pessoa *ListaClientes::buscarCliente(string cpf)
{
	NodoPessoa *atual = inicio;
	while (atual != nullptr)
	{
		if (atual->pessoa->cpf == cpf)
		{
			return atual->pessoa;
		}
		atual = atual->prox;
	}
	return nullptr;
}

void ListaClientes::exibirCliente()
{
	NodoPessoa *atual = inicio;
	while (atual != nullptr)
	{
		cout << "Nome: " << atual->pessoa->nome << ", CPF: " << atual->pessoa->cpf << "\n";
		atual = atual->prox;
	}
}
