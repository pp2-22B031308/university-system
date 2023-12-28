package charge;

import enums.*;
import users.TechSupportSpecialist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import additional.*;

public class TechSupportSpecialistCharge {

    public void acceptOrder(Order order) {
        System.out.println("Order accepted. Processing...");
        System.out.println("Order Details: " + order.toString());
        order.setStatus(OrderStatus.ACCEPTED);
        System.out.println("Order processed successfully.");
    }
    
    public static void sendTechSupportRequestToManager(TechSupportSpecialist techSupportSpecialist) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Order Details:");
        String details = br.readLine();
        Order order = new Order(details);
        System.out.println("Sending Tech Support Request to Manager...");
        ManagerСharge.receiveTechSupportRequest(techSupportSpecialist.getManager(), techSupportSpecialist, order);
    }
}
