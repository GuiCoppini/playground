package datastructs;

public class DataStructuresMain {
    public static void main(String[] args) {
        DataStructure ds = new LinkedList();

        checkStructure(ds);

        System.out.printf("Success!");
    }


    static void checkStructure(DataStructure structure) {
        int[] numbers = {1, 3,53,2,7,31,5};
        int sizeShouldBe = 0;

        for (int num : numbers) {
            // size on insert
            test(structure.size() == sizeShouldBe, "Size Insert -1- on num " + num);
            structure.insert(num);
            sizeShouldBe++;
            test(structure.size() == sizeShouldBe, "Size Insert -2- on num " + num);
        }

        test(structure.size() == sizeShouldBe, "Size after inserts");
        test(structure.exists(53), "Should exist 53");
        test(!structure.exists(9), "Should NOT exist 9");

        // shuffled by hand to avoid the return of the shuffle being exactly the same array, giving a false positive
        int[] shuffled = {53, 2, 5, 7, 3, 1, 31};
        for (int num : shuffled) {
            // size on delete
            structure.delete(num);
            sizeShouldBe--;
            test(structure.size() == sizeShouldBe, "Size Delete on num " + num);
        }
    }

//    private static int[] shuffle(int[] a) {
//        int[] resultAsArray = new int[a.length];
//
//        List<Integer> result = Arrays.stream(a.clone())
//                .boxed()
//                .collect(Collectors.toList());
//        Collections.shuffle(result);
//
//        for (int i = 0; i < result.size(); i++) {
//            resultAsArray[i] = result.get(i);
//        }
//
//        return resultAsArray;
//    }

    static boolean test(boolean condition, String name) {
        if(condition) {
            return true;
        } else {
            throw new RuntimeException("Deu pau no " + name);
        }
    }
}
