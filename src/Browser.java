import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;


public class Browser extends JFrame{
    private JTextArea Ingresar;
    private JButton Enter;
    private JButton Back;//Undo
    private JButton Forward;//Redo
    private JTextArea Mostrar;
    private JPanel Jpanel1;
    private JPanel JPanel2;
    private JButton Limpiar;

    private Stack<String> browser = new Stack<>();
    private Stack<String> browserAhead = new Stack<>();

    public Browser() {

        setContentPane(Jpanel1);

        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BackAction();
                RefreshTextArea();
            }
        });

        Forward.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ForwardAction();
                RefreshTextArea();
            }
        });

        Enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddWebToStack();
                RefreshTextArea();
            }
        });

        Limpiar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
               Limpiar();
            }
        });

        Back.setEnabled(false);
        Forward.setEnabled(false);
    }

    private void ForwardAction() {
        if(browserAhead.isEmpty()){
            Forward.setEnabled(false);
            return;
        }
        browser.push(browserAhead.pop());
    }

    private void BackAction() {
        if(browser.isEmpty()) return;

        browserAhead.push(browser.pop());
        Forward.setEnabled(true);

        if(browser.isEmpty()) Back.setEnabled(false);
    }

    private void RefreshTextArea(){
        Mostrar.setText(browser.toString());
    }

    private void AddWebToStack(){
        //browser.push("Website #"+browser.size());
        browser.push(Ingresar.getText());
        browserAhead.clear();

        Back.setEnabled(true);
        Forward.setEnabled(false);
    }

    private void Limpiar(){
        Ingresar.setText("");
    }

}
