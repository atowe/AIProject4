/**
 * Created by Andrew Towe on 12/4/2014.
 */
public class middleNode {
    int givenend;
    int givenbegining;
    int searchedend;
    int searchedbeginning;
    double[] prob;
    //hello
    public middleNode(double a, double b, double c, double d){
        givenbegining=1;
        givenend=2;
        searchedbeginning=1;
        searchedend=2;
        prob=new double[4];
        prob[0]=a;
        prob[1]=b;
        prob[2]=c;
        prob[3]=d;
    }
    public double chance(int thisnode, int parent1, int parent2){
        double store;
        if(parent1==1){ //if burglary is true
            if(parent2==1){  //if earthquake is true
                store=prob[0];
            }else{
                store=prob[1];
            }
        }else{  //if burglary is false
            if(parent2==1){  //if earthquake is true
                store=prob[2];
            }else{          //if earthquake is false
                store=prob[3];
            }
        }
        if(thisnode==1){
            return store;
        }else{
            return (1-store);
        }
    }
}
