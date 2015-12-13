/*
 * Extern.h
 *
 *  Created on: 12 de dez de 2015
 *      Author: lenovo
 */

#ifndef EXTERN_H_
#define EXTERN_H_

#ifdef __cplusplus
extern "C" {
#endif

int iniciar(char* porta);
int ler();
int getId();	//indeticador
int getRFID(); //dados do RFID
int getStatusVaga(); //dados do sensor ultrassonico
int getDistancia(); //dados do sensor ultrassonico
int finalizar();
#ifdef __cplusplus
}
#endif

#endif /* EXTERN_H_ */
