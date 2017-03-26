package handson.commons.domain;

import java.time.ZonedDateTime;
import java.util.Random;

/**
 * Created by diegoicosta on 25/03/17.
 */
public class Order {

    private String id;
    private String accountId;
    private long amount;
    private ZonedDateTime createdAt;
    private Status status;

    private static Random random = new Random();

    public static Order buildRandom(String[] accounts) {
        Order order = new Order();
        String mpa = accounts[random.nextInt(5)];
        order.accountId = mpa;
        order.amount = random.nextInt(10000);
        order.createdAt = ZonedDateTime.now();
        order.status = Status.CREATED;
        order.id = IdBuilder.generate("ORD");
        return order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        CREATED,
        PAID,
        CANCELLED
    }
}
