package practise.java8.codility;

import java.math.BigDecimal;

public class SoldProductsAggregate {
    @Value
    class SoldProductsAggregate {

        public List<SimpleSoldProduct> getProducts() {
            return products;
        }

        public void setProducts(List<SimpleSoldProduct> products) {
            this.products = products;
        }

        public BigDecimal getTotal() {
            return total;
        }

        public void setTotal(BigDecimal total) {
            this.total = total;
        }

        List<SimpleSoldProduct> products;
        BigDecimal total;
    }
}
