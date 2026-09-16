package avengers.domain.heroes;
import avengers.domain.skills.*;

public class Aquaman extends Hero implements Aquatic {
    public Aquaman() { super("Aquaman"); }
    @Override public void swim() { }
}