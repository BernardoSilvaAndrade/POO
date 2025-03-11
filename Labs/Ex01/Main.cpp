#include "Historico.hpp"

int main()
{
    Historico historico;
    int opcao;
    std::string site;

    do
    {
        std::cout << "\n1. Adicionar site\n2. Remover site\n3. Exibir historico\n4. Verificar se esta vazio\n5. Visualizar topo\n0. Sair\nOpcao: ";
        std::cin >> opcao;
        std::cin.ignore();

        switch (opcao)
        {
        case 1:
            std::cout << "Digite o site: ";
            std::getline(std::cin, site);
            historico.adicionarSite(site);
            break;
        case 2:
            historico.removerSite();
            break;
        case 3:
            historico.exibirHistorico();
            break;
        case 4:
            std::cout << (historico.estaVazio() ? "Historico vazio" : "Historico nao esta vazio") << std::endl;
            break;
        case 5:
            historico.visualizarTopo();
            break;
        }
    } while (opcao != 0);

    return 0;
}