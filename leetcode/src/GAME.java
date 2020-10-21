import java.util.Arrays;
import java.util.Scanner;



public class GAME {
    public static void main(String[] args) {
        ThreeChess game = new ThreeChess();
        game.startGame();

    }
}

class ThreeChess{
    private char[][] chessBoard = new char[3][3];
    private int size = 0; //已经下的棋数
    private final int CAPACITY = 9; //总共可下的棋数

    ThreeChess(){
        for(char[] line : chessBoard){ //初始化棋盘
            Arrays.fill(line, ' ');
        }
    }

    //【游戏开始】
    public void startGame(){
        System.out.println("");
        System.out.println("┌───┬───┬───┐");
        System.out.println("│ 1 │ 2 │ 3 │");
        System.out.println("├───┼───┼───┤");
        System.out.println("│ 4 │ 5 │ 6 │");
        System.out.println("├───┼───┼───┤");
        System.out.println("│ 7 │ 8 │ 9 │");
        System.out.println("└───┴───┴───┘");
        System.out.println("输入 1 ~ 9 表示要下棋的位置");
        System.out.println("O是你的棋子，*是电脑的棋子");
        Scanner in = new Scanner(System.in);

        System.out.print("选择谁先开始：\n\t1.用户\n\t2.机器人\nInput: ");
        int whoFirst = in.nextInt();
        System.out.print("选择机器人智商：\n\t1. 999+\n\t2. 250\nInput: ");
        int level = in.nextInt();

        class Play{ //代码重用
            //方法返回-1表示退出
            int robotPlay(){
                if(level == 1)
                    smartRobot();
                else
                    sillyRobot();

                printChessBroad();
                if(isSuccessful() == -1) {
                    System.out.println("机器人胜 (/ □ \\)");
                    return -1;
                }else if (size == CAPACITY){
                    System.out.println("==游戏平局==");
                    return -1;
                }
                return 0;
            }


            int userPlay(){
                int pos;
                while(true){
                    System.out.print("下棋位置: ");
                    pos = in.nextInt();
                    if(pos < 1
                            || pos > 9
                            || chessBoard[(pos - 1) / 3][(pos - 1) % 3] != ' '){
                        System.out.println("输入错误，重新输入！");
                        continue;
                    } else {
                        chessBoard[(pos - 1)/3][(pos - 1) % 3] = 'O';
                        size++;
                        break;
                    }
                }

                if(isSuccessful() == 1){
                    printChessBroad();
                    System.out.println("恭喜，你胜了 ╰(*°▽°*)╯");
                    return -1;
                } else if(size == CAPACITY){
                    printChessBroad();
                    System.out.println("==游戏平局==");
                    return -1;
                }
                return 0;
            }
        }

        Play play = new Play();
        if(whoFirst == 2){
            while(true){
                //1.机器人下棋
                if(play.robotPlay() == -1)
                    return;

                //2.用户下棋
                if(play.userPlay() == -1)
                    return;
            }
        } else {
            while(true){
                //1.用户下棋
                if(play.userPlay() == -1)
                    return;

                //2.机器人下棋
                if(play.robotPlay() == -1)
                    return;
            }
        }
    }





    //【机器人下棋】
    private void sillyRobot(){ //笨机器人
        int l, c;
        while(true){
            l = (int)(Math.random() * 3);
            c = (int)(Math.random() * 3);
            if(chessBoard[l][c] == ' '){
                chessBoard[l][c] = '*';
                break;
            }
        }
        size++;
    }

