package doit.core.entites;

import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// REVIEW DATE: 11.08.2015
// REVIEWER: ALMAZ


/**
 * Класс для хранения и работы с задачей
 * @author Anatoly
 */
@XmlRootElement(name = "task")
@XmlType(name = "", propOrder = {"name", "description", "startDate", "finishDate", "attachmentList"})
public class DoitTask extends DoitAbstractTask {
    /** Степень важности задачи */
    @XmlAttribute(name = "priority")
    private DoitTaskPriority priority;
    /** Статус завершения задачи */
    @XmlAttribute(name = "status")
    private DoitTaskStatus status;

    /***
     * Инициализация полей {@link DoitTask#name}, {@link DoitTask#startDate},
     *              {@link DoitAttachment}  {@link DoitTaskPriority} {@link DoitTaskStatus}
     *
     * @param name Имя
     * @param start Дата начала
     * @param attachment Прикрепление
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
     * Инициализация полей {@link DoitTask#name}, {@link DoitTask#startDate}, {@link DoitAttachment}
     * @param name Имя
     * @param start Дата начала
     * @param attachment Прикрепление
     */
    public DoitTask(String name, Date start, DoitAttachment attachment) {
        this.name = name;
        this.startDate = start;
        this.attachmentList.add(attachment);
    }
    /**
     * Инициализация полей {@link DoitTask#name}, {@link DoitTask#startDate}
     * @param name Имя
     * @param start Дата начала
     */
    public DoitTask(String name, Date start) {
        this.name = name;
        this.startDate = start;
    }
    /**
     * Инициализация полей {@link DoitTask#name}
     * @param name Имя
     */
    public DoitTask(String name) {
        this.name = name;
    }

    public DoitTask() {
    }

    /**
     * Изменение степени важности задачи
     * @param  priority
     */
    public void setPriority(DoitTaskPriority priority) {
        this.priority = priority;
    }

    public DoitTaskPriority getPriority() {
        return priority;
    }

    public DoitTaskStatus getStatus() {
        return status;
    }

    public void setStatus(DoitTaskStatus status) {
        this.status = status;
    }
}
