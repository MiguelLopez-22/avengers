package avengers.domain.missions;
import avengers.domain.heroes.Hero;
import avengers.domain.skills.*;
import avengers.services.IMessageService;

public abstract class Mission {
    protected String description;
    protected IMessageService messageService;

    public Mission(String description, IMessageService messageService) {
        this.description = description;
        this.messageService = messageService;
    }

    public void assignHero(Hero hero, String contactInfo) {
        if (checkCompatibility(hero)) {
            messageService.sendMessage(contactInfo, "MISION ASIGNADA a " + hero.getName() + ": " + description);
        } else {
            messageService.sendMessage(contactInfo, "ALERTA: " + hero.getName() + " no es apto. Riesgo de fallo inminente.");
        }
    }

    protected abstract boolean checkCompatibility(Hero hero);
}
