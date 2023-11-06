class SeatManager {
    constructor(n) {
        this.last = 0;
        this.pq = [];
    }

    reserve() {
        if (this.pq.length === 0) {
            return ++this.last;
        } else {
            this.pq.sort((a, b) => a - b);
            return this.pq.shift();
        }
    }

    unreserve(seatNumber) {
        if (seatNumber === this.last) {
            this.last--;
        } else {
            this.pq.push(seatNumber);
        }
    }
}