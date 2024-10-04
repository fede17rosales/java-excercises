package data;

import java.util.List;
import domain.Musician;
public interface IMusicianDAO {
    List<Musician> listMusicians();
    boolean findMusiciansById(Musician musician);
    boolean addMusicians(Musician musician);
    boolean updateMusicians(Musician musician);

    boolean deleteMusicians(int id);
}
