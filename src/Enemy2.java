import java.awt.*;

public class Enemy2 extends Enemy {
    public Enemy2(MyPanel myPanel) {
        super(myPanel);
        //TODO Auto-generated constructor stub
        this.width = 69;
        this.height = 99;
        this.hp = 5;
        this.x = (int) (Math.random() * (BaseFrame.frameWidth - this.width));
        this.y = -this.height;
        this.image = Toolkit.getDefaultToolkit().getImage("E:\\Plane\\images\\enemy2.png");
    }
    //�л���ըЧ��������������
    public Image[] dieImages = new Image[]{
            Toolkit.getDefaultToolkit().getImage("E:\\Plane\\images\\enemy2_down1.png"),
            Toolkit.getDefaultToolkit().getImage("E:\\Plane\\images\\enemy2_down2.png"),
            Toolkit.getDefaultToolkit().getImage("E:\\Plane\\images\\enemy2_down3.png"),
            Toolkit.getDefaultToolkit().getImage("E:\\Plane\\images\\enemy2_down4.png")
    };
    //��ŵ�ǰͼƬ�±�
    public int imageIndex = 0;
    //���л�
    public void drawSelf(Graphics g) {
        //�ж��Ƿ񱻻���
        if (hp > 0) {
            g.drawImage(this.image, x, y, width, height, null);
        } else {
            //������
            g.drawImage(this.dieImages[imageIndex], x, y, width, height, null);
            //ÿ10�����л�һ��ͼƬ
            if (this.myPanel.timer % 50 == 0) {
                imageIndex++;
                if (imageIndex >= this.dieImages.length) {
                    //�л�����
                    killed();
                }
            }
        }
        //�л������ƶ�������л����������
        if (this.myPanel.timer % 35 == 0) {
            y = y + 10;
            if (y >= BaseFrame.frameHeight) {
                killed();
            }
        }
    }
}