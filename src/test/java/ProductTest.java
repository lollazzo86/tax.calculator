import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    /**
     * check that price is set and read correctly on Product
     */
    @Test
    public void getPrice(){
        Product product = new Product(ProductType.book, ProductSource.national, "product1", 12.34);
        assertEquals(BigDecimal.valueOf(12.34).compareTo(product.getPrice()), 0);
    }

    /**
     * check that all different taxes are correctly calculated given a Product
     */
    @Test
    public void calculateTax() {
        // product with no tax
        Product pNoTax = new Product(ProductType.book, ProductSource.national, "productNoTax", 12.34);
        assertEquals(pNoTax.calculateTax().compareTo(Tax.noTax.getRate()), 0);

        // product with sales tax
        Product pSales = new Product(ProductType.generic, ProductSource.national, "product1", 12.34);
        BigDecimal pSalesTax = NumberUtils.round(Tax.salesTax.getRate().multiply(pSales.getPrice()));
        assertEquals(pSalesTax.compareTo(pSales.calculateTax()), 0);

        // product with import tax
        Product pImport = new Product(ProductType.medical, ProductSource.imported, "product1", 12.34);
        BigDecimal pImportTax = NumberUtils.round(Tax.importTax.getRate().multiply(pImport.getPrice()));
        assertEquals(pImportTax.compareTo(pImport.calculateTax()), 0);

        // product with both sales and import tax
        Product pBoth = new Product(ProductType.generic, ProductSource.imported, "product1", 12.34);
        BigDecimal pBothTax = NumberUtils.round(Tax.importTax.getRate().multiply(pBoth.getPrice())).add(NumberUtils.round(Tax.salesTax.getRate().multiply(pBoth.getPrice())));
        assertEquals(pBothTax.compareTo(pBoth.calculateTax()), 0);
    }
}
