package codingQuestions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class streamGroupBy {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<Order> l = new ArrayList<>();
        l.add(new Order("Rohit", 100));
        l.add(new Order("Rohit", 10));
        l.add(new Order("Neha", 120));

        Map<String, Integer> hm = l.stream().collect(Collectors.groupingBy(Order::getCustomerEmail,
                Collectors.summingInt(Order::getAmount)
        ));

        hm = hm.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue())
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(hm);


    }
}

class Order {
    String customerEmail;
    Integer amount;

    public Order(String customerEmail, Integer amount) {
        this.customerEmail = customerEmail;
        this.amount = amount;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


}
