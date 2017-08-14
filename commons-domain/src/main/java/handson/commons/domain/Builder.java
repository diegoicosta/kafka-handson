package handson.commons.domain;

import handson.commons.domain.avro.*;

import java.time.ZonedDateTime;
import java.util.Random;
import java.util.UUID;

/**
 * Created by diegoicosta on 14/08/17.
 */
public class Builder {

    public static PaymentFull buildPaymentFull(Payment payment, Order order) {
        return new PaymentFull(
                payment.getId(),
                payment.getProductId(),
                payment.getTransaction(),
                payment.getProductType(),
                payment.getAmount(),
                payment.getStatus(),
                payment.getCreatedAt(),
                order.getAccountId()
        );
    }

    public static Order orderAfterPay(final Order order, final Payment payment) {
        Order orderUpdate = new Order();
        orderUpdate.setId(order.getId());
        orderUpdate.setAmount(order.getAmount());
        orderUpdate.setAccountId(order.getAccountId());
        orderUpdate.setCreatedAt(order.getCreatedAt());
        orderUpdate.setStatus(
                payment.getStatus().equals(PaymentStatus.AUTHORIZED) ? OrderStatus.PAID : OrderStatus.CANCELLED);

        return orderUpdate;
    }

    public static Order buildRandom(String[] accounts) {
        Random random = new Random();

        Order order = new Order();
        String mpa = accounts[random.nextInt(5)];
        order.setAccountId(mpa);
        order.setAmount(((Integer) random.nextInt(10000)).longValue());
        order.setCreatedAt(ZonedDateTime.now().toEpochSecond());
        order.setStatus(OrderStatus.CREATED);
        order.setId(IdBuilder.generate("ORD"));
        return order;
    }

    public static Payment buildRandom(Order order) {
        Random random = new Random();
        Payment payment = new Payment();
        payment.setId(IdBuilder.generate("PAY"));
        payment.setProductId(order.getId());
        payment.setProductType(ProductType.ECOMMERCE);
        payment.setAmount(order.getAmount());
        payment.setCreatedAt(ZonedDateTime.now().toEpochSecond());
        payment.setTransaction(UUID.randomUUID().toString());
        payment.setStatus(PaymentStatus.values()[random.nextInt(2)]);
        return payment;
    }
}
