package Java_Concepts;

/*Parents and child example - Child inherit the properties of parents.
 extend keyword is used to inherit the properties of class
*/
public class InheritanceExample {
    public static void main(String[] args) {
        Result demo = new Result();
        demo.result();
    }
}

class Result extends Calculations {
    public void result() {
        Calculations demo = new Calculations();

        System.out.println("The sum of the given numbers:" + demo.add(2, 3));
        System.out.println("The difference of the given numbers:" + demo.subtract(5, 3));
    }
}

class Calculations {
    int ans;

    public int add(int firstNumber, int secondNumber) {
        ans = firstNumber + secondNumber;
        return ans;
    }

    public int subtract(int firstNumber, int secondNumber) {
        ans = firstNumber - secondNumber;
        return ans;
    }
}
