package handson.commons.domain;

import java.time.ZonedDateTime;
import java.util.Random;
import java.util.UUID;

/**
 * Created by diegoicosta on 26/03/17.
 */
public class Payment {
    private String id;
    private String sourceId;
    private Product product;
    private String transactionId;
    private long amount;
    private ZonedDateTime createdAt;
    private Status status;

    private static Random random = new Random();

    public static Payment buildRandom(Order order) {
        Payment payment = new Payment();
        payment.id = IdBuilder.generate("PAY");
        payment.sourceId = order.getId();
        payment.product = Product.ORDER;
        payment.setAmount(order.getAmount());
        payment.createdAt = ZonedDateTime.now();
        payment.transactionId = UUID.randomUUID().toString();
        int statusIndex = random.nextInt(2);
        payment.status = Status.values()[statusIndex];
        return payment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean isAuthorized() {
        return status.equals(Status.AUTHORIZED);
    }

    public enum Status {
        AUTHORIZED,
        DENIED
    }

    public enum Product {
        ORDER,
        INVOICE,
        SUBSCRIPTION
    }

    @Override
    public String toString() {
        return "Payment{" + "id='" + id + '\'' + ", sourceId='" + sourceId + '\'' + ", product=" + product
                + ", transactionId='" + transactionId + '\'' + ", amount=" + amount + ", createdAt=" + createdAt
                + ", status=" + status + '}';
    }
}
