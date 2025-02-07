package basic.Ch06_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionSortTest {
    public static void main(String[] args) {
        //ArrayList를 이용한 정렬
        List<Item> list = new ArrayList<>();
        list.add(new Item(3,"66"));
        list.add(new Item(2,"77"));
        list.add(new Item(5,"33"));
        list.add(new Item(8,"44"));

        System.out.println(list);

        //#1. Comparable
//        Collections.sort(list); //implements Comparable한 객체가 아닌 경우 컴파일 에러 발생
//        System.out.println(list);

        //#2. Comparator 인터페이스 구현 - lambda
        Collections.sort(list, (o1, o2) -> o1.itemId - o2.itemId);
        System.out.println(list);
    }

    //#1. Comparable
        static class Item implements Comparable<Item> {
        int itemId;
        String itemName;

        Item(int itemId, String itemName) {
            this.itemId = itemId;
            this.itemName = itemName;
        }

        @Override
        public String toString() {
            return "Item [itemId=" + itemId + ", itemName=" + itemName + "]";
        }

        @Override
        public int compareTo(Item o) { //정렬 기준 제공
//            return this.itemId - o.itemId; //natural ordering
//            return o.itemId - this.itemId; //natural ordering
//            return this.itemName.compareTo(o.itemName);
            //itemId 우성 비교하는데 같은 값이면 itemName 비교
            return this.itemId == o.itemId ? this.itemName.compareTo(o.itemName) : this.itemId - o.itemId;
        }
    }
}