import java.util.Arrays;

public class TicketManager {
    TicketTimeComparator timeComparator = new TicketTimeComparator();
    Ticket[] tickets = new Ticket[0];
    public TicketRepository repo;
    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.add(ticket);
    }

    public Ticket[] remove(int id) {
        repo.removeById(id);
        return repo.getAll();
    }
    public Ticket[] findAll() {
        return repo.getAll();
    }


    public Ticket[] findAll(String from, String to, TicketTimeComparator timeComparator) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getAll()) {
            if (((ticket.getDeparture()).equals(from)) && (ticket.getArrival()).equals(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for(int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                Arrays.sort(tmp, timeComparator);
                result = tmp;
            }
        } return result;
    }

}
