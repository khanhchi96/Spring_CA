package SpringCA.entities;

import SpringCA.entities.CompositeId.LecturerLeaveId;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@IdClass(LecturerLeaveId.class)
public class LecturerLeave {
    @Id
    @ManyToOne
    @JoinColumn(name = "lecturerId")
    private Lecturer lecturerByLeave;

    @Id
    @NotNull(message = "Start date cannot be empty")
    @Future(message = "Start date must be an upcoming date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date startDate;


    @NotNull(message = "End date cannot be empty")
    @Future(message = "Start date must be an upcoming date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date endDate;

    private String status;

    public LecturerLeave(){}

    public LecturerLeave(Lecturer lecturerByLeave, Date startDate, Date endDate, String status) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
