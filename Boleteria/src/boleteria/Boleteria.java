package boleteria;

import Views.Loggin;
import main.Admin;
import Views.TicketSales;
/**
 *
 * @author Manuel
 */
public class Boleteria {


    public static void main(String[] args) {
        /**
        System.out.println("Rober mi lider");
        TicketSales ticket = new TicketSales();
        ticket.setVisible(true);
        ticket.setResizable(false);
        ticket.setLocationRelativeTo(null);
        
        /**Loggin log = new Loggin();
        log.setVisible(true);
        log.setResizable(false);
        log.setLocationRelativeTo(null);*/

        Admin log = new Admin();
        log.setVisible(true);
        log.setResizable(false);
        log.setLocationRelativeTo(null);
    }
    
}
