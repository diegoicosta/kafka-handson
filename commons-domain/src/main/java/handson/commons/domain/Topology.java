package handson.commons.domain;

/**
 * Created by diegoicosta on 26/03/17.
 */
public enum Topology {
    HANDSON_ORDER("handson.orders"),
    HANDSON_PAYMENT("handson.payments");

    private String name;

    Topology(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
