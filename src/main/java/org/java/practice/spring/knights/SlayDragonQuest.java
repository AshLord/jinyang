package org.java.practice.spring.knights;


import java.io.PrintStream;

/**
 * Created by yang.jin on 05/09/2017.
 */
public class SlayDragonQuest implements Quest {

    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {

        this.stream = stream;
    }

    @Override
    public void embark() {
        stream.println("Embarking on quest to slay a Dragon!");
    }
}
