package org.java.practice.springinaction.knights.config;

import org.java.practice.springinaction.knights.BraveKnight;
import org.java.practice.springinaction.knights.Knight;
import org.java.practice.springinaction.knights.Quest;
import org.java.practice.springinaction.knights.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yang.jin on 05/09/2017.
 */
@Configuration
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }
}
