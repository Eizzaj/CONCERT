import java.util.ArrayList;
import java.util.Stack;

public class ConcertBooking {
    private ArrayList<ConcertTicket> bookedTickets;
    private Stack<ConcertTicket> ticketStack;

    public ConcertBooking() {
        bookedTickets = new ArrayList<>();
        ticketStack = new Stack<>();
    }

    public boolean bookTicket(ConcertTicket ticket) {
        if (isBooked(ticket)) {
            return false;
        } else {
            bookedTickets.add(ticket);
            ticketStack.push(ticket);
            return true;
        }
    }

    public ConcertTicket undoLastBooking() {
        if (!ticketStack.isEmpty()) {
            ConcertTicket last = ticketStack.pop();
            bookedTickets.remove(last);
            return last;
        }
        return null;
    }

    public ArrayList<ConcertTicket> getBookedTickets() {
        return bookedTickets;
    }

    public boolean isBooked(ConcertTicket ticket) {
        for (ConcertTicket t : bookedTickets) {
            if (t.equals(ticket)) return true;
        }
        return false;
    }
}
