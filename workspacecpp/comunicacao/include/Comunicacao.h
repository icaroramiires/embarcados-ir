/*
 * Comunicacao.h
 *
 *  Created on: 24/10/2015
 *      Author: Igo Romero
 *  Class para comunicação com o dispositivo controlador
 */
#include <stdlib.h>
#ifndef INCLUDE_COMUNICACAO_H_
#define INCLUDE_COMUNICACAO_H_

// diretivas de compilação include p/ Windows

#if _WIN32 || _WIN64
#include <windows.h>
#endif

// diretivas de complição  include p/ linux

#ifdef __linux__
#include <unistd.h>
#define Sleep(x) usleep(x * 1000); //Sleep do windows e do linux nano -> micro
#endif

class Comunicacao {
private:
	char* porta;
//diretivas de compilação

#ifdef __linux__
	int hPorta;
#endif

#if _WIN32 || _WIN64
	HANDLE hPorta;
#endif


//metodos da class
public:
	Comunicacao(char* porta);

	int iniciar(); //inicia a comunicação com a porta serial
	int ler(char* buffer, long unsigned int bytesParaLer); // realiza a leitura de um buffer a partir de uma porta serial
	int finalizar(); //finaliza o uso da porta serial


};

#endif /* INCLUDE_COMUNICACAO_H_ */
