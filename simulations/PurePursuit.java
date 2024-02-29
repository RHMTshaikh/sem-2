package simulations;

public class PurePursuit {
    public void purePursuit(int[][] bomberPositions, double fighterX, double fighterY, int fighterSpeed){
        int height=(int)Math.abs(bomberPositions[2][0]-fighterY);
        int width=(int)Math.abs(bomberPositions[1][0]-fighterX);

        System.out.print("F ");
        for (int j = 1; j < width; j++) {
            System.out.print("+ ");
        }System.out.println();
        
        for (int i = 1; i < height-1; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("+ ");
            }System.out.println();
        }

        for (int j = 1; j < width; j++) {
            System.out.print("+ ");
        }
        System.out.print("B ");
        System.out.println();
            
        int time = 0;
        double distance = Math.sqrt( Math.pow(bomberPositions[1][time]-fighterX,2) + Math.pow(bomberPositions[2][time]-fighterY,2) );
        double velocityX = fighterSpeed*(bomberPositions[1][time]-fighterX)/distance;
        double velocityY = fighterSpeed*(bomberPositions[2][time]-fighterY)/distance;
        time++;
        
        while (time < bomberPositions[0].length) {
            
            if (distance <= 10) {
                return;
            }
            fighterX = fighterX + velocityX;
            fighterY = fighterY + velocityY;
            
            distance = Math.sqrt( Math.pow(bomberPositions[1][time]-fighterX,2) + Math.pow(bomberPositions[2][time]-fighterY,2) );
            velocityX = fighterSpeed*(bomberPositions[1][time]-fighterX)/distance;
            velocityY = fighterSpeed*(bomberPositions[2][time]-fighterY)/distance;
            time++;
            // System.out.print("\033[H\033[2J");
            // System.out.flush();
        }
    }
    public static void main(String[] args) {
        int[][] bomberPositions = {
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
            {80, 90, 99, 108, 116, 125, 133, 141, 151, 160, 169, 179, 180},//X
            {0, -2, -5, -9, -15, -18, -23, -29, -28, -25, -21, -20, -17}//Y
        };
        PurePursuit p = new PurePursuit();
        p.purePursuit(bomberPositions, 0, 80, 0);
    }
}
