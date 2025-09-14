import java.util.*;

class Product {
    int id;
    String name;
    double price;
    int stock;

    Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String toString() {
        return id + " - " + name + " | Gia: " + price + " | Ton kho: " + stock;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Danh sach san pham
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 1000, 10));
        products.add(new Product(2, "Dien thoai", 800, 20));
        products.add(new Product(3, "Ao thun", 20, 50));

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Xem san pham");
            System.out.println("2. Mua san pham");
            System.out.println("3. Thoat");
            System.out.print("Chon: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                // Hien thi san pham
                for (Product p : products) {
                    System.out.println(p);
                }
            } else if (choice == 2) {
                System.out.print("Nhap ID san pham: ");
                int id = sc.nextInt();
                Product found = null;
                for (Product p : products) {
                    if (p.id == id) {
                        found = p;
                        break;
                    }
                }
                if (found != null) {
                    System.out.print("Nhap so luong: ");
                    int qty = sc.nextInt();
                    if (qty <= found.stock) {
                        double total = qty * found.price;
                        found.stock -= qty;
                        System.out.println("Mua thanh cong! Tong tien: " + total);
                    } else {
                        System.out.println("Khong du hang ton kho!");
                    }
                } else {
                    System.out.println("San pham khong ton tai!");
                }
            } else if (choice == 3) {
                System.out.println("Cam on da su dung!");
                break;
            } else {
                System.out.println("Lua chon khong hop le!");
            }
        }

        sc.close();
    }
}
