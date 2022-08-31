import java.awt.*;

public class Player {
    //ʹ��MyPanel��ԭ���ǣ�Ҫ����MyPanel�е�timer
    public MyPanel myPanel;
    //width��height�����Ƿɻ������߶�
    public int width = 102;
    public int height = 126;
    //x��y�����Ƿɻ������꣨���Ͻǣ�
    public int x;
    public int y;
    //���Ƿɻ�Ѫ��
    public int hp=10;
    //�����е����Ƿɻ� ͼƬ����ŵ�������
    public Image[] images = new Image[] {
            Toolkit.getDefaultToolkit().getImage("images\\me1.png"),
            Toolkit.getDefaultToolkit().getImage("images\\me2.png")
    };
    //��ŵ�ǰͼƬ���±�
    public int imageIndex = 0;
    public Player(MyPanel myPanel) {
        this.myPanel = myPanel;
        this.x = (BaseFrame.frameWidth - this.width)/2;
        this.y = BaseFrame.frameHeight - this.height*2;
    }

    public void drawSelf(Graphics g) {
        g.drawImage(this.images[imageIndex],x,y,width,height,null);
        if (hp > 0) {

        }
        //ÿ��50�����л�һ��ͼƬ
        if(this.myPanel.timer%50==0) {
            imageIndex++;
            //ͼƬ���������һ����ͼƬ�±��ٴ���0��ʼ
            if(this.imageIndex==this.images.length) {
                this.imageIndex = 0;
            }
        }
        //�ж����Ƿɻ��Ƿ�Ե���Ʒ
        for (int i = 0; i < this.myPanel.items.size(); i++) {
            Item item = this.myPanel.items.get(i);
            if ((this.x >= item.x - this.width && this.x <= item.x + item.width) && (this.y >= item.y - this.height && this.y <= item.y + item.height)) {
                item.eated();
            }
        }
    }
}