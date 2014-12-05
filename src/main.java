/**
 * Created by Andrew Towe on 12/3/2014.
 */
public class main {
    static initialNode Burglary;
    static initialNode EarthQuake;
    static middleNode Alarm;
    static endNode John;
    static endNode Mary;
    public static void main(String args[]){
        setup(args);
        printout(process());
    }
    private static void setup(String[] args){
        if (args.length>6|args.length<1){
            System.out.println("Wrong number of variables");
            System.exit(0);
        }
        boolean givenflag=false;
        Burglary=new initialNode(.001);
        EarthQuake=new initialNode(.002);
        Alarm=new middleNode(.95, .94, .29, .001);
        John=new endNode(.9, .05);
        Mary=new endNode(.7, .01);
        for(String s: args){
            if(s.equals("given")){
                givenflag=true;
            }else if(s.equals("Bt")){
                Burglary.searchedend=1;
                //System.out.println("Burglary is set to true");
                if(givenflag){
                    Burglary.givenend=1;
                    //System.out.println("this is a given");
                }
            }else if(s.equals("Bf")){
                Burglary.searchedbeginning=2;
                //System.out.println("Burglary is set to false");
                if(givenflag){
                    Burglary.givenbeginning=2;
                    //System.out.println("this is a given");
                }
            }else if(s.equals("Et")){
                EarthQuake.searchedend=1;
                //System.out.println("Earthquake is set to true");
                if(givenflag){
                    EarthQuake.givenend=1;
                    //System.out.println("this is a given");
                }
            }else if(s.equals("Ef")){
                EarthQuake.searchedbeginning=2;
                //System.out.println("Earthquake is set to false");
                if(givenflag){
                    EarthQuake.givenbeginning=2;
                    //System.out.println("this is a given");
                }
            }else if(s.equals("At")){
                Alarm.searchedend=1;
                //System.out.println("Alarm is set to true");
                if(givenflag){
                    Alarm.givenend=1;
                    //System.out.println("this is a given");
                }
            }else if(s.equals("Af")){
                Alarm.searchedbeginning=2;
                //System.out.println("Alarm is set to false");
                if(givenflag){
                    Alarm.givenbegining=2;
                    //System.out.println("this is a given");
                }
            }else if(s.equals("Jt")){
                John.searchedend=1;
                //System.out.println("John is set to true");
                if(givenflag){
                    John.givenend=1;
                    //System.out.println("this is a given");
                }
            }else if(s.equals("Jf")){
                John.searchedbeginning=2;
                //System.out.println("John is set to false");
                if(givenflag){
                    John.givenbeginning=2;
                    //System.out.println("this is a given");
                }
            }else if(s.equals("Mt")){
                Mary.searchedend=1;
                //System.out.println("Mary is set to true");
                if(givenflag){
                    Mary.givenend=1;
                    //System.out.println("this is a given");
                }
            }else if(s.equals("Mf")){
                Mary.searchedbeginning=2;
                //System.out.println("Mary is set to false");
                if(givenflag){
                    Mary.givenbeginning=2;
                    //System.out.println("this is a given");
                }
            }else{
                System.out.println("Wrong input, exiting");
                System.exit(0);
            }
        }
    }
    private static double process(){
        double numerator=0.0;
        double denominator=0.0;
        boolean evalue;
        boolean bvalue;
        boolean avalue;
        boolean jvalue;
        boolean mvalue;
        //this is to do the numerator, the thing we are searching for
        for(int e=EarthQuake.searchedbeginning; e<=EarthQuake.searchedend; e++){
            for(int b=Burglary.searchedbeginning; b<= Burglary.searchedend; b++){
                for(int a=Alarm.searchedbeginning; a<=Alarm.searchedend; a++){
                    for(int j=John.searchedbeginning; j<=John.searchedend; j++){
                        for(int m=Mary.searchedbeginning; m<=Mary.searchedend; m++){
                            if(e==1){
                                evalue=true;
                            }else{
                                evalue=false;
                            }
                            if(b==1){
                                bvalue=true;
                            }else{
                                bvalue=false;
                            }
                            if(a==1){
                                avalue=true;
                            }else{
                                avalue=false;
                            }
                            if(j==1){
                                jvalue=true;
                            }else{
                                jvalue=false;
                            }
                            if(m==1){
                                mvalue=true;
                            }else{
                                mvalue=false;
                            }
                            numerator+=computeProbability(evalue, bvalue,avalue,jvalue,mvalue);
                        }
                    }
                }
            }
        }
        //for the denominator Not checking for things we are searching for
        for(int e=EarthQuake.givenbeginning; e<=EarthQuake.givenend; e++) {
            for (int b = Burglary.givenbeginning; b <= Burglary.givenend; b++) {
                for (int a = Alarm.givenbegining; a <= Alarm.givenend; a++) {
                    for (int j = John.givenbeginning; j <= John.givenend; j++) {
                        for (int m = Mary.givenbeginning; m <= Mary.givenend; m++) {
                            if(e==1){
                                evalue=true;
                            }else{
                                evalue=false;
                            }
                            if(b==1){
                                bvalue=true;
                            }else{
                                bvalue=false;
                            }
                            if(a==1){
                                avalue=true;
                            }else{
                                avalue=false;
                            }
                            if(j==1){
                                jvalue=true;
                            }else{
                                jvalue=false;
                            }
                            if(m==1){
                                mvalue=true;
                            }else{
                                mvalue=false;
                            }
                            denominator += computeProbability(evalue, bvalue,avalue,jvalue,mvalue);
                        }
                    }
                }
            }
        }
        System.out.println(numerator);
        System.out.println(denominator);
        return numerator/denominator;
    }
    private static double computeProbability(boolean e, boolean b, boolean a, boolean j, boolean m){
        //so long and thanks for all the fish.
        int evalue;
        int bvalue;
        int avalue;
        int jvalue;
        int mvalue;
        if(e==true){
            evalue=1;
        }else{
            evalue=2;
        }
        if(b==true){
            bvalue=1;
        }else{
            bvalue=2;
        }
        if(a==true){
            avalue=1;
        }else{
            avalue=2;
        }
        if (j==true){
            jvalue=1;
        }else{
            jvalue=2;
        }
        if(m==true){
            mvalue=1;
        }else{
            mvalue=2;
        }
        return (EarthQuake.chance(evalue)*Burglary.chance(bvalue)*Alarm.chance(avalue, bvalue, evalue)*John.chance(jvalue, avalue)*Mary.chance(mvalue, avalue));
    }
    private static void printout(double value){
        System.out.println("The percentage of this happening is: "+value);
    }


}
