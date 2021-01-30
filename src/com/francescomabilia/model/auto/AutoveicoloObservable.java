package com.francescomabilia.model.auto;

import com.francescomabilia.model.percorrimenti.PercorrimentiObserver;

public interface AutoveicoloObservable {
    void attach(PercorrimentiObserver trattaObserver);

    void detach(PercorrimentiObserver trattaObserver);

    void notifyObserver();
}
