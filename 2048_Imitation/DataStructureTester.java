public class DataStructureTester {

    private static SortedList testSortedList(SortedList sortedList) {
        System.out.println("Adding 7..");
        sortedList.add(7);
        System.out.println("Adding 9..");
        sortedList.add(9);
        System.out.println("Adding 2..");
        sortedList.add(2);
        System.out.println("Adding 6..");
        sortedList.add(6);
        System.out.println("Adding 3..");
        sortedList.add(3);
        System.out.println("Adding 5..");
        sortedList.add(5);

        System.out.println("Deleting an element..");
        int deleted = sortedList.delete();
        System.out.println("Deleted: " + deleted);
        System.out.println("Deleting an element..");
        deleted = sortedList.delete();
        System.out.println("Deleted: " + deleted);

        System.out.println("Top: " + sortedList.peek());
        System.out.println(sortedList.toString());
        System.out.println("Size: " + sortedList.size());
        return sortedList;
    }

    private static LifoList testLifoList(LifoList LifoList) {
        System.out.println("Adding 7..");
        LifoList.add(7);
        System.out.println("Adding 9..");
        LifoList.add(9);
        System.out.println("Adding 2..");
        LifoList.add(2);
        System.out.println("Adding 6..");
        LifoList.add(6);
        System.out.println("Adding 3..");
        LifoList.add(3);
        System.out.println("Adding 5..");
        LifoList.add(5);

        System.out.println("Deleting an element..");
        int deleted = LifoList.delete();
        System.out.println("Deleted: " + deleted);
        System.out.println("Deleting an element..");
        deleted = LifoList.delete();
        System.out.println("Deleted: " + deleted);

        System.out.println("Top: " + LifoList.peek());
        System.out.println(LifoList.toString());
        System.out.println("Size: " + LifoList.size());
        return LifoList;
    }

    private static FifoList testFifoList(FifoList FifoList) {
        System.out.println("Adding 7..");
        FifoList.add(7);
        System.out.println("Adding 9..");
        FifoList.add(9);
        System.out.println("Adding 2..");
        FifoList.add(2);
        System.out.println("Adding 6..");
        FifoList.add(6);
        System.out.println("Adding 3..");
        FifoList.add(3);
        System.out.println("Adding 5..");
        FifoList.add(5);

        System.out.println("Deleting an element..");
        int deleted = FifoList.delete();
        System.out.println("Deleted: " + deleted);
        System.out.println("Deleting an element..");
        deleted = FifoList.delete();
        System.out.println("Deleted: " + deleted);

        System.out.println("Top: " + FifoList.peek());
        System.out.println(FifoList.toString());
        System.out.println("Size: " + FifoList.size());
        return FifoList;
    }
    private static Set testSet(Set Set) {
        System.out.println("Adding 13..");
        Set.add(13);
        System.out.println("Adding 6..");
        Set.add(6);
        System.out.println("Adding 3..");
        Set.add(3);
        System.out.println("Adding 3..");
        Set.add(3);
        System.out.println("Adding 3..");
        Set.add(3);
        System.out.println("Adding 7..");
        Set.add(7);
        System.out.println("Adding 9..");
        Set.add(9);
        System.out.println("Adding 19..");
        Set.add(19);
        System.out.println("Adding 4..");
        Set.add(4);

        System.out.println("Size: " + Set.size());
        SortedList p = Set.toSortedList();
        System.out.println(p.toString());

        return Set;
    }

    public static void main(String[] args) {
        SortedList sortedList1 = new SortedList(5);
        SortedList sortedList2 = new SortedList(sortedList1);
        System.out.println("Testing SortedList");
        sortedList2 = testSortedList(sortedList2);
        System.out.println("*********************************************************************");

        FifoList fifoList1 = new FifoList(5);
        FifoList fifoList2 = new FifoList(fifoList1);
        System.out.println("Testing FifoList");
        fifoList2 = testFifoList(fifoList2);
        System.out.println("*********************************************************************");

        LifoList LifoList = new LifoList(5);
        LifoList lifoList2 = new LifoList(LifoList);
        System.out.println("Testing LifoList");
        lifoList2 = testLifoList(lifoList2);
        System.out.println("*********************************************************************");

        Set Set = new Set(5);
        Set set2 = new Set(Set);
        System.out.println("Testing Set");
        set2 = testSet(set2);
        System.out.println("*********************************************************************");



    }
}
