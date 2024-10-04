package service;

import java.util.Scanner;

public interface IMusicianService {
   void listMusicians();
   void findMusicianById(Scanner console);

   void createMusician( Scanner console);

   void updateMusician(Scanner console);

   void deleteMusician(Scanner console);
}
