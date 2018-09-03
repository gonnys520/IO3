package domain;

public class Menu {

    private String code;
    private String name;
    private int price;
    private String image;

    public Menu(String code, String name, int price, String image) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
