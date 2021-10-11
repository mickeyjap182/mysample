package practice.basicfeature.novice.extendsinterface.interfaces;

public interface Fightable {

    default public void bark(Avoidable defender) {
        System.out.println("Wooo!");
    }

    default public void bite(Avoidable defender) {
        System.out.println("ガブっ!");
    }

    public void intimidate(Avoidable defender);
}
