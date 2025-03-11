#include <iostream>
#include "NodoPessoa.hpp"

NodoPessoa::NodoPessoa(Pessoa *pessoa) : pessoa(pessoa), prox(nullptr) {}