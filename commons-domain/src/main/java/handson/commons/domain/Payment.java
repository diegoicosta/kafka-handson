package handson.commons.domain;

import java.time.ZonedDateTime;
import java.util.Random;

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

    public enum Status {
        AUTHORIZED,
        DENIED
    }

    public enum Product {
        ORDER,
        INVOICE,
        SUBSCRIPTION
    }

}
