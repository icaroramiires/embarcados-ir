/*
 * Extern.cpp
 *
 *  Created on: 12 de dez de 2015
 *      Author: lenovo
 */

/*
 * Extern.cpp
 *
 *  Created on: 03/12/2015
 *      Author: acer
 */
#include <Extern.h>
#include <Comunicacao.h>

struct InfoRF {
	short id, rfid, statusvaga, distancia;
} inforRF;
char ci, cf;

Comunicacao com = NULL;

int iniciar(char* porta) {
	com = Comunicacao(porta);
	return com.iniciar();
}
int ler() {
	int resultado = com.ler((char*) &ci, sizeof(ci));
	if ((resultado == EXIT_SUCCESS) && (ci == 'I')) {
		resultado = com.ler((char*) &inforRF, sizeof(inforRF));
		if (resultado == EXIT_SUCCESS) {
			resultado = com.ler((char*) &cf, sizeof(cf));
			if ((resultado == EXIT_SUCCESS) && (cf == 'F')) {
				return resultado;
			}
		}

	}
	return resultado;
}

int getId() {
	return inforRF.id;
}

int getRFID() {
	return inforRF.rfid;

}
int getStatusVaga() {
	return inforRF.statusvaga;

}
int getDistancia() {
	return inforRF.distancia;
}

int finalizar() {
	return com.finalizar();
}

