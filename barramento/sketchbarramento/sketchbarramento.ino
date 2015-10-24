#include <Wire.h>
#include "ADXL345.h"
#include "Adafruit_BMP085.h"

struct Dados{ //Estutura contendo as informaçoes que seram enviadas no buffer
  bool atividade; // atividade 
  int altitude;  // altitude
};

Dados dados; //criando um elemento da estutura dados

ADXL345 acelerometro = ADXL345(); // Criando o acelerometro

Adafruit_BMP085 bmp = Adafruit_BMP085(); //Criando o Barometro 


void setup(){
 Serial.begin(9600); // Iniciando a comunicaçao Serial
 acelerometro.powerOn(); // Iniciando acelerometro
 bmp.begin();  // iniciando o Barometro 
}

void loop(){
  
 byte leitura = acelerometro.getInterruptSource(); //leitura dos dados
 
 dados.atividade = verificaTerremoto(leitura); // metodo para verificar atividade
 dados.altitude =  verificaAltitude();    // metodo para recuperar a altitude do lugar
 
 enviarDados(); //metodo que envia o buffer de informacoes pela Serial

 delay(100);
}

void enviarDados(){

int tam = sizeof(dados);
char buffer[tam];
memcpy(&buffer,&dados,5);

Serial.write('I');
Serial.write((uint8_t*)&buffer, 5);
Serial.write('F');


}

bool verificaTerremoto(byte leitura){
acelerometro.setInterruptMapping( ADXL345_INT_ACTIVITY_BIT,   ADXL345_INT1_PIN );
 
bool valor = ((leitura >> ADXL345_INT_ACTIVITY_BIT  ) & 1); 

if(valor == 1 ){  // retorna verdadeiro se tiver atividade 
 return true;
 
}if(valor == 0){ //retorna falso se nao tiver atividade
 return false;
}


}
int verificaAltitude(){
  int altitude = (int) ((bmp.readAltitude() + bmp.readAltitude(102200)) / 2 ); // altitude media = altitude padrao + 102200 Pascal(altitude vca) <-  100 * 1022 milibar (pressao atimosferica VCA)  
  return altitude;
}

  
  
