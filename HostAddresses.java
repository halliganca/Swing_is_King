import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.Arrays;
import javax.swing.*;

public class HostAddresses extends JFrame implements ActionListener 
{

    // private final JLabel label;
    private final JTextField tf;
    private final JTextArea ta;
    private final JButton button;
    
    public HostAddresses () 
    {

	super("Java");
	setLayout(new FlowLayout());        

	tf = new JTextField (30);
	add(tf);

	button = new JButton ("Enter");
	button.addActionListener(this);
	add(button);
        
        ta = new JTextArea();
        ta.setSize(460, 500);
        ta.setText("Displays all IP addresses for a given host...");
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        add(ta);

	// label = new JLabel (" ");
        // label.setSize(600, 400);
	// add(label);
    }
    
    private static void createAndShowGUI () 
    {
	JFrame frame = new HostAddresses ();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));
        frame.setSize(640, 480);
	// frame.pack();
	frame.setVisible(true);
    }    
	   
    @Override
    public void actionPerformed (ActionEvent e)  
    {
        try
        {
            InetAddress[] myList = InetAddress.getAllByName(tf.getText());
              
                if (e.getSource() == button) 
                {
                    // label.setText(Arrays.toString(myList));
                    ta.setText(Arrays.toString(myList));              
                }
                  
        }
                        
        catch(UnknownHostException err)
        {
            ta.setText(err.getMessage());
        }
                
    }

public static void main(String[] args) 
{
    javax.swing.SwingUtilities.invokeLater(new Runnable() 
    { 
        @Override
	public void run() 
        {  
	    createAndShowGUI(); 
        }
    });	        
	 
    
}

}

