package hello.itemservice.domain.item;

import hello.itemservice.domain.item.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository // @Component -> 싱글톤
public class ItemRepository {
    // 멀티쓰레드 환경에서는 갑이 꼬일 수 있으니 ConcurrentHashMap을 사용해야함
    // sequence 변수 또한 atomic long? 을 사용해서 다수의 접근 환경에서 값이 꼬이는 것을 방지해야함
    private static final Map<Long, Item> store = new HashMap<>(); //static 사용.
    private static long sequence = 0L; //static 사용.

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    // 보통은 ItemDto를 만들어서 updateparam에서 쓰지 않는 id 필드 값을 제외한 객체를 만들어서 사용해야함
    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}