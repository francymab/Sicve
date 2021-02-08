package com.francescomabilia.model.sensore;

import java.time.LocalDateTime;

public interface SensoreIstantaneo extends Sensore{
    int calcolaVelocitaIstantanea(LocalDateTime time);
}
