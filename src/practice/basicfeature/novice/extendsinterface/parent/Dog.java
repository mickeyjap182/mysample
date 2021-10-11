package practice.basicfeature.novice.extendsinterface.parent;

import practice.basicfeature.novice.extendsinterface.abstruct.Animal;
import practice.basicfeature.novice.extendsinterface.interfaces.Avoidable;
import practice.basicfeature.novice.extendsinterface.interfaces.Fightable;
import practice.basicfeature.novice.extendsinterface.interfaces.StatusRuleAbility;
import practice.basicfeature.novice.extendsinterface.values.DOG_RULE;

public class Dog extends Animal implements Fightable, Avoidable {

    public String voice;
    public String name;
    private DOG_RULE type;
    private Status status;

    public Dog(DOG_RULE type, DogGenerator dog, String name, String voice) {
        this(
                type,
                name,
                voice,
                Status.newInstance((StatusRuleAbility)type,
                        dog)
        );
    }

    private Dog(DOG_RULE type, String name, String voice, Status status) {
        this.type = type;
        this.name = name;
        this.voice = voice;
        this.status = status;
    }

    @Override
    public void bark(Avoidable defender) {
        System.out.println(name + " : " + voice);
    }
    @Override
    public void avoid(Fightable fighter) {
        fighter.intimidate(this);
        System.out.println(name + ": kuuu...");
    }

    @Override
    public void intimidate(Avoidable defender) {
        System.out.println(name + " : grrrrrr... !");
    }

    @Override
    public void sleep() {
        System.out.println(name + ": is sleeping");
    }

}
