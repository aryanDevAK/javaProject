public class AstrologyInfo {
    private String rashi;
    private String ratan;
    private String day;
    private String dhatu;
    private String quantity;

    public AstrologyInfo(String rashi, String ratan, String day, String dhatu, String quantity) {
        this.rashi = rashi;
        this.ratan = ratan;
        this.day = day;
        this.dhatu = dhatu;
        this.quantity = quantity;
    }

    // Getters
    public String getRashi() { return rashi; }
    public String getRatan() { return ratan; }
    public String getDay() { return day; }
    public String getDhatu() { return dhatu; }
    public String getQuantity() { return quantity; }
}

