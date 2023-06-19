import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.text.DecimalFormat;
class Temp implements ActionListener
{
    private static JButton btn;
    private static JTextField intext,outputText;
    private static JComboBox<String> cbf, cbt;
    
    public static void main(String args[])
    {
        JFrame f=new JFrame();

        JLabel inputTemp=new JLabel();
        inputTemp.setText("Enter temperature :");
        inputTemp.setBounds(10, 20, 200, 30);
        inputTemp.setFont(new Font("Times New Roman", Font.PLAIN, 24));

        JLabel type1=new JLabel();
        type1.setText("Convert from :");
        type1.setBounds(10, 100, 200, 30);
        type1.setFont(new Font("Times New Roman", Font.PLAIN, 24));

        JLabel out=new JLabel();
        out.setText("Output :");
        out.setBounds(10, 250, 200, 30);
        out.setFont(new Font("Times New Roman", Font.PLAIN, 24));

        JLabel type2=new JLabel();
        type2.setText("To :");
        type2.setBounds(300, 100, 200, 30);
        type2.setFont(new Font("Times New Roman", Font.PLAIN, 24));

        btn=new JButton("Convert");
        btn.setBounds(180,150,100,50);
        btn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btn.setFocusable(false);
        btn.setBackground(new Color(0x754522));
        btn.setForeground(new Color(0xffffff));
        btn.addActionListener(new Temp());

        intext=new JTextField();
        intext.setBounds(200,20,200,30);
        intext.setBackground(new Color(0x754522));
        intext.setForeground(new Color(0xffffff));
        intext.setCaretColor(Color.white);
        intext.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        String opf[]={"Celsius","Fahrenheit","Kelvin"};
        cbf=new JComboBox<>(opf);
        cbf.setBounds(160,103,100,30);
        cbf.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        String opt[]={"Celsius","Fahrenheit","Kelvin"};
        cbt=new JComboBox<>(opt);
        cbt.setBounds(350,103,100,30);
        cbt.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        outputText=new JTextField();
        outputText.setBounds(200,250,200,30);
        outputText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        outputText.setBackground(new Color(0x754522));
        outputText.setForeground(new Color(0xffffff));
        outputText.setEditable(false);
        
        ImageIcon img=new ImageIcon("C:\\Users\\91760\\OneDrive\\Desktop\\New folder (2)\\Temperature\\icon.jpeg");

        f.setSize(500,350);
        f.setTitle("Temperature converter");
        f.getContentPane().setBackground(new Color(0xf5e8c4));
        f.setIconImage(img.getImage());
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.add(intext);
        f.add(outputText);
        f.add(inputTemp);
        f.add(type1);
        f.add(out);
        f.add(type2);
        f.add(btn);
        f.add(cbf);
        f.add(cbt);
        f.setVisible(true);
    }
    
    private static DecimalFormat decimalFormat = new DecimalFormat("#.###");

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btn)
        {
            String val=intext.getText();
            if(isValidNumber(val))
            {
                intext.setEditable(false);
                btn.setEnabled(false);
                outputText.setText(intext.getText());
                String fr=(String)cbf.getSelectedItem();
                String t=(String)cbt.getSelectedItem();

                double ct=convertedTemp(fr,t);
                String formattedOutput = decimalFormat.format(ct);
                outputText.setText(formattedOutput);
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid input type","Warning",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private static boolean isValidNumber(String input) 
    {
        try 
        {
            Double.parseDouble(input);
            return true;
        } 
        catch (NumberFormatException e) 
        {
            return false;
        }
    }
    
    private static double convertedTemp(String f, String t)
    {
        double d=Double.parseDouble(intext.getText());
        if(f.equalsIgnoreCase("Celsius"))
        {
            if(t.equalsIgnoreCase("Kelvin"))
            {
                return d+273.15;            
            }
            else if(t.equalsIgnoreCase("Celsius"))
            {
                return d;
            }
            else if(t.equalsIgnoreCase("Fahrenheit"))
            {
                return (1.8*d)+32;
            }
        }
        else if(f.equalsIgnoreCase("Kelvin"))
        {
            if(t.equalsIgnoreCase("Kelvin"))
            {
                return d;            
            }
            else if(t.equalsIgnoreCase("Celsius"))
            {
                return d-273.15;
            }
            else if(t.equalsIgnoreCase("Fahrenheit"))
            {
                return (1.8*(d-273.15))+32;
            }
        }
        else if(f.equalsIgnoreCase("Fahrenheit"))
        {
            if(t.equalsIgnoreCase("Kelvin"))
            {
                return ((d-32)/1.8)+273.15;            
            }
            else if(t.equalsIgnoreCase("Celsius"))
            {
                return ((d-32)/1.8);
            }
            else if(t.equalsIgnoreCase("Fahrenheit"))
            {
                return d;
            }
        }
        return 0.0;
    }
}