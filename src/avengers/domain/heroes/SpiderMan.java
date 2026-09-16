package avengers.domain.heroes;
import avengers.domain.skills.*;

public class SpiderMan extends Hero implements WallClimbable, Stealthy {
    public SpiderMan() { super("SpiderMan"); }
    @Override public void climb() { }
    @Override public void sneak() { }
}
