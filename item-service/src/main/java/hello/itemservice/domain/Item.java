package hello.itemservice.domain;

import lombok.Data;

@Data // 보통 @Getter @Setter로 사용한다. @Data는 위험
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
