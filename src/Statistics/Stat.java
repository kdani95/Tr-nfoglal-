package Statistics;

public class Stat{
   
    private String name;
    private double avg;
    private int min;
    private int max;
    private int samples;
    
    private double exp;
    private double mult;

    public Stat(String name, double avg, int max, int min, int smpls,double mult,double exp) {
        this.name = name;
        this.avg = avg;
        this.max = max;
        this.min = min;
        this.samples = smpls;
        this.mult = mult;
        this.exp = exp;
    }
    
    public double getChance(double points){
        //System.out.println("avg: " + this.avg + " min:" + this.min + " max:" + this.max);
        if(samples < 4){
            return 0.0;
        }
        double p = points -min;
        if(p < 0){
            return -0.1;
        }else if(p >= max-min){
            return 1.0;
        }
        
        return Function(mult, exp, p);
    } 
    
    public void calcFunction(){
        double pMax = max - min;
        double pMin = 0;
        double pAvg = avg - min;
        double pErr = 0.01;
        boolean fit = false;
        double e = 1;
        double m = 1;
        double step = 0;
        
        if(avg != min && min != max && avg != max){
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
        
    }
    
    public void addStat(int p){
        if(p < 0){
            return;
        }
        System.out.println("stat points: " + p);
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

    String getName() {
        return this.name;
    }

    public double getAvg() {
        return this.avg;
    }

    public int getMax() {
        return this.max;
    }

    public int getMin() {
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
