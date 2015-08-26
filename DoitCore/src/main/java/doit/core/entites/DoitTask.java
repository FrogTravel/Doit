package doit.core.entites;

import java.util.Date;
import javax.xml.bind.annotation.*;

/**
 * @author Anatoly
 */
@XmlRootElement(name = "task")
@XmlType(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class DoitTask extends DoitAbstractTask {
    /** Task priority */
    @XmlAttribute(name = "priority")
    private DoitTaskPriority priority;
    /** Task status*/
    @XmlAttribute(name = "status")
    private DoitTaskStatus status;

    /***
     * Initializing field {@link DoitTask#name}, {@link DoitTask#startDate},
     *              {@link DoitAttachment}  {@link DoitTaskPriority} {@link DoitTaskStatus}
     *
     * @param name Short task name
     * @param start Start task date
     * @param attachment Attachment
     * @param priority Task priority
     * @param status Current task status
     */
    public DoitTask(String name, Date start, DoitAttachment attachment,
                    DoitTaskPriority priority, DoitTaskStatus status) {
        this.name = name;
        this.startDate = start;
        this.attachmentList.add(attachment);
        this.priority = priority;
        this.status = status;
    }
    /**
     * Initializing field {@link DoitTask#name}, {@link DoitTask#startDate}, {@link DoitAttachment}
     * @param name Short task name
     * @param start Start task date
     * @param attachment Attachment
     */
    public DoitTask(String name, Date start, DoitAttachment attachment) {
        this.name = name;
        this.startDate = start;
        this.attachmentList.add(attachment);
    }
    /**
     * Initializing field  {@link DoitTask#name}, {@link DoitTask#startDate}
     * @param name Short task name
     * @param start Start task date
     */
    public DoitTask(String name, Date start) {
        this.name = name;
        this.startDate = start;
    }
    /**
     * Initializing field {@link DoitTask#name}
     * @param name Short task name
     */
    public DoitTask(String name) {
        this.name = name;
    }

    public DoitTask() {
    }

    /**
     * Change priority for task
     * @param  priority
     */
    public void setPriority(DoitTaskPriority priority) {
        this.priority = priority;
    }

    /***
     * @return current task priority
     */
    public DoitTaskPriority getPriority() {
        return priority;
    }

    /***
     * @return current task status
     */
    public DoitTaskStatus getStatus() {
        return status;
    }

    /***
     * Change status for the task
     * @param status new status
     */
    public void setStatus(DoitTaskStatus status) {
        this.status = status;
    }
}
