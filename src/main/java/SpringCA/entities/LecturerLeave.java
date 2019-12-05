package SpringCA.entities;

import SpringCA.entities.CompositeId.LecturerLeaveId;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@IdClass(LecturerLeaveId.class)
public class LecturerLeave {
    @Id
    @ManyToOne
    @JoinColumn(name = "lecturerId")
    private Lecturer lecturerByLeave;

    @Id
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;

    public LecturerLeave(){}

    public LecturerLeave(Lecturer lecturerByLeave, LocalDateTime startDate, LocalDateTime endDate, String status) {
        this.lecturerByLeave = lecturerByLeave;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Lecturer getLecturerByLeave() {
        return lecturerByLeave;
    }

    public void setLecturerByLeave(Lecturer lecturerByLeave) {
        this.lecturerByLeave = lecturerByLeave;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
