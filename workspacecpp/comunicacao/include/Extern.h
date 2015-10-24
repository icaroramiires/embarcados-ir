/*
 * Extern.h
 *
 *  Created on: 24/10/2015
 *      Author: Igo Romero
 */

#ifndef EXTERN_H_
#define EXTERN_H_

#ifdef __cplusplus
extern "C" {
#endif

int iniciar(char* porta);
int ler();
int getAtividade();
int getAltura();
int finalizar();

#ifdef __cplusplus
}
#endif

#endif /* EXTERN_H_ */
