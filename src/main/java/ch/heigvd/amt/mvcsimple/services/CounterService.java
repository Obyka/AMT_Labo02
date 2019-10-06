package ch.heigvd.amt.mvcsimple.services;

import javax.ejb.Stateless;

@Stateless
public class CounterService implements CounterServiceLocal{
    static private int counter = 0;
    public void incCounter(){
        CounterService.counter++;
    }
    public void resetCounter(){
        CounterService.counter = 0;
    }
    public Integer getCounter(){
        return CounterService.counter;
    }
}
