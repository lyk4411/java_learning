package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Wombat {
    final Logger logger = LoggerFactory.getLogger(Wombat.class);
    Integer t,oldT;
    public void setTemperature(Integer temperature) {
        oldT = t;
        t = temperature;
        
        logger.error("Temperature set to {}. Old temperature was {}.", t, oldT);
        if (temperature.intValue() > 50) {
            logger.info("Temperature has risen above 50 degrees.");
        }
        if (logger.isDebugEnabled()) {
            logger.debug("There are now  yes " );
        }else{
        	logger.info("NO NO NO NO NO NO NO NO NO NO ");
        	System.out.println(logger.ROOT_LOGGER_NAME);
        }
        
    }
    public static void main(String[] args) {
        Wombat wombat = new Wombat();
        wombat.setTemperature(1);
        wombat.setTemperature(55);
        wombat.setTemperature(155);
        wombat.setTemperature(5);
    }
}