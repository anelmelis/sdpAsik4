import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        BookingFacade booking = new BookingFacade();
        System.out.println("=== BUILDING SPACE BOOKING SYSTEM ===");


        System.out.println("\n--- ALL SPACES ---");
        for (Space space : booking.getAllSpaces()) {
            System.out.println(space);
        }

        LocalDate date = LocalDate.now().plusDays(1);

        LocalDateTime start = date.atTime(14, 0);
        LocalDateTime end = date.atTime(16, 0);


        System.out.println("\n--- TEST 1: SUCCESSFUL BOOKING ---");
        Reservation firstBooking = booking.bookSpace(
                101,
                "AiTu Team",
                5,
                start,
                end
        );


        System.out.println("\n--- TEST 2: DOUBLE BOOKING ---");
        try {
            booking.bookSpace(
                    101,
                    "Pururu Team",
                    4,
                    date.atTime(15, 0),
                    date.atTime(17, 0)
            );
        } catch (IllegalStateException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }





        System.out.println("\n--- TEST 3: CAPACITY CHECK ---");
        try {
            booking.bookSpace(
                    101,
                    "Large Company",
                    20,
                    date.atTime(17, 0),
                    date.atTime(18, 0)
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }





        System.out.println("\n--- TEST 4: CANCELLATION ---");

        booking.cancelBooking(firstBooking.getReservationId());





        System.out.println("\n--- TEST 5: BOOK AFTER CANCELLATION ---");

        booking.bookSpace(
                101,
                "Pururu Team",
                4,
                date.atTime(15, 0),
                date.atTime(17, 0)
        );

        System.out.println("\n=== ALL TESTS COMPLETED ===");
    }
}

