# -*- coding: utf-8 -*-

from threading import Thread
from ctypes import cdll
from Tkinter import *
import time
import os

class AsyncExec(Thread):

    def __init__(self, porta):
        Thread.__init__(self)
        self.porta = porta
        self.listeners = list()
        self.continuar = True

    def add_listener(self, listener):
        self.listeners.append(listener)

    def set_continuar(self, continuar):
        self.continuar = continuar

    def notify(self):
        for listener in self.listeners:
            listener.notificar_atividade()

    def run(self):
        conector = cdll.LoadLibrary("/home/webmaster/Documentos/monitor-python/comunicacao.so")
        if conector.iniciar(self.porta) == 0:
            self.continuar = True
            print "pegar dados"
            while self.continuar:
                conector.ler()
                if(conector.getAtividade() == 1):
                    self.notify()
                time.sleep(0.10)
            conector.finalizar()
        else:
            print("nao foi possivel comunicar com o arduino")

class Notification:
    def __init__(self, master):
        pass
    def notificar_atividade(self):
        print "Terremoto"

if __name__ == '__main__':
    async = AsyncExec("/dev/ttyUSB0")
    root = Tk()
    notificacao = Notification(root)
    async.add_listener(notificacao)
    async.start()
    i = 0
    while(i < 10):
        time.sleep(1)
        i += 1
    async.set_continuar(False)
