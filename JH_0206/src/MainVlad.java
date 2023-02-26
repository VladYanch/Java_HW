public class MainVlad {
//    try (
//    BufferedReader bufferedReader = new BufferedReader(new FileReader("seq1.txt"));
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("seq1_sorted.txt"));
//    BufferedWriter bufferedWriterRes = new BufferedWriter(new FileWriter("result.txt"));
//        ) {
//        List<String> list = bufferedReader.lines().toList();
//        List<List<Integer>> ints = new ArrayList<>();
//
//        try {
//            list.forEach(s -> {
//                ints.add(Arrays.stream(s.split(" ")).filter(str -> !(str.equals(""))).map(Integer::parseInt).toList());
//                count++;
//            });
//
//            count = 1;
//            try (
//                    BufferedReader bufferedReader = new BufferedReader(new FileReader("seq1.txt"));
//                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("seq1_sorted.txt"));
//                    BufferedWriter bufferedWriterRes = new BufferedWriter(new FileWriter("result.txt"));
//            ) {
//                List<String> list = bufferedReader.lines().toList();
//                List<List<Integer>> ints = new ArrayList<>();
//
//                try {
//                    list.forEach(s -> {
//                        ints.add(Arrays.stream(s.split(" ")).filter(str -> !(str.equals(""))).map(Integer::parseInt).toList());
//                        count++;
//                    });
//
//                    count = 1;
//
//                    or (List<Integer> l : ints) {
//                        bufferedWriter.write(l.stream().sorted(Collections.reverseOrder()).map(Object::toString).collect(Collectors.joining("; ")) + "\n");
//
//                        bufferedWriterRes.write(
//                                "Line: " + count++ + "; " +
//                                        "SEven: " + l.stream().filter(x -> x % 2 == 0).mapToInt(Integer::intValue).sum() + "; " +
//                                        "AOdd: " + l.stream().filter(x -> x % 2 != 0).mapToDouble(Integer::doubleValue).average().orElseThrow() + "; " +
//                                        "Max: " + l.stream().max(Comparator.comparing(Integer::intValue)).orElseThrow() + "; " +
//                                        "Min: " + l.stream().min(Comparator.comparing(Integer::intValue)).orElseThrow() + "\n"
//                        );
//                    }
//                }
//                catch (NumberFormatException e) {
//                    bufferedWriterRes.write("Line #, " + count + " " + e.getMessage());
//                }
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
}
