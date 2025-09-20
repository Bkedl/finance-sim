import java.time.LocalDate;

public class Transaction {
    private Instrument instrument;
    private int quantity;
    private LocalDate date;
    private String type; // "Buy" or "Sell"

    public Transaction(Instrument instrument, int quantity, LocalDate date, String type) {
        this.instrument = instrument;
        this.quantity = quantity;
        this.date = date;
        this.type = type;
    }

    public double getAmount() {
        return type.equalsIgnoreCase("Buy") ? -instrument.getPrice() * quantity
                : instrument.getPrice() * quantity;
    }

    public Instrument getInstrument() { return instrument; }
    public String getType() { return type; }
    public LocalDate getDate() { return date; }

    @Override
    public String toString() {
        return type + " " + quantity + " of " + instrument.getSymbol() + " at $" + instrument.getPrice() + " on " + date;
    }
}
