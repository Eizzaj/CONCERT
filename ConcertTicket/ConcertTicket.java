public class ConcertTicket {
    String section;
    String seat;

    public ConcertTicket(String section, String seat) {
        this.section = section;
        this.seat = seat;
    }

    @Override
    public String toString() {
        return section + " - Seat " + seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConcertTicket)) return false;
        ConcertTicket other = (ConcertTicket) o;
        return section.equals(other.section) && seat.equals(other.seat);
    }
}
