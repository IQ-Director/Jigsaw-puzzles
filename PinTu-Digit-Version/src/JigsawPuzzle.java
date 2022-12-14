import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

/**
 * 拼图游戏
 */
public class JigsawPuzzle extends JFrame implements ActionListener {
    private JButton buttons[][];// 存储按键的数组
    private Container container;// 一个容器
    private GridLayout layout;// 布局方式为GridLayout
    private int count = 0, is[] = new int[8];// count的作用是计算按键移动的次数，is[]储存一个随机产生的1到8数字数组

    public JigsawPuzzle() {
        super("拼图游戏");// 设置标题
        layout = new GridLayout(3, 3);// 3行3列
        container = getContentPane();// 该容器的布局方式，及其重要，否则产生空引用异常
        container.setLayout(layout);// 将该布局方式作用于容器
        buttons = new JButton[3][3];// 给按键数组分配储存空间
        int locate1, locate2;// locate1用来指示当前产生的元素 locate2用来指示locate1之前的元素
        // 该方法作用是产生1到8这8个数，随机分配给数组，即无序排列
        for (locate1 = 0; locate1 < 8; locate1++) {
            int g = new Random().nextInt(8) + 1;// 随机产生一个空白按键，即不显示的那个
            is[locate1] = g;
            for (locate2 = locate1 - 1; 0 <= locate2; locate2--) {
                if (is[locate1] == is[locate2])
                    break;
            }
            if (locate2 != -1)
                locate1--;
        }
        int temp = 0;
        int r = new Random().nextInt(3);// 随机产生一个0到3的数，代表空白按键的行
        int l = new Random().nextInt(3);// 随机产生一个0到3的数，代表空白按键的列
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 空白按键设置为9，不显示
                if (r == i && l == j) {
                    buttons[i][j] = new JButton("9");
                    container.add(buttons[i][j]);
                    buttons[i][j].setVisible(false);
                } else {
                    buttons[i][j] = new JButton("" + is[temp++]);// 将数组的值作为显示的8个按键的名字
                    container.add(buttons[i][j]);
                }
                buttons[i][j].addActionListener(this);// 注册监听事件
            }
        }
        setSize(300, 300);// 设置显示容器区域大小
        setVisible(true);
    }

    // 事件处理，由于计算量小该处将所有按键单独分析
    @Override
    public void actionPerformed(ActionEvent event) {
        JButton b = (JButton) event.getSource();  //通过二维数组的调配，使的游戏一直处于运行当中，直到游戏完成。
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
                count++; //使用到的函数有setText、getText游戏进行中
            }
        }

        if (buttons[0][0].getText().equals("1") && buttons[0][1].getText().equals("2") && buttons[0][2].getText().equals("3")
                && buttons[1][0].getText().equals("4") && buttons[1][1].getText().equals("5") && buttons[1][2].getText().equals("6")
                && buttons[2][0].getText().equals("7") && buttons[2][1].getText().equals("8")) // 假如1到8已经排列完成，则执行该语句
        {
            JOptionPane.showMessageDialog(null, "您一共花费了" + count + "步完成了游戏！");// 弹出对话框，显示共移动步数
            System.exit(0);// 退出程序
        }
    }


}

