package Reservation;

public class DataReservation {
    private String username;
    private String course;
    private String round;
    private String table;
    private String partySize;
    private String day;
    private String mount;
    private String year;

    public DataReservation(String username,String course,String round,String table,String partySize,String day,String mount,String year){
        this.username=username;
        this.course=course;
        this.round=round;
        this.table=table;
        this.partySize=partySize;
        this.day=day;
        this.mount=mount;
        this.year=year;
    }
    public String toString() {
        return String.format(
                "username: preemSoCute Course:%s , Round: %s , Table: %s ,Party Size: %d , Date: %d / %d / %d ", course,
                round, table, partySize, day, mount, year);
    }

}


