#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main() {
    ifstream inputFile("entrada.txt");
    if (!inputFile) {
        cerr << "Erro ao abrir o arquivo de entrada." << endl;
        return 1;
    }

    int italico = 0;
    int negrito = 0;
    string linha;

    while (getline(inputFile, linha)) {
        int i = 0;
        while (i < linha.length()) {
            char c = linha[i];
            if (c == '_') {
                if (italico == 1) {
                    cout << "</i>";
                } else {
                    cout << "<i>";
                }
                italico = 1 - italico; 
            } else if (c == '*') {
                if (negrito == 1) {
                    cout << "</b>";
                } else {
                    cout << "<b>";
                }
                negrito = 1 - negrito; 
            } else {
                cout.write(&c, 1);
            }
            i = i + 1;
        }
        cout.write("\n", 1);
    }

    inputFile.close();
    return 0;
}
