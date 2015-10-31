/*
 * Executor.cpp
 *
 *  Created on: 29/10/2015
 *      Author: webmaster
 */

#include <stdlib.h>
#include <iostream>

using namespace std;


int main(int argc, char** argv) {
	int temperatura = 36;
	int pressaoSistolica = 8;
	int pressaoDiastolica = 12;
	int batimentos = 100;

	int info = 0;
	cout << "tam " << sizeof(info) << endl;

	info = info | (temperatura << 24);
	info = info | (pressaoSistolica << 16);
	info = info | (pressaoDiastolica << 8);
	info = info | batimentos;
		// informação enviada pelo RF
	cout << info << endl;
		// informação recebebida e decodificada pelo receptor
	int temperaturaRec = (info & 4278190080) >> 24;
	int pressaoSistolicaRec = (info & 16711680) >> 16;
	int pressaoDiastolicaRec = (info & 65280) >> 8;
	int batimentosRec = (info & 255);

	cout << temperaturaRec << endl;
	cout << pressaoSistolicaRec << endl;
	cout << pressaoDiastolicaRec << endl;
	cout << batimentosRec << endl;
}
