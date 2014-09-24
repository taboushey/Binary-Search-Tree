
import javax.swing.JOptionPane;

/*
 * @author Tabetha Boushey 
 * Date: 6/25/2013 
 * CSCI232 Lab 1 
 * Class: Data
 */
public class Data implements Comparable {

    private int intValue;
    private String stringValue;

    public Data(int h, String i) {
        intValue = h;
        stringValue = i;
    }

    public void setIntValue(int newVal) {
        this.intValue = newVal;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setStringValue(String newVal) {
        this.stringValue = newVal;
    }

    public String getStringValue() {
        return this.stringValue;
    }

    public static Data fromString(String str) {

        str = str.trim();

        String tokens[] = str.split(" ");
        String number = tokens[0];
        String string = "";
        for (int i = 1; i < tokens.length; i++) {
            string = string + tokens[i] + " ";
            
        }
        string = string.trim();
        
        Data data = null;
        try {
            int value = Integer.parseInt(number);
            data = new Data(value, string);
        } catch (NumberFormatException ex) {
            throw ex;
        }
        return data;
    }

    @Override
    public int compareTo(Object t) {
        Data that = (Data) t;
        if (this.getStringValue().equals(that.getStringValue())) {
            return this.getIntValue() - that.getIntValue();
        } else {
            return this.getStringValue().compareTo(that.getStringValue());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Data) {
            Data that = (Data) o;
            if (this.getIntValue() == that.getIntValue() && this.getStringValue().equals(that.getStringValue())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "[" + this.getIntValue() + " " + this.getStringValue() + "]";
    }
    
}
