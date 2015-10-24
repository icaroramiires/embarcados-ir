/*
 * Extern.cpp
 *Externalização das rotinas de acesso ao acelerometro e barometro
 *  Created on: 24/10/2015
 *      Author: Igo Romero
 */

#include <Extern.h>

#include <Comunicacao.h>
#include <stddef.h>

#include "../include/Comunicao.h"

struct Dados {
	bool atividade;
	short altitude;
};

Dados dados;

Comunicacao com = NULL;

int iniciar(char* porta) {
	com = Comunicacao(porta);
	return com.iniciar();
}

int ler() {
	char i, f;


	int resultado = com.ler((char*) &i, sizeof(i));

	if ((resultado == EXIT_SUCCESS) && (i == 'I')) {

		resultado = com.ler((char*) &dados, sizeof(dados));
		if (resultado == EXIT_SUCCESS) {
			resultado = com.ler((char*) &f, sizeof(f));

			if ((resultado == EXIT_SUCCESS) && (f == 'F')) {
				resultado = EXIT_SUCCESS;
			}
		}

	}
	return resultado;
}

bool getAtividade(){
	return dados.atividade;
}

int getAltitude(){
	return dados.altitude;
}

int finalizar(){
	return com.finalizar();
}
