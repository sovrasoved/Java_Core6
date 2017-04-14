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
    User user_o;

    public Order(long id, int price, Currency currency, String itemName, String shopIdentificator, User user_o) {
        this.id = id;
        this.price = price;
        this.currency = currency;
        this.itemName = itemName;
        this.shopIdentificator = shopIdentificator;
        this.user_o = user_o;
    }


    public long getId() {
        return id;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (price != order.price) return false;
        if (currency != order.currency) return false;
        if (itemName != null ? !itemName.equals(order.itemName) : order.itemName != null) return false;
        if (shopIdentificator != null ? !shopIdentificator.equals(order.shopIdentificator) : order.shopIdentificator != null)
            return false;
        return user_o != null ? user_o.equals(order.user_o) : order.user_o == null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public String getItemName() {
        return itemName;
    }

    public String getShopIdentificator() {
        return shopIdentificator;
    }

    public User getUser_o() {
        return user_o;
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
                ", user_o=" + user_o +
                '}';
    }
}
