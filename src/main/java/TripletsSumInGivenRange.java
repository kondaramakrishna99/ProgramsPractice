public class TripletsSumInGivenRange {

    public int solve(String[] array) {
        if(array.length < 3) return 0;

        double a = Double.parseDouble(array[0]);
        double b = Double.parseDouble(array[1]);
        double c = Double.parseDouble(array[2]);


        for(int i = 3; i < array.length; i++){

            if((a+b+c) > 1 && (a+b+c) < 2){
                return 1;
            }


            double n = Double.parseDouble(array[i]);

            // System.out.println("n is "+n);
            if((a+b+c) >= 2){
                if(a > b && a > c){
                    a = n;
                } else if( b > c){
                    b = n;
                } else{
                    c = n;
                }

                // System.out.println("A "+a+" b "+b+" c "+c);
            } else{
                if(a < b && a < c){
                    a = n;
                } else if( b < c){
                    b = n;
                } else{
                    c = n;
                }
                //       System.out.println("A "+a+" b "+b+" c "+c);
            }
        }
        // System.out.println(" in last A "+a+" b "+b+" c "+c);
        if((a+b+c) > 1 && (a+b+c) < 2){
            return 1;
        }

        return 0;
    }
}
