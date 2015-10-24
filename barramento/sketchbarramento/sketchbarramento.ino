#include <Wire.h>
#include "ADXL345.h"
#include "Adafruit_BMP085.h"

 int x,y,z; 

ADXL345 adxl;
Adafruit_BMP085 bmp;


void setup(){

 Serial.begin(9600);
   adxl.powerOn(); 
   bmp.begin();
}

void loop(){
  
 adxl.readAccel(&x, &y, &z);
 
 byte leitura = adxl.getInterruptSource();

 verificaTerremoto(leitura);
 verificaAltitude();

}


void verificaTerremoto(byte leitura){

adxl.setInterruptMapping( ADXL345_INT_ACTIVITY_BIT,   ADXL345_INT1_PIN );
 
bool valor = ((leitura >> ADXL345_INT_ACTIVITY_BIT  ) & 1);

if(valor == 1 ){
  
  Serial.println("atividade");
 
}
}

void verificaAltitude(){
  
  Serial.print(" Altitude ");
  Serial.print((bmp.readAltitude() + bmp.readAltitude(102200)) / 2 ); // altitude media = altitude padrao + 102200 Pascal <-  100 * 1022 milibar(altitude de Vitoria da Conquista) 
  Serial.println(" metros");

}

  
  
