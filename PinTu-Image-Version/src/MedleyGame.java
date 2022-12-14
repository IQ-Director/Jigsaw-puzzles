import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class MedleyGame extends JFrame{

    private JPanel centerPanel;// 拼图按钮面板
    private JButton emptyButton;// 空白按钮对象

    public MedleyGame() {
        super();// 继承JFrame类的构造方法
        setResizable(false);// 设置窗体大小不可改变
        setTitle("拼图游戏");// 设置窗体的标题
        setBounds(100, 100, 354, 435);// 设置窗体的显示位置及大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置关闭窗体时退出程序
        final JPanel topPanel = new JPanel();// 创建面板对象
        topPanel.setBorder(new TitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, null, null));// 为面板添加边框
        topPanel.setLayout(new BorderLayout());// 设置面板采用边界布局
        getContentPane().add(topPanel,BorderLayout.NORTH);// 将面板添加到窗体顶部
        final JLabel modelLabel = new JLabel();// 创建显示参考图片的标签对象
        modelLabel.setIcon(new ImageIcon("img/model.jpg"));// 设置标签显示的参考图片
        topPanel.add(modelLabel, BorderLayout.WEST);// 将标签添加到面板的左侧
        final JButton startButton = new JButton();// 创建“下一局”按钮对象
        startButton.setText("下一局");// 设置按钮的标签文本
        startButton.addActionListener(new StartButtonAction());// 为按钮添加监听器
        topPanel.add(startButton, BorderLayout.CENTER);// 将按钮添加到面板的中间

        centerPanel = new JPanel();// 创建拼图按钮面板对象
        centerPanel.setBorder(new TitledBorder(null, "",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, null, null));// 为面板添加边框
        centerPanel.setLayout(new GridLayout(0, 3));// 设置拼图按钮面板采用3列的网格布局
        getContentPane().add(centerPanel, BorderLayout.CENTER);// 将面板添加到窗体的中间

        String[][] stochasticOrder = reorder();// 获得网格图片的随机摆放顺序
        for (int row = 0; row < 3; row++) {// 遍例行
            for (int col = 0; col < 3; col++) {// 遍例列
                final JButton button = new JButton();// 创建拼图按钮对象
                button.setName(row + "" + col);// 设置按钮的名称
                button.setIcon(new ImageIcon(stochasticOrder[row][col])); // 为拼图按钮设置图片
                if (stochasticOrder[row][col].equals("img/22.jpg")) // 判断是否为空白按钮
                    emptyButton = button;
                button.addActionListener(new ImgButtonAction()); // 为拼图按钮添加监听器
                centerPanel.add(button);// 将按钮添加到拼图按钮面板中
            }
        }
        //
    }
    private String[][] reorder(){// 用来获取网格图片的随机摆放顺序
        String[][] exactnessOrder = new String[3][3];// 网格图片的正确摆放顺序
        for (int row = 0; row < 3; row++) {// 遍例行
            for (int col = 0; col < 3; col++) {// 遍例列
                exactnessOrder[row][col] = "img/" + row + col + ".jpg";
            }
        }
        String[][] stochasticOrder = new String[3][3];// 网格图片的随机摆放顺序
        for (int row = 0; row < 3; row++) {// 遍例行
            for (int col = 0; col < 3; col++) {// 遍例列
                while (stochasticOrder[row][col] == null) { // 随机摆放顺序的指定网格为空
                    int r = (int) (Math.random() * 3);// 取随机行
                    int c = (int) (Math.random() * 3);// 取随机列
                    if (exactnessOrder[r][c] != null) { // 正确摆放顺序的指定网格不为空
                        // 将位于正确摆放顺序的指定网格的图片摆放到位于随机摆放顺序的指定网格中
                        stochasticOrder[row][col] = exactnessOrder[r][c];
                        // 将位于正确顺序的指定网格设置为空
                        exactnessOrder[r][c] = null;
                    }
                }
            }
        }
        return stochasticOrder;
    }

    class ImgButtonAction implements ActionListener {// 拼图按钮监听器
        public void actionPerformed(ActionEvent e) {
            String emptyName = emptyButton.getName();// 获得空白按钮的名称
            char emptyRow = emptyName.charAt(0);// 获得空白按钮所在的行
            char emptyCol = emptyName.charAt(1);// 获得空白按钮所在的列
            JButton clickButton = (JButton) e.getSource();// 获得被点击按钮对象
            String clickName = clickButton.getName();// 获得被点击按钮的名称
            char clickRow = clickName.charAt(0);// 获得被点击按钮所在的行
            char clickCol = clickName.charAt(1);// 获得被点击按钮所在的列
            // 判断被点击按钮与空白按钮是否相临
            if (Math.abs(clickRow - emptyRow) + Math.abs(clickCol - emptyCol) == 1) {
                // 将被点击按钮的图片移动到空白按钮上
                emptyButton.setIcon(clickButton.getIcon());
                // 设置被点击的按钮显示空白图片
                clickButton.setIcon(new ImageIcon("img/22.jpg"));
                emptyButton = clickButton;// 将被点击的按钮设置为空白按钮
            }
        }
    }
    class StartButtonAction implements ActionListener {// 下一局按钮监听器
        public void actionPerformed(ActionEvent e) {
            String[][] stochasticOrder = reorder();// 获得网格图片的随机摆放顺序
            int i = 0;// 拼图按钮在拼图按钮面板中的索引
            for (int row = 0; row < 3; row++) {// 遍例行
                for (int col = 0; col < 3; col++) {// 遍例列
                    JButton button = (JButton) centerPanel.getComponent(i++); // 获得位于指定索引的拼图按钮
                    button.setIcon(new ImageIcon(stochasticOrder[row][col])); // 为拼图按钮设置图片
                    if (stochasticOrder[row][col].equals("img/22.jpg")) // 判断是否为空白按钮
                        emptyButton = button;
                }
            }
        }
    }
}

