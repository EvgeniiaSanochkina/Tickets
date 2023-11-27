import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketTest {

    Ticket ticket1 = new Ticket(1, 7000, "NOVOSIBIRSK", "MOSCOW", 240);
    Ticket ticket2 = new Ticket(2, 10000, "MOSCOW", "BERLIN", 240);
    Ticket ticket3 = new Ticket(3, 25000, "BERLIN", "BEIJING", 480);
    Ticket ticket4 = new Ticket(4, 16000, "BEIJING", "NOVOSIBIRSK", 240);
    Ticket ticket5 = new Ticket(5, 20000, "MOSCOW", "BERLIN", 240);
    Ticket ticket6 = new Ticket(6, 15000, "MOSCOW", "BERLIN", 240);

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    @Test
    public void shouldAdd() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        Ticket[] actual = manager.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnSpecificTickets() {
        String from = "MOSCOW";
        String to = "BERLIN";
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] actual = manager.findAll(from, to);
        Ticket[] expected = {ticket2, ticket6, ticket5};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveById() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket5);
        Ticket[] actual = manager.remove(5);
        Ticket[] expected = {ticket1, ticket2};
        Assertions.assertArrayEquals(expected, actual);
    }
}

