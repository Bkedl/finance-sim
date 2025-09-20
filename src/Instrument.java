public class Instrument {
    private String name;
    private String symbol;
    private double price;

    /* 'Instrument' refers to anything that holds information
    about a stock or financial instrument */
    public Instrument(String name, String symbol, double price) {
        this.name = name;
        this.symbol = symbol;
        this.price = price;
    }

    // Getters
    public String getName() { return name; }
    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }

    // Update price dynamically from MockInstrument class
    public void updatePrice() {
        this.price = MockInstrument.getPrice(this.symbol);
    }

    @Override
    public String toString() {
        return name + " (" + symbol + ") - $" + price;
    }
}
