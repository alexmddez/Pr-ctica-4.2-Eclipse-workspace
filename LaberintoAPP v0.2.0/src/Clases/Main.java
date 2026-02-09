package Clases;

public class Main {

    private static Session session = new Session();
    private static Maze maze = new Maze();

    public static void main(String[] args) {

        boolean exit = false;

        System.out.println(Config.welcome);

        while (!exit) {

            if (!session.isLogged()) {

                System.out.print(Config.unlogged_menu);
                String option = Input.getString();

                switch (option) {
                    case "1":
                        session.login();
                        break;
                    case "2":
                        session.signup();
                        break;
                    case "0":
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción incorrecta.");
                }

            } else {

                System.out.print(Config.logged_menu);
                String option = Input.getString();

                switch (option) {
                    case "1":
                        maze.loadMaze();
                        break;
                    case "2":
                        maze.showMaze();
                        break;
                    case "3":
                        maze.setStartEnd(); 
                        break;
                    case "4":
                        System.out.println("Próximamente");
                        break;
                    case "5":
                        session.showUser();
                        break;
                    case "6":
                        session.logout();
                        maze.clear();
                        break;
                    case "0":
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción incorrecta.");
                }
            }
        }

        System.out.println(Config.goodbye);
    }
}