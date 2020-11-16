package machine;

public class arrayTest {

    public static void main (String[] args) {

//        int[] miArray = new int[10];
//
//        miArray[0] = 1;
//        miArray[1] = 2;
//        miArray[2] = 3;
//        miArray[3] = 4;
//        miArray[4] = 5;
//
//        System.out.println(miArray[4]);
//

        int[] miArray = {1, 2, 3, 4, 5, 6};

        System.out.println(miArray[2]);

        for (int i = 0; i < miArray.length; i++) {
            System.out.print(miArray[i] + " ");
            
        }

        for(int elemento:miArray) {
            System.out.println(elemento);
        }
    }


}
