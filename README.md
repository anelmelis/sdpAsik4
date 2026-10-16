# Building Space Booking System

### Assignment 4 — Facade Design Pattern
SE-2527  MELIS ANEL 

## Project Description
This project is a simple booking system for a building with private offices and open spaces.
Users can book an entire space for themselves or their team. The system checks room capacity and availability before confirming a reservation.
The project demonstrates the **Facade Design Pattern**, which simplifies interaction between different services.

## Main Features

- View available offices and open spaces
- Book a space for a selected date and time
- Check room capacity
- Prevent double bookings
- Cancel existing reservations
- Display booking confirmations

## Facade Pattern

The main class is `BookingFacade.java`.

It connects four services:

- `SpaceService` — manages spaces
- `AvailabilityService` — checks booking conflicts
- `ReservationService` — creates and cancels bookings
- `NotificationService` — displays confirmations

Instead of calling each service separately, the client uses the `BookingFacade` class.

## Clean Code Principles

The project follows several Clean Code principles:

1. **Meaningful Names** — classes and methods have clear names.
2. **Single Responsibility** — each service has its own task.
3. **Encapsulation** — class fields are private.
4. **Error Handling** — invalid bookings are handled using exceptions.
5. **Simple Interface** — the Facade hides the complexity of the booking process.

## How to Run

1. Open the project in IntelliJ IDEA.
2. Make sure Java JDK 17 or newer is installed.
3. Open `Main.java`.
4. Run the `main()` method.
5. Check the booking results in the console.

The system uses in-memory data, so reservations are reset when the program restarts.

## UML Diagram

The class diagram is available in `docs/uml 4.png`.

## Conclusion

This assignment helped me understand how the Facade Pattern works in Java. By using one simple interface, the booking process becomes easier to use, while each service remains responsible for its own functionality.