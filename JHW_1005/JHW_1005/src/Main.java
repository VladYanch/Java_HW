public class Main {
    public static void main(String[] args) {
        double ball=4.1;
        String[] arrS = {"Jack", "John", "Stan", "Ed"};
        double[] arrB = {3.5, 4.2, 4.8, 4.1};
        int indeх = searchStud(arrB);
        System.out.println("Успешный студент "+arrS[indeх]+" "+arrB[indeх]);
        System.out.println("-------------");
        searchStudUp(arrS, arrB, ball );
    }
    public static int searchStud(double[] arr) {
        double max = arr[0];
        int index=0;
        //for (int element:arr) {
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i] > max) {
                max=arr[i];
                index=i;
            }
        }
        return index;
    }

    public static void searchStudUp(String[] arrS, double[] arrB, double ball) {
        //for (int element:arr) {
        for (int i = 0; i < arrB.length ; i++) {
            if (arrB[i] > ball) {
                System.out.println("Успешный студент "+arrS[i]+" "+arrB[i]);
            }
        }
    }

}