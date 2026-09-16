# 🦸‍♂️ Sistema de Asignación de Misiones - Avengers Initiative

Este repositorio contiene la solución completa para el sistema de asignación inteligente de misiones de los Avengers, desarrollado en **Java** aplicando **Clean Architecture** y principios **SOLID**.

---

## 📌 Contexto del Problema

Actualmente, la organización presenta fallos en la asignación de misiones debido a que no se evalúan las habilidades reales de los superhéroes antes de desplegarlos[cite: 4]:
* **Thor** es enviado por error a misiones acuáticas[cite: 4].
* **Hulk** es asignado a misiones de sigilo[cite: 4].
* **Aquaman** es enviado a misiones de vuelo[cite: 4].

Este proyecto resuelve el problema validando mediante contratos e interfaces la compatibilidad de cada héroe con los requerimientos específicos de la misión antes de confirmar la asignación[cite: 4].

---

## 🏗️ Principios SOLID Aplicados

Para evitar *Code Smells* como **Switch Statements**, **Large Class** y **Long Method**, el sistema fue diseñado bajo los siguientes principios:

* **Single Responsibility Principle (SRP):** Cada clase tiene una sola razón para cambiar. Las entidades de héroes representan únicamente al personaje, las misiones gestionan su validación específica y los servicios manejan la mensajería.
* **Open/Closed Principle (OCP):** El sistema está abierto a extensión pero cerrado a modificación. Se pueden incorporar nuevos tipos de misiones (ej. `SpaceMission`) o nuevos héroes sin alterar el código existente.
* **Liskov Substitution Principle (LSP):** Cualquier subclase de `Hero` o `Mission` puede sustituir a su clase base sin alterar la estabilidad del programa.
* **Interface Segregation Principle (ISP):** Se crearon interfaces granulares y específicas en el paquete `skills` (`Aquatic`, `Flyable`, `Stealthy`, etc.) en lugar de una interfaz monolítica. Los héroes solo implementan las capacidades que poseen.
* **Dependency Inversion Principle (DIP):** Las misiones no dependen de una implementación concreta de envío de mensajes, sino de la abstracción `IMessageService`, permitiendo desacoplar la infraestructura del dominio[cite: 4].

---

## 📁 Estructura del Proyecto y Paquetes

La estructura de carpetas en `src/main/java/` sigue una separación de capas clara:

```text
proyecto-avengers/
└── src/
    └── main/
        └── java/
            └── com/
                └── avengers/
                    ├── domain/
                    │   ├── heroes/          # Entidades de superhéroes (IronMan, Thor, Hulk, etc.)
                    │   ├── missions/        # Reglas de validación y tipos de misiones
                    │   └── skills/          # Interfaces granulares de habilidades (ISP)
                    ├── services/            # Clases de infraestructura y mensajería (DIP)
                    └── main/                # Punto de entrada y ensamblaje de componentes

🧩 Detalle del Código y Funcionalidad
1. Paquete com.avengers.domain.skills
Contiene los contratos de habilidades individuales:

Aquatic: Para operaciones subacuáticas.

Flyable: Para desplazamiento aéreo.

Stealthy: Para infiltración y sigilo.

WallClimbable: Para desplazamiento en superficies verticales.

FireControllable: Para mitigación y manejo de incendios.

2. Paquete com.avengers.domain.heroes
Hero (Clase Abstracta): Define la identidad básica del superhéroe (name).

Aquaman: Extiende Hero e implementa Aquatic.

IronMan: Extiende Hero e implementa Flyable y FireControllable.

SpiderMan: Extiende Hero e implementa WallClimbable y Stealthy.

Thor: Extiende Hero e implementa Flyable.

Hulk: Extiende Hero (sin implementar habilidades de sigilo o acuáticas).

3. Paquete com.avengers.services
IMessageService: Abstracción que define el método sendMessage(String to, String message).

TwilioSmsService: Implementación real que se conecta con la API de mensajería para cumplir con la restricción de notificaciones reales sin usar System.out.println como simulación[cite: 4].

4. Paquete com.avengers.domain.missions
Mission (Clase Abstracta): Contiene la lógica común de asignación, requiere una instancia de IMessageService y delega la verificación al método abstracto checkCompatibility(Hero hero).

AquaticMission: Valida dinámicamente si el héroe implementa la interfaz Aquatic.

StealthMission: Valida dinámicamente si el héroe implementa la interfaz Stealthy.