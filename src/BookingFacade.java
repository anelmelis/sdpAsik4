import java.time.LocalDateTime;
import java.util.List;

public class BookingFacade {
    private final SpaceService spaceService;
    private final AvailabilityService availabilityService;
    private final ReservationService reservationService;
    private final NotificationService notificationService;

    public BookingFacade() {
        this.spaceService = new SpaceService();
        this.availabilityService = new AvailabilityService();
        this.reservationService = new ReservationService();
        this.notificationService = new NotificationService();
    }

    public List<Space> getAllSpaces() {
        return spaceService.getAllSpaces();
    }

    public Reservation bookSpace(int spaceId,
                                 String customerName,
                                 int attendees,
                                 LocalDateTime startTime,
                                 LocalDateTime endTime) {

        Space space = spaceService.findSpaceById(spaceId);

        if (space == null) {
            throw new IllegalArgumentException("Space not found: " + spaceId);
        }





        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("Customer name is required");
        }

        if (attendees <= 0 || attendees > space.getCapacity()) {
            throw new IllegalArgumentException("Invalid number of attendees");
        }

        if (startTime == null || endTime == null
                || !endTime.isAfter(startTime)) {
            throw new IllegalArgumentException("Invalid booking time");
        }







        boolean available = availabilityService.isAvailable(
                spaceId,
                startTime,
                endTime,
                reservationService.getAllReservations()
        );

        if (!available) {
            throw new IllegalStateException(
                    "Space is already booked for the selected time"
            );
        }







        Reservation reservation = reservationService.createReservation(
                spaceId,
                customerName,
                attendees,
                startTime,
                endTime
        );





        notificationService.sendBookingConfirmation(reservation, space);
        return reservation;
    }

    public boolean cancelBooking(int reservationId) {
        boolean cancelled = reservationService.cancelReservation(reservationId);
        if (cancelled) {
            notificationService.sendCancellationConfirmation(reservationId);
        }
        return cancelled;
    }
}
