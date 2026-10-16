import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private final List<Reservation> reservations = new ArrayList<>();
    private int nextReservationId = 1;

    public Reservation createReservation(int spaceId,
                                         String customerName,
                                         int attendees,
                                         LocalDateTime startTime,
                                         LocalDateTime endTime) {

        Reservation reservation = new Reservation(
                nextReservationId,
                spaceId,
                customerName,
                attendees,
                startTime,
                endTime
        );

        reservations.add(reservation);
        nextReservationId++;
        return reservation;
    }

    public List<Reservation> getAllReservations() {
        return List.copyOf(reservations);
    }

    public boolean cancelReservation(int reservationId) {
        return reservations.removeIf(
                reservation -> reservation.getReservationId() == reservationId
        );
    }
}
