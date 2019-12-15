package SpringCA.entities.CompositeId;

import SpringCA.entities.LecturerLeave;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class LecturerLeaveId implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int lecturerByLeave;

    private Date startDate;

    public LecturerLeaveId(){}

    public LecturerLeaveId(int lecturerByLeave, Date startDate) {
        this.lecturerByLeave = lecturerByLeave;
        this.startDate = startDate;
    }

    public int getLecturerByLeave() {
        return lecturerByLeave;
    }

    public void setLecturerByLeave(int lecturerByLeave) {
        this.lecturerByLeave = lecturerByLeave;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result+ lecturerByLeave;
        result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LecturerLeaveId other = (LecturerLeaveId) obj;
        if (lecturerByLeave != other.lecturerByLeave)
            return false;
        if (startDate == null) {
            if (other.startDate != null)
                return false;
        } else if (!startDate.equals(other.startDate))
            return false;
        return true;
    }
}
