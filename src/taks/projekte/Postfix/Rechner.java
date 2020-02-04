// "2 3 4 5 1 + * * *"
package taks.projekte.Postfix;
import lib.liniareDatenstrukturen.Stack;

public class Rechner {
    public Rechner(String pTerm) {
        Stack<Integer> lStack = new Stack<Integer>();
        String lZahl;
        for (int i = 0; i < pTerm.length(); i++) {
            if (obZahl("" + pTerm.charAt(i))) {
                String lZahl1 = "" + pTerm.charAt(i);
                String lZahl2;
                i++;
                while (pTerm.charAt(i) != ' ') {
                    lZahl2 = "" + pTerm.charAt(i);
                    lZahl1 = lZahl1 + lZahl2;
                    i++;
                }
                lStack.push(Integer.parseInt(lZahl1));
            } else if (obOperator("" + pTerm.charAt(i))) {
                int lOberstes = lStack.top();
                lStack.pop();
                int l2Oberstes = lStack.top();
                lStack.pop();
                if (pTerm.charAt(i) == '+')
                    lStack.push(lOberstes + l2Oberstes);
                else if (pTerm.charAt(i) == '-')
                    lStack.push(lOberstes - l2Oberstes);
                else if (pTerm.charAt(i) == '*')
                    lStack.push(lOberstes * l2Oberstes);
                else if (pTerm.charAt(i) == ':')
                    lStack.push(lOberstes / l2Oberstes);
            }
        }
        System.out.println(lStack.top());
    }

    public boolean obZahl(String pZahl) {
        switch (pZahl) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                return true;
        }
        return false;
    }

    public boolean obOperator(String pZeichen) {
        switch (pZeichen) {
            case "+":
            case "-":
            case "*":
            case ":":
                return true;
        }
        return false;
    }
}
