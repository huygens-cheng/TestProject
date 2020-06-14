import java.awt.*;
import javax.swing.*;

/**
 * 设备选件面板
 * @author chen
 *
 */

public class DeviceOptionTab extends JPanel{

	//function:initDeviceOptionPanel
	private String[] arrangedStr = { "无", "FS-532", "SD-506", "SD-506+FS-532","FS-612" };
	private JComboBox arrangedComboBox = new JComboBox(arrangedStr);
	private String[] largeCapacityPaperFeedBoxStr = { "无", "LU-202", "PF-707", "PF-708" };
	private JComboBox largeCapacityPaperFeedBoxComboBox = new JComboBox(largeCapacityPaperFeedBoxStr);
	private String[] perforatingEquipmentStr = {"无"};
	private JComboBox perforatingEquipmentComboBox = new JComboBox(perforatingEquipmentStr);
	
	
	private JPanel initDeviceOptionLeftPanel() {
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		//panel.setBorder(BorderFactory.createTitledBorder("Finish"));
		
		JLabel arrangedLabel = new JLabel("整理器:");
		JLabel largeCapacityPaperFeedBoxLabel = new JLabel("折叠方式:");
		JLabel perforatingEquipmentLabel = new JLabel("打孔设备:");
		
		panel.add(arrangedLabel);
		panel.add(arrangedComboBox);
		panel.add(largeCapacityPaperFeedBoxLabel);
		panel.add(largeCapacityPaperFeedBoxComboBox);
		panel.add(perforatingEquipmentLabel);
		panel.add(perforatingEquipmentComboBox);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		con.insets = new Insets(3,3,3,3);
		gridbag.setConstraints(arrangedLabel, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 1;
		gridbag.setConstraints(arrangedComboBox, con);

		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(largeCapacityPaperFeedBoxLabel, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 1;
		gridbag.setConstraints(largeCapacityPaperFeedBoxComboBox, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(perforatingEquipmentLabel, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 1;
		gridbag.setConstraints(perforatingEquipmentComboBox, con);
	
		return panel;
	}
	
	
	
	private JPanel initDeviceOptionPanel() {
		
		//GridBagLayout gridbag = new GridBagLayout();
		//GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(new GridLayout(1,2,0,0));
		panel.setBorder(BorderFactory.createTitledBorder("设备选件"));
		
		JPanel leftPanel = initDeviceOptionLeftPanel();
		JPanel blank = new JPanel();
		
		panel.add(leftPanel);
		panel.add(blank);
		
		
		return panel;
	}
	
	public DeviceOptionTab() {
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		this.setLayout(gridbag);
		
		JPanel deviceOptionPanel = initDeviceOptionPanel();
		JPanel blank = new JPanel();
		
		this.add(deviceOptionPanel);
		this.add(blank);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 1;
		gridbag.setConstraints(deviceOptionPanel, con);
		con.weighty = 1;
		gridbag.setConstraints(blank, con);
		
	}
}
