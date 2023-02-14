package com.hades.java.example._generic_type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _5_Use_Wildcard {
    public static void main(String[] args) {
        _5_Use_Wildcard example = new _5_Use_Wildcard();
        example.test();
    }

    private void test() {
        {
            {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(3);
                printList(list);
            }

            {
                List<String> list = new ArrayList<>();
                list.add("A");
                list.add("B");
                list.add("C");
                printList(list);
            }

            {
                List list = new ArrayList<>();
                list.add(1);
                list.add("A");
                printList(list);
            }
        }
        {
            {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(3);

                /**
                 * Error : Compile error
                 *  Required type:List<Object>
                 * Provided:List<Integer>
                 */
//                printList2(list);
            }

            {
                List<Object> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(3);
                printList2(list);
            }

            {
                List<Object> list = new ArrayList<>();
                list.add("A");
                list.add("B");
                list.add("C");
                printList2(list);
            }

            {
                List<Object> list = new ArrayList<>();
                list.add(1);
                list.add("A");
                printList(list);
            }
        }

        {

            {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(3);
                printList3(list);
            }

            {
                List<String> list = new ArrayList<>();
                list.add("A");
                list.add("B");
                list.add("C");
                printList3(list);
            }

            {
                List<Object> list = new ArrayList<>();
                list.add(1);
                list.add("A");
                printList(list);
            }

            {
                List<?> list = new ArrayList<String>();
                /**
                 * Error : Compile error
                 * Required type:capture of ?
                 * Provided:Object
                 */
                // list.add(new Object());

                list.add(null);

                /**
                 * Error : Compile error
                 * Required type:capture of ?
                 * Provided:String
                 */
//                list.add("ag");
            }
        }


    }

    /**
     * 不使用泛型
     *
     * @param list List<任何类类型> / List, list可以接收元素
     */
    private void printList(List list) {
        Iterator iterator = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 不使用泛型
     *
     * @param list 只能传 List<Object>，list可以接收元素
     */
    private void printList2(List<Object> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    /**
     * 使用通配符?
     * <p>
     * 通配符？:
     * 表示该集合存储的元素类型未知，可以是任何类型。往集合中加入元素需要是一个未知元素类型的子类型，正因为该集合存储的元素类型未知，
     * 所以我们没法向该集合中添加任何元素。唯一的例外是null，因为null是所有类型的子类型，所以尽管元素类型不知道，但是null一定是它的子类型。
     * 因此：通配符？, 只能用在一个函数的形参，不能用在实惨。否则，只能添加null，不能添加除了null之前的任何元素。
     *
     * 即使如此，实际开发中也不会使用List<?>。因为数组的本身含义是一组相同的类型，没有必要使用List<?>，而是使用List<具体类型>
     *
     * @param list List<任何类类型>, list可以接收元素
     */
    private void printList3(List<?> list) {
        Iterator<?> iterator = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(iterator.next());
        }

        for (Object item : list) {
            System.out.println(item);
        }
    }
}
