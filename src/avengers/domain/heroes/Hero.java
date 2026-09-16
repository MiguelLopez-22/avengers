package avengers.domain.heroes;
import avengers.domain.skills.*;

public abstract class Hero {
    private String name;
    public Hero(String name) { this.name = name; }
    public String getName() { return name; }
}
