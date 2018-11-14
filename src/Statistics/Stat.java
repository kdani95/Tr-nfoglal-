package Statistics;

public class Stat{
   
    private int cardID;
    private double avg;
    private int min;
    private int max;
    private int samples;
    
    private double exp;
    private double mult;

    public Stat(int id, double avg, int max, int min, int smpls,double mult,double exp) {
        this.cardID = id;
        this.avg = avg;
        this.max = max;
        this.min = min;
        this.samples = smpls;
        this.mult = mult;
        this.exp = exp;
    }
    
    public double getChance(int points){
        System.out.println("avg: " + this.avg + " min:" + this.min + " max:" + this.max);
        int p = points -min;
        if(p > max-min){
            return 1.0;
        }else if(p < 0){
            return 0.0;
        }
        
        return Function(mult, exp, p);
    } 
    
    public void calcFunction(){
        double pMax = max - min;
        double pMin = 0;
        double pAvg = avg - min;
        double pErr = 0.0001;
        boolean fit = false;
        double e = 1;
        double m = 1;
        double step = 0;
        if(pAvg < pMax/2)
            step = 0.1;
        else
            step = -0.1;
        while (!fit) {
            e = e - step;
            m = 1 / Function(1, e, pMax);
            if(Function(m, e, pAvg) > 0.5+pErr){
                if(step > 0)
                    step = -Math.abs(step / 2);
                else
                    step = -Math.abs(step);
            }else if(Function(m, e, pAvg) < 0.5-pErr){
                if(step < 0)
                    step = Math.abs(step / 2);
                else
                    step = Math.abs(step);
            }else{
                fit = true;
            }
            this.mult = m;
            this.exp = e;
        }
        
    }
    
    public void addStat(int p){
        this.avg = ((this.avg*this.samples) + p) / (this.samples+1) ;
        this.samples++;
        if(p < this.min){
            this.min = p;
        }
        if(p > this.max){
            this.max = p;
        }
        calcFunction();
        Stats.refreshStat(this);
    }
    
    private double Function(double m, double e,double p){
        return m * Math.pow(p, e);
    }

    int getId() {
        return this.cardID;
    }

    double getAvg() {
        return this.avg;
    }

    int getMax() {
        return this.max;
    }

    int getMin() {
        return this.min;
    }

    int getSmpls() {
        return this.samples;
    }
    
    double getMult() {
        if( Double.isInfinite(this.mult) ){
            return 5000;
        }
        return this.mult;
    }
    
    double getExp() {
        return this.exp;
    }
}
