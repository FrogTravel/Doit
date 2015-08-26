package doit.core.entites;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlEnum;

/**
 * Created by Almaz on 23.08.2015.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlEnum
public enum  DoitTaskStatus {
    /**
     * This filter contains all actual tasks, events, notes, and notices.
     * Only in the "Open" filter, task sorting depends on the priority. The
     * sorting in the other filters results from the date the task was changed.
     */
    OPENED,

    /**
     * In progress status means than task in processing to resolve and
     * will be finished soon.
     */
    IN_PROGRESS,

    /**
     * Info required task status identify than for processing task processor need
     * some additional information. So, this task blocked by others activities
     */
    INFO_REQUIRED,

    /**
        Completed tasks are displayed in the Open filter, but their names are
        displayed as stroke out. It allows the authors of controlled tasks respond
        to completion of tasks promptly
     */
    COMPLETED,

    /**
     * Canceled tasks are not displayed on user dashboard. Its displays only by pressing
     * special button in GUI.
     */
    CANCELED,

    /**
        This filter contains all closed tasks; this is so-called database of performed
        tasks. The task is moved to this filter, as soon as the "Close" button is pressed
        on it. Each user can see the list of tasks assigned to and by him/her.
    */
    CLOSED
}
