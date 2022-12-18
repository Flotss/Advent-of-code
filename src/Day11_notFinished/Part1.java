package Day11_notFinished;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Part1 {
    public static void main(String[] args) throws IOException {
        Set<Monkey> monkeys = new TreeSet<>();

        BufferedReader reader = new BufferedReader(new FileReader("inputs/inputDay11.txt"));
        String line;

        Factory factory = new Factory();
        while ((line = reader.readLine()) != null) {
            if (line.equals("")) {
                line = reader.readLine();
            }

            int name = Integer.parseInt(line.split(" ")[1].replace(":", ""));
            System.out.println("Monkey " + name + ":");

            line = reader.readLine();
            line = line.replace("Starting items: ", "");
            line = line.replace(" ", "");
            line = line.replace(",", " ");

            ArrayList<Integer> items = new ArrayList<>();
            for (String s : line.split(" ")) {
                items.add(Integer.parseInt(s));
            }
            System.out.print("Starting items: ");
            for (int i : items) {
                System.out.print(i + " ");
            }
            System.out.println();

            line = reader.readLine();
            String operation = line.split("= ")[1];
            String[] split = operation.split(" ");
            Operator operator = factory.getOperator(split[1]);
            String by = split[2];

            boolean isInteger = by != null && by.matches("[-+]?\\d*\\.?\\d+");

            line = reader.readLine();
            int divider = Integer.parseInt(line.split(" ")[5]);

            line = reader.readLine();
            int trueThrowto = Integer.parseInt(line.split(" ")[9]);
            System.out.println("True throw to: " + trueThrowto);

            line = reader.readLine();
            int falseThrowto = Integer.parseInt(line.split(" ")[9]);
            System.out.println("False throw to: " + falseThrowto);

            Monkey monkey = new Monkey(name, items, operator, isInteger, by, divider, trueThrowto, falseThrowto);
            monkeys.add(monkey);
        }

        System.out.println("Monkeys:");
        for (Monkey m : monkeys) {
            System.out.println(m);
        }

    }


    public interface Operator {
        int operate(int item, int another);

        String toString();
    }

    public static class Monkey implements Comparable<Monkey> {
        final int name;
        final int trueThrowto;
        final int falseThrowto;
        final int divider;
        final Operator operator;
        final boolean isInteger;
        final ArrayList<Integer> items;

        public Monkey(int name, ArrayList<Integer> items, Operator operator, boolean isInteger, String by, int divider, int trueThrowto, int falseThrowto) {
            this.name = name;
            this.items = items;
            this.operator = operator;
            this.isInteger = isInteger;
            this.divider = divider;
            this.trueThrowto = trueThrowto;
            this.falseThrowto = falseThrowto;
        }

        public void addItem(int item) {
            items.add(item);
        }

        public void throwItemtoMonkey(Monkey monkey, int item) {
            monkey.addItem(item);
            items.remove(item);
        }

        public void makeCalculation(Operator operator, String by) {
            for (int i = 0; i < items.size(); i++) {
                int item = items.get(i);
                int result = operator.operate(item, Integer.parseInt(by));

            }
        }

        @Override
        public int compareTo(Monkey o) {
            return name - o.name;
        }

        public String toString() {
            String info = "Monkey " + name + "\n";
            info += "Items: ";
            for (int i : items) {
                info += i + " ";
            }
            info += "\n";
            info += "Divider: " + divider + "\n";
            info += "True throw to: " + trueThrowto + "\n";
            info += "False throw to: " + falseThrowto + "\n";
            return info;
        }
    }

    public static class Addition implements Operator {
        @Override
        public int operate(int item, int another) {
            return item + another;
        }
    }

    public static class Multiplication implements Operator {
        @Override
        public int operate(int item, int another) {
            return item * another;
        }
    }

    public static class Division implements Operator {
        @Override
        public int operate(int item, int another) {
            return item / another;
        }
    }

    public static class Subtraction implements Operator {
        @Override
        public int operate(int item, int another) {
            return item - another;
        }
    }


    public static class Factory {
        public Operator getOperator(String operator) {
            return switch (operator) {
                case "+" -> new Addition();
                case "*" -> new Multiplication();
                case "/" -> new Division();
                case "-" -> new Subtraction();
                default -> null;
            };
        }
    }


}

