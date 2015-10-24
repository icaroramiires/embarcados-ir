/*
 * Teste.cpp
 *
 *  Created on: 24/10/2015
 *      Author: Igo Romero
 */

#include <cstdlib>

#include "../include/Comunicacao.h"

using namespace std;

struct Dados {
	short atividade, altura;
};

int main(int argc, char **argv) {

	//cria uma Instancia da Classe  Comunicacao

	Comunicacao com = Comunicacao("/dev/ttyUSB0"); //Construtor

	if (com.iniciar() == EXIT_SUCCESS) { //testa para erro - nega a condicao
		char ci, cf;
		Dados dados;

		//Enquanto estiver execultando
		while (true) {
			// realiza a leitura do caracter I
			int resultado = com.ler((char*) &ci, sizeof(ci)); //vai ler i o inicio

			if ((resultado == EXIT_SUCCESS) && (ci == 'I')) { //vai ler ci e ver se tem i
				// se a leitura de I ocorrer bem
				//ler os eixos
				resultado = com.ler((char*) &dados, sizeof(dados));
				if (resultado == EXIT_SUCCESS) {

					resultado = com.ler((char*) &cf, sizeof(cf));

					if ((resultado == EXIT_SUCCESS) && (cf == 'F')) {
						//se a leitura dos eixos ocorrer bem
						//ler o caracter 'F' Final
						cout << "atividade = " << dados.atividade << endl;
						cout << "altura = " << dados.altura << endl;

					}
				}

			}
			Sleep(100);
		}
	}
	return EXIT_SUCCESS;

}


