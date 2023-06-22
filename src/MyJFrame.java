import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.swing.*;


public class MyJFrame<judge> extends JFrame implements MouseListener {
    int window_width = 187, window_height = 250;//初始化游戏窗口大小
    static int mine_crosswise = 10, mine_vertical = 10;//初始化雷区为10*10
    static int mine_mun = 10;//初始化雷的数量
    static int sign_mun = 0;//初始化旗子的数量
    static int[][] mine = new int[mine_crosswise][mine_vertical];//保存每个雷的位置
    static int[][] mine1 = new int[mine_crosswise][mine_vertical];//给用户展示的数据
    int[][] sign = new int[mine_crosswise][mine_vertical];//保存每个旗子的位置
    int[][] uncertainty = new int[mine_crosswise][mine_vertical];//保存每个？的位置
    static BufferedImage image = null;//获取图片路径
    static int judge = 0;//判断游戏状态 0游戏中，1赢了，2输了
    static boolean mine_place = false;//绘制雷的开关，判断雷是否以放置，防止多次放置


    //---------------------------------------------------------------------------------------------------------------------
    //窗体
    public void myJFrame() {
        this.setTitle("扫雷"); //标题
        this.setSize(window_width, window_height); //窗口大小
        this.setResizable(false); //窗口是否可以改变大小=否
        this.setDefaultCloseOperation(MyJFrame.EXIT_ON_CLOSE);//窗口关闭方式为关闭窗口同时结束程序
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;//获取屏幕宽度
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕高度
        this.setLocation((width - window_width) / 2, (height - window_height) / 2); //设置窗口默认位置以屏幕居中
        this.addMouseListener(this);
        this.setVisible(true); //窗口是否显示=是
    }


