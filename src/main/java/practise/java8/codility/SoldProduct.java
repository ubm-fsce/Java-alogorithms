package practise.java8.codility;

import java.math.BigDecimal;
import java.util.Objects;

class SoldProduct {

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SoldProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoldProduct that = (SoldProduct) o;
        return Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, currency);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    String name;
    BigDecimal price;
    String currency;
}
