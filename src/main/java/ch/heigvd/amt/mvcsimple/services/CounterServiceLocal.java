package ch.heigvd.amt.mvcsimple.services;

import javax.ejb.Local;

@Local
public interface CounterServiceLocal {
    void incCounter();
    void resetCounter();
    Integer getCounter();
}
