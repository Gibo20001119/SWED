# Website Change Monitor (SWED)

A modular Java-based backend application designed to monitor website content changes and trigger notifications for subscribed users. This project demonstrates clean code practices using **GRASP (General Responsibility Assignment Software Patterns)** and a strict **Layered Package Architecture**.

---

## Architecture & Design Principles

The system is strictly structured according to core **GRASP** patterns to ensure high cohesion and low coupling:

* **Information Expert:** The `Website` class encapsulates its own state and evaluation logic (`hasChanged`), making it the expert for content validation.
* **Creator:** The `WebsiteMonitor` controller handles the creation lifecycle of `User` and `Subscription` instances.
* **Controller:** `WebsiteMonitor` acts as the central coordinator, orchestrating system events without tightly coupling individual domain components.

---

## Package Structure

To maintain clean separation of concerns, the project is organized into logical layers:

* `de.gabriel.monitor.model` — Contains pure domain entities (`User`, `Website`, `Subscription`).
* `de.gabriel.monitor.service` — Infrastructure and technical services (`Notification`).
* `de.gabriel.monitor.controller` — Application coordination layer (`WebsiteMonitor`).
* `de.gabriel.monitor.main` — Application entry point (`Main`).

---

## Software Metrics Analysis

To evaluate the design quality, **Robert C. Martin's Stability Metrics** were applied to the core packages:

| Component | Afferent Coupling ($C_a$) | Efferent Coupling ($C_e$) | Instability ($I$) | Status |
| :--- | :---: | :---: | :---: | :--- |
| **User** | 3 | 0 | **0.0** | Stable (Core Domain) |
| **Website** | 2 | 0 | **0.0** | Stable (Core Domain) |
| **Notification** | 1 | 1 | **0.5** | Balanced Service |
| **Subscription** | 1 | 2 | **0.67** | Flexible Aggregator |
| **WebsiteMonitor** | 1 | 4 | **0.8** | Configurable Controller |

> **Architectural Note:** The high instability ($I = 0.8$) of the Controller is intentional, as its sole responsibility is coordinating multiple components. The foundational domain models remain perfectly stable ($I = 0.0$).

---

## Architectural Optimizations (Future Scope)
To further decouple the components and reduce the Controller's efferent coupling ($C_e$), the following patterns are slated for implementation:
1. **Dependency Inversion Principle (DIP):** Introducing a `MessageService` interface to isolate the concrete notification medium.
2. **Observer Pattern:** Decoupling the change detection event from the notification dispatch logic.