    //---------------------------------------------------------------------------------------------------------------------
    //覆写paint方法,绘制界面
    public void paint(Graphics g) {

        //双缓冲技术防止屏幕闪烁
        BufferedImage bi = new BufferedImage(window_width, window_height, BufferedImage.TYPE_INT_ARGB);
        Graphics g2 = bi.createGraphics();

        //剩余雷的数量
        g2.setColor(Color.red);//设置画笔颜色
        g2.setFont(new Font("微软雅黑", 10, 10));//设置字体
        g2.drawString("雷数：" + mine_mun, 30, 50);//绘制字符

        //剩余时间
        g2.setColor(Color.red);//设置画笔颜色
        g2.setFont(new Font("微软雅黑", 10, 10));//设置字体
        g2.drawString("时间：无限", 30 , 40);//绘制字符

        //调用放置小黄脸的方法
        again();
        //笑脸位置居中
        g2.drawImage(image, window_width  / 2-10, 45, this);


        /*
         * 绘制雷区
         * 根据初始化的雷区数值，循环生成雷区
         * 0、9:：没有掀开，1-8：显示周围雷数、-1掀开
         */
        for (int i = 0; i < mine_crosswise; i++) {
            for (int j = 0; j < mine_vertical; j++) {
                if (mine1[i][j] == -1) {
                    try {
                        image = ImageIO.read(new File("src/resources/0.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    g2.drawImage(image, 9 + i * 17, 73 + j * 17, this);
                    continue;
                }
                if (mine1[i][j] == 1) {
                    try {
                        image = ImageIO.read(new File("src/resources/1.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    g2.drawImage(image, 9 + i * 17, 73 + j * 17, this);
                    continue;
                }
                if (mine1[i][j] == 2) {
                    try {
                        image = ImageIO.read(new File("src/resources/2.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    g2.drawImage(image, 9 + i * 17, 73 + j * 17, this);
                    continue;
                }
                if (mine1[i][j] == 3) {
                    try {
                        image = ImageIO.read(new File("src/resources/3.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    g2.drawImage(image, 9 + i * 17, 73 + j * 17, this);
                    continue;
                }
                if (mine1[i][j] == 4) {
                    try {
                        image = ImageIO.read(new File("src/resources/4.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    g2.drawImage(image, 9 + i * 17, 73 + j * 17, this);
                    continue;
                }
                if (mine1[i][j] == 5) {
                    try {
                        image = ImageIO.read(new File("src/resources/5.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    g2.drawImage(image, 9 + i * 17, 73 + j * 17, this);
                    continue;
                }
                if (mine1[i][j] == 6) {
                    try {
                        image = ImageIO.read(new File("src/resources/6.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    g2.drawImage(image, 9 + i * 17, 73 + j * 17, this);
                    continue;
                }
                if (mine1[i][j] == 7) {
                    try {
                        image = ImageIO.read(new File("src/resources/7.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    g2.drawImage(image, 9 + i * 17, 73 + j * 17, this);
                    continue;
                }
                if (mine1[i][j] == 8) {
                    try {
                        image = ImageIO.read(new File("src/resources/8.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    g2.drawImage(image, 9 + i * 17, 73+ j * 17, this);
                    continue;
                }
                if (sign[i][j] == 1) {
                    try {
                        image = ImageIO.read(new File("src/resources/11.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    g2.drawImage(image, 9 + i * 17, 73 + j * 17, this);
                    continue;
                }
                if (sign[i][j] == 2) {
                    try {
                        image = ImageIO.read(new File("src/resources/ask.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    g2.drawImage(image, 9 + i * 17, 73 + j * 17, this);
                    continue;
                }
                try {
                    image = ImageIO.read(new File("src/resources/blank.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                g2.drawImage(image, 9+ i * 17, 73 + j * 17, this);
            }
        }


        /*
         * 绘制游戏结束后显示的雷
         * 根据初始化的雷区数值，循环生成雷区
         * 游戏结束后可显示所有雷位置
         */
        if (judge == 1 || judge == 2) {
            for (int i = 0; i < mine_crosswise; i++) {
                for (int j = 0; j < mine_vertical; j++) {
                    if (mine[i][j] == 9) {
                        try {
                            image = ImageIO.read(new File("src/resources/12.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        g2.drawImage(image, 9 + i * 17, 73 + j * 17, this);
                    }
                }

            }
        }

        //调用放置地雷的方法
        place();

        //将以上所述全部绘制在画布上
        g.drawImage(bi, 0, 0, this);
    }

    /**
     * 通过递归算法实现连锁 D
     * 判断四个边、四个角、和其余的中间部分，如果为零则将其改为-1，代表已翻开
     * 否则将数字显示出来
     */
    public static void scan(int x, int y) {
        //上
        if (x - 1 >= 0 && x + 1 <= mine_crosswise - 1 && y - 1 < 0) {
            if (mine[x - 1][y] == 0) {
                mine1[x - 1][y] = mine[x - 1][y] = -1;
                scan(x - 1, y);
            } else {
                mine1[x - 1][y] = mine[x - 1][y];
            }
            if (mine[x - 1][y + 1] == 0) {
                mine1[x - 1][y + 1] = mine[x - 1][y + 1] = -1;
                scan(x - 1, y + 1);

            } else {
                mine1[x - 1][y + 1] = mine[x - 1][y + 1];

            }

            if (mine[x][y + 1] == 0) {
                mine1[x][y + 1] = mine[x][y + 1] = -1;
                scan(x, y + 1);

            } else {
                mine1[x][y + 1] = mine[x][y + 1];

            }

            if (mine[x + 1][y + 1] == 0) {
                mine1[x + 1][y + 1] = mine[x + 1][y + 1] = -1;
                scan(x + 1, y + 1);

            } else {
                mine1[x + 1][y + 1] = mine[x + 1][y + 1];
            }

            if (mine[x + 1][y] == 0) {
                mine1[x + 1][y] = mine[x + 1][y] = -1;
                scan(x + 1, y);

            } else {
                mine1[x + 1][y] = mine[x + 1][y];
            }
        }
        //下
        if (x - 1 >= 0 && x + 1 <= mine_crosswise - 1 && y + 1 > mine_vertical - 1) {

            if (mine[x - 1][y] == 0) {
                mine1[x - 1][y] = mine[x - 1][y] = -1;
                scan(x - 1, y);

            } else {
                mine1[x - 1][y] = mine[x - 1][y];
            }

            if (mine[x - 1][y - 1] == 0) {
                mine1[x - 1][y - 1] = mine[x - 1][y - 1] = -1;
                scan(x - 1, y - 1);
            } else {
                mine1[x - 1][y - 1] = mine[x - 1][y - 1];
            }

            if (mine[x][y - 1] == 0) {
                mine1[x][y - 1] = mine[x][y - 1] = -1;
                scan(x, y - 1);
            } else {
                mine1[x][y - 1] = mine[x][y - 1];
            }

            if (mine[x + 1][y - 1] == 0) {
                mine1[x + 1][y - 1] = mine[x + 1][y - 1] = -1;
                scan(x + 1, y - 1);
            } else {
                mine1[x + 1][y - 1] = mine[x + 1][y - 1];
            }

            if (mine[x + 1][y] == 0) {
                mine1[x + 1][y] = mine[x + 1][y] = -1;
                scan(x + 1, y);
            } else {
                mine1[x + 1][y] = mine[x + 1][y];
            }
        }
        //左
        if (y - 1 >= 0 && y + 1 <= mine_crosswise - 1 && x - 1 < 0) {

            if (mine[x][y - 1] == 0) {
                mine1[x][y - 1] = mine[x][y - 1] = -1;
                scan(x, y - 1);
            } else {
                mine1[x][y - 1] = mine[x][y - 1];
            }

            if (mine[x + 1][y - 1] == 0) {
                mine1[x + 1][y - 1] = mine[x + 1][y - 1] = -1;
                scan(x + 1, y - 1);
            } else {
                mine1[x + 1][y - 1] = mine[x + 1][y - 1];
            }

            if (mine[x + 1][y] == 0) {
                mine1[x + 1][y] = mine[x + 1][y] = -1;
                scan(x + 1, y);
            } else {
                mine1[x + 1][y] = mine[x + 1][y];
            }

            if (mine[x + 1][y + 1] == 0) {
                mine1[x + 1][y + 1] = mine[x + 1][y + 1] = -1;
                scan(x + 1, y + 1);
            } else {
                mine1[x + 1][y + 1] = mine[x + 1][y + 1];
            }

            if (mine[x][y + 1] == 0) {
                mine1[x][y + 1] = mine[x][y + 1] = -1;
                scan(x, y + 1);
            } else {
                mine1[x][y + 1] = mine[x][y + 1];
            }
        }
        //右
        if (y - 1 >= 0 && y + 1 <= mine_vertical - 1 && x + 1 > mine_crosswise - 1) {
            if (mine[x][y - 1] == 0) {
                mine1[x][y - 1] = mine[x][y - 1] = -1;
                scan(x, y - 1);
            } else {
                mine1[x][y - 1] = mine[x][y - 1];
            }

            if (mine[x - 1][y - 1] == 0) {
                mine1[x - 1][y - 1] = mine[x - 1][y - 1] = -1;
                scan(x - 1, y - 1);
            } else {
                mine1[x - 1][y - 1] = mine[x - 1][y - 1];
            }

            if (mine[x - 1][y] == 0) {
                mine1[x - 1][y] = mine[x - 1][y] = -1;
                scan(x - 1, y);
            } else {
                mine1[x - 1][y] = mine[x - 1][y];
            }

            if (mine[x - 1][y + 1] == 0) {
                mine1[x - 1][y + 1] = mine[x - 1][y + 1] = -1;
                scan(x - 1, y + 1);
            } else {
                mine1[x - 1][y + 1] = mine[x - 1][y + 1];
            }

            if (mine[x][y + 1] == 0) {
                mine1[x][y + 1] = mine[x][y + 1] = -1;
                scan(x, y + 1);
            } else {
                mine1[x][y + 1] = mine[x][y + 1];
            }
        }
        //左上角
        if (x - 1 < 0 && y - 1 < 0) {

            if (mine[x + 1][y] == 0) {
                mine1[x + 1][y] = mine[x + 1][y] = -1;
                scan(x + 1, y);
            } else {
                mine1[x + 1][y] = mine[x + 1][y];
            }

            if (mine[x][y + 1] == 0) {
                mine1[x][y + 1] = mine[x][y + 1] = -1;
                scan(x, y + 1);
            } else {
                mine1[x][y + 1] = mine[x][y + 1];
            }

            if (mine[x + 1][y + 1] == 0) {
                mine1[x + 1][y + 1] = mine[x + 1][y + 1] = -1;
                scan(x + 1, y + 1);
            } else {
                mine1[x + 1][y + 1] = mine[x + 1][y + 1];
            }
        }
        //右上角
        if (x + 1 >= mine_crosswise && y - 1 < 0) {

            if (mine[x - 1][y] == 0) {
                mine1[x - 1][y] = mine[x - 1][y] = -1;
                scan(x - 1, y);
            } else {
                mine1[x - 1][y] = mine[x - 1][y];
            }

            if (mine[x][y + 1] == 0) {
                mine1[x][y + 1] = mine[x][y + 1] = -1;
                scan(x, y + 1);
            } else {
                mine1[x][y + 1] = mine[x][y + 1];
            }

            if (mine[x - 1][y + 1] == 0) {
                mine1[x - 1][y + 1] = mine[x - 1][y + 1] = -1;
                scan(x - 1, y + 1);
            } else {
                mine1[x - 1][y + 1] = mine[x - 1][y + 1];
            }
        }
        //左下角
        if (x - 1 < 0 && y + 1 >= mine_vertical) {

            if (mine[x + 1][y] == 0) {
                mine1[x + 1][y] = mine[x + 1][y] = -1;
                scan(x + 1, y);
            } else {
                mine1[x + 1][y] = mine[x + 1][y];
            }

            if (mine[x][y - 1] == 0) {
                mine1[x][y - 1] = mine[x][y - 1] = -1;
                scan(x, y - 1);
            } else {
                mine1[x][y - 1] = mine[x][y - 1];
            }

            if (mine[x + 1][y - 1] == 0) {
                mine1[x + 1][y - 1] = mine[x + 1][y - 1] = -1;
                scan(x + 1, y - 1);
            } else {
                mine1[x + 1][y - 1] = mine[x + 1][y - 1];
            }
        }
        //右下角
        if (x + 1 >= mine_crosswise && y + 1 >= mine_vertical) {

            if (mine[x - 1][y] == 0) {
                mine1[x - 1][y] = mine[x - 1][y] = -1;
                scan(x - 1, y);
            } else {
                mine1[x - 1][y] = mine[x - 1][y];
            }

            if (mine[x][y - 1] == 0) {
                mine1[x][y - 1] = mine[x][y - 1] = -1;
                scan(x, y - 1);
            } else {
                mine1[x][y - 1] = mine[x][y - 1];
            }

            if (mine[x - 1][y - 1] == 0) {
                mine1[x - 1][y - 1] = mine[x - 1][y - 1] = -1;
                scan(x - 1, y - 1);
            } else {
                mine1[x - 1][y - 1] = mine[x - 1][y - 1];
            }
        }

        //中间部分
        if (x - 1 >= 0 && y - 1 >= 0 && x + 1 < mine_crosswise && y + 1 < mine_vertical) {

            if (mine[x - 1][y - 1] == 0) {
                mine1[x - 1][y - 1] = mine[x - 1][y - 1] = -1;
                scan(x - 1, y - 1);
            } else {
                mine1[x - 1][y - 1] = mine[x - 1][y - 1];
            }

            if (mine[x - 1][y] == 0) {
                mine1[x - 1][y] = mine[x - 1][y] = -1;
                scan(x - 1, y);
            } else {
                mine1[x - 1][y] = mine[x - 1][y];
            }

            if (mine[x - 1][y + 1] == 0) {
                mine1[x][y - 1] = mine[x][y - 1] = -1;
                scan(x - 1, y + 1);
            } else {
                mine1[x][y - 1] = mine[x][y - 1];
            }

            if (mine[x][y - 1] == 0) {
                mine1[x][y - 1] = mine[x][y - 1] = -1;
                scan(x, y - 1);
            } else {
                mine1[x][y - 1] = mine[x][y - 1];
            }

            if (mine[x][y + 1] == 0) {
                mine1[x][y + 1] = mine[x][y + 1] = -1;
                scan(x, y + 1);
            } else {
                mine1[x][y + 1] = mine[x][y + 1];
            }

            if (mine[x + 1][y - 1] == 0) {
                mine1[x + 1][y - 1] = mine[x + 1][y - 1] = -1;
                scan(x + 1, y - 1);
            } else {
                mine1[x + 1][y - 1] = mine[x + 1][y - 1];
            }

            if (mine[x + 1][y] == 0) {
                mine1[x + 1][y] = mine[x + 1][y] = -1;
                scan(x + 1, y);
            } else {
                mine1[x + 1][y] = mine[x + 1][y];
            }

            if (mine[x + 1][y + 1] == 0) {
                mine1[x + 1][y + 1] = mine[x + 1][y + 1] = -1;
                scan(x + 1, y + 1);
            } else {
                mine1[x + 1][y + 1] = mine[x + 1][y + 1];
            }
        }

    }


    /**
     * 小黄脸——重新开始按钮
     * 判断游戏当前状态，改变小黄脸的表情
     */
    public static void again() {
        if (judge == 0) {
            try {
                image = ImageIO.read(new File("src/resources/face1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (judge == 1) {
            try {
                image = ImageIO.read(new File("src/resources/face3.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (judge == 2) {
            try {
                image = ImageIO.read(new File("src/resources/face2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 放置地雷
     * 利用当前时间为随机数种子
     * 随机二位数组的位置，赋值为1，代表此处有雷
     * 如果随机到已经有雷的区域，则跳出循环，重新随机
     * 放置雷后将周围数值加1
     */
    public static void place() {
        if (mine_place == false) {
            Random r = new Random();
            int x, y;
            for (int i = 0; i < mine_mun; i++) {
                x = r.nextInt(mine_mun);
                y = r.nextInt(mine_mun);
                if (mine[x][y] == 9) {
                    i--;
                    continue;
                }
                mine1[x][y] = mine[x][y] = 9;

                //上
                if (x - 1 >= 0 && x + 1 <= mine_crosswise - 1 && y - 1 < 0) {
                    if (mine[x - 1][y] != 9) {
                        mine[x - 1][y]++;
                    }
                    if (mine[x - 1][y + 1] != 9) {
                        mine[x - 1][y + 1]++;
                    }
                    if (mine[x][y + 1] != 9) {
                        mine[x][y + 1]++;
                    }

                    if (mine[x + 1][y + 1] != 9) {
                        mine[x + 1][y + 1]++;
                    }
                    if (mine[x + 1][y] != 9) {
                        mine[x + 1][y]++;
                    }
                }
                //下
                if (x - 1 >= 0 && x + 1 <= mine_crosswise - 1 && y + 1 > mine_vertical - 1) {
                    if (mine[x - 1][y] != 9) {
                        mine[x - 1][y]++;
                    }
                    if (mine[x - 1][y - 1] != 9) {
                        mine[x - 1][y - 1]++;
                    }
                    if (mine[x][y - 1] != 9) {
                        mine[x][y - 1]++;
                    }
                    if (mine[x + 1][y - 1] != 9) {
                        mine[x + 1][y - 1]++;
                    }
                    if (mine[x + 1][y] != 9) {
                        mine[x + 1][y]++;
                    }

                }
                //左
                if (y - 1 >= 0 && y + 1 <= mine_crosswise - 1 && x - 1 < 0) {
                    if (mine[x][y - 1] != 9) {
                        mine[x][y - 1]++;
                    }
                    if (mine[x + 1][y - 1] != 9) {
                        mine[x + 1][y - 1]++;
                    }
                    if (mine[x + 1][y] != 9) {
                        mine[x + 1][y]++;
                    }
                    if (mine[x + 1][y + 1] != 9) {
                        mine[x + 1][y + 1]++;
                    }
                    if (mine[x][y + 1] != 9) {
                        mine[x][y + 1]++;
                    }
                }
                //右
                if (y - 1 >= 0 && y + 1 <= mine_vertical - 1 && x + 1 > mine_crosswise - 1) {
                    if (mine[x][y - 1] != 9) {
                        mine[x][y - 1]++;
                    }
                    if (mine[x - 1][y - 1] != 9) {
                        mine[x - 1][y - 1]++;
                    }
                    if (mine[x - 1][y] != 9) {
                        mine[x - 1][y]++;
                    }
                    if (mine[x - 1][y + 1] != 9) {
                        mine[x - 1][y + 1]++;
                    }
                    if (mine[x][y + 1] != 9) {
                        mine[x][y + 1]++;
                    }
                }
                //左上角
                if (x - 1 < 0 && y - 1 < 0) {
                    if (mine[x + 1][y] != 9) {
                        mine[x + 1][y]++;
                    }
                    if (mine[x][y + 1] != 9) {
                        mine[x][y + 1]++;
                    }
                    if (mine[x + 1][y + 1] != 9) {
                        mine[x + 1][y + 1]++;
                    }
                }
                //右上角
                if (x + 1 >= mine_crosswise && y - 1 < 0) {
                    if (mine[x - 1][y] != 9) {
                        mine[x - 1][y]++;
                    }
                    if (mine[x][y + 1] != 9) {
                        mine[x][y + 1]++;
                    }
                    if (mine[x - 1][y + 1] != 9) {
                        mine[x - 1][y + 1]++;
                    }

                }
                //左下角
                if (x - 1 < 0 && y + 1 >= mine_vertical) {
                    if (mine[x + 1][y] != 9) {
                        mine[x + 1][y]++;
                    }
                    if (mine[x][y - 1] != 9) {
                        mine[x][y - 1]++;
                    }
                    if (mine[x + 1][y - 1] != 9) {
                        mine[x + 1][y - 1]++;
                    }
                }
                //右下角
                if (x + 1 >= mine_crosswise && y + 1 >= mine_vertical) {
                    if (mine[x - 1][y] != 9) {
                        mine[x - 1][y]++;
                    }
                    if (mine[x][y - 1] != 9) {
                        mine[x][y - 1]++;
                    }
                    if (mine[x - 1][y - 1] != 9) {
                        mine[x - 1][y - 1]++;
                    }
                }
                //中间部分
                if (x - 1 >= 0 && y - 1 >= 0 && x + 1 < mine_crosswise && y + 1 < mine_vertical) {
                    if (mine[x - 1][y - 1] != 9) {
                        mine[x - 1][y - 1]++;
                    }
                    if (mine[x - 1][y] != 9) {
                        mine[x - 1][y]++;
                    }
                    if (mine[x - 1][y + 1] != 9) {
                        mine[x - 1][y + 1]++;
                    }
                    if (mine[x][y - 1] != 9) {
                        mine[x][y - 1]++;
                    }
                    if (mine[x][y + 1] != 9) {
                        mine[x][y + 1]++;
                    }
                    if (mine[x + 1][y - 1] != 9) {
                        mine[x + 1][y - 1]++;
                    }
                    if (mine[x + 1][y] != 9) {
                        mine[x + 1][y]++;
                    }
                    if (mine[x + 1][y + 1] != 9) {
                        mine[x + 1][y + 1]++;
                    }
                }

            }
            mine_place = true;
        }
    }


    //---------------------------------------------------------------------------------------------------------------------
    @Override//鼠标点击
    public void mouseClicked(MouseEvent e) {
        //获取鼠标点击位置
        int x = e.getX();
        int y = e.getY();


        //判断是否开始了游戏
        if (judge == 0) {
            //判断点击位置是否在雷区内
            if (x > 9 && x < 9 + mine_crosswise * 17 && y > 73 && y <73 + mine_vertical * 17) {
                x = (x - 9) / 17;
                y = (y - 73) / 17;
                //判断鼠标点击方式BUTTON1：左键、BUTTON2：中键、BUTTON3：右键
                if (e.getButton() == MouseEvent.BUTTON1) {
                    //左键代表翻开
                    //判断点击位置是否合法
                    if (sign[x][y] == 0 && uncertainty[x][y] == 0) {
                        //判断点击区域有没有雷
                        if (mine[x][y] != 9) {
                            //调用递归
                            scan(x, y);
                            mine1[x][y] = mine[x][y];
                            this.repaint();

                        } else if (mine[x][y] == 9) {
                            judge = 2;
                            this.repaint();
                            JOptionPane.showMessageDialog(this, "你被雷炸了个粉碎！");
                        }

                        int mun = 0;//计算还有多少个方块没有翻开
                        for (int i = 0; i < mine_crosswise; i++) {
                            for (int j = 0; j < mine_vertical; j++) {
                                if (mine1[i][j] == 0) {
                                    ++mun;
                                }
                            }
                        }
                        //如果全翻开了，那就赢了
                        if (mun == 0) {
                            judge = 1;
                            this.repaint();
                            JOptionPane.showMessageDialog(this, "WIN！");
                        }
                    }
                } else if (e.getButton() == MouseEvent.BUTTON2) {
                    //中键代表问号
                    if (uncertainty[x][y] == 0 && sign[x][y] == 0) {
                        uncertainty[x][y] = 1;
                    } else if (uncertainty[x][y] == 1) {
                        uncertainty[x][y] = 0;
                    }
                    this.repaint();
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    //右键代表插旗
                    if (sign[x][y] == 0 && sign_mun < mine_mun && uncertainty[x][y] == 0) {
                        sign[x][y] = 1;
                        sign_mun++;
                    } else if (sign[x][y] == 1) {
                        sign[x][y] = 2;
                        sign_mun++;
                    }else if (sign[x][y] == 2) {
                        sign[x][y] = 0;
                        sign_mun=sign_mun-2;}
                    this.repaint();

                }
            }


            //重新开始按钮——小黄脸
            if (x >= (window_width - 17) / 2 && y >= 45 && x <= (window_width - 17) / 2 + 17 && y <= 45 + 17) {
                //重置所有数据
                mine_mun = 10;//初始化雷的数量
                //初始化二维数组
                for (int i = 0; i < mine_crosswise; i++) {
                    for (int j = 0; j < mine_vertical; j++) {
                        mine[i][j] = 0;
                        mine1[i][j] = 0;
                        sign[i][j] = 0;
                        uncertainty[i][j] = 0;
                    }
                }
                mine_place = false;//绘制雷的开关
                //生成新的数据
                again();//小黄脸的新状态
                place();//雷的新位置
                judge = 0;//恢复游戏状态
                this.repaint();
            }
            //判断是否开始了游戏
            if (judge == 0) {
                // ... 用户点击游戏界面上的方块
            } else { // 游戏已经结束
                //重新开始按钮——小黄脸
                if (x >= (window_width - 17) / 2 && y >= 45 && x <= (window_width - 17) / 2 + 17 && y <= 45 + 17) {
                    // 重置所有数据
                    //...
                    mine_place = false;//绘制雷的开关
                    //生成新的数据
                    again();//小黄脸的新状态
                    place();//雷的新位置
                    judge = 0;//恢复游戏状态

                    // 调用 repaint 方法刷新界面
                    this.repaint();
                }
            }


        }
    }


    @Override//鼠标按下
    public void mousePressed(MouseEvent e) {

    }

    @Override//鼠标抬起
    public void mouseReleased(MouseEvent e) {

    }

    @Override//鼠标进入
    public void mouseEntered(MouseEvent e) {

    }

    @Override//鼠标离开
    public void mouseExited(MouseEvent e) {


    }

}

