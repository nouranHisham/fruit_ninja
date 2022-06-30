package LogicPackage.Misc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Time")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaveTimer {

    @XmlElement(name = "mins")
    private int mins ;
    @XmlElement(name ="secs")
    private int secs ;
    @XmlElement(name = "millis")
    private int millis;

    public int getMins() {
        return mins;
    }

    public void setMins(int mins) {
        this.mins = mins;
    }

    public int getSecs() {
        return secs;
    }

    public void setSecs(int secs) {
        this.secs = secs;
    }

    public int getMillis() {
        return millis;
    }

    public void setMillis(int millis) {
        this.millis = millis;
    }
}
