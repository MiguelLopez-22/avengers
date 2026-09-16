package avengers.domain.heroes;
import avengers.domain.skills.*;

public class Thor extends Hero implements Flyable {
    public Thor() { super("Thor"); }
    @Override public void fly() { }
}