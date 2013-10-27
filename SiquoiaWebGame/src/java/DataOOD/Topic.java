/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOOD;

/**
 *
 * @author mr.nam
 */
public class Topic {

    private int id;
    private String topic;

    public Topic(int id, String topic) {
        this.id = id;
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    @Override
    public String toString() {
        return "[[id:"+id+"],[topic:"+topic+"]]";
    }

    String toSimpleString() {
        return topic;
    }

    
}
