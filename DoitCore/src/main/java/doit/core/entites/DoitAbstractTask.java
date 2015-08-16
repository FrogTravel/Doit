/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doit.core.entites;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


// REVIEW DATE: 12.08.2015
// REVIEWER: ALMAZ


/**
 * Абстрактный класс, описывающий общие поля и методы, для работы с задачами
 * @author Anatoly
 */
@XmlRootElement
@XmlType(propOrder = {"name", "description", "startDate", "finishDate", "attachmentList"})
public abstract class DoitAbstractTask {
    /** Имя */
    protected String name;
    /** Описание */
    protected String description;
    /** Дата начала */
    protected Date startDate;
    /** Дата завершения */
    protected Date finishDate;

    protected List<DoitAttachment> attachmentList;

    // TODO: Describe this function here, please
    public void addAttachment(DoitAttachment attachment){
        this.attachmentList.add(attachment);
    }
    // TODO: Describe this function here, please
    public void removeAttachment(DoitAttachment attachment){
        this.attachmentList.remove(attachment);
    }
    // TODO: Describe this function here, please
    public List<DoitAttachment> getAttachmentList(){
        return attachmentList;
    }

    @XmlElementWrapper(name = "attachments")
    @XmlElement(name = "attachment")
    public void setAttachmentList(List<DoitAttachment> attachments){
        attachmentList = attachments;
    }

    protected DoitAbstractTask() {
        this.attachmentList = new ArrayList<DoitAttachment>();
    }

    
    /**
     * Изменение имени
     * @param name Новое имя
     * 
     * TODO: а если я null передам, то что будет?
     */
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получение имени
     * @return Имя
     */
    public String getName() {
        return this.name;
    }

    /**
     * Возвращает описание
     * @return Описание
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Позволяет именить описание ({@link DoitAbstractTask#description})
     * @param descr Новое описание
     * 
     * TODO: а если я null передам, то что будет?
     */
    @XmlElement
    public void setDescription(String descr) {
        this.description = descr;
    }

    /**
     * Возвращает объект Date - дата начала
     * @return Дата начала
     */
    public Date getStartDate() {
        return this.startDate;
    }

    /**
     * Возвращает объект Date - дата завершения
     * @return Дата завершения
     */
    public Date getFinishDate() {
        return this.finishDate;
    }


    /**
     * Позволяет изменить дату завершения
     * @param finish Дата завершения
     *
     * TODO: а если я null передам, то что будет?
     */
    @XmlElement
    public void setFinishDate(Date finish) {
        this.finishDate = finish;
    }

    @XmlElement
    public void setStartDate(Date start) {
        this.startDate = start;
    }

}
