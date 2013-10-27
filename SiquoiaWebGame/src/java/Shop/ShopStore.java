/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Shop;

import DataOOD.Node;
import DataOOD.Topic;
import java.util.List;

/**
 *
 * @author mr.nam
 */
public class ShopStore {
    private List<Packet> packetList;
    private  Node topicNode;
    public ShopStore(Node topicNode) {
        this.topicNode = topicNode;
        makePacketList(topicNode);
    }

    private void makePacketList(Node topicList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<Packet> getPacketList() {
        return packetList;
    }
    
}
