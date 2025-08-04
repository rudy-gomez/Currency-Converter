package rudy.currencyconverter.model;
import java.util.Map;

public class ExchangeResponse {
    public String result;
    public String base_code;
    public Map<String, Double> conversion_rates;
}
