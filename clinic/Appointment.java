package clinic;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private String visitorName;
    private LocalDate date;
    private LocalTime time;

    public Appointment(String visitorName, LocalDate date, LocalTime time) {
        this.visitorName = visitorName;
        this.date = date;
        this.time = time;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "visitorName='" + visitorName + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
