
public class Fraction {
    //find gcf in Section 2
    static int findGCF(int a, int b){
        while (a !=b){
            if (a>b)  a = a-b;
            else b = b-a;
        }//while
        return (a);
    }//gcf

    
    //Section 3: attributes
    int num; //numerator
    int den;
    
    //Section 4: constructors
    Fraction (int a, int b){
        int gcf = findGCF(Math.abs(a),Math.abs(b));
       
        if (   (a<0  && b<0)
            || (a>=0 && b<0)
           )  { a = -a; b=-b; }

        num = a/gcf;
        den = b/gcf;
    }
    Fraction (String s){ // "  2 1/2  "
        s= s.trim();
        int posB=s.indexOf(" ");
int w=0;
if (posB>-1){
        String whole =s.substring(0,posB);
        w = Integer.parseInt(whole);
        s =s.substring(posB);
}
    
        s=s.trim();
        int posSl=s.indexOf("/");
        String top =s.substring(0,posSl);
        String bot =s.substring(posSl+1);
        int t = Integer.parseInt(top);
        int b = Integer.parseInt(bot);
        int a = w*b + t;
    
        int gcf=findGCF(a,b);
        num = a/gcf;
        den = b/gcf;
    }//contructor
    
    //Section 5:  methods
    void display(){
        System.out.println("fraction is "+ num +"/"+ den);
    }
    public String toString() {
        String rtn="";
        //Body to collect into rtn all displayed items
        rtn =  num +"/"+ den;
        return rtn;
    }


}//class



