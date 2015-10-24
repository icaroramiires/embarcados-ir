/*
 * Extern.h
 *
 *  Created on: 24/10/2015
 *      Author: Igo Romero
 */

#ifndef INCLUDE_EXTERN_H_
#define INCLUDE_EXTERN_H_

#ifdef __cplusplus
extern "C"{
#endif

int iniciar(char* porta);
int ler();
bool getAtividade();
int getAltitude();
int finalizar();

#ifdef __cplusplus
}
#endif

#endif /* INCLUDE_EXTERN_H_ */
