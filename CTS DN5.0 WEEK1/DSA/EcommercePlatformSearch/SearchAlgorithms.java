
import java.util.*;

public class SearchAlgorithms {

    public static Product linearSearch(Product[] product, int productId) {

        for (int i = 0; i < product.length; i++) {
            if (product[i].productId == productId) {
                return product[i];
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] product, int productId) {
        // int mid = product.length/2;
        int l = 0;
        int r = product.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (product[mid].productId == productId) {
                return product[mid];
            } else if (product[mid].productId > productId) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return null;
    }

    public static void main(String args[]) {

        Product[] product = {
                new Product(101, "Laptop", "Electronics"),
                new Product(103, "Shoes", "Clothing"),
                new Product(102, "Watch", "Accesories"),
                new Product(104, "TV", "Electronics"),
                new Product(100, "Pick Axe", "Minecraft")
        };

        System.out.println("Linear Search Execution: ");
        Product result1 = linearSearch(product, 102);
        System.out.println("Product Found " + result1);

        Arrays.sort(product, (p1, p2) -> p1.productId - p2.productId);
        System.out.println("Binary Search Execution");
        Product result2 = binarySearch(product, 102);
        System.out.println("Product Found " + result2);
    }
}
