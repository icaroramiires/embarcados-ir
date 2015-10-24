/*
 * Teste.cpp
 *
 *  Created on: 24/10/2015
 *      Author: Igo Romero
 *
 *      Classe para testar a biblioteca
 */

#include "Comunicacao.h"
#include "iostream"

using namespace std;

struct Dados {
	bool atividade;
	int altura;
};

int main(int argc, char **argv) {
	//Cria uma classe Comunicacao

	Comunicacao com = Comunicacao("/dev/ttyUSB0"); //Construtor Comunicacao

	if (com.iniciar() == EXIT_SUCCESS) {
		char i, f;
		Dados dados;

		while (true) {
			int resultado = com.ler((char*) &i, sizeof(i));

			if ((resultado == EXIT_SUCCESS) && (i == 'I')) {

				resultado = com.ler((char*) &dados, sizeof(dados));

				if (resultado == EXIT_SUCCESS) {

					resultado = com.ler((char*) &f, sizeof(f));

					if ((resultado == EXIT_SUCCESS) && (f == 'F')) {
						cout << "Atividade " << dados.atividade;
						cout << "Altura " << dados.altura;

					}

				}

			}

			Sleep(100);
		}

	}

	return EXIT_SUCCESS;

}
