package ZeeshanSir;

public class InfixToPostfix {
    static int precedence(String c) {
        if (c.equals("*")) {
            return 4;
        }else if (c.equals("/")) {
            return 3;
        }else if (c.equals("-")) {
            return 2;
        }else if (c.equals("+")) {
            return 1;
        }else {
            return -1;
        }
    }
    static boolean isOperator(String c){
        if(c.equals("*" )||c.equals("/" )||c.equals("+" )||c.equals( "-")) return true;
        return false;
    }
    static boolean isOperand(String c){
        if(!(c.equals( "*") ||c.equals( "/") ||c.equals( "+") ||c.equals( "-")||c.equals( "(")||c.equals( ")"))) return true;
        return false;
    }    
    static int myAtoi(String s) { // string to number
        boolean begin = true;
        char[] c = s.toCharArray();
        int p = 0;
        int res = 0;
        while (p < c.length && c[p] == ' ') {
            p ++;
        }
        int positive = 1;
        for (int i = p; i < c.length; i ++) {
            if (begin == true && c[i] == '-') {
                positive = -1;
            }
            else if (begin == true && c[i] == '+') {
                positive = 1;
            }
            else if (Character.isDigit(c[i])) {
                int temp = c[i] - '0';
                if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10&&temp>Integer.MAX_VALUE%10)){
                    return Integer.MAX_VALUE;
                }

                if(res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10&&-temp<Integer.MIN_VALUE%10)){
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + temp*positive;
            }else {
                break;
            }
            begin = false;
        }
        return res;
    }

    static String infixToPostfix(String infix) throws Exception{
        TockenStack<String> stack = new TockenStack(infix.length()/2);
        String postfix = "";

        infix = infix + " )";
        stack.push("(");

        String[] tokens = infix.split("\\s+");

        for (String x : tokens) {

            if (x.equals("(")) {
                stack.push(x);
            }else if(x.equals(")")) {
                String y = stack.pop();
                while (!y.equals("(" )) {
                    postfix = postfix+y+' ';
                    y = stack.pop();
                }
            }else if( isOperator(x) ){
                String y = stack.pop();
                while (isOperator(y) && precedence(y) > precedence(x)) {
                    postfix = postfix+y+' ';
                    y = stack.pop();
                }
                stack.push(y);
                stack.push(x);
            }else if ( isOperand(x) ){
                postfix = postfix+x+' ';
            }else{
                throw new Exception("Invalid tocken");
            }
        }
        return postfix;
    }
    static int postfixToInfix(String postfix) throws Exception{
        TockenStack<Integer> stack = new TockenStack(postfix.length()/2);

        String[] tockenStrings = postfix.split("\\s+");
        
        for (String string : tockenStrings) {
            if (isOperator(string) ) {
                int x = stack.pop();
                int y = stack.pop();
                int val=0;

                switch (string) {
                    case "+":
                        val = y+x;
                        break;
                    case "-":
                        val = y-x;
                        break;
                    case "*":
                        val = y*x;
                        break;
                    case "/":
                        val = y/x;
                        break;
                }
                stack.push(val);

            } else {
                stack.push(myAtoi(string));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) throws Exception{
        String infix = "3 - 2 * 3 * 2 * 2 + 9 + 1";
        String[] tockenStrings = infix.split("\\s+");

        System.out.println("input infix");
        for (String string : tockenStrings) {
            System.out.print(string+' ');
        }
        System.out.println();

        String postfix = infixToPostfix(infix);

        System.out.println("output postfix");
        System.out.println(postfix);

        System.out.println(postfixToInfix(postfix));
    }
}

class TockenStack <T> {
    T[] stack ;
    int top=-1;
    int length;

    TockenStack(int length){
        this.length = length;
        stack = (T[]) new Object[length];
    }
    void push(T element) throws Exception{
        if (top == length-1) throw new Exception("stack is full");       
        top++;
        stack[top] = element;
    }
    T pop(){
        if(top < 0) throw new IllegalArgumentException("Stack is empty");

        return stack[top--];
    }
    T peep(int index){
        if(index<0 || index>top) throw new IllegalArgumentException("invalid index");
        return stack[top-index];
    }
    T peek(){
        return stack[top];
    }
    boolean isEmpty(){
        if (top == -1) {
            return true;
        }else{
            return false;
        }
    }
    int size(){
        return top+1;
    }
    void display(){
        for (int i = 0; i < stack.length; i++) {
            System.out.print(stack[i]+" ");
        }
    }
    //  public static void main(String[] args) {
    //     TockenStack m = new TockenStack(10);
    //     try {
    //         m.push("4");
    //         m.push("-");
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //     }
    //     System.out.println(m.peek());
    // }
}