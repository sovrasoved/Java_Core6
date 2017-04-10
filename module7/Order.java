package module7;



/**
 * Created by sovra on 09.04.2017.
 */
public class Order {
    long id;
    int price;
    Currency currency;
    String itemName;
    String shopIdentificator;

    public Order(long id, int price, Currency currency, String itemName, String shopIdentificator) {
        this.id = id;
        this.price = price;
        this.currency = currency;
        this.itemName = itemName;
        this.shopIdentificator = shopIdentificator;
    }

    public String getItemName() {
        return itemName;
    }

    public String getShopIdentificator() {
        return shopIdentificator;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", currency=" + currency +
                ", itemName='" + itemName + '\'' +
                ", shopIdentificator='" + shopIdentificator + '\'' +
                '}';
    }
}
