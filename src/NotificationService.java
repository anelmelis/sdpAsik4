import java.time.format.DateTimeFormatter;

public class NotificationService {
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public void sendBookingConfirmation(Reservation reservation, Space space) {
        if (reservation == null || space == null) {
            throw new IllegalArgumentException("Booking details cannot be null");
        }

        System.out.println("\n=== BOOKING CONFIRMED ===");
        System.out.println("Reservation ID: " + reservation.getReservationId());
        System.out.println("Customer: " + reservation.getCustomerName());
        System.out.println("Space: " + space.getName());
        System.out.println("Type: " + space.getType());
        System.out.println("Attendees: " + reservation.getAttendees());
        System.out.println("Start: " + reservation.getStartTime().format(formatter));
        System.out.println("End: " + reservation.getEndTime().format(formatter));
        System.out.println("=========================\n");
    }

    public void sendCancellationConfirmation(int reservationId) {
        System.out.println("\n=== BOOKING CANCELLED ===");
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Your booking has been cancelled successfully.");
        System.out.println("=========================\n");
    }
}
