package data;

import domain.Musician;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static conexion.Conexion.getConexion;

public class MusicianDAO implements IMusicianDAO {
    private static final String listMusicianQuery ="SELECT * FROM musician";
    private static final String findMusicianByIdQuery ="SELECT * FROM musician WHERE id = ?";
    private static final String insertMusicianQuery ="INSERT INTO musician (total_members,vocalist,guitarist,drummer,bassist,concerts) VALUES (?,?,?,?,?,?)";
    private static final String updateMusicianQuery ="UPDATE musician SET total_members = ?, vocalist = ?, guitarist = ?, drummer = ?, bassist = ?, concerts = ? WHERE id = ?";
    private static final String deleteMusicianQuery = "DELETE FROM musician WHERE id = ?";

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public List<Musician> listMusicians() {
        Connection conn = getConexion();
        List<Musician> musicians = new ArrayList<>();
        try{
            preparedStatement = conn.prepareStatement(listMusicianQuery);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Musician musician = new Musician();
                musician.setId(resultSet.getInt("id"));
                musician.setVocalist(resultSet.getString("vocalist"));
                musician.setGuitarist(resultSet.getString("guitarist"));
                musician.setDrummer(resultSet.getString("drummer"));
                musician.setBassist(resultSet.getString("bassist"));
                musician.setTotalMembers(resultSet.getInt("total_members"));
                musician.setConcerts(resultSet.getInt("concerts"));
                musicians.add(musician);
            }
        }catch (Exception e){
            System.out.println("Error when try list musicians : " + e.getMessage());
        } finally {
            try{
                conn.close();
            }catch (Exception e){
                System.out.println("Error when try close the connection: " + e.getMessage());
            }
        }
        return musicians;
    }

    @Override
    public boolean findMusiciansById(Musician musician) {
        Connection conn = getConexion();
        try{
            preparedStatement = conn.prepareStatement(findMusicianByIdQuery);
            preparedStatement.setInt(1, musician.getId());
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                musician.setId(resultSet.getInt("id"));
                musician.setVocalist(resultSet.getString("vocalist"));
                musician.setGuitarist(resultSet.getString("guitarist"));
                musician.setDrummer(resultSet.getString("drummer"));
                musician.setBassist(resultSet.getString("bassist"));
                musician.setTotalMembers(resultSet.getInt("total_members"));
                musician.setConcerts(resultSet.getInt("concerts"));
                return true;
            }
        }catch (Exception e){
            System.out.println("Error when try find musicians : " + e.getMessage());
        } finally {
            try{
                conn.close();
            }catch (Exception e){
                System.out.println("Error when try close the connection: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean addMusicians(Musician musician) {
        Connection conn = getConexion();
        try{
            preparedStatement = conn.prepareStatement(insertMusicianQuery);
            preparedStatement.setInt(1, musician.getTotalMembers());
            preparedStatement.setString(2, musician.getVocalist());
            preparedStatement.setString(3, musician.getGuitarist());
            preparedStatement.setString(4, musician.getDrummer());
            preparedStatement.setString(5, musician.getBassist());
            preparedStatement.setInt(6, musician.getConcerts());
            preparedStatement.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error when try insert band : " + e.getMessage());
        } finally {
            try{
                conn.close();
            }catch (Exception e){
                System.out.println("Error when try close the connection: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean updateMusicians(Musician musician) {
        Connection conn = getConexion();
        try{
            preparedStatement = conn.prepareStatement(updateMusicianQuery);
            preparedStatement.setInt(1, musician.getTotalMembers());
            preparedStatement.setString(2, musician.getVocalist());
            preparedStatement.setString(3, musician.getGuitarist());
            preparedStatement.setString(4, musician.getDrummer());
            preparedStatement.setString(5, musician.getBassist());
            preparedStatement.setInt(6, musician.getConcerts());
            preparedStatement.setInt(7, musician.getId());
            preparedStatement.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error when try update band : " + e.getMessage());
        } finally {
            try{
                conn.close();
            }catch (Exception e){
                System.out.println("Error when try close the connection: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean deleteMusicians(int id) {
        Connection conn = getConexion();
        try{
            preparedStatement = conn.prepareStatement(deleteMusicianQuery);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error when try delete musician : " + e.getMessage());
        } finally {
            try{
                conn.close();
            }catch (Exception e){
                System.out.println("Error when try close the connection: " + e.getMessage());
            }
        }
        return false;
    }
}
