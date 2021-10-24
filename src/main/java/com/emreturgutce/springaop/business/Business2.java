package com.emreturgutce.springaop.business;

import com.emreturgutce.springaop.data.Dao2;
import org.springframework.stereotype.Service;

@Service
public class Business2 {

    private final Dao2 dao2;

    public Business2(Dao2 dao2) {
        this.dao2 = dao2;
    }

    public String calculateSomething() {
        return dao2.retrieveSomething();
    }
}
