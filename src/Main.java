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
        // Cash usd = dollar.in("USD");
        // System.out.println("Dollar to Dollar: " + usd.toString());
        // Cash jpy = dollar.in("JPY");
        // System.out.println("Dollar to JPY: " + jpy.toString());
    }
}

//----------------Fake Exchange for Cash, Replace NYSE with FakeExchange-------------------------------
/**
 * Class FakeExchange is to avoid external API calls
 * return a fixed exchange rate for unit testing
 */
class FakeExchange implements Exchange {
    @Override
    public float rate(String origin, String target) {
        //System.out.println("Exchange requested: " + origin + " to " + target); // debug
        if (origin.equals(target)) {
            return 1.0f; 
        } 
        return 0.2f; // assume 1 USD = 0.2 Euro or other currency
    }
}