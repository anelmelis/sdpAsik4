import java.time.LocalDateTime;
import java.util.List;

public class AvailabilityService {
    public boolean isAvailable(int spaceId,
                               LocalDateTime startTime,
                               LocalDateTime endTime,
                               List<Reservation> reservations) {

        if (startTime == null || endTime == null
                || !endTime.isAfter(startTime)) {
            throw new IllegalArgumentException("Invalid booking time");
        }
        if (reservations == null) {
            throw new IllegalArgumentException("Reservations list cannot be null");
        }

        for (Reservation reservation : reservations) {
            if (reservation.getSpaceId() == spaceId) {
                boolean overlaps =
                        startTime.isBefore(reservation.getEndTime())
                                && endTime.isAfter(reservation.getStartTime());
                if (overlaps) {
                    return false;
                }
            }
        }
        return true;
    }
}
