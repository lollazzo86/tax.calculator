public class Runner {

    public static void main(String[] args){

        Product p1 = new Product(ProductType.book, ProductSource.national, "book", 12.49);
        Product p2 = new Product(ProductType.generic, ProductSource.national, "music CD", 14.99);
        Product p3 = new Product(ProductType.food, ProductSource.national, "chocolate bar", 0.85);
        Cart cart1 = new Cart(new CartEntry(p1, 1), new CartEntry(p2, 1), new CartEntry(p3, 1));
        printReceiptForCart(cart1);

        Product p4 = new Product(ProductType.food, ProductSource.imported, "imported box of chocolates", 10.00);
        Product p5 = new Product(ProductType.generic, ProductSource.imported, "imported bottle of perfume", 47.50);
        Cart cart2 = new Cart(new CartEntry(p4, 1), new CartEntry(p5, 1));
        printReceiptForCart(cart2);

        Product p6 = new Product(ProductType.generic, ProductSource.imported, "imported bottle of perfume", 27.99);
        Product p7 = new Product(ProductType.generic, ProductSource.national, "bottle of perfume", 18.99);
        Product p8 = new Product(ProductType.medical, ProductSource.national, "packet of headache pills", 9.75);
        Product p9 = new Product(ProductType.food, ProductSource.imported, "box of imported chocolates", 11.25);
        Cart cart3 = new Cart(new CartEntry(p6, 1), new CartEntry(p7, 1), new CartEntry(p8, 1), new CartEntry(p9, 1));
        printReceiptForCart(cart3);
    }

    private static void printReceiptForCart(Cart cart){
        if (cart != null && cart.getCartEntries() != null && cart.getCartEntries().size() > 0){
            System.out.println("-----------------------------------");
            for (CartEntry cartEntry : cart.getCartEntries()){
                System.out.println(cartEntry.getQuantity() + " " + cartEntry.getProduct().getName() + ": " + cartEntry.getTotalPriceWithTax());
            }
            System.out.println("Sales Taxes: " + cart.getTotalTax());
            System.out.println("Total: " + cart.getTotalPriceWithTax());
        }
    }
}