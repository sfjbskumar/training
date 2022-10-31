package com.rama.artemis.consumer;

import com.rama.artemis.config.ArtemisConfig;
import com.rama.artemis.producer.ArtemisProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ArtemisConsumer {
    @Autowired
    ArtemisProducer producer;
    private static final Logger LOGGER = LoggerFactory.getLogger(ArtemisConfig.class);
    @JmsListener(destination = "${jms.out.queue.destination}")
    public void receive(String msg){
        System.out.println("Consumer Got Message: " + msg);
        producer.send("Consumer send back:"+msg);
    }

}

