public class Main {
    public static void main(String[] args) {
        // Unit Test for Cash class

        // Test setup
        // Exchange exchange = new NYSE("someAccessKey");
        Exchange exchange = new FakeExchange(); 
        Cash dollar = new Cash(exchange, 100);
        System.out.println("Dollar: " + dollar.toString());

        // Test 'in' method of Cash
        Cash euro = dollar.in("Euro");
        System.out.println("Dollar to Euro: " + euro.toString());
        Cash usd = dollar.in("USD");
        System.out.println("Dollar to Dollar: " + usd.toString());
        Cash jpy = dollar.in("JPY");
        System.out.println("Dollar to JPY: " + jpy.toString());
    }
}

//----------------Fake Exchange for Cash, Replace NYSE with FakeExchange---------------------------------
/**
 * Class FakeExchange is to avoid external API calls
 */
class FakeExchange implements Exchange {
    @Override
    public float rate(String origin, String target) {
        //System.out.println("Exchange requested: " + origin + " to " + target); // debug
        // return a fixed exchange rate for unit testing
        if (origin.equals("USD") && target.equals("Euro")) {
            return 0.2f; // assume 1 USD = 0.2 Euro
        } else if (origin.equals(target)){
            return 1.0f; // if same currency, so 1:1 conversion
        }
        throw new IllegalArgumentException("Exchange rate is not available for " + origin + " to " + target);
    }
}