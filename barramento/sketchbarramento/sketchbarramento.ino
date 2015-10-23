#include <Wire.h>
#include "ADXL345.h"

ADXL345 acelerometro = ADXL345();

void setup(){

  Serial.begin(9600);
  acelerometro.powerOn();
  
}

void verificarTerremoto() {
bool x;


x = acelerometro.getActivityThreshold();

Serial.println(x);

}


void loop(){
  
  verificarTerremoto();

}
