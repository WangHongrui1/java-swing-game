import javax.swing.*;
import java.awt.*;

public class BaseFrame extends JFrame {
    //���ڵĿ��
    public static int frameWidth = 420;
    public static int frameHeight = 700;
    public MyPanel myPanel;
    //�������¼�
    public FrameMouseListener frameMouseListener;
    public void setTouchListener() {
        this.frameMouseListener = new FrameMouseListener();
        this.frameMouseListener.baseFrame = this;
        this.addMouseListener(this.frameMouseListener);
    }

    public void addEnemyType(Class c) {
        this.myPanel.enemyType.add(c);
    }
    public BaseFrame() {
        //���ñ���
        this.setTitle("�ɻ���ս");
//        super("�ɻ���ս");
        //��ȡ��Ļ�ֱ���
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((int) ((screenSize.getWidth() - frameWidth) / 2), 30, frameWidth, frameHeight);
//      setBounds((int) (screenSize.getWidth() - frameWidth / 2), 30, frameWidth, frameHeight);
        //���ò��ַ�ʽ
        this.setLayout(null);
        //����һ��MyPanel����
        this.myPanel = new MyPanel();
        //����MyPanel�����λ�úʹ�С
        this.myPanel.setBounds(0,0,frameWidth,frameHeight);
//      setLayout(null);
        //�������ӵ�������
        this.add(this.myPanel);
        //���ü�����
        setTouchListener();
        //��ӵл�����
        addEnemyType(Enemy1.class);
        addEnemyType(Enemy2.class);
        addEnemyType(Enemy3.class);
        //���ڵĿ��ӻ�����ʾ���ڣ�JFrameĬ�ϴ��ڲ���ʾ
        this.setVisible(true);
        //����������޸Ľ����С
        setResizable(false);
        //���ô��ڹرգ����ڹرպ󣬳���ֹͣ
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}