/**
 * Created by Andrew Towe on 12/4/2014.
 */
public class initialNode{
    int givenend;
    int givenbeginning;
    int searchedend;
    int searchedbeginning;
    double prob;
    public initialNode(double p){
        givenbeginning=1;
        givenend=2;
        searchedbeginning=1;
        searchedend=2;
        prob=p;
    }
    public double chance(int thisnode){
        if(thisnode==1) {
            return prob;
        }else{
            return (1-prob);
        }
    }
}
