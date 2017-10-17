import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Mainframe extends JFrame {
    private JTextField Jtf = new JTextField();
   private JButton Jbtn[] = new JButton[9];
   private JPanel Jp= new JPanel(new GridLayout(3,3,3,3));
    private Container cp;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW = 300,frmH=400 ,ScreenW,ScreenH;
    private  Loginframe log;

    public Mainframe(Loginframe loginframe){
       log= loginframe;
        init();

    }
    private void init(){

        ScreenH=dim.height;
        ScreenW=dim.width;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Mainframe.this.setVisible(false);
                log.setVisible(true);
            }
        });

       // this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(ScreenW/2-frmW/2,ScreenH/2-frmH/2,frmW,frmH);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(5,5));
        cp.add(Jtf,BorderLayout.NORTH);
        cp.add(Jp,BorderLayout.CENTER);
        for (int i = 0 ;i<9;i++){
            Jbtn[i]=new JButton(Integer.toString(i));
            Jp.add(Jbtn[i]);
            Jbtn[i].addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tmpButton = (JButton)e.getSource();
                    Jtf.setText(Jtf.getText()+tmpButton.getText());

                }
            });


        }
        Jtf.setEditable(false);
    }
}
