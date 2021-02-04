package com.francescomabilia.model.sensore;

import com.francescomabilia.model.auto.Autoveicolo;

public interface SensoreIstantaneo extends Sensore{
    int calcolaVelocitaIstantanea(Autoveicolo autoveicolo);
}
