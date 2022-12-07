import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Run {

    private final Map<String, Class<?>> classes = new TreeMap<>();
    private final ArrayList<String> days = new ArrayList<>();

    public Run() throws ClassNotFoundException, InterruptedException {
        ArrayList<File> nameClasses = new ArrayList<>();
        File folder = new File("src");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isDirectory()) {
                if (file.getName().contains("notFinished")) {
                    continue;
                }

                days.add(file.getName().substring(3));
                for (File file2 : file.listFiles()) {
                    String name = file2.getName();
                    if (name.endsWith(".java")) {
                        nameClasses.add(file2);
                    }
                }
            }
        }

        System.out.println("Loading classes...");
        for (File file : nameClasses) {
            String name = file.getPath();
            name = name.substring(0, name.length() - 5);
            name = name.replace("\\", ".");
            name = name.replace("src.", "");


            System.out.print(name + " ");
            if (name.endsWith("Part2")) {
                System.out.println();
            }
            classes.put(name, Class.forName(name));
            Thread.sleep(100);
        }
        System.out.println("Classes loaded.");

    }

    public static void main(String[] args) throws Exception {
        Run run = new Run();


        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            int day;
            do {
                System.out.print("Choose a day : ");
                for (String s : run.days) {
                    if (run.days.indexOf(s) != run.days.size() - 1) {
                        System.out.print(s + ", ");
                    } else {
                        System.out.println(s + ".\n");
                    }
                }

                try {
                    day = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Please enter a number");
                    day = 0;
                }
            } while (!run.days.contains(day + ""));

            int part;
            do {
                System.out.println("Choose a part : 1 or 2");
                try {
                    part = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Please enter a number");
                    part = 0;
                }
            } while (part != 1 && part != 2);

            System.out.println("\nRunning day " + day + " part " + part + ", so the class is " + run.getClass("Day" + day + ".Part" + part));
            Class<?> c = run.getClass("Day" + day + ".Part" + part);
            Method m = run.getMethod(c, "main");
            m.invoke(null, (Object) new String[0]);

            System.out.println("\nDo you want to run another day ? (y/n)");
            while (true) {
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("n")) {
                    loop = false;
                    break;
                } else if (answer.equalsIgnoreCase("y")) {
                    break;
                } else {
                    System.out.println("Please enter y or n");
                }
            }
        }
    }

    public Class<?> getClass(String name) {
        return classes.get(name);
    }

    public Method getMethod(Class<?> c, String name) {
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals(name)) {
                return method;
            }
        }
        return null;
    }

}
