package Reservation;
//show data Reservation
public class DataReservation {
    private String username;
    private int  course;
    private int  round;
    private String  table;
    private int partySize;
    private int day;
    private int mount;
    private int year;

    public DataReservation(String username,int course,int round,String table,int partySize,int day,int mount,int year){
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
                "username: %s Course:%s , Round: %s , Table: %s ,Party Size: %d , Date: %d / %d / %d ",username, course,
                round, table, partySize, day, mount, year);
    }

}


