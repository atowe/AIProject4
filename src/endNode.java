/**
 * Created by Andrew Towe on 12/4/2014.
 */
public class endNode {
    int givenend;
    int givenbeginning;
    int searchedend;
    int searchedbeginning;
    double[] prob;
    public endNode(double a, double b){
        givenbeginning=1;
        givenend=2;
        searchedbeginning=1;
        searchedend=2;
        prob=new double[2];
        prob[0]=a;
        prob[1]=b;
    }
    public double chance(int thisnode, int parent){
        double store;
        if(parent==1){
            store=prob[0];
        }else{
            store=prob[1];
        }
        if(thisnode==1){
            return store;
        }else{
            return(1-store);
        }
    }
}
