import java.util.Scanner;

public class Reverse{

    static CS211Stack myStack = new CS211Stack();

    public static void main(String[] args){
        String in = "";
        System.out.println("Enter a string to be reversed: ");
        Scanner readIn = new Scanner(System.in);
        in = readIn.nextLine();
        System.out.println(invert(in));
        }

    public static String invert(String s){
        myStack.init();
        for (int i = 0; i<s.length(); i++){
            myStack.push(s.charAt(i));
        }

        String toReturn = "";

        for (int i = 0; i<s.length(); i++){
            toReturn = toReturn + myStack.pop();
        }

        return toReturn;
    }
}