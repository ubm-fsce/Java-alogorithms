package practise.java8.codility;

import java.math.BigDecimal;
import java.util.Optional;

interface ExchangeService {
    Optional<BigDecimal> rate(String currency);
}