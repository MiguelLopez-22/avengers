package avengers.domain.heroes;
import avengers.domain.skills.*;

public class IronMan extends Hero implements Flyable, FireControllable {
    public IronMan() { super("IronMan"); }
    @Override public void fly() { }
    @Override public void controlFire() { }
}
