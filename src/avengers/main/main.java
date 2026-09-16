package avengers.main;

import avengers.domain.heroes.*;
import avengers.domain.missions.AquaticMission;
import avengers.domain.missions.Mission;
import avengers.domain.missions.StealthMission;
import avengers.services.IMessageService;
import avengers.services.TwilioSmsService;


public class main {
    public static void main(String[] args) {
        IMessageService smsService = new TwilioSmsService();
        String adminPhone = "+573001234567";

        // Instanciamos a los héroes del problema
        Hero thor = new Thor();
        Hero aquaman = new Aquaman();
        Hero hulk = new Hulk();
        Hero spiderMan = new SpiderMan();

        // Creamos las misiones
        Mission waterMission = new AquaticMission("Recuperar artefacto en las fosas Marianas", smsService);
        Mission stealthMission = new StealthMission("Infiltración silenciosa en base enemiga", smsService);

        System.out.println("--- PRUEBAS DE MISIONES ACUÁTICAS ---");
        waterMission.assignHero(thor, adminPhone);    // Falla (Soluciona el problema del PDF)
        waterMission.assignHero(aquaman, adminPhone); // Éxito

        System.out.println("\n--- PRUEBAS DE MISIONES DE SIGILO ---");
        stealthMission.assignHero(hulk, adminPhone);      // Falla (Soluciona el problema del PDF)
        stealthMission.assignHero(spiderMan, adminPhone); // Éxito
    }
}
