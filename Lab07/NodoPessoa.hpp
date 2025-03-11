#pragma once
#include <iostream>
#include "Pessoa.hpp"

using namespace std;

class NodoPessoa
{
public:
	Pessoa* pessoa;
	NodoPessoa* prox;

	NodoPessoa(Pessoa* pessoa);
};
