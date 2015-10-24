

#include <Wire.h>
#include "ADXL345.h"

 int x,y,z; 

ADXL345 adxl;
void setup(){

 Serial.begin(9600);
   adxl.powerOn(); 
}

void loop(){
  
 adxl.readAccel(&x, &y, &z); 
 
 byte leitura = adxl.getInterruptSource();

 verificaTerremoto(leitura);


}


void verificaTerremoto(byte leitura){

 if(adxl.triggered(leitura, ADXL345_INACTIVITY)){
  Serial.println("Sem terremoto");
 }
  
 if(adxl.triggered(leitura, ADXL345_ACTIVITY)){
  Serial.println("Terremto Detectado"); 
  
 }
}
  
  
  