    private int corner = 2;
    private void smartRobot(){ //无法战胜的机器人
        if(chessBoard[1][1] == ' '){ //抢占中心位置
            chessBoard[1][1] = '*';
            size++;
            return;
        }

        //1.判断是否可以下一个棋子就胜利（不能放在一起同时判断，否则有可能错误最佳位置）
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(chessBoard[i][j] == ' '){ //【1】如果这个位置没有棋子，就尝试下载这个地方，看看是否可以胜；
                    chessBoard[i][j] = '*';
                    if(isSuccessful() == -1){  //【1】如果胜的话，就下在这个地方了，返回即可；
                        size++;
                        return ;
                    }
                    else
                        chessBoard[i][j] = ' ';
                }
            }
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                //【2】逻辑同【1】
                if(chessBoard[i][j] == ' '){
                    chessBoard[i][j] = 'O'; //【2】否则尝试用户下在这个位置
                    if(isSuccessful() == 1){ //【2】如果用户下在这个位置会胜利，就占领它。
                        chessBoard[i][j] = '*';
                        size++;
                        return ;
                    } else
                        chessBoard[i][j] = ' ';
                }
            }
        }

        //2.如果用户下在了中间的话，就赶紧占两个四角的位置，才能保证不输。优先级要比第一个低。用户没下在中间也可抢占。
        if(corner > 0){
            corner--;
            for(int i = 0; i < 3; i++){ //优先找四边中没有用户棋子的地方下
                if(i == 1)
                    continue;
                boolean NoBigO = true;
                for(int j = 0; j < 3; j++){
                    if(chessBoard[i][j] == 'O')
                        NoBigO = false;
                }
                for(int j = 0; j < 3 && NoBigO; j++){
                    if(chessBoard[i][j] == ' '){
                        chessBoard[i][j] = '*';
                        size++;
                        return;
                    }
                }
            }

            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(j == 1 || i == 1)
                        continue;
                    if(chessBoard[i][j] == ' '){
                        chessBoard[i][j] = '*';
                        size++;
                        return;
                    }
                }
            }
        } //end if

        //3.判断是否可以下一个棋子，从而再下一步可以胜利（不能放在一起判断）
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(chessBoard[i][j] == ' '){
                    chessBoard[i][j] = '*';
                    if(willBeSuccessful(-1)){
                        size++;
                        return;
                    } else
                        chessBoard[i][j] = ' ';
                }
            }
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(chessBoard[i][j] == ' '){
                    chessBoard[i][j] = 'O';
                    if (willBeSuccessful(1)) {
                        chessBoard[i][j] = '*';
                        size++;
                        return;
                    } else
                        chessBoard[i][j] = ' ';
                }
            }
        }

        sillyRobot();
    }

    //【打印棋盘】
    private void printChessBroad(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //模拟清屏
        System.out.println("┌───┬───┬───┐");
        System.out.println("│ " + chessBoard[0][0] + " │ " + chessBoard[0][1] + " │ " + chessBoard[0][2] + " │");
        System.out.println("├───┼───┼───┤");
        System.out.println("│ " + chessBoard[1][0] + " │ " + chessBoard[1][1] + " │ " + chessBoard[1][2] + " │");
        System.out.println("├───┼───┼───┤");
        System.out.println("│ " + chessBoard[2][0] + " │ " + chessBoard[2][1] + " │ " + chessBoard[2][2] + " │");
        System.out.println("└───┴───┴───┘");
    }
    //【判断成功逻辑】
    private enum Choice{
        LINE,           //行
        COLUMN,         //列
        RIGHT_DIAGONAL, //右对角线
        LEFT_DIAGONAL;  //左对角线
    }
    private int calculate(Choice choice, int i){ //计算行、列、对角线是否连成一条线
        switch (choice){
            case LINE:
                return chessBoard[i][0] + chessBoard[i][1] + chessBoard[i][2];
            case COLUMN:
                return chessBoard[0][i] + chessBoard[1][i] + chessBoard[2][i];
            case RIGHT_DIAGONAL:
                return chessBoard[0][0] + chessBoard[1][1] + chessBoard[2][2];
            case LEFT_DIAGONAL:
                return chessBoard[0][2] + chessBoard[1][1] + chessBoard[2][0];
        }
        return 0;
    }
    private int isSuccessful(){
        /*
        返回-1系统胜；返回1用户胜；返回0表示继续下棋。
        系统胜：126 == '*' + '*' + '*'
        用户胜：237 == 'O' + 'O' + 'O'
        */
        for(int i = 0; i < 3; i++){
            if(calculate(Choice.LINE, i) == 237 || calculate(Choice.COLUMN, i) == 237)
                return 1;
            if(calculate(Choice.LINE, i) == 126 || calculate(Choice.COLUMN, i) == 126)
                return -1;
        }
        if(calculate(Choice.LEFT_DIAGONAL, 0) == 237 || calculate(Choice.RIGHT_DIAGONAL, 0) == 237)
            return 1;
        if(calculate(Choice.LEFT_DIAGONAL, 0) == 126 || calculate(Choice.RIGHT_DIAGONAL, 0) == 126)
            return -1;
        return 0; //继续下棋
    }

    private boolean willBeSuccessful(int who){ //who：-1表示判断机器人的，+1表示判断用户的。
        //如果行、列、对角线有2个相同棋子的个数，则将会胜，
        //190 == 2 * 'O' + ' '
        //116 == 2 * '*' + ' '

        int n = 0;
        int s = (who == 1) ? 190 : 116; //用户or机器人要计算的值

        for(int i = 0; i < 3; i++){
            if(calculate(Choice.LINE, i) == s)
                n++;
            if(calculate(Choice.COLUMN, i) == s)
                n++;
        }
        //因为中心一定会被占的，所以就不用判断对角线了
        return n > 1;
    }
}