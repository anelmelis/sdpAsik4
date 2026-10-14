import java.time.LocalDateTime;
public class Reservation {
    private final int reservationId;
    private final int spaceId;
    private final String customerName;
    private final int attendees;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public Reservation(int reservationId, int spaceId,
                       String customerName, int attendees,
                       LocalDateTime startTime, LocalDateTime endTime) {

        if (reservationId <= 0 || spaceId <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }

        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("Customer name is required");
        }

        if (attendees <= 0) {
            throw new IllegalArgumentException("Invalid number of attendees");
        }

        if (startTime == null || endTime == null
                || !endTime.isAfter(startTime)) {
            throw new IllegalArgumentException("Invalid booking time");
        }

        this.reservationId = reservationId;
        this.spaceId = spaceId;
        this.customerName = customerName;
        this.attendees = attendees;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getReservationId() {
        return reservationId;
    }

    public int getSpaceId() {
        return spaceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getAttendees() {
        return attendees;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId
                + " | Space ID: " + spaceId
                + " | Customer: " + customerName
                + " | Attendees: " + attendees
                + " | From: " + startTime
                + " | To: " + endTime;
    }
}

