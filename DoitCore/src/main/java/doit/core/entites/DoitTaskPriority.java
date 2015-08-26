package doit.core.entites;

import javax.xml.bind.annotation.*;

/**
 * Created by Almaz on 23.08.2015.
 */
@XmlType(name = "priority")
@XmlEnum
public enum DoitTaskPriority {
    @XmlEnumValue("PRIORITY_1")
    PRIORITY_1,
    @XmlEnumValue("PRIORITY_2")
    PRIORITY_2,
    @XmlEnumValue("PRIORITY_3")
    PRIORITY_3,
    @XmlEnumValue("PRIORITY_4")
    PRIORITY_4,
    @XmlEnumValue("PRIORITY_5")
    PRIORITY_5;
}
