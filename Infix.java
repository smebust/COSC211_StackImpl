import java.util.Scanner;

public class Infix{

    public static CS211Stack<Operator> stack = new CS211Stack<Operator>();

    public static boolean debug = false;

    public static void main(String args[]){

        String in = "";
        System.out.println("Enter a string to be post-fixed (include spaces): ");
        Scanner readIn = new Scanner(System.in);
        in = readIn.nextLine();
        Scanner sc = new Scanner(in);
        stack.init();
        System.out.println(convert(sc));

    }

    public static String convert(Scanner sc){
        String toReturn = "";

        while (sc.hasNext()){
            if(debug){
                System.out.println("IN FOR LOOP");
                System.out.println("CURRENT OUTPUT: " + toReturn);
            }
            if (sc.hasNextInt()){
                if(debug){
                    System.out.println("Is an int");
                }
                int c = sc.nextInt();
                toReturn = toReturn + " " + c;  
            } else {
                if(debug){
                    System.out.println("Is not an int");
                }
                String c = sc.next();
                if (c.equals(")")) { 
                    Operator.baseP = Operator.baseP - 4;
                    if(debug){
                        System.out.println("Is a )");
                    }
                }
                if (c.equals("(")){
                    Operator.baseP = Operator.baseP + 4;
                    if(debug){
                        System.out.println("Is a (");
                    }
                }
                if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                    if(debug){
                        System.out.println("Is an operator");
                    }
                    Operator myOp = new Operator(c);
                    if(debug){
                        System.out.println("myOp op: " + myOp);
                        System.out.println("myOp prec: " + myOp.precedence);
                    }
                    if (stack.isEmpty() != true){
                        Operator lastPush = stack.peek();
                        if(myOp.precedence <= (lastPush.precedence)){
                            Operator popped = stack.pop();
                            toReturn = toReturn + " " + popped;
                        }
                    }
                    stack.push(myOp);
                }
                if (c.equals("=")){
                    if(debug){
                        System.out.println("Is a =");
                    }
                    for(int j = 0; j<=stack.size(); j++){
                        if(debug) System.out.println(j);
                        Operator popped = stack.pop();
                        toReturn = toReturn + " " + popped;
                    }
                    toReturn = toReturn + " " + c;
                }
            }
        }
        return toReturn;
    }
}