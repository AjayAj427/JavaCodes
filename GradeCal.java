package sdmcet;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Calculate implements ActionListener{
	double see,tm;
	int cie;
	JFrame f = new JFrame("Student Grading System");
	JLabel l = new JLabel("Grade Calculator");
	JLabel l1= new JLabel("Enter IA-1 Marks");
	JLabel l2 = new JLabel("Enter IA-2 Marks");
	JLabel l3 = new JLabel("Enter IA-3 Marks");
	JLabel l4 = new JLabel("Enter CTA Marks");
	JLabel l5 = new JLabel("Invalid Marks");
	JLabel l6 = new JLabel("Detained from SEE");
	JLabel l7 = new JLabel("Enter SEE Marks");
	JLabel l8 = new JLabel("Total Marks : ");
	JLabel l9 = new JLabel("");
	JLabel l10 = new JLabel("Grade : ");
	JLabel l11 = new JLabel("");
	
	JTextField tf1 = new JTextField(10);
	JTextField tf2 = new JTextField(10);
	JTextField tf3 = new JTextField(10);
	JTextField tf4 = new JTextField(10);
	JTextField tf5 = new JTextField(10);
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JPanel p6 = new JPanel();
	JPanel p7 = new JPanel();
	JPanel p8 = new JPanel();
	JPanel p9 = new JPanel();
	JPanel p10 = new JPanel();
	
	JButton b1 = new JButton("Check Eligibility");
	JButton b2 = new JButton("Calculate");
	
	Calculate(){
		f.setBounds(100, 100, 400,500);
		f.setVisible(true);
		
		p1.add(l);                  
		
		p2.add(l1);
		p2.add(tf1);
		
		p3.add(l2);
		p3.add(tf2);
		
		p4.add(l3);
		p4.add(tf3);
		
		p5.add(l4);
		p5.add(tf4);
		
		p6.add(b1);
		p8.add(b2);
		
		p7.add(l7);
		p7.add(tf5);
		
		p9.add(l8);
		p9.add(l9);
		p9.add(l10);
		p9.add(l11);
		
		f.add(p1);                
		f.add(p2);
		f.add(p3);
		f.add(p4);
		f.add(p5);
		f.add(p6);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout(10,0));
		b1.addActionListener(this);
		b2.addActionListener(this);	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int ia1,ia2,ia3,cta;
		
		if(e.getSource()==b1) {
			if(tf1.getText().isEmpty()) {            
				ia1 = 0;
			}else {
				ia1 = Integer.parseInt(tf1.getText());
			}
			if(tf2.getText().isEmpty()) {
				ia2 = 0;
			}else {
				ia2 = Integer.parseInt(tf2.getText());
			}
			if(tf3.getText().isEmpty()) {
				ia3 = 0;
			}else {
				ia3 = Integer.parseInt(tf3.getText());
			}
			if(tf4.getText().isEmpty()) {
				cta = 0;
			}else {
				cta = Integer.parseInt(tf4.getText());
			}
			if(ia1>=ia3 && ia2>=ia3) {                   
				cie = ia1+ia2+cta;
			}else if(ia2>=ia1 && ia3>=ia1) {
				cie = ia2+ia3+cta;
			}else {
				cie = ia1+ia3+cta;
			}
			      
			try {                                        
				if(ia1<0 || ia1>20 || ia2<0 || ia2>20 || ia3<0 || ia3>20 || cta<0 || cta>10) {
					throw new ArithmeticException();
				}
			}
			catch(ArithmeticException ae) {              
				JOptionPane.showMessageDialog(f, l5, "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		    if(cie<20) {                                 
		    	JOptionPane.showMessageDialog(f, l6, "Message", JOptionPane.INFORMATION_MESSAGE);
		    	return;
		    }	
		}
		
		f.add(p7);
		f.add(p8);
		f.setBounds(00, 00, 500, 500);
		
		if(e.getSource()==b2) {
			f.add(p9);	
			if(tf5.getText().isEmpty()) {
				see = 0;
			}else {
				see = Integer.parseInt(tf5.getText());
			}
			                                        
			try {          
				if(see<0 || see >100) {
					throw new ArithmeticException();
				}
			}catch(ArithmeticException ae){
				f.setBounds(00, 00, 490, 490);
				JOptionPane.showMessageDialog(f, l5, "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(see==38 || see==39) {
				see=40;
			}
			if(see<38) {
				l11.setText("F");
				l9.setText("");
				l8.setText("");
				return;
			}
			
			see = see/2;                         
			see = (int)Math.ceil(see);
			tm = see+cie;
			
			String total = Double.toString(tm);   
			l9.setText(total);
	     	l8.setText("Total Marks : ");
			if(tm<=100 && tm>=90) {
				l11.setText("S");
			}else if(tm<=89 && tm>=80) {
				l11.setText("A");
			}else if(tm<=79 && tm>=70) {
				l11.setText("B");
			}else if(tm<=69 && tm>=60) {
				l11.setText("C");
			}else if(tm<=59 && tm>=50) {
				l11.setText("D");
			}else if(tm<=49 && tm>=40) {
				l11.setText("E");
			}else{
				l11.setText("F");
			}	
		}			
	}	
}
public class GradeCal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculate c = new Calculate();
	}
}
