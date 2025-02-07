package basic.Ch06_sort;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySortTest {
    public static void main(String[] args) {
//        //배열 정렬
//        int[] intArray = {3, 5, 2 ,7, 9, 4};
//
//        //int
//        System.out.println(Arrays.toString(intArray));
//        Arrays.sort(intArray);
//        System.out.println(Arrays.toString(intArray));
//
//        //String
//        String[] strArray = {"Hello", "UPlus", "URECA", "World"};
//        System.out.println(Arrays.toString(strArray));
//        Arrays.sort(strArray);
//        System.out.println(Arrays.toString(strArray));
//        Arrays.sort(strArray, Collections.reverseOrder()); //역정렬
//        System.out.println(Arrays.toString(strArray));

        //사용자 정의 클래스
        Item[] itemArray = {new Item(3, "66"), new Item(3, "77"), new Item(5, "44"), new Item(8, "11")};

        //#1 클래스에 정의
//        Arrays.sort(itemArray);
//        System.out.println(Arrays.toString(itemArray));

        //#2 Comparator 인터페이스 이용 - anonymous 객체
        //정렬 대상 클래스에 comparable 인터페이스 구현하지 않아도, 정렬 시점에 정렬 기준을 구현한 객체를 전달
//        Arrays.sort(itemArray, new Comparator<Item>() {
//            @Override
//            public int compare(Item o1, Item o2) {
//                return o1.itemId - o2.itemId; //natural ordering
//            }
//        });
//        System.out.println(Arrays.toString(itemArray));


        //#3 Comparator 인터페이스 이용 - lambda
        //정렬 대상 클래스에 comparable 인터페이스 구현하지 않아도, 정렬 시점에 정렬 기준을 구현한 객체를 전달
        Arrays.sort(itemArray, (o1, o2) -> o1.itemId == o2.itemId ? o1.itemName.compareTo(o2.itemName) : o1.itemId - o2.itemId);
        System.out.println(Arrays.toString(itemArray));
    }

    //객체들을 정렬할 때 기준이 필요
    //#1 클래스에 정의
//    static class Item implements Comparable<Item>{
//        int itemId;
//        String itemName;
//
//        Item(int itemId, String itemName) {
//            this.itemId = itemId;
//            this.itemName = itemName;
//        }
//
//        @Override
//        public String toString() {
//            return "Item [itemId=" + itemId + ", itemName=" + itemName + "]";
//        }
//
//        @Override
//        public int compareTo(Item o) { //정렬 기준 제공
////            return this.itemId - o.itemId; //natural ordering
////            return o.itemId - this.itemId; //natural ordering
////            return this.itemName.compareTo(o.itemName);
//            //itemId 우성 비교하는데 같은 값이면 itemName 비교
//            return this.itemId == o.itemId ? this.itemName.compareTo(o.itemName) : this.itemId - o.itemId;
//        }
//    }

    //#2 Comparator 인터페이스 이용
    static class Item{
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

    }
}
