package lesson7.labs.prob3;

public interface MuteQuack {
    default void quack() {
        System.out.println("cannot quack");
    }
}
