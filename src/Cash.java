public class Cash {
    private Exchange exchange;
    private int cents;

    public Cash(Exchange exchange, int cents) {
        this.exchange = exchange;
        this.cents = cents;
    }

    public Cash in(String currency) {
        return new Cash(this.exchange,
                Math.round(this.cents *
                        this.exchange.rate("USD", currency)
                )
        );
    }

    @Override
    public String toString() {
        return "Cash{" +
                //"exchange=" + exchange.getClass().getSimpleName() + //debug
                "exchange=" + exchange +
                ", cents=" + cents +
                '}';
    }
}
