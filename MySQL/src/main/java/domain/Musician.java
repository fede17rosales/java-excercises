package domain;

import java.util.Objects;

public class Musician {
    private int id;
    private int totalMembers;
    private String vocalist;
    private String guitarist;
    private String drummer;
    private String bassist;
    private int concerts;

    public Musician() {
    }

    public Musician(int id) {
        this.id = id;
    }

    public Musician(int totalMembers, String vocalist, String guitarist, String drummer, String bassist, int concerts) {
        this.totalMembers = totalMembers;
        this.vocalist = vocalist;
        this.guitarist = guitarist;
        this.drummer = drummer;
        this.bassist = bassist;
        this.concerts = concerts;
    }

    public Musician(int id, int totalMembers, String vocalist, String guitarist, String drummer, String bassist, int concerts) {
        this(totalMembers,vocalist, guitarist, drummer,bassist,concerts);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }

    public String getVocalist() {
        return vocalist;
    }

    public void setVocalist(String vocalist) {
        this.vocalist = vocalist;
    }

    public String getGuitarist() {
        return guitarist;
    }

    public void setGuitarist(String guitarist) {
        this.guitarist = guitarist;
    }

    public String getDrummer() {
        return drummer;
    }

    public void setDrummer(String drummer) {
        this.drummer = drummer;
    }

    public String getBassist() {
        return bassist;
    }

    public void setBassist(String bassist) {
        this.bassist = bassist;
    }

    public int getConcerts() {
        return concerts;
    }

    public void setConcerts(int concerts) {
        this.concerts = concerts;
    }

    @Override
    public String toString() {
        return  "{ " + id +
                ", vocalist='" + vocalist + '\'' +
                ", guitarrist='" + guitarist + '\'' +
                ", baterist='" + drummer + '\'' +
                ", bassist='" + bassist + '\'' +
                ", concerts=" + concerts +
                ", totalMembers =" + totalMembers + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musician musician = (Musician) o;
        return id == musician.id && totalMembers == musician.totalMembers && concerts == musician.concerts && Objects.equals(vocalist, musician.vocalist) && Objects.equals(guitarist, musician.guitarist) && Objects.equals(drummer, musician.drummer) && Objects.equals(bassist, musician.bassist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalMembers, vocalist, guitarist, drummer, bassist, concerts);
    }
}
