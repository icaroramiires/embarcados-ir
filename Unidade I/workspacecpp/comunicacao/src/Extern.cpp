/*
 * Extern.cpp
 *
 *  Created on: 24/10/2015
 *      Author: Igo Romero
 */

#include "Extern.h"

#include <stddef.h>

#include "../include/Comunicacao.h"

struct Dados {
	short ativade, altura;
};

Dados dados;
Comunicacao com = NULL;

int iniciar(char* porta) {
	com = Comunicacao(porta);
	return com.iniciar();
}

int ler() {
	char ci, cf;
	//Enquanto estiver execultando
	// realiza a leitura do caracter I
	int resultado = com.ler((char*) &ci, sizeof(ci)); //vai ler i o inicio

	if ((resultado == EXIT_SUCCESS) && (ci == 'I')) { //vai ler ci e ver se tem i
		// se a leitura de I ocorrer bem
		//ler os eixos
		resultado = com.ler((char*) &dados, sizeof(dados));
		if (resultado == EXIT_SUCCESS) {

			resultado = com.ler((char*) &cf, sizeof(cf));

			if ((resultado == EXIT_SUCCESS) && (cf == 'F')) {
				resultado = EXIT_SUCCESS;
			}
		}
	}
	return resultado;
}

int getAtividade() {
	return dados.ativade;
}

int getAltura() {
	return dados.altura;
}

int finalizar() {
	return com.finalizar();
}
