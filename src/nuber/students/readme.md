# Nuber Simulator 

This project makes use of Java's multithreading capabilities to mimic concurrent ride dispatching:

- ExecutorService to handle several reservations concurrently.
- To securely manage available drivers, use LinkedBlockingQueue.
- Semaphore to regulate each region's active booking count.
- AtomicInteger for monitoring unique IDs and realtime booking counts.

Every reservation is a passenger's request for a driver. The driver becomes accessible once more after the system mimics the pickup, travel duration, and drop-off phases.


## Files Worked On

### Driver.java

Depicts a driver who:
- picks up a passenger following a random delay, and
- simulates driving to a destination. 

Once the trip is completed, the driver becomes available again.

### Booking.java

The class is in charge of:
- handling a booking process, which is created after a passenger requests a ride, 
- following which the system logs a creation, its pickup and arrival

Once, the booking is finished, a BookingResult is returned. 

### NuberDispach.java 

It acts as a central controller which manages:
- various regions and drivers,
- tracks bookings, both pending and ongoing, and

This controller class dispatches passengers to its region. 


### NuberRegion.java

The class represents:
- An active serving region,
- Keeps track of active bookings, and
- ensures shutdown of the region.