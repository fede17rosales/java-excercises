package service;

import data.IMusicianDAO;
import data.MusicianDAO;
import domain.Musician;

import java.util.List;
import java.util.Scanner;

public class MusicianServiceImpl implements IMusicianService{
    private final IMusicianDAO musicianDAO = new MusicianDAO();

    @Override
    public void listMusicians() {
        System.out.println("------ Musicians ------");
        List<Musician> musicians = musicianDAO.listMusicians();
        System.out.println("musicians = " + musicians);
    }

    @Override
    public void findMusicianById(Scanner console) {
        System.out.println("Input id of the musician: ");
        int id = Integer.parseInt(console.nextLine());
        var musician = new Musician(id);
        var result = musicianDAO.findMusiciansById(musician);
        if(result){
            System.out.println("Musician: " + musician);
        }else {
            System.out.println("Musician not found with id: " + musician.getId());
        }
    }

    @Override
    public void createMusician(Scanner console) {
        System.out.println("--- Add new musician ---");
        System.out.println("Input total members: ");
        int totalMembers = Integer.parseInt(console.nextLine());
        System.out.println("Input a vocalist: ");
        String vocalist = console.nextLine();
        System.out.println("Input a guitarist: ");
        String guitarist = console.nextLine();
        System.out.println("Input a drummer: ");
        String drummer = console.nextLine();
        System.out.println("Input a bassist: ");
        String bassist = console.nextLine();
        System.out.println("Input a number of concerts: ");
        int concerts = Integer.parseInt(console.next());
        var musician = new Musician(totalMembers,vocalist,guitarist,drummer,bassist,concerts);
        boolean added = musicianDAO.addMusicians(musician);
        if(added){
            System.out.println("Musicians added");
        }else {
            System.out.println("Musicians not added: " + musician);
        }
    }

    @Override
    public void updateMusician(Scanner console) {
        System.out.println("--- Modify a musician ---");
        System.out.println("Id:");
        int id = Integer.parseInt(console.nextLine());
        System.out.println("Input total members: ");
        int totalMembers = Integer.parseInt(console.next());
        System.out.println("Input a vocalist: ");
        String vocalist = console.nextLine();
        System.out.println("Input a guitarist: ");
        String guitarist = console.nextLine();
        System.out.println("Input a drummer: ");
        String drummer = console.nextLine();
        System.out.println("Input a bassist: ");
        String bassist = console.nextLine();
        System.out.println("Input a number of concerts: ");
        int concerts = Integer.parseInt(console.next());
        var musician = new Musician(id,totalMembers,vocalist,guitarist,drummer,bassist,concerts);
        boolean updatedMusician = musicianDAO.updateMusicians(musician);
        if(updatedMusician){
            System.out.println("Musicians updated");
        }else {
            System.out.println("Musicians not updated: " + musician);
        }
    }

    @Override
    public void deleteMusician(Scanner console) {
        System.out.println("--- Delete a musician ---");
        System.out.println("Id:");
        int id = Integer.parseInt(console.nextLine());
        var musicianDeleted = musicianDAO.deleteMusicians(id);
        if(musicianDeleted){
            System.out.println("Musician deleted with id: " + id);
        }else{
            System.out.println("Musician can't deleted: " + id);
        }
    }
}
