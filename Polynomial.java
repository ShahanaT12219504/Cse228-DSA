import java.util.Scanner;

public class Polynomial {

    private Node head;
    private int degree;
    private int numTerms;

    public Polynomial() {
        this.head = null;
        this.degree = 0;
        this.numTerms = 0;
    }

    public void addTerm(double coefficient, int exponent) {
        if (coefficient == 0) {
            return;
        }

        Node newNode = new Node(coefficient, exponent);

        if (head == null) {
            head = newNode;
        }

        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        if (exponent > degree) {
            degree = exponent;
        }

        numTerms++;
    }

    public double evaluate(double xValue) {
        double result = 0;
        Node current = head;

        while (current != null) {
            result += current.coefficient * Math.pow(xValue, current.exponent);
            current = current.next;
        }

        return result;
    }

    public int getDegree() {
        return degree;
    }

    public int getNumTerms() {
        return numTerms;
    }
    private class Node {
        double coefficient;
        int exponent;
        Node next;
        public Node(double coefficient, int exponent) {
            this.coefficient = coefficient;
            this.exponent = exponent;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the degree of the polynomial: ");
        int degree = scanner.nextInt();

        System.out.println("Enter the number of terms in the polynomial: ");
        int numTerms = scanner.nextInt();

        Polynomial polynomial = new Polynomial();

        for (int i = 0; i < numTerms; i++) {
            System.out.println("Enter the coefficient of term " + (i + 1) + ": ");
            double coefficient = scanner.nextDouble();

            System.out.println("Enter the exponent of term " + (i + 1) + ": ");
            int exponent = scanner.nextInt();

            if (degree != exponent) {
                System.out.println("Error: The degree of the polynomial and the exponent of the current term do not match.");
                return;
            }

            polynomial.addTerm(coefficient, exponent);
        }

        System.out.println("The polynomial equation is: ");
        Node current = polynomial.head;
        while (current != null) {
            if (current.coefficient > 0) {
                System.out.print("+");
            }
            System.out.print(current.coefficient + "x^" + current.exponent);
            current = current.next;
        }

        System.out.println("\nEnter the value of x for which you want to evaluate the polynomial: ");
        double xValue = scanner.nextDouble();

        double result = polynomial.evaluate(xValue);

        System.out.println("The result of evaluating the polynomial at x = " + xValue + " is: " + result);
    }
}



