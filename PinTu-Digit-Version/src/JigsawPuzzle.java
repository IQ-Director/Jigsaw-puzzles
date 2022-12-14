import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

/**
 * ƴͼ��Ϸ
 */
public class JigsawPuzzle extends JFrame implements ActionListener {
    private JButton buttons[][];// �洢����������
    private Container container;// һ������
    private GridLayout layout;// ���ַ�ʽΪGridLayout
    private int count = 0, is[] = new int[8];// count�������Ǽ��㰴���ƶ��Ĵ�����is[]����һ�����������1��8��������

    public JigsawPuzzle() {
        super("ƴͼ��Ϸ");// ���ñ���
        layout = new GridLayout(3, 3);// 3��3��
        container = getContentPane();// �������Ĳ��ַ�ʽ��������Ҫ����������������쳣
        container.setLayout(layout);// ���ò��ַ�ʽ����������
        buttons = new JButton[3][3];// ������������䴢��ռ�
        int locate1, locate2;// locate1����ָʾ��ǰ������Ԫ�� locate2����ָʾlocate1֮ǰ��Ԫ��
        // �÷��������ǲ���1��8��8�����������������飬����������
        for (locate1 = 0; locate1 < 8; locate1++) {
            int g = new Random().nextInt(8) + 1;// �������һ���հװ�����������ʾ���Ǹ�
            is[locate1] = g;
            for (locate2 = locate1 - 1; 0 <= locate2; locate2--) {
                if (is[locate1] == is[locate2])
                    break;
            }
            if (locate2 != -1)
                locate1--;
        }
        int temp = 0;
        int r = new Random().nextInt(3);// �������һ��0��3����������հװ�������
        int l = new Random().nextInt(3);// �������һ��0��3����������հװ�������
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // �հװ�������Ϊ9������ʾ
                if (r == i && l == j) {
                    buttons[i][j] = new JButton("9");
                    container.add(buttons[i][j]);
                    buttons[i][j].setVisible(false);
                } else {
                    buttons[i][j] = new JButton("" + is[temp++]);// �������ֵ��Ϊ��ʾ��8������������
                    container.add(buttons[i][j]);
                }
                buttons[i][j].addActionListener(this);// ע������¼�
            }
        }
        setSize(300, 300);// ������ʾ���������С
        setVisible(true);
    }

    // �¼��������ڼ�����С�ô������а�����������
    @Override
    public void actionPerformed(ActionEvent event) {
        JButton b = (JButton) event.getSource();  //ͨ����ά����ĵ��䣬ʹ����Ϸһֱ�������е��У�ֱ����Ϸ��ɡ�
        if (b == buttons[0][0]) {
            if (buttons[0][1].getText().equals("9")) {
                buttons[0][1].setText("" + buttons[0][0].getText());
                buttons[0][1].setVisible(true);
                buttons[0][0].setText("9");
                buttons[0][0].setVisible(false);
                count++;
            } else if (buttons[1][0].getText().equals("9")) {
                buttons[1][0].setText("" + buttons[0][0].getText());
                buttons[1][0].setVisible(true);
                buttons[0][0].setText("9");
                buttons[0][0].setVisible(false);
                count++;
            }
        } else if (b == buttons[0][1]) {
            if (buttons[0][0].getText().equals("9")) {
                buttons[0][0].setText("" + buttons[0][1].getText());
                buttons[0][0].setVisible(true);
                buttons[0][1].setText("9");
                buttons[0][1].setVisible(false);
                count++;
            } else if (buttons[0][2].getText().equals("9")) {
                buttons[0][2].setText("" + buttons[0][1].getText());
                buttons[0][2].setVisible(true);
                buttons[0][1].setText("9");
                buttons[0][1].setVisible(false);
                count++;
            } else if (buttons[1][1].getText().equals("9")) {
                buttons[1][1].setText("" + buttons[0][1].getText());
                buttons[1][1].setVisible(true);
                buttons[0][1].setText("9");
                buttons[0][1].setVisible(false);
                count++;
            }
        } else if (b == buttons[0][2]) {
            if (buttons[0][1].getText().equals("9")) {
                buttons[0][1].setText("" + buttons[0][2].getText());
                buttons[0][1].setVisible(true);
                buttons[0][2].setText("9");
                buttons[0][2].setVisible(false);
                count++;
            } else if (buttons[1][2].getText().equals("9")) {
                buttons[1][2].setText("" + buttons[0][2].getText());
                buttons[1][2].setVisible(true);
                buttons[0][2].setText("9");
                buttons[0][2].setVisible(false);
                count++;
            }
        } else if (b == buttons[1][0]) {
            if (buttons[0][0].getText().equals("9")) {
                buttons[0][0].setText("" + buttons[1][0].getText());
                buttons[0][0].setVisible(true);
                buttons[1][0].setText("9");
                buttons[1][0].setVisible(false);
                count++;
            } else if (buttons[1][1].getText().equals("9")) {
                buttons[1][1].setText("" + buttons[1][0].getText());
                buttons[1][1].setVisible(true);
                buttons[1][0].setText("9");
                buttons[1][0].setVisible(false);
                count++;
            } else if (buttons[2][0].getText().equals("9")) {
                buttons[2][0].setText("" + buttons[1][0].getText());
                buttons[2][0].setVisible(true);
                buttons[1][0].setText("9");
                buttons[1][0].setVisible(false);
                count++;
            }
        } else if (b == buttons[1][1]) {
            if (buttons[0][1].getText().equals("9")) {
                buttons[0][1].setText("" + buttons[1][1].getText());
                buttons[0][1].setVisible(true);
                buttons[1][1].setText("9");
                buttons[1][1].setVisible(false);
                count++;
            } else if (buttons[1][0].getText().equals("9")) {
                buttons[1][0].setText("" + buttons[1][1].getText());
                buttons[1][0].setVisible(true);
                buttons[1][1].setText("9");
                buttons[1][1].setVisible(false);
                count++;
            } else if (buttons[1][2].getText().equals("9")) {
                buttons[1][2].setText("" + buttons[1][1].getText());
                buttons[1][2].setVisible(true);
                buttons[1][1].setText("9");
                buttons[1][1].setVisible(false);
                count++;
            } else if (buttons[2][1].getText().equals("9")) {
                buttons[2][1].setText("" + buttons[1][1].getText());
                buttons[2][1].setVisible(true);
                buttons[1][1].setText("9");
                buttons[1][1].setVisible(false);
                count++;
            }
        } else if (b == buttons[1][2]) {
            if (buttons[0][2].getText().equals("9")) {
                buttons[0][2].setText("" + buttons[1][2].getText());
                buttons[0][2].setVisible(true);
                buttons[1][2].setText("9");
                buttons[1][2].setVisible(false);
                count++;
            } else if (buttons[2][2].getText().equals("9")) {
                buttons[2][2].setText("" + buttons[1][2].getText());
                buttons[2][2].setVisible(true);
                buttons[1][2].setText("9");
                buttons[1][2].setVisible(false);
                count++;
            } else if (buttons[1][1].getText().equals("9")) {
                buttons[1][1].setText("" + buttons[1][2].getText());
                buttons[1][1].setVisible(true);
                buttons[1][2].setText("9");
                buttons[1][2].setVisible(false);
                count++;
            }
        } else if (b == buttons[2][0]) {
            if (buttons[1][0].getText().equals("9")) {
                buttons[1][0].setText("" + buttons[2][0].getText());
                buttons[1][0].setVisible(true);
                buttons[2][0].setText("9");
                buttons[2][0].setVisible(false);
                count++;
            } else if (buttons[2][1].getText().equals("9")) {
                buttons[2][1].setText("" + buttons[2][0].getText());
                buttons[2][1].setVisible(true);
                buttons[2][0].setText("9");
                buttons[2][0].setVisible(false);
                count++;
            }
        } else if (b == buttons[2][1]) {
            if (buttons[2][0].getText().equals("9")) {
                buttons[2][0].setText("" + buttons[2][1].getText());
                buttons[2][0].setVisible(true);
                buttons[2][1].setText("9");
                buttons[2][1].setVisible(false);
                count++;
            } else if (buttons[2][2].getText().equals("9")) {
                buttons[2][2].setText("" + buttons[2][1].getText());
                buttons[2][2].setVisible(true);
                buttons[2][1].setText("9");
                buttons[2][1].setVisible(false);
                count++;
            } else if (buttons[1][1].getText().equals("9")) {
                buttons[1][1].setText("" + buttons[2][1].getText());
                buttons[1][1].setVisible(true);
                buttons[2][1].setText("9");
                buttons[2][1].setVisible(false);
                count++;
            }
        } else if (b == buttons[2][2]) {
            if (buttons[2][1].getText().equals("9")) {
                buttons[2][1].setText("" + buttons[2][2].getText());
                buttons[2][1].setVisible(true);
                buttons[2][2].setText("9");
                buttons[2][2].setVisible(false);
                count++;
            } else if (buttons[1][2].getText().equals("9")) {
                buttons[1][2].setText("" + buttons[2][2].getText());
                buttons[1][2].setVisible(true);
                buttons[2][2].setText("9");
                buttons[2][2].setVisible(false);
                count++; //ʹ�õ��ĺ�����setText��getText��Ϸ������
            }
        }

        if (buttons[0][0].getText().equals("1") && buttons[0][1].getText().equals("2") && buttons[0][2].getText().equals("3")
                && buttons[1][0].getText().equals("4") && buttons[1][1].getText().equals("5") && buttons[1][2].getText().equals("6")
                && buttons[2][0].getText().equals("7") && buttons[2][1].getText().equals("8")) // ����1��8�Ѿ�������ɣ���ִ�и����
        {
            JOptionPane.showMessageDialog(null, "��һ��������" + count + "���������Ϸ��");// �����Ի�����ʾ���ƶ�����
            System.exit(0);// �˳�����
        }
    }


}

