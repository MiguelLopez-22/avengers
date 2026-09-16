package avengers.domain.missions;
import avengers.domain.heroes.Hero;
import avengers.domain.skills.*;
import avengers.services.IMessageService;

public class AquaticMission extends Mission {
    public AquaticMission(String description, IMessageService messageService) {
        super(description, messageService);
    }
    @Override
    protected boolean checkCompatibility(Hero hero) {
        return hero instanceof Aquatic;
    }
}
