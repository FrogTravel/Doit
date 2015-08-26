/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doit.core.entites;

import java.io.File;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Anatoly
 */
@XmlRootElement(name = "attachment")
@XmlType(propOrder = {"name", "file"})
public class DoitAttachment extends File{
    private File file;
    private String name;

    /**
     *
     * Initializing field  {@link DoitAttachment} и {@link DoitAttachment#file}
     * @param name Short attachment name
     * @param file path to attached file
     * @see DoitAttachment
     */
    public DoitAttachment(String name, File file) {
        super(file.toURI());
        this.name = name;
        this.file = file;
    }
    
    public DoitAttachment(){
        super("");
    }

    
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
