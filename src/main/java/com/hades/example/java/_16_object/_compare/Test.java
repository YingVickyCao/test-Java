package com.hades.example.java._16_object._compare;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
//        test.testEquals();
        test.testCompare();
    }

    private void testEquals() {
        Stu stu = new Stu(25, "A", 1000);
        Stu stu2 = new Stu("A", 1000);
        Stu stu3 = new Stu("B", 1000);

        System.out.println(stu.equals(stu));    // true
        System.out.println(stu.equals(stu2));   // true
        System.out.println(stu.equals(stu3));   // false
        System.out.println(stu2.equals(stu3));  // false
    }

    private void testCompare() {
        {
            List<DownloadItem> list = new ArrayList<>();
            list.add(new DownloadItem(true, 10, "Item_1"));
            list.add(new DownloadItem(true, 9, "Item_2"));

//            Collections.sort(list);
            sortList(list);

            // [DownloadItem{isSaved=true, num=9, name='Item_1'}, DownloadItem{isSaved=true, num=10, name='Item_1'}]
            System.out.println(Arrays.toString(list.toArray()));
        }
        {

            List<DownloadItem> list = new ArrayList<>();
            list.add(new DownloadItem(false, 10, "Item_1"));
            list.add(new DownloadItem(true, 10, "Item_2"));

//            Collections.sort(list);
            sortList(list);

            // [DownloadItem{isSaved=false, num=10, name='Item_1'}, DownloadItem{isSaved=true, num=10, name='Item_2'}]
            System.out.println(Arrays.toString(list.toArray()));
        }
        {
            List<DownloadItem> list = new ArrayList<>();
            list.add(new DownloadItem(true, 10, "Item_1"));
            list.add(new DownloadItem(false, 5, "Item_2"));
            list.add(new DownloadItem(true, 5, "Item_2"));

//            Collections.sort(list);
            sortList(list);
            // [DownloadItem{isSaved=false, num=5, name='Item_2'}
            // , DownloadItem{isSaved=true, num=5, name='Item_2'}
            // , DownloadItem{isSaved=true, num=10, name='Item_1'}]
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    private void sortList(List<DownloadItem> list) {
        Collections.sort(list, new Comparator<DownloadItem>() {
            @Override
            public int compare(DownloadItem o1, DownloadItem o2) {
                /**
                 * ASC
                 */
                // this= Second one
                // o = First one
                if (o1.isSaved && !o2.isSaved) {
                    return 1;
                }
                if (!o1.isSaved && o2.isSaved) {
                    return -1;
                }
                return Integer.compare(o1.num, o2.num);

//                return o1.name.compareTo(o2.name);
//                return 0;
            }
        });
    }

}
