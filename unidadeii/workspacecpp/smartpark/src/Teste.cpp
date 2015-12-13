/*
 * Teste.cpp
 *
 *  Created on: 12 de dez de 2015
 *      Author: lenovo
 */

#include <cstdlib>
#include <iostream>

#include "../include/Comunicacao.h"

using namespace std;

struct InfoRF {
	short id, rfid, statusvaga, distancia;
};

int main(int argc, char **argv) {

	Comunicacao com("/dev/ttyACM0");
	if (com.iniciar() == EXIT_SUCCESS) { //testa para erro - nega a condicao
		char ci, cf;
		InfoRF info = { 0 };

		while (true) {
			int resultado = com.ler((char*) &ci, sizeof(ci));
			if ((resultado == EXIT_SUCCESS) && (ci == 'I')) {
				resultado = com.ler((char*) &info, sizeof(info));
				if (resultado == EXIT_SUCCESS) {
					resultado = com.ler((char*) &cf, sizeof(cf));

					if ((resultado == EXIT_SUCCESS) && (cf == 'F')) {
						cout << "id: " << info.id << endl;
						cout << "Tag RFID: " << info.rfid << endl;
						cout << "Status Vaga: " << info.statusvaga << endl;
						cout << "Distancia: " << info.distancia << endl;
					}
				}

			}
			Sleep(500);
		}
	}
	return EXIT_SUCCESS;
}



