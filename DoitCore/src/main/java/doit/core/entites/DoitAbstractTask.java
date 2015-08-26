/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doit.core.entites;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 * @author Anatoly
 */
@XmlRootElement
@XmlTransient
@XmlSeeAlso({DoitTask.class, DoitProject.class})
@XmlType(propOrder = {"name", "description", "startDate", "finishDate", "attachmentList"})
public abstract class DoitAbstractTask {
    protected String name;
    protected String description;
    protected Date startDate;
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

    public DoitAbstractTask() {
        this.attachmentList = new ArrayList<DoitAttachment>();
    }

    
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public Date getFinishDate() {
        return this.finishDate;
    }

    @XmlElement
    public void setFinishDate(Date finish) {
        this.finishDate = finish;
    }

    @XmlElement
    public void setStartDate(Date start) {
        this.startDate = start;
    }

}
