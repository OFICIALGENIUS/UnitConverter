import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UnitConverter {
	public static void main(String [] rk)
     {
	JFrame jf = new JFrame();
	jf.setSize(600, 400);
	jf.setLocationRelativeTo(null);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	String [] arr = {"Temperature", "Weight", "Length", "Currency"};
	JComboBox <String>  jcb = new JComboBox<>(arr);
	jcb.insertItemAt("Time", 1);	

	

	jf.add(jcb, BorderLayout.NORTH);

	JPanel p = new JPanel();
	jf.add(p);
	p.setLayout(null);
	
	String [] temp = {"Celcius", "Fahrenheite", "Kelvin"};
	JTextField t1 = new JTextField(10);
	JComboBox <String> jc1 = new JComboBox<>(temp);

	JTextField t2 = new JTextField(10);
	t2.setEditable(false);   
	JComboBox <String> jc2 = new JComboBox<>(temp);

	p.add(t1);     t1.setBounds(100, 100, 200, 50);
	p.add(jc1);   jc1.setBounds(350, 100, 80, 50);

	p.add(t2);     t2.setBounds(100, 200, 200, 50);
	p.add(jc2);   jc2.setBounds(350, 200, 80, 50);

	class MyListener implements ItemListener
	{
	     public void itemStateChanged(ItemEvent e)
	      {
                                    String str = t1.getText();
		double input = 0;
		if(str != null)
		        input = Double.parseDouble(str);
		String input_type = (String) jc1.getSelectedItem();
		String output_type = (String) jc2.getSelectedItem();
		double result = input;

		if(input_type.equals("Celcius"))
		{
		     if(output_type.equals("Fahrenheite"))
		     {
			 result = (input * 9/5)+32;
		     }
		     else if(output_type.equals("Kelvin"))
		     {
			 result = 273.15+input;
		     }
		   
		}

		t2.setText(""+result);	

                        }
	}	
	MyListener ml = new MyListener();
	jcb.addItemListener(ml);
	jc1.addItemListener(ml);
	jc2.addItemListener(ml);
	jf.setVisible(true);
    }
}
