package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    double ptacka;
    double ktacka;
    boolean ptacka_pripada;
    boolean ktacka_pripada;
    public Interval(double v, double v1, boolean b, boolean b1){
        if(v>v1) throw new IllegalArgumentException("Nije u intervalu");
        ptacka=v;
        ktacka=v1;
        ptacka_pripada=b;
        ktacka_pripada=b1;

    }
    public Interval (){
        ptacka=0;
        ktacka=0;
        ptacka_pripada=false;
        ktacka_pripada=false;
    }

    public boolean isIn(double v) {
        if(ptacka_pripada && ktacka_pripada)
            if(v>=ptacka && v<=ktacka)
                return true;
        if(!ptacka_pripada && ktacka_pripada)
            if(v>ptacka && v<=ktacka)
                return true;
        if(!ptacka_pripada && !ktacka_pripada)
            if(v>ptacka && v<ktacka)
                return true;
        if(ptacka_pripada && !ktacka_pripada)
            if(v>=ptacka && v<ktacka)
                return true;

        return false;

    }


    public boolean isNull() {
        if(ptacka==0 && ktacka==0)
                return true;
        return false;
    }

    public Interval intersect (Interval i) {
        double mini;
        double maxi;
        boolean pripadapt;
        boolean pripadakt;
        if(ptacka<i.ptacka) {
            maxi = i.ptacka;
            pripadapt=i.ptacka_pripada;
        }
        else {
            maxi = ptacka;
            pripadapt=ptacka_pripada;
        }
        if(ktacka>i.ktacka) {
            mini = i.ktacka;
            pripadakt=i.ktacka_pripada;
        }
        else {
            mini = ktacka;
            pripadakt=ktacka_pripada;
        }
        Interval novi= null;
        novi = new Interval(maxi,mini,pripadapt,pripadakt);

        return novi;

    }
    public static Interval intersect (Interval i,Interval i2) {
        double mini;
        double maxi;
        boolean pripadapt;
        boolean pripadakt;
        if(i2.ptacka<i.ptacka) {
            maxi = i.ptacka;
            pripadapt=i.ptacka_pripada;
        }
        else {
            maxi = i2.ptacka;
            pripadapt=i2.ptacka_pripada;
        }
        if(i2.ktacka>i.ktacka) {
            mini = i.ktacka;
            pripadakt=i.ktacka_pripada;
        }
        else {
            mini = i2.ktacka;
            pripadakt=i2.ktacka_pripada;
        }
        Interval novi= null;
        novi = new Interval(maxi,mini,pripadapt,pripadakt);

        return novi;
    }

    @Override
    public String toString() {
        if(ptacka==0 && ktacka==0)
            return "()";

        else if(ptacka_pripada && !ktacka_pripada)
          return "["+ptacka+","+ktacka+")";
       else if(!ptacka_pripada && ktacka_pripada)
         return "("+ptacka+","+ktacka+"]";
       else if(!ptacka_pripada && !ktacka_pripada)
           return "("+ptacka+","+ktacka+")";
       else if(ptacka_pripada && ktacka_pripada)
           return "["+ptacka+","+ktacka+"]";

       return "";
    }

    @Override
    public boolean equals (Object o){
        if(ptacka==((Interval)o).ptacka && ktacka==((Interval)o).ktacka
         && ptacka_pripada==((Interval)o).ptacka_pripada && ktacka_pripada==((Interval)o).ktacka_pripada)
                return true;
        return false;
    }
}
