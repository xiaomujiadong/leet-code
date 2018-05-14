package com.saint.easy.string;

public class RotatedDigits {

    public static int tets(int N){
        int temp = 10;
        int yushu = N % temp;
        int shang = N / temp;
        int count = 1;

        int gege = 0;
        int loop = 0;

        do{
            if(loop == 0) {//算的个位上的好数
                if (0 <= yushu && yushu < 2) {
                    count = 0;
                } else if (2 <= yushu && yushu < 5) {
                    count = count * 1;
                } else if (5 == yushu) {
                    count = count << 1;
                } else if (6 <= yushu && yushu < 9) {
                    count = count * 3;
                } else if (yushu == 9) {
                    count = count << 2;
                }
                gege = 4;
            }else if(shang*10 > 9){//算除了最高位和最低位的值
                if(yushu == 0){
                    count = count * 1;
                }else if(yushu == 1){
                    count = count * 2;
                }else if(2<=yushu && yushu<5){
                    count = count * 3;
                }else if(yushu == 5){
                    count = count * 4;
                }else if(6==yushu || yushu==7){
                    count = count * 5;
                }else if(yushu == 8){
                    count = count * 6;
                }else if(yushu == 9){
                    count = count * 7;
                }

                gege = 7 * gege;
            }else if(shang<10){
                if(yushu == 1){
                    count = count * 1;
                }else if(2<=yushu && yushu<5){
                    count = count * 2;
                }else if(yushu == 5){
                    count = count * 3;
                }else if(6==yushu || yushu==7){
                    count = count * 4;
                }else if(yushu == 8){
                    count = count * 5;
                }else if(yushu == 9){
                    count = count * 6;
                }
            }
            System.out.println("gege: "+gege+", count: "+count+", yushu: "+yushu+", shang: "+shang);
            ++loop;
            shang = shang / 10;
            yushu = yushu % 10;


        }while (shang != 0);

        return count + gege;
    }



    public static int rotatedDigits(int N) {

        int goodCont = 0;
        int googTemp = 1;
        int temp = 10;
        int count = 0;
        int chu = N;
        int te = 0;
        do{
             te = chu%temp;

            if(0 == te){

            }
            if(2<=te && te<5 ){
                if(count == 0){
                    count = 1;
                }
                count = count * 1;
            }else if(5==te){
                if(count == 0){
                    count = 1;
                }
                count = count << 1;
            }else if(6 <= te && te<9){
                if(count == 0){
                    count = 1;
                }
                count = count * 3;
            }else if(te==9){
                if(count == 0){
                    count = 1;
                }
                count = count << 2;
            }

            if(chu>9){
                googTemp = googTemp << 2;
                goodCont += googTemp;
            }
            System.out.println("count: "+count+", good: "+goodCont);
            chu = chu/10;
            temp = temp * 10;
        }while(chu > 0);

        return goodCont + count;
    }

    public static void main(String[] args){
        int n = 857;
        System.out.println("result: "+tets(n));
    }
}
