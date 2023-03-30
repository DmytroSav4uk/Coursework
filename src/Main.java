import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class Main {
    Object[] headersA = { "Column 1", "Column 2", "Column 3", "Column 4"};
    Object[] headersB = { "Column 1", "Column 2", "Column 3" };
    Object[] headersAt = { "Column 1", "Column 2", "Column 3" };
    Object[] headersBt = { "Column 1", "Column 2", "Column 3" };
    Object[] headersC = { "Column 1", "Column 2", "Column 3" };
    Object[][] A = { { 2, 3, 4, 2 }, { 3, 6, 3, 5 }, { 4, 6, 3, 1 } };
    Object[][] B = { { 3, 2, 4, 2, 6 }, { 2, 1, 6, 5, 7 }, { 3, 6, 4, 5, 4 }, { 5, 3, 4, 2, 6 } };
    Object[][] At = new Object[3][4];
    Object[][] Bt = new Object[4][3];
    Object[][] C = new Object[4][3];
    int i, j, f, g;
    int maxElement = Integer.MIN_VALUE;

    {
        for (i = 0; i < 3; i++)
            for (j = 0; j < 4; j++) {
                At[i][j] = (int) A[i][j];
            }
    }
    {
        for (i = 0; i < 3; i++)
            for (j = 0; j < 4; j++) {
                Bt[j][i] = (int) B[i][j];
            }
    }

    {
        for (i = 0; i < 4; i++)
            for (j = 0; j < 3; j++) {
                C[i][j] = 4 * ((int) At[j][i] * (int) At[j][i]) + (int) Bt[i][j];
            }
    }
    {
        for (i = 0; i < 4; i++)
            for (j = 0; j < 3; j++) {
                if ((int) C[i][j] > maxElement) {
                    maxElement =(int) C[i][j];
                }
            }
    }
    int product = 1;
    {
        for (i = 1; i < 4; i = i + 2)
            for (j = 0; j < 3; j++) {
                product *= (int) C[i][j];

            }
    }
    JTable jTabA;
    JTable jTabB;
    JTable jTabAt;
    JTable jTabBt;
    JTable jTabC;

    Main() {
        JFrame jfrm = new JFrame("VARIANT 15, OK-33");

        jfrm.getContentPane().setLayout(new GridLayout(3, 2));
        jfrm.setSize(900, 350);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setVisible(true);

        jTabA = new JTable(A, headersA);
        JScrollPane jscrlpA = new JScrollPane(jTabA);
        jTabA.setPreferredScrollableViewportSize(new Dimension(250, 100));
        jfrm.getContentPane().add(jscrlpA);

        jTabB = new JTable(B, headersB);
        JScrollPane jscrlpB = new JScrollPane(jTabB);
        jTabB.setPreferredScrollableViewportSize(new Dimension(250, 100));
        jfrm.getContentPane().add(jscrlpB);

        jTabAt = new JTable(At, headersAt);
        JScrollPane jscrlpAt = new JScrollPane(jTabAt);
        jTabAt.setPreferredScrollableViewportSize(new Dimension(250, 100));
        jfrm.getContentPane().add(jscrlpAt);

        jTabBt = new JTable(Bt, headersBt);
        JScrollPane jscrlpBt = new JScrollPane(jTabBt);
        jTabBt.setPreferredScrollableViewportSize(new Dimension(250, 100));
        jfrm.getContentPane().add(jscrlpBt);

        jTabC = new JTable(C, headersC);
        JScrollPane jscrlpC = new JScrollPane(jTabC);
        jTabC.setPreferredScrollableViewportSize(new Dimension(250, 100));
        jfrm.getContentPane().add(jscrlpC);

        JButton button = new JButton("Рохрахувати");
        JLabel label = new JLabel("Максимальний елемент матриці С");
        JTextField text = new JTextField("              ");
        JLabel label1 = new JLabel("Добуток елементів непарних рядків матриці С");
        JTextField text1 = new JTextField("                       ");

        FlowLayout F1 = new FlowLayout();
        JPanel panel = new JPanel(F1);
        panel.setBorder(BorderFactory.createEtchedBorder());
        panel.add(label);

        panel.add(text);
        panel.add(label1);
        panel.add(text1);
        panel.add(button);
        jfrm.getContentPane().add(panel);
        button.addActionListener(e -> {

            text.setText("" + maxElement);
            text1.setText("" + product);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}