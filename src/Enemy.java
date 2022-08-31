import java.awt.*;

public class Enemy {
    // //ʹ��MyPanel��ԭ���ǣ�Ҫ����MyPanel�е�timer
    public MyPanel myPanel;
    //�л��Ŀ�͸�
    public int width;
    public int height;
    //�л�������
    public int x;
    public int y;
    public Image image;
    //�л�������ֵ
    public int hp;
    //�л���ըЧ��������������
    public Image[] dieImages = new Image[]{
            Toolkit.getDefaultToolkit().getImage("images\\enemy1_down1.png"),
            Toolkit.getDefaultToolkit().getImage("images\\enemy1_down2.png"),
            Toolkit.getDefaultToolkit().getImage("images\\enemy1_down3.png"),
            Toolkit.getDefaultToolkit().getImage("images\\enemy1_down4.png")
    };


    public Enemy(MyPanel myPanel) {
        this.myPanel = myPanel;
    }

    //��ŵ�ǰͼƬ�±�
    public int imageIndex = 0;
    //���л�
    public void drawSelf(Graphics g) {
        //�жϵл��Ƿ񱻴���
        if (hp > 0) {
            g.drawImage(this.image, x, y, width, height, null);
        } else {
            //������
            g.drawImage(this.dieImages[imageIndex], x, y, width, height,null);
            //ÿ50�����л�һ��ͼƬ
            if (this.myPanel.timer % 50 == 0) {
                imageIndex++;
                if (imageIndex >= this.dieImages.length) {
                    //�л�����
                    killed();
                }
            }
        }

        if (this.myPanel.timer % 35 == 0) {
            y = y + 10;
            if (y >= BaseFrame.frameHeight) {
                killed();
            }
        }
    }
    //�Ƴ�������ϳ�����ĵл�
    public void killed() {
/*        Item[] items = new Item(this);

        if (items != null && items.length > 0) {
//            �л�����,�ͷŽ�Ʒ
            for (int i = 0; i < items.length; i++) {
                Item item = items[i];
//                ��Ʒ���ֵ�λ�þ��ǵл�������λ��
//                25*id��Ŀ���ǽ���Ʒ����
                item.x = this.x + 25 * i;
                item.y = this.y;
                this.myPanel.items.add(item);
            }
        }*/
        this.myPanel.enemys.remove(this);
    }
    //if�л����ڱ�����״̬��������ֵ����
    public void underAttack() {
        if (hp > 0){
        hp--;}
    }}