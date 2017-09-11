package org.java.practice.spring.knights;

/**
 * DamselRescuingKnight只能执行RescueDamselQuest探险任务
 * Created by yang.jin on 05/09/2017.
 */
public class DamselRescuingKnight implements Knight {

    private RescueDamselQuest quest;

    public DamselRescuingKnight() {
        this.quest = new RescueDamselQuest();
    }

    public void embarkOnQuest() {
        quest.embark();
    }

}
