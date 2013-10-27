/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Shop;

import DataOOD.Topic;

/**
 *
 * @author mr.nam
 */
public class Packet {
    private  double price;
    private  Topic topic;

    public Packet(Topic topic, double price) {
        this.topic = topic;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
    
}
