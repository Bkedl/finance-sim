import java.util.HashMap;
import java.util.Map;

public class MockInstrument {
    private static Map<String, Double> prices = new HashMap<>();

    // Random list I made via AI chat
    static {
        prices.put("AAPL", 172.55);
        prices.put("GOOGL", 136.75);
        prices.put("TSLA", 243.90);
        prices.put("AMZN", 133.50);
        prices.put("MSFT", 313.20);
        prices.put("NFLX", 408.25);
        prices.put("FB", 211.40);
        prices.put("NVDA", 280.10);
        prices.put("ADBE", 478.30);
        prices.put("PYPL", 84.65);
        prices.put("INTC", 54.20);
        prices.put("CSCO", 51.10);
        prices.put("ORCL", 97.50);
        prices.put("IBM", 138.75);
        prices.put("SAP", 128.90);
        prices.put("BABA", 102.40);
        prices.put("DIS", 95.60);
        prices.put("V", 220.80);
        prices.put("MA", 362.50);
        prices.put("TWTR", 62.30);
    }

    public static double getPrice(String symbol) {
        return prices.getOrDefault(symbol.toUpperCase(), 0.0);
    }
}