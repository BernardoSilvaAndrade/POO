#include <iostream>
#include "TechLead.hpp"
#include "Gerente.hpp"
#include "Desenvolvedor.hpp"

int main()
{
    Funcionario *funcionario = nullptr;
    int opcao;

    while (true)
    {
        std::cout << "\nMenu:" << std::endl;
        std::cout << "1. Cadastrar Gerente" << std::endl;
        std::cout << "2. Cadastrar desenvolvedor" << std::endl;
        std::cout << "3. Cadastrar TechLead" << std::endl;
        std::cout << "4. Imprimir Dados do Funcionário" << std::endl;
        std::cout << "5. Sair" << std::endl;

        std::cout << "Selecione uma opção: ";
        std::cin >> opcao;
        std::cin.ignore();

        switch (opcao)
        {
        case 1:
        {
            int salario, numero_equipes;
            std::string nome;

            std::cout << "Digite o nome do gerente: ";
            std::getline(std::cin, nome);
            std::cout << "Informe o salario do gerente: ";
            std::cin >> salario;
            std::cin.ignore();
            std::cout << "Informe o numero de equipes do gerente: ";
            std::cin >> numero_equipes;
            std::cin.ignore();
            funcionario = new Gerente(nome, salario, numero_equipes);
            break;
        }

        case 2:
        {
            std::string nomeDev;
            int salarioDev;
            std::string linguagem_principalDev;

            std::cout << "Digite o nome do desenvolvedor: ";
            std::getline(std::cin, nomeDev);
            std::cout << "Informe o salario do desenvolvedor: ";
            std::cin >> salarioDev;
            std::cin.ignore();
            std::cout << "Informe a linguagem principal do desenvolvedor: ";
            std::getline(std::cin, linguagem_principalDev);

            funcionario = new Desenvolvedor(nomeDev, salarioDev, linguagem_principalDev);
            break;
        }

        case 3:
        {
            std::string nomeTech;
            int salarioTech, numero_equipesTech, numero_projetosTech;
            std::string linguagem_principalTech;

            std::cout << "Informe o nome do TechLead: ";
            std::getline(std::cin, nomeTech);
            std::cout << "Informe o salario do TechLead: ";
            std::cin >> salarioTech;
            std::cin.ignore();
            std::cout << "Informe o numero de equipes do TechLead: ";
            std::cin >> numero_equipesTech;
            std::cin.ignore();
            std::cout << "Informe a linguagem principal do TechLead: ";
            std::getline(std::cin, linguagem_principalTech);
            std::cout << "Informe o numero de projetos realizados pelo TechLead: ";
            std::cin >> numero_projetosTech;
            std::cin.ignore();

            funcionario = new TechLead(nomeTech, salarioTech, numero_equipesTech, linguagem_principalTech, numero_projetosTech);
            break;
        }

        case 4:
            if (funcionario)
            {
                std::cout << funcionario->descricao() << std::endl;
            }
            else
            {
                std::cout << "Nenhum funcionario foi cadastrado ainda." << std::endl;
            }
            break;

        case 5:
            delete funcionario;
            return 0;

        default:
            std::cout << "Opcao invalida!" << std::endl;
        }
    }

    return 0;
}