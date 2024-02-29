package simulations;
import java.util.Random;

public class Inventory {
    int stock=115, day=1, dueDate=0, unitsDue=0, estimatedStock=0, demand=0;
    float cost=0;
    void policy(int reorderPoint, int reorderQuantity){
        while (day <= 180) {
            if(day==dueDate){
                stock += unitsDue;
                cost += unitsDue*(18);
                unitsDue = 0;
            }
            demand = new Random().nextInt(100)+1;
            stock = stock - demand;
            estimatedStock = stock;

            if (estimatedStock < reorderPoint) {
                dueDate = day + 3;
                while(estimatedStock < reorderPoint) {
                    estimatedStock += reorderQuantity;
                    cost += 75;
                }
                unitsDue = estimatedStock - stock;                
            }
            if(stock > 0){
                cost += stock*(0.75);
            }
            // if (demand>stock) {
            //     cost += (demand-stock)*18;
            //     stock=0;
            // } else{
            //     stock = stock - demand;
            //     cost = cost + stock*(0.75f);

            // }
            // estimatedStock = stock + unitsDue;
            // if(estimatedStock<reorderPoint){
            //     unitsDue = reorderQuantity;
            //     cost += 75;
            //     dueDate = day+3;
            // }

            day++;
        }
        System.out.println(cost);
    }
    public static void main(String[] args) {
        System.out.println("qqqq");
        for (int i = 0; i < 10; i++) {
            new Inventory().policy(125, 250);
            
        }
    }
}
