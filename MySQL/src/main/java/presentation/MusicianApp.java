package presentation;

import service.IMusicianService;
import service.MusicianServiceImpl;

import java.util.Scanner;

public class MusicianApp {
    private static final IMusicianService musicianService = new MusicianServiceImpl();

    public static void main(String[] args) {
        boolean exit = false;
        while(!exit){
            try{
                Scanner console = new Scanner(System.in);
                int option =viewMenu(console);
                exit = executeOptions(console,option,musicianService);
            }catch (Exception e){
                System.out.println("Error when execute the options: " + e);
            }
            System.out.println();
        }
    }

    private static int viewMenu(Scanner console){
        System.out.println("""
                *** MusicianAPP ***
                1. List musicians
                2. Find musicians
                3. Add musicians
                4. Modify a musician
                5. Delete a musician
                6. Exit
                Execute a Option: \s""");
        return Integer.parseInt(console.nextLine());
    }

    private static boolean executeOptions(Scanner console, int option, IMusicianService musicianService ){
        boolean exit = false;
        switch (option){
            case 1 -> {
                musicianService.listMusicians();
            }
            case 2 -> {
                musicianService.findMusicianById(console);
            }
            case 3 -> {
                musicianService.createMusician(console);
                musicianService.listMusicians();
            }
            case 4 -> {
                musicianService.updateMusician(console);
                musicianService.listMusicians();
            }
            case 5 -> {
                musicianService.deleteMusician(console);
                musicianService.listMusicians();
            }
            case 6 ->{
                System.out.println("Good Bye!!!");
                exit = true;
            }
            default -> {
                System.out.println("Option not found: " + option);
            }
        }
        return exit;
    }
}
