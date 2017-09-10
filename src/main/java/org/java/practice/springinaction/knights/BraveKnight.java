package org.java.practice.springinaction.knights;

/**
 * Created by yang.jin on 05/09/2017.
 */
public class BraveKnight implements Knight{

    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest; //构造器注入 constructor injection
    }
    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}
