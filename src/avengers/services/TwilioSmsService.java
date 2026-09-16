package avengers.services;

public class TwilioSmsService implements IMessageService {
    private String apiKey = "TU_API_KEY_REAL";

    @Override
    public void sendMessage(String to, String message) {
        // Integración real con la API (HttpClient, Twilio SDK, etc.)
        System.out.println("Enviando SMS a " + to + " -> " + message);
        // Nota: Dejé el print solo para que lo veas correr,
        // pero recuerda borrarlo e instanciar la API real para tu entrega.
    }
}
