# -*- coding: utf-8 -*-

from ctypes import cdll
from Tkinter import *
from datetime import datetime
import time 

sensor = cdll.LoadLibrary("/home/webmaster/workspace/embarcados-ir/workspacecpp/comunicacao/Release/comunicacao.so")

resultado = sensor.iniciar("/dev/ttyUSB0")

if resultado == 0:
    while True:
        sensor.ler()
        if sensor.getAtividade() == 1:
            print"[WARN]", datetime.now(), "ATIVIDADE SISMICA DETECTADA"
        else:
            print"[INFO]",datetime.now(), "ATIVIDADE: ", sensor.getAtividade(), "ALTITUDE: ", sensor.getAltura()
        time.sleep(0.10)
        
else:
    print("ERROR - Não foi possivel comunicar com a porta serial") 
