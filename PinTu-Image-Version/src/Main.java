public class Main {
    public static void main(String[] args) {
        try {
            MedleyGame frame = new MedleyGame();//创建本类的对象
            frame.setVisible(true);//设置窗体为可见
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
