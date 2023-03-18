

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Math.pow;

public class Main {
    Object[] headersA = {"Column 1", "Column 2", "Column 3", "Column 4"};
    //Масив, що вміщає заголовки таблиці В
    Object[] headersB = {"Column 1", "Column 2", "Column 3", "Column 4"};
    //Масив, що вміщає заголовки перетвореної таблиці А
    Object[] headersANew = {"Column 1", "Column 2", "Column 3", "Column 4"};
    //Масив, що вміщає заголовки перетвореної таблиці В
    Object[] headersBNew = {"Column 1", "Column 2", "Column 3", "Column 4"};
    //Масив, що вміщає заголовки результуючої таблиці С
    Object[] headersC = {"Column 1", "Column 2", "Column 3", "Column 4"};
    Object[][] dataA = {{1, 3, 5, 5}, {2, 4, 2, 4}, {7, 9, 11, 10}, {7, 9, 8, 10},};
    Object[][] dataB = {{71, 1, 0, 1}, {94, 2, 1, 0}, {75, 12, 31, 40}, {34, 3, 1, 2},};
    Object[][] dataANew = new Object[4][4];
    int i, j;

    {
        for (i = 0; i < 4; i++)
            for (j = 0; j < 4; j++) {
                dataANew[i][j] = (int) dataA[j][i];
            }
    }

    Object[][] dataBNew = new Object[4][4];

    {
        for (i = 0; i < 4; i++)
            for (j = 0; j < 4; j++) {
                dataBNew[i][j] = pow((int) dataB[j][i], 1);
            }
    }

    //Масив, що вміщає дані таблиці C
    Object[][] dataC = new Object[4][4];
    int f, g;

    {
        for (f = 0; f < 4; f++)
            for (g = 0; g < 4; g++) {
                dataC[f][g] = 7 * f + 3 * g;
            }
    }

    int p, l, count;
    double max, min;
    int nr_min, ns_min;

    {

        nr_min = 0;
        ns_min = 0;
        count = 0;


        for (p = 0; p < dataC.length; p++)
            for (l = 0; l < dataC[p].length; l++) {
                int foo = (int) dataC[p][l];
                if (  foo >  0 ) {
                    count += 1;
                }
            }
    }

    int p1, l1;
    int sum = 0;

    {
        for (p1 = 0; p1 < 4; p1++)

            for (l1 = 0; l1 < 4; l1++) {
                if (l1 % 2 != 0){
                sum += (int) dataC[p1][l1];
                System.out.println(dataC[p1][l1]);
                }
            }

    }

    //Об'єкт таблиці А
    JTable jTabA;
    //Об'єкт таблиці B
    JTable jTabB;
    //Об'єкт таблиці АNew
    JTable jTabANew;
    //Об'єкт таблиці BNew
    JTable jTabBNew;
    //Об'єкт таблиці C
    JTable jTabC;

    Main() {
        JFrame jfrm = new JFrame("VARIANT_10, OK-33");

        jfrm.getContentPane().setLayout(new GridLayout(3, 2));
        jfrm.setSize(900, 600);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setVisible(true);

        jTabA = new JTable(dataA, headersA);
        JScrollPane jscrlpA = new JScrollPane(jTabA);
        jTabA.setPreferredScrollableViewportSize(new Dimension(250, 100));


        jfrm.getContentPane().add(jscrlpA);

        jTabB = new JTable(dataB, headersB);
        JScrollPane jscrlpB = new JScrollPane(jTabB);
        jTabB.setPreferredScrollableViewportSize(new Dimension(250, 100));


        jfrm.getContentPane().add(jscrlpB);
        jTabANew = new JTable(dataANew, headersANew);
        JScrollPane jscrlpANew = new JScrollPane(jTabANew);
        jTabANew.setPreferredScrollableViewportSize(new Dimension(250, 100));

        jfrm.getContentPane().add(jscrlpANew);

        jTabBNew = new JTable(dataBNew, headersBNew);
        JScrollPane jscrlpBNew = new JScrollPane(jTabBNew);
        jTabBNew.setPreferredScrollableViewportSize(new Dimension(250, 100));

        jfrm.getContentPane().add(jscrlpBNew);

        jTabC = new JTable(dataC, headersC);
        JScrollPane jscrlpC = new JScrollPane(jTabC);
        jTabC.setPreferredScrollableViewportSize(new Dimension(250, 100));

        jfrm.getContentPane().add(jscrlpC);

        JButton button = new JButton("Рохрахувати");
        JLabel label2 = new JLabel("Номер рядка мінімального елементу матриці С");
        JTextField text12 = new JTextField("              ");
        JLabel label3 = new JLabel("Номер стовпця мінімального елементу матриці С");
        JTextField text13 = new JTextField("              ");
        JLabel label = new JLabel("Кількість додатних чисел матриці С");
        JTextField text = new JTextField("              ");
        JLabel label1 = new JLabel("сума елементів парних стовпців матриці  С");
        JTextField text1 = new JTextField("                       ");
        FlowLayout F1 = new FlowLayout();
        JPanel panel = new JPanel(F1);
        panel.setBorder(BorderFactory.createEtchedBorder());

        panel.add(label2);
        panel.add(text12);
        panel.add(label3);
        panel.add(text13);
        panel.add(label);
        panel.add(text);
        panel.add(label1);
        panel.add(text1);
        panel.add(button);
        jfrm.getContentPane().add(panel);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //при натисканні на кнопку виконується метод actionPerformed
                //виводимо результат пошуку даних в матриці С
                text12.setText("" + (nr_min + 1));
                text13.setText("" + (ns_min + 1));
                text.setText("" + count);
                text1.setText("" + sum);
            }
        });
    }

    //Функція main, Що запускається при старті додатка
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}