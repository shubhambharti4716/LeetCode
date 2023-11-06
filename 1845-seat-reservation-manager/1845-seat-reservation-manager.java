class SeatManager {

    boolean[] isSeatReserved;
    int nextSeat = 1;

    TreeSet<Integer> unreservedSeats = new TreeSet<>();

    public SeatManager(int n) {
        isSeatReserved = new boolean[n+1];
    }

    public int reserve() {
        int seat;
        if (unreservedSeats.isEmpty()) {
            seat = nextSeat;
            nextSeat++;
        } else {
            seat = unreservedSeats.first();
            unreservedSeats.remove(seat);
        }
        return seat;
    }

    public void unreserve(int seatNumber) {
        isSeatReserved[seatNumber] = false;
        unreservedSeats.add(seatNumber);
    }
}