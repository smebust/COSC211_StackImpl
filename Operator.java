public class Operator{

    public int precedence;

    public String op;

    public static int baseP;

    public Operator(String c){
        
        op = c;
        
        if(op.equals("+") || op.equals("-")){
            precedence = baseP+1;
        } else if(op.equals("*") || op.equals("/")){
            precedence = baseP+2;
        }
        
    }

    public String toString(){
        return this.op;
    }
}